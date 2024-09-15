package pizzeria.repository;

import pizzeria.domain.Customer;
import pizzeria.domain.Pizza;

import java.util.List;

public interface CustomerRepository {

    Customer save(Customer pizza);
    List<Customer> findAll();
    Customer findById (long id);
    void update (Customer pizza);
    void deleteById(long Id);


}
