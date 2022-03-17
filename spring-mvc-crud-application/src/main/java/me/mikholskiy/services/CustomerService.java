package me.mikholskiy.services;

import com.github.tomaslanger.chalk.Chalk;
import me.mikholskiy.daos.Dao;
import me.mikholskiy.domains.Customer;
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
		System.out.println(Chalk.on("===[CustomerService::getAll]===").blue().bold());
		return customerDao.getAll();
	}

	@Override
	@Transactional
	public Optional<Customer> get(int id) {
		System.out.println(Chalk.on("===[CustomerService::get]===: {id = " + Chalk.on(String.valueOf(id)).yellow()).blue().bold());
		return customerDao.get(id);
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		System.out.println(Chalk.on("===[CustomerService::save]===: {" + customer + "}").blue().bold());
		customerDao.save(customer);
	}

	@Override
	@Transactional
	public void update(Customer customer) {
		System.out.println(Chalk.on("===[CustomerService::update]===: {" + customer.toString() + "}").blue().bold());
		customerDao.update(customer);
	}

	@Override
	@Transactional
	public void delete(int id) {
		System.out.println(Chalk.on("===[CustomerService::delete]===: {id=" + Chalk.on(String.valueOf(id)).yellow() + "}").blue().bold());
		customerDao.delete(id);
	}
}
