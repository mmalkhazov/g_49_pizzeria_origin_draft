package pizzeria.controller;

import pizzeria.domain.Pizza;
import pizzeria.service.PizzaService;

import java.util.List;

public class PizzaController {


    private PizzaService service;

    public PizzaController(PizzaService service) {
        this.service = service;
    }

    public List<Pizza> getAll() {
        return service.getAllActivePizzas();
    }

    public Pizza save(String title, double price) {
        return service.save(title, price);
    }

    public Pizza getById(long id) {
        return service.getActivePizzaById(id);
    }

    public void deleteById(long id) {
        service.deletePizzaById(id);
    }

    public void updatePizza(long id, double newPrice){
        service.updatePizza(id, newPrice);
    }


    public void deleteByTitle(String title){
        service.deletePizzaByTitle(title);
    }
    public void restoreById(long id) {
        service.restorePizzaById(id);
    }

    public long getPizzasCount() {
        return service.getAllActivePizzasCount();
    }

    public double getPizzasTotalPrice() {
        return service.getAllActivePizzasTotalPrice();
    }

    public double getPizzasAveragePrice() {
        return service.getAllActivePizzasAveragePrice();
    }

}
