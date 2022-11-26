package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	BigDecimal price;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	Category category;

	@ManyToMany()
	@JoinTable(name = "pro_man",
	joinColumns = { @JoinColumn(name = "product_id") },
	inverseJoinColumns = { @JoinColumn(name = "manufacture_id") })
	List<Manufacture> manufactures;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Manufacture> getManufactures() {
		return manufactures;
	}

	public void setManufactures(List<Manufacture> manufactures) {
		this.manufactures = manufactures;
	}

}
