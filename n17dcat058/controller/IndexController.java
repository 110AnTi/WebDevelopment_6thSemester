package n17dcat058.controller;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import n17dcat058.entity.Author;
import n17dcat058.entity.Book;
import n17dcat058.entity.Genre;
import n17dcat058.entity.User;

@Transactional
@Controller
public class IndexController {
	@Autowired
	SessionFactory factory;
	@Autowired
	JavaMailSender mailer;

	@RequestMapping("index")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(ModelMap model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user, BindingResult br, ModelMap model) {
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		try {
			session.save(user);
			trans.commit();
			model.addAttribute("message", "Congratulation! Registration Success!");
			mkdirUser(user.getUsername());
		} catch (Exception ex) {
			trans.rollback();
			model.addAttribute("message", ex);
		} finally {
			session.close();
		}
		return "index";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam String username, @RequestParam String password, ModelMap model,
			HttpSession httpsession) {
		List<User> listUser = getListUsers();
		for (int i = 0; i < listUser.size(); i++) {
			if (listUser.get(i).getUsername().trim().equals(username)
					&& listUser.get(i).getPassword().trim().equals(password)) {
				httpsession.setAttribute("user", listUser.get(i));
				model.addAttribute("message", "Login success!");
				return "index";
			}
		}
		return "login";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
		return "logout";
	}

	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public String logout(HttpSession httpsession, ModelMap model) {
		httpsession.removeAttribute("user");
		model.addAttribute("message", "Logout success!");
		return "index";
	}

	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String profile(HttpSession httpsession, ModelMap model) {
		User user = (User) httpsession.getAttribute("user");
		model.addAttribute("user", user);
		return "profile";
	}

	@RequestMapping(value = "profile", method = RequestMethod.POST)
	public String profile(@ModelAttribute("user") User user, ModelMap model, HttpSession httpsession) {
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		User checkUser = (User) httpsession.getAttribute("user");
		if (!checkUser.getPassword().trim().equals(user.getPassword().trim())) {
			model.addAttribute("message", "Wrong password!");
			return "profile";
		}
		try {
			httpsession.setAttribute("user", user);
			session.update(user);
			trans.commit();
			model.addAttribute("message", "Profile is updated!");
		} catch (Exception ex) {
			trans.rollback();
			model.addAttribute("message", ex);
		} finally {
			session.close();
		}
		return "profile";
	}

	@RequestMapping(value = "requestCode", method = RequestMethod.GET)
	public String requestCode() {
		return "requestCode";
	}

	@RequestMapping(value = "requestCode", method = RequestMethod.POST)
	public String requestCode(@RequestParam String email, ModelMap model, HttpSession httpsession) {
		List<User> listUser = getListUsers();
		for (int i = 0; i < listUser.size(); i++) {
			if (listUser.get(i).getEmail().trim().equals(email.trim())) {
				try {
					MimeMessage mail = mailer.createMimeMessage();
					MimeMessageHelper helper = new MimeMessageHelper(mail);
					String verifiedCode = nLengthRandomStr(10);

					helper.setFrom("hotien51999@gmail.com");
					helper.setTo(email);
					helper.setReplyTo("hotien51999@gmail.com");
					helper.setSubject("VERIFIED CODE");
					helper.setText(verifiedCode, true);

					mailer.send(mail);
					httpsession.setAttribute("email", email);
					httpsession.setAttribute("verifiedCode", verifiedCode);
					model.addAttribute("message", "Code sent successfully!");

					return "resetPassword";
				} catch (Exception ex) {
					model.addAttribute("message", ex);
				}
			}
		}
		return "requestCode";
	}

	@RequestMapping(value = "resetPassword", method = RequestMethod.GET)
	public String resetPassword() {
		return "resetPassword";
	}

	@RequestMapping(value = "resetPassword", method = RequestMethod.POST)
	public String resetPassword(@RequestParam String password1, @RequestParam String password2,
			@RequestParam String code, HttpSession httpsession, ModelMap model) {

		if (password1.trim().equals(password2.trim())) {
			String verifiedCode = (String) httpsession.getAttribute("verifiedCode");
			String email = (String) httpsession.getAttribute("email");
			List<User> listUser = getListUsers();

			for (int i = 0; i < listUser.size(); i++) {
				if (listUser.get(i).getEmail().trim().equals(email.trim()) && verifiedCode.trim().equals(code.trim())) {
					listUser.get(i).setPassword(password1.trim());
					model.addAttribute("message", "Password is reset!");
					break;
				}
			}
		}
		httpsession.removeAttribute("email");
		httpsession.removeAttribute("verifiedCode");
		return "index";
	}

	@RequestMapping(value = "upload", method = RequestMethod.GET)
	public String upload(ModelMap model) {
		model.addAttribute("book", new Book());
		return "upload";
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public String upload(@ModelAttribute("book") Book book, @ModelAttribute("listAuthor") List<Author> listAuthors,
			HttpSession httpsession, @RequestParam("filepdf") MultipartFile filepdf,
			@RequestParam("authors") String authors, ModelMap model) {
		String path = "C:\\web-user\\" + ((User) httpsession.getAttribute("user")).getUsername().trim();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		try {
			Path pathPDF = Paths.get(path.toString(), filepdf.getOriginalFilename());
			try (OutputStream os = Files.newOutputStream(pathPDF)) {
				os.write(filepdf.getBytes());
			}
			addAuthors(listAuthors, authors, model);
			model.addAttribute("book", book);
			session.save(book);
			trans.commit();
			model.addAttribute("message", "Finish uploading!");
		} catch (Exception ex) {
			trans.rollback();
			model.addAttribute("message", ex);
		} finally {
			session.close();
		}
		return "upload";
	}

	public List<User> getListUsers() {
		Session session = factory.getCurrentSession();
		String hql = "FROM User";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = query.list();
		return listUser;
	}

	public String nLengthRandomStr(int n) {
		int leftLimit = 48;
		int rightLimit = 122;
		Random random = new Random();

		String returnStr = random.ints(leftLimit, rightLimit + 1).limit(n)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		return returnStr;
	}

	public void mkdirUser(String username) {
		File file = new File("C:\\web-user\\" + username);
		if (!file.exists()) {
			file.mkdir();
		}
	}

	@ModelAttribute("listGenres")
	public List<Genre> getListGenres() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Genre";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Genre> setGenres = query.list();
		return setGenres;
	}

	public void addAuthors(@ModelAttribute("listAuthor") List<Author> listAuthors, String authors, ModelMap model) {
		String[] listName = authors.split(",");

		for (String name : listName) {
			boolean isExist = false;
			for (Author author : listAuthors) {
				if (name.trim().equalsIgnoreCase(author.getName().trim())) {
					isExist = true;
					break;
				}
			}
			if (!isExist) {
				saveAuthor(name, model);
			}
		}
	}

	@ModelAttribute("listAuthors")
	public List<Author> getListAuthors() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Author";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Author> listAuthors = query.list();
		return listAuthors;
	}

	public void saveAuthor(String name, ModelMap model) {
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		Author author = new Author();
		try {
			author.setName(name);
			session.save(author);
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			model.addAttribute("message", ex);
		} finally {
			session.close();
		}
		author = null;
	}
}
