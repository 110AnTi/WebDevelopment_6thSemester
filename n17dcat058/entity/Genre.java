package n17dcat058.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Genre {
	@Id
	private Integer ID;
	private String Name;
	private String Description;
	@ManyToMany(mappedBy = "genres")
	private List<Book> books = new ArrayList<>();

	public Genre() {
	}

	public Genre(Integer iD, String name, String description, List<Book> books) {
		this.setID(iD);
		this.setName(name);
		this.setDescription(description);
		this.setBooks(books);
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
