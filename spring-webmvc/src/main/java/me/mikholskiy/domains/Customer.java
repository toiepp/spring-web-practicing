package me.mikholskiy.domains;

import me.mikholskiy.validation.courseCode.CourseCode;
import me.mikholskiy.validation.nameSyntax.NameSyntax;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class Customer {
	@NameSyntax
	private String firstName = null;

	@NotNull
	@Length(min = 2, max = 20)
	@NameSyntax
	private String lastName = null;

	@Min(value = 0)
	@Max(value = 10)
	private int freePasses;

	@Pattern(regexp = "^[a-zA-Z0-9]{5}")
	private String postalCode;

	@NotEmpty(message = "shouldn't be blank")
	@CourseCode(value = "GEN", message = "should start with GEN")
	private String courseCode;

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

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}
}
