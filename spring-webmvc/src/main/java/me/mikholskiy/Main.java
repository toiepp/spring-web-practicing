package me.mikholskiy;

import me.mikholskiy.domains.*;
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
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
				 Session session = sessionFactory.getCurrentSession()) {
			session.beginTransaction();

			Student student = session.get(Student.class, 5);
			student.setEmail("mihoho1980@gmail.com");
			session.saveOrUpdate(student);

			session.getTransaction().commit();
		}
	}
}