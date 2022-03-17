package me.mikholskiy;

import com.github.tomaslanger.chalk.Chalk;
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

			Student s = session.get(Student.class, 8);
			session.remove(s);

			session.createQuery("from Student", Student.class).list().forEach(student -> System.out.println(Chalk.on(student.toString()).blue().underline()));

			session.createQuery("from Course", Course.class).list().forEach(c -> System.out.println(Chalk.on(c.toString()).green()));

			session.getTransaction().commit();
		}
	}
}