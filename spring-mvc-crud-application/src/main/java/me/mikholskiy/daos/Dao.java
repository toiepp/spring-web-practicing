package me.mikholskiy.daos;

import me.mikholskiy.domains.Customer;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
	void save(T t);

	Optional<T> get(int id);

	List<T> getAll();

	void update(Customer customer);

	void delete(int id);
}
