package me.mikholskiy.domains;

import me.mikholskiy.validators.NameSyntax;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	@NotNull(message = "is required")
	@Size(min = 2, max = 45, message = "should fit between 2 and 45 characters")
	@NameSyntax
	@Column(name = "first_name", length = 45)
	private String firstName;

	@NotNull(message = "is required")
	@Size(min = 2, max = 45, message = "should fit between 2 and 45 characters")
	@NameSyntax
	@Column(name = "last_name", length = 45)
	private String lastName;

	@NotNull(message = "is required")
	@Size(max = 45, message = "too long email")
	@Email(message = "invalid email")
	@Column(name = "email", length = 45)
	private String email;

	public Customer() {
	}

	public Customer(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer{" +
			"id=" + id +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", email='" + email + '\'' +
			'}';
	}
}
