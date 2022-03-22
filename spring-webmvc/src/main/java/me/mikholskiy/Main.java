package me.mikholskiy;

import me.mikholskiy.domains.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Course> cr = cb.createQuery(Course.class);
			Root<Course> root = cr.from(Course.class);

			cr.select(root);
			cr.where(cb.ge(root.get("id"), 5));

			session.createQuery(cr).getResultList().forEach(System.out::println);

			session.getTransaction().commit();
		}
	}
}