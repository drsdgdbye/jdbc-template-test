package ru.drsdgdbye.jdbctemplatetest.services;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.drsdgdbye.jdbctemplatetest.entities.Customer;
import ru.drsdgdbye.jdbctemplatetest.repos.CustomerRepository;

import java.util.Collection;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Setter(onMethod_ = {@Autowired})
    private CustomerRepository customerRepository;

    @Override
    public void createOrUpdateCustomer(Integer id, Customer customer) {
        if (!customerRepository.isPresent(id)) {
            customerRepository.save(customer);
        } else customerRepository.update(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Collection<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
