package pizzeria.service;

import pizzeria.domain.Pizza;

import java.util.List;

public interface PizzaService {

//    Сохранить продукт в базе данных при сохранении продукт автоматически считается активным
//Вернуть все продукты из базы данных активные
//Вернуть один продукт из базы данных по его идентификатору если он активен
//Изменить один продукт в базе данных по его идентификатору
//Удалить продукт из базы данных по его идентификатору
//Удалить продукт из базы данных по его наименованию
//Восстановить удалённый продукт в базе данных по его идентификатору
//Вернуть общее количество продуктов в базе данных активных
//Вернуть суммарную стоимость всех продуктов в базе данных активных
//Вернуть среднюю стоимость продукта в базе данных из активных


    Pizza save(String pizzaTitle, double pizzaPrice);
    List<Pizza> getAllActivePizzas();
    Pizza getActivePizzaById(long id);
    void updatePizza(long pizzaId, double newPrice);
    void deletePizzaById(long id);
    void deletePizzaByTitle(String title);
    void restorePizzaById(long id);
    long getAllActivePizzasCount();
    double getAllActivePizzasTotalPrice();
    double getAllActivePizzasAveragePrice();




}
