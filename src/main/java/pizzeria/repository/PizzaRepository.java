package pizzeria.repository;

import pizzeria.domain.Pizza;

import java.util.List;

public interface PizzaRepository {

Pizza save(Pizza pizza);
List<Pizza> findAll();
Pizza findById (long id);
void update (Pizza pizza);
void deleteById(long Id);



}
