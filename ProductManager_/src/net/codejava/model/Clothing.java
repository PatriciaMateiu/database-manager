package net.codejava.model;


public class Clothing {
	private Integer clothing_id;
	private String name;
	private Integer size;
	private Integer quantity;
	private Integer price;

	
	public Clothing() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Clothing(Integer clothing_id, String name, Integer size, Integer quantity, Integer price) {
	
	
		this(name, size, quantity, price);
		this.clothing_id = clothing_id;
	}
	public Clothing( String name, Integer size, Integer quantity, Integer price) {
		
		this.name = name;
		this.size = size;
		this.quantity = quantity;
		this.price = price;
	}


	public Integer getClothing_id() {
		return clothing_id;
	}

	public void setClothing_id(Integer clothing_id) {
		this.clothing_id = clothing_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}


}
