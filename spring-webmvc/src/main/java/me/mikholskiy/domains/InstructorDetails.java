package me.mikholskiy.domains;

import javax.persistence.*;

@Entity
@Table(name = "instructor_details")
public class InstructorDetails {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "youtube_channel", length = 128)
	private String youtubeChannel;

	@Column(name = "hobby", length = 100)
	private String hobby;

	@OneToOne(
			fetch = FetchType.LAZY,
			mappedBy = "instructorDetails",
			cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private Instructor instructor;

	public InstructorDetails() {
	}

	public InstructorDetails(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetails{" +
				"youtubeChannel='" + youtubeChannel + '\'' +
				", hobby='" + hobby + '\'' +
				'}';
	}
}
