package me.mikholskiy.services;

import me.mikholskiy.domains.Customer;

import java.util.List;
import java.util.Optional;

public interface Service<T> {
	List<T> getAll();

	Optional<T> get(int id);

	void save(T t);

	void update(Customer customer);

	void delete(int id);
}
