package me.mikholskiy.domains;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class Customer {
	private String firstName = null;
	@NotNull(message = "is required")
	@Length(min = 2, max = 20, message = "should fit between 2 and 20 characters")
	private String lastName = null;

	public Customer() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}
}
