package ru.drsdgdbye.jdbctemplatetest.repos;

import ru.drsdgdbye.jdbctemplatetest.entities.Customer;

import java.util.List;

public interface CustomerRepository {
    void save(Customer customer);

    void update(Customer customer);

    void deleteById(Integer id);

    List<Customer> findAll();
}
