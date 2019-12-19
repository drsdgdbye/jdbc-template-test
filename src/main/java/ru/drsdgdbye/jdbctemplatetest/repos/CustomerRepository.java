package ru.drsdgdbye.jdbctemplatetest.repos;

import ru.drsdgdbye.jdbctemplatetest.entities.Customer;

import java.util.List;

public interface CustomerRepository {
    int save(Customer customer);

    int update(Customer customer);

    int deleteById(Integer id);
    List<Customer> findAll();
}
