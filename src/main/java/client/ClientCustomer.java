package client;


import pizzeria.controller.CustomerController;
import pizzeria.domain.Customer;
import pizzeria.domain.Pizza;
import pizzeria.repository.CustomerRepository;
import pizzeria.repository.CustomerRepositoryFile;
import pizzeria.repository.PizzaRepository;
import pizzeria.repository.PizzaRepositoryFile;
import pizzeria.service.CustomerService;
import pizzeria.service.CustomerServiceImpl;
import pizzeria.service.PizzaServiceImpl;

import java.util.List;


public class ClientCustomer {


    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryFile();
        PizzaRepository pizzaRepository = new PizzaRepositoryFile();

        CustomerService service = new CustomerServiceImpl(repository, pizzaRepository);
        CustomerController controller = new CustomerController(service);





//        Вернуть всех покупателей из базы данных активных
        System.out.println("Список всех клиентов");
        List<Customer> customersList = controller.getAll();
        customersList.forEach(System.out::println);

//     Сохранить покупателя в базе данных при сохранении покупатель автоматически считается активным
        controller.save("Александр");
        controller.save("Кристин");
        controller.save("Игорь");
        controller.save("Вася");
//        controller.deleteById(2);


//        System.out.println("Список всех клиентов");
//        customersList = controller.getAll();
//        customersList.forEach(System.out::println);

//     Вернуть одного покупателя из базы данных по его идентификатору если он активен
//        System.out.println("---");
//        controller.addPizzaToOrder(3, 3);
//        System.out.println("Клиент - id 3:" + controller.getById(3));
////        System.out.println("----");

//    Удалить покупателя из базы данных по его идентификатору
//        controller.deleteById(3);

//    Удалить покупателя из базы данных по его имени

//        controller.deleteByName("Кристин");
//        System.out.println("Список всех клиентов");
//        customersList = controller.getAll();
//        customersList.forEach(System.out::println);

//   Восстановить удалённого покупателя в базе данных по его идентификатору

//        controller.restoreById(3);
//        System.out.println("Список всех клиентов");
//        customersList = controller.getAll();
//        customersList.forEach(System.out::println);


//     Изменить одного покупателя в базе данных по его идентификатору

//        controller.updateCustomer(2, "Вася");
//        System.out.println("Список всех клиентов");
//        customersList = controller.getAll();
//        customersList.forEach(System.out::println);


//    Добавить товар в корзину покупателя по их идентификаторам если оба активны
//        controller.addPizzaToOrder(1, 1);
        controller.addPizzaToOrder(2, 5);
        controller.addPizzaToOrder(2, 3);
        controller.addPizzaToOrder(2, 4);
        System.out.println("Список всех клиентов");
        customersList = controller.getAll();
        customersList.forEach(System.out::println);

//    Удалить товар из корзины покупателя по их идентификаторам

//        controller.removePizzaFromOrder(2,3);



//    Полностью очистить корзину покупателя по его идентификатору если он активен
        controller.clearCustomerOrder(2);
        System.out.println("Список всех клиентов");
        customersList = controller.getAll();
        customersList.forEach(System.out::println);


//      Вернуть стоимость корзины покупателя по его идентификатору если он активен
//      Вернуть среднюю стоимость продукта в корзине покупателя по его идентификатору если он активен

        System.out.println("Сумма цен продуктов - " + controller.getCustomersOrderTotalPrice(2));
        System.out.println("Средняя цена продукта - " + controller.getCustomersOrderAveragePrice(2));


//        Вернуть общее количество покупателей в базе данных активных
//        System.out.println("Количество клиентов в БД:");
//        long customersCount = controller.getCustomersCount();
//        System.out.println(customersCount);





    }
}
