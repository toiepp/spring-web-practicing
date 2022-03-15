package me.mikholskiy;

import me.mikholskiy.domains.Course;
import me.mikholskiy.domains.Instructor;
import me.mikholskiy.domains.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		try (SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
				 Session session = sessionFactory.getCurrentSession()) {
			session.beginTransaction();


			session.getTransaction().commit();
		}
	}
}