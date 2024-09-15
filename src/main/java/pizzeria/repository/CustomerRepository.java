package pizzeria.repository;

import pizzeria.domain.Customer;
import pizzeria.domain.Pizza;

import java.util.List;

public interface CustomerRepository {

    Customer save(Customer customer);
    List<Customer> findAll();
    Customer findById (long id);
    void update (Customer customer);
    void deleteById(long Id);


}
