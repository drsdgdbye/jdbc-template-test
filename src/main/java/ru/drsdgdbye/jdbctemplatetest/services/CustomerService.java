package ru.drsdgdbye.jdbctemplatetest.services;

import ru.drsdgdbye.jdbctemplatetest.entities.Customer;

import java.util.Collection;

public interface CustomerService {
    void createOrUpdateCustomer(Integer id, Customer customer);

    void deleteCustomer(Integer id);

    Collection<Customer> getCustomers();
}
