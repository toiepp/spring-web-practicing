package me.mikholskiy.daos;

import com.github.tomaslanger.chalk.Chalk;
import me.mikholskiy.domains.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("customerDao")
public class CustomerDao implements Dao<Customer> {
	private final SessionFactory sessionFactory;

	public CustomerDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Optional<Customer> get(int id) {
		return Optional.ofNullable(sessionFactory.getCurrentSession().get(Customer.class, id));
	}

	@Override
	public List<Customer> getAll() {
		return sessionFactory.getCurrentSession()
			.createQuery("from Customer", Customer.class)
			.getResultList();
	}

	@Override
	public void save(Customer customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
	}

	@Override
	public void update(Customer customer) {
		Session session = sessionFactory.getCurrentSession();

		System.out.println(Chalk.on(customer.toString()).blue().bold());

		session.saveOrUpdate(customer);
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Optional.ofNullable(session.get(Customer.class, id)).ifPresent(session::remove);
	}
}
