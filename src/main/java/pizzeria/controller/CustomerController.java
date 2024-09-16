package pizzeria.controller;

import pizzeria.domain.Customer;
import pizzeria.service.CustomerService;

import java.util.List;

public class CustomerController {

    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }


    public List<Customer> getAll() {
        return service.getAllActiveCustomer();
    }

    public Customer save(String name) {
        return service.save(name);
    }

    public Customer getById(long id) {
        return service.getActiveCustomerById(id);
    }

    public void deleteById(long id) {
        service.deleteCustomerById(id);
    }

    public void updateCustomer(long id, String newName) {
        service.updateCustomer(id, newName);
    }


    public void deleteByName(String name) {
        service.deleteCustomerByName(name);
    }

    public void restoreById(long id) {
        service.restoreCustomerById(id);
    }

    public long getCustomersCount() {
        return service.getAllActiveCustomersCount();
    }

    public double getCustomersOrderTotalPrice(long id) {
        return service.getCustomerOrderTotalPrice(id);
    }


    public double getCustomersOrderAveragePrice(long id) {
        return service.getCustomerOrderAveragePrice(id);
    }


    public void addPizzaToOrder(long customerId, long pizzaId) {
        service.addActivePizzaToCustomerOrder(customerId, pizzaId);
    }

    public void removePizzaFromOrder(long customerId, long pizzaId) {
        service.removePizzaFromCustomerOrder(customerId, pizzaId);


    }

    public void clearCustomerOrder(long customerId) {
        service.clearActiveCustomerOrder(customerId);


    }
}