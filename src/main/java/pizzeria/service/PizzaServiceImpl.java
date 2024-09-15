package pizzeria.service;

import pizzeria.domain.Pizza;
import pizzeria.repository.PizzaRepository;

import java.util.List;

public class PizzaServiceImpl implements PizzaService {

    private PizzaRepository repository;

    public PizzaServiceImpl(PizzaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pizza save(String pizzaTitle, double pizzaPrice) {
        Pizza pizza = new Pizza(pizzaTitle, pizzaPrice);
        repository.save(pizza);
        return pizza;
    }

    @Override
    public List<Pizza> getAllActivePizzas() {
        return repository.findAll()
                .stream()
                .filter(Pizza::isActive)
                .toList();

    }

    @Override
    public Pizza getActivePizzaById(long id) {
        Pizza pizza = repository.findById(id);
        if (pizza != null && pizza.isActive()) {
            return pizza;
        } else {
            return null;
        }

    }

        @Override
        public void updatePizza(long pizzaId, double newPrice) {
            Pizza pizza = new Pizza(pizzaId, newPrice);
            repository.update(pizza);

        }

    @Override
    public void deletePizzaById(long id) {
        repository.deleteById(id);

    }

    @Override
    public void deletePizzaByTitle(String title) {
        repository.findAll()
                .stream()
                .filter(x -> x.getTitle().equals(title))
                .limit(1)
                .forEach(x -> deletePizzaById(x.getId()));

    }

    @Override
    public void restorePizzaById(long id) {
        Pizza pizza = repository.findById(id);

        if (pizza != null && !pizza.isActive()) {
            repository.update(pizza);
        }

    }

    @Override
    public long getAllActivePizzasCount() {
        return getAllActivePizzas().size();
    }

    @Override
    public double getAllActivePizzasTotalPrice() {
        return getAllActivePizzas()
                .stream()
                .mapToDouble(Pizza::getPrice)
                .sum();
    }

    @Override
    public double getAllActivePizzasAveragePrice() {
        return getAllActivePizzas()
                .stream()
                .mapToDouble(Pizza::getPrice)
                .average()
                .orElse(0.0);
    }
}
