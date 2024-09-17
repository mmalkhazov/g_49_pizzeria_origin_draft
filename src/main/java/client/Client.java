package client;

import pizzeria.controller.PizzaController;
import pizzeria.domain.Pizza;
import pizzeria.repository.PizzaRepository;
import pizzeria.repository.PizzaRepositoryFile;
import pizzeria.service.PizzaService;
import pizzeria.service.PizzaServiceImpl;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        PizzaRepository repository=new PizzaRepositoryFile();
        PizzaService service=new PizzaServiceImpl(repository);
        PizzaController controller = new PizzaController(service);

        controller.save("Неаполитанская пицца",100);
        controller.save("Римская пицца", 200);
        controller.save("Сицилийская пицца", 300);
        controller.save("Фермерская пицца", 400);
        controller.save("Пицца по-апулийски", 500);

//        controller.updatePizza(2, 220);


        controller.deleteById(2);

//        controller.deleteByTitle("Peach");
//        controller.deleteByTitle("Маргаритка");
//        controller.restoreById(13L);
//        controller.restoreById(3L);
//        controller.restoreById(1L);


//        System.out.println("Список всех пицц");
//        List<Pizza> pizzasList= controller.getAll();
//        pizzasList.forEach(System.out::println);
////        controller.updatePizza(2, 220);
//        System.out.println("Продукт по идентификатору 2:");
//        Pizza pizza = controller.getById(2L);
//        System.out.println(pizza);
//
//        System.out.println("Количество продуктов в БД:");
//        long pizzasCount = controller.getPizzasCount();
//        System.out.println(pizzasCount);
//
//        System.out.println("Сумма цен продуктов - " + controller.getPizzasTotalPrice());
//        System.out.println("Средняя цена продукта - " + controller.getPizzasAveragePrice());

    }
}
