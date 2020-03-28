package net.codejava.model;


public class Product {
	private Integer product_id;
	private String name;
	private Integer price;
	private Integer quantity;
	private String volume;
	
	public Product(Integer id, String name, Integer price, Integer quantity, String volume) {
		this(name, price, quantity, volume);
		this.product_id = id;
		
	}
	
	public Product( String name, Integer price, Integer quantity, String volume) {
		
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.volume = volume;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return product_id;
	}

	public void setId(Integer id) {
		this.product_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	
}
