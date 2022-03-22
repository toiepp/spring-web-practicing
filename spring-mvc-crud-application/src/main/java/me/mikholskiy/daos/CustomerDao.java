package me.mikholskiy.daos;

import me.mikholskiy.domains.Customer;
import me.mikholskiy.exceptions.CustomerNotFoundException;
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
	public Optional<Customer> get(int id) throws CustomerNotFoundException {
		Optional<Customer> customer = Optional.ofNullable(sessionFactory.getCurrentSession().get(Customer.class, id));

		if (customer.isEmpty()) {
			throw new CustomerNotFoundException("Couldn't find " + Customer.class.getPackageName() + ".Customer with id=" + id);
		}

		return customer;
	}

	@Override
	public List<Customer> getAll() {
		return sessionFactory.getCurrentSession()
							 .createQuery("from Customer", Customer.class)
							 .list();
	}

	@Override
	public void save(Customer customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
	}

	@Override
	public void update(Customer customer) {
		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(customer);
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Optional.ofNullable(session.get(Customer.class, id)).ifPresent(session::remove);
	}
}
