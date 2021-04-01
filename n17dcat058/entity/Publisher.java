package n17dcat058.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Publisher {
	@Id
	private Integer ID;
	private String Name;
	@OneToMany(mappedBy="publisher", fetch=FetchType.EAGER)
	private Set<Book> books;
	public Publisher() {}
	public Publisher(Integer iD, String name, Set<Book> books) {
		this.setID(iD);
		this.setName(name);
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
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
}
