package me.mikholskiy.domains;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "courses")
public class Course {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	@Column(name = "title")
	private String title;

	@ManyToOne(
			cascade = {PERSIST, REFRESH, DETACH, MERGE})
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;

	@OneToMany(cascade = ALL)
	@JoinColumn(name = "course_id")
	private final List<Review> reviews = new ArrayList<>();

	@ManyToMany(cascade = {PERSIST, MERGE, REFRESH, DETACH})
	@JoinTable(name = "course_student",
			joinColumns = @JoinColumn(name = "course_id"),
			inverseJoinColumns = @JoinColumn(name = "student_id"))
	private final List<Student> students = new ArrayList<>();

	public Course() {
	}

	public Course(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review... review) {
		reviews.addAll(Arrays.asList(review));
	}

	public void addStudent(Student... student) {
		students.addAll(Arrays.asList(student));
	}

	public List<Student> getStudent() {
		return students;
	}

	@Override
	public String toString() {
		return "Course{" +
				"id=" + id +
				", title='" + title + '\'' +
				", instructor=" + instructor +
				'}';
	}
}
