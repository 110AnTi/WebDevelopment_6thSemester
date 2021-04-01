package n17dcat058.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "`User`")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ID;
	private String Username;
	private String Fullname;
	private String Password;
	private Byte Gender;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date Birthday;
	private String Email;
	private String Phone;
	private String Address;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Detail_bookmark", joinColumns = { @JoinColumn(name = "idUser") }, inverseJoinColumns = {
			@JoinColumn(name = "idBook") })
	private Set<Book> books = new HashSet<>();

	public User() {
	}

	public User(Integer ID, String Username, String Fullname, String Password, Byte Gender, Date Birthday, String Email,
			String Phone, String Address, Set<Book> books) {
		this.setID(ID);
		this.setUsername(Username);
		this.setFullname(Fullname);
		this.setPassword(Password);
		this.setGender(Gender);
		this.setBirthday(Birthday);
		this.setEmail(Email);
		this.setPhone(Phone);
		this.setAddress(Address);
		this.setBooks(books);
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getFullname() {
		return Fullname;
	}

	public void setFullname(String fullname) {
		Fullname = fullname;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Byte getGender() {
		return Gender;
	}

	public void setGender(Byte gender) {
		Gender = gender;
	}

	public Date getBirthday() {
		return Birthday;
	}

	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}
