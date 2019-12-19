package ru.drsdgdbye.jdbctemplatetest.repos;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.drsdgdbye.jdbctemplatetest.entities.Customer;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Setter(onMethod_ = {@Autowired})
    private JdbcTemplate jdbcTemplate;
    private Map<Integer, Customer> identityMap = new ConcurrentHashMap<>();

    @Override
    public int save(Customer customer) {
        identityMap.putIfAbsent(customer.getId(), customer);
        return jdbcTemplate.update("insert into customers(name, lastname, email) values(?, ?, ?)",
                customer.getName(),
                customer.getLastname(),
                customer.getEmail());
    }

    @Override
    public int update(Customer customer) {
        identityMap.replace(customer.getId(), customer);
        return jdbcTemplate.update("update customers set name = ?, lastname = ?,  email = ? where id = ?",
                customer.getName(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getId());
    }

    @Override
    public int deleteById(Integer id) {
        identityMap.remove(id);
        return jdbcTemplate.update("delete customers where id = ?", id);
    }

    @Override
    public List<Customer> findAll() {
        return jdbcTemplate.query("select * from customers",
                (resultSet, rowNum) -> new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email")));
    }
}
