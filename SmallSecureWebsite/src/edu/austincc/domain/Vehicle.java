/**
 * 
 */
package edu.austincc.domain;

/**
 * @author javauser
 *
 */
public class Vehicle {

	int id;
	int mileage;
	String make;
	String model;
	int year;
	String color;
	
	public Vehicle(int id, String make, String model, String color, int year, int mileage) {
		super();
		this.id = id;
		this.mileage = mileage;
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the mileage
	 */
	public int getMileage() {
		return mileage;
	}

	/**
	 * @param mileage the mileage to set
	 */
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vehicle [id=").append(id).append(", mileage=")
				.append(mileage).append(", make=").append(make)
				.append(", model=").append(model).append(", year=")
				.append(year).append(", color=").append(color).append("]");
		return builder.toString();
	}


	
	
	
	
}
