package n17dcat058.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	private Integer ID;
	private String Title;
	private float Rating;
	private String Description;
	@ManyToMany(mappedBy = "books")
	private Set<User> users = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "idPublisher")
	private Publisher publisher;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Detail_genre", 
	joinColumns = { @JoinColumn(name = "idBook") }, 
	inverseJoinColumns = { @JoinColumn(name = "idGenre") })
	List<Genre> genres = new ArrayList<>();
	
	@ManyToMany(mappedBy = "books")
	List<Author> authors = new ArrayList<>();
		
	public Book() {
	}

	public Book(Integer iD, String title, float rating, String description, 
			Set<User> users, Publisher publisher, List<Genre> genres, 
			List<Author> authors) {
		this.setID(iD);
		this.setTitle(title);
		this.setRating(rating);
		this.setDescription(description);
		this.setUsers(users);
		this.setPublisher(publisher);
		this.setGenres(genres);
		this.setAuthors(authors);
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public float getRating() {
		return Rating;
	}

	public void setRating(float rating) {
		Rating = rating;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
}
