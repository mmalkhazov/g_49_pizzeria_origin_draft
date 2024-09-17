package pizzeria.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pizzeria.domain.Customer;
import pizzeria.repository.CustomerRepositoryFile;
import pizzeria.repository.PizzaRepositoryFile;
import pizzeria.service.CustomerService;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceImplTest {


    private CustomerService service;

    @BeforeEach
    void setUp() {
        service = new CustomerServiceImpl(new CustomerRepositoryFile(), new PizzaRepositoryFile());
    }

    @Test
    void checkSaveCustomerFunction() {
        String expectedName = "Вася";
        Customer actual = service.save("Вася");
        assertEquals(expectedName, actual.getName(), "The Name returned corrupted");
    }

    @Test
    void getAllActiveCustomer() {
    }

    @Test
    void getActiveCustomerById() {
        String expectedName = "Вася";
        Customer savedCustomer = service.save("Вася");
        long idCustomer = savedCustomer.getId();
        Customer actual= service.getActiveCustomerById(idCustomer);

        assertEquals(expectedName, actual.getName(), "The Name returned corrupted");

    }

    @Test
    void updateCustomer() {
        String expectedName = "Вася";
        Customer savedCustomer = service.save("Саша");
        long idCustomer = savedCustomer.getId();
        service.updateCustomer(idCustomer,expectedName);
        Customer newCustomer= service.getActiveCustomerById(idCustomer);

        assertEquals(expectedName, newCustomer.getName(), "The Name returned corrupted");

    }


    @Test
    void deleteCustomerById() {
        String expectedName = "Вася";
        Customer savedCustomer = service.save("Вася");
        long idCustomer = savedCustomer.getId();
        service.updateCustomer(idCustomer,expectedName);
        Customer newCustomer= service.getActiveCustomerById(idCustomer);

        assertEquals(expectedName, newCustomer.getName(), "The Name returned corrupted");


    }

    @Test
    void deleteCustomerByName() {
    }

    @Test
    void restoreCustomerById() {
    }

    @Test
    void getAllActiveCustomersCount() {
    }

    @Test
    void getCustomerOrderTotalPrice() {
    }

    @Test
    void getCustomerOrderAveragePrice() {
    }

    @Test
    void addActivePizzaToCustomerOrder() {
    }

    @Test
    void removePizzaFromCustomerOrder() {
    }

    @Test
    void clearActiveCustomerOrder() {
    }
}