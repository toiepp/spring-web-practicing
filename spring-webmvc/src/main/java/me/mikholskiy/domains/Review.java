package me.mikholskiy.domains;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "reviews")
public class Review {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	@Column(name = "comment")
	private String comment;

	public Review() {
	}

	public Review(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Review{" +
				"id=" + id +
				", comment='" + comment + '\'' +
				'}';
	}
}
