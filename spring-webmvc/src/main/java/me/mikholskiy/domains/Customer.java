package me.mikholskiy.domains;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class Customer {
	private String firstName = null;
	@NotNull(message = "is required")
	@Length(min = 1, message = "is required")
	private String lastName = null;
	@Min(value = 0, message = "should be positive")
	@Max(value = 10, message = "should be less then 10")
	private int freePasses;
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 symbols")
	private String postalCode;

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

	public int getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}
}
