package me.mikholskiy.services;

import me.mikholskiy.daos.Dao;
import me.mikholskiy.domains.Customer;
import me.mikholskiy.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service("customerService")
public class CustomerService implements Service<Customer> {
	private Dao<Customer> customerDao;

	@Autowired
	public void setCustomerDao(Dao<Customer> customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	@Transactional
	public List<Customer> getAll() {
		return customerDao.getAll();
	}

	@Override
	@Transactional
	public Optional<Customer> get(int id) throws CustomerNotFoundException {
		return customerDao.get(id);
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	@Transactional
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	@Transactional
	public void delete(int id) {
		customerDao.delete(id);
	}
}
