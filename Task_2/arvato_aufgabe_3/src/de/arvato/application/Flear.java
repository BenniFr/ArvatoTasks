package de.arvato.application;

import java.util.Objects;

public class Flear {
	
	String name;
	float price;
	int rating;
	
	public Flear() {}
	
	public Flear(final String name, final float price, final int rating){
		this.name=name;
		this.price=price;
		this.rating=rating;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String value) {
		this.name = value;
	}
	public float getPrice() {
		return this.price;
	}
	public void setPrice(float value) {
		this.price = value;
	}
	public int getRating() {
		return this.rating;
	}
	public void setRating(int value) {
		this.rating = value;
	}
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		if (!super.equals(object)) return false;
		Flear item = (Flear) object;
		return java.util.Objects.equals(name, item.name);
	}
	
	public int hashCode() {
		return Objects.hash(super.hashCode(), name);
	}

}
