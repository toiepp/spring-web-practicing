package me.mikholskiy.services;

import me.mikholskiy.domains.Customer;
import me.mikholskiy.exceptions.CustomerNotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public interface Service<T> {
	List<T> getAll();

	Optional<T> get(int id) throws CustomerNotFoundException;

	void save(T t);

	void update(Customer customer);

	void delete(int id);
}
