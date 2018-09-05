package com.lambazon.domain;

public class Product {
	
	private Integer id;
	private String name, description, details;
	private int quantity;
	private double price;

	public Product(int id, int quantity, double price, String name, String description) {
		setId(id);
		setQuantity(quantity);
		setPrice(price);
		setName(name);
		setDescription(description);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getQuantity() {
		return quantity;
	}

    /**
     * Adding a condition to setQuantity for negative values
     */
	public void setQuantity(int quantity) {
	    if(quantity > 0) {
        this.quantity = quantity;
	    } else {
            this.quantity=0;
        }
    }
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

    /**
     * Changing the method to return the inventory price
     */
	public double getInventoryPrice() { return quantity*price; }

}
