package n17dcat058.entity;

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

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ID;
	private String Name;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Detail_author", 
	joinColumns = { @JoinColumn(name = "idAuthor") }, 
	inverseJoinColumns = { @JoinColumn(name = "idBook") })
	private Set<Book> books = new HashSet<>();

	public Author() {
	}

	public Author(Integer id, String name, Set<Book> books) {
		this.setID(id);
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
