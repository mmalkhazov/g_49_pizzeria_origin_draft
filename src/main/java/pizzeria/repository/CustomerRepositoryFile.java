package pizzeria.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import pizzeria.domain.Customer;
import pizzeria.domain.Pizza;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerRepositoryFile implements CustomerRepository{

    private File database;
    private ObjectMapper mapper;
    private long currentId;


    public CustomerRepositoryFile() {
        database = new File("customer_database.txt");
        mapper = new ObjectMapper();

        try {
            database.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getMaxId();
    }

    private void getMaxId() {
        List<Customer> customersList = findAll();
        if (!customersList.isEmpty()) {
            Customer lastCustomer = customersList.get(customersList.size() - 1);
            currentId = lastCustomer.getId();
        }

    }



    @Override
    public Customer save(Customer customer) {
        List<Customer> customersList = findAll();
        customer.setId(++currentId);
        customer.setActive(true);
        customersList.add(customer);
        try {
            mapper.writeValue(database, customersList);
            return customer;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> findAll() {
        try {
            Customer[] customersArray = mapper.readValue(database, Customer[].class);
            List<Customer> customersList = new ArrayList<>();
            Collections.addAll(customersList, customersArray);
            return customersList;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Customer findById(long id) {
        return findAll()
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Customer customer) {
        List<Customer> customersList = findAll();

        customersList
                .stream()
                .filter(x -> x.getId() == customer.getId())
                .limit(1)
                .forEach(x -> {
                    x.setName(customer.getName());
                    x.setActive(true);

                });
        try {
            mapper.writeValue(database, customersList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteById(long Id) {
        List<Customer> customersList = findAll();

        customersList
                .stream()
                .filter(x -> x.getId() == Id)
                .limit(1)
                .forEach(x -> x.setActive(false));


        try {
            mapper.writeValue(database, customersList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
