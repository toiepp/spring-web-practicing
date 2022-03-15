package me.mikholskiy.domains;

import javax.persistence.*;

@Entity
@Table(name = "instructors")
public class Instructor {
	@Id
	@Column(name = "id", updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name", length = 45)
	private String firstName;
	@Column(name = "last_name", length = 45)
	private String lastName;
	@Column(name = "email", length = 45)
	private String email;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	/* Указывает по какому столбцу происходит отображение */
	@JoinColumn(name = "instructor_details_id")
	private InstructorDetails instructorDetails;

	public Instructor() {
	}

	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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

	public InstructorDetails getInstructorDetails() {
		return instructorDetails;
	}

	public void setInstructorDetails(InstructorDetails instructorDetails) {
		this.instructorDetails = instructorDetails;
	}

	@Override
	public String toString() {
		return "Instructor{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", instructorDetails=" + instructorDetails +
				'}';
	}
}
