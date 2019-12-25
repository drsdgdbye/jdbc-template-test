package ru.drsdgdbye.jdbctemplatetest.controllers;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.drsdgdbye.jdbctemplatetest.entities.Customer;
import ru.drsdgdbye.jdbctemplatetest.services.CustomerService;

@RestController
public class CustomerController {
    @Setter(onMethod_ = {@Autowired})
    CustomerService customerService;

    @RequestMapping(value = "/customers")
    public ResponseEntity<Object> getCustomers() {
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
        customerService.createOrUpdateCustomer(customer.getId(), customer);
        return new ResponseEntity<>("Product is created", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>
    updateProduct(@PathVariable("id") String id, @RequestBody Customer customer) {
        customerService.createOrUpdateCustomer(Integer.parseInt(id), customer);
        return new ResponseEntity<>("customer is updated", HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        customerService.deleteCustomer(Integer.parseInt(id));
        return new ResponseEntity<>("customer is deleted", HttpStatus.OK);
    }

}
