package pizzeria.service;

import pizzeria.domain.Customer;
import pizzeria.domain.Pizza;
import pizzeria.repository.CustomerRepository;
import pizzeria.repository.PizzaRepository;


import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository repository;
    private PizzaRepository pizzaRepository;

    public CustomerServiceImpl(CustomerRepository repository) {

        this.repository = repository;
    }


    //Сохранить покупателя в базе данных при сохранении покупатель автоматически считается активным/
    @Override
    public Customer save(String customerName) {
        Customer customer = new Customer(customerName);
        repository.save(customer);
        return customer;
    }
    //Вернуть всех покупателей из базы данных активных/
    @Override
    public List<Customer> getAllActiveCustomer() {
        return repository.findAll()
                .stream()
                .filter(Customer::isActive)
                .toList();
    }
    //Вернуть одного покупателя из базы данных по его идентификатору если он активен/
    @Override
    public Customer getActiveCustomerById(long id) {
        Customer customer = repository.findById(id);
        if (customer != null && customer.isActive()) {
            return customer;
        } else {
            return null;
        }

    }
    //Изменить одного покупателя в базе данных по его идентификатору/
    @Override
    public void updateCustomer(long id, String newName) {
        Customer customer = new Customer(id, newName);
        repository.update(customer);

    }
    //Удалить покупателя из базы данных по его идентификатору/
    @Override
    public void deleteCustomerById(long id) {
        repository.deleteById(id);

    }
    //Удалить покупателя из базы данных по его имени/
    @Override
    public void deleteCustomerByName(String name) {
        repository.findAll()
                .stream()
                .filter(x -> x.getName().equals(name))
                .limit(1)
                .forEach(x -> deleteCustomerById(x.getId()));

    }

    //Восстановить удалённого покупателя в базе данных по его идентификатору/
    @Override
    public void restoreCustomerById(long id) {
        Customer customer = repository.findById(id);

        if (customer != null && !customer.isActive()) {
            repository.update(customer);
        }


    }

    //Вернуть общее количество покупателей в базе данных активных/
    @Override
    public long getAllActiveCustomersCount() {

        return getAllActiveCustomer().size();
    }

    //Вернуть стоимость корзины покупателя по его идентификатору если он активен/
    @Override
    public double getCustomerOrderTotalPrice(long id) {
        Customer customer = getActiveCustomerById(id);
        if (customer!=null){
            return customer.getActivePizzasTotalPrice();
        }
        return 0.0;
    }

    //Вернуть среднюю стоимость продукта в корзине покупателя по его идентификатору если он активен/
    @Override
    public double getCustomerOrderAveragePrice(long id) {
        Customer customer = getActiveCustomerById(id);
        if (customer!=null){
            return customer.getActivePizzasAveragePrice();
        }
        return 0.0;
    }

    //Добавить товар в корзину покупателя по их идентификаторам если оба активны/
    @Override
    public void addActivePizzaToCustomerOrder(long customerId, long pizzaId) {
        Customer customer = getActiveCustomerById(customerId);
        Pizza pizza = pizzaRepository.findById(pizzaId);

        if(customer != null && pizza != null && pizza.isActive()){
            customer.addPizza(pizza);
            repository.update(customer);


        }


    }

    //Удалить товар из корзины покупателя по их идентификаторам/
    @Override
    public void removePizzaFromCustomerOrder(long customerId, long pizzaId) {
        Customer customer = getActiveCustomerById(customerId);
        if (customer != null) {
            customer.deletePizzaById(pizzaId);
            repository.update(customer);

        }

    }

    //Полностью очистить корзину покупателя по его идентификатору если он активен
    @Override
    public void clearActiveCustomerOrder(long customerId) {
        Customer customer = getActiveCustomerById(customerId);
        if (customer != null) {
            customer.clearAllPizzas();
            repository.update(customer);

        }
    }
}
