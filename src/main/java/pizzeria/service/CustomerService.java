package pizzeria.service;

import pizzeria.domain.Customer;

import java.util.List;

public interface CustomerService {


//Функционал сервиса покупателей
//Сохранить покупателя в базе данных при сохранении покупатель автоматически считается активным/
//Вернуть всех покупателей из базы данных активных/
//Вернуть одного покупателя из базы данных по его идентификатору если он активен/
//Изменить одного покупателя в базе данных по его идентификатору/
//Удалить покупателя из базы данных по его идентификатору/
//Удалить покупателя из базы данных по его имени/
//Восстановить удалённого покупателя в базе данных по его идентификатору/
//Вернуть общее количество покупателей в базе данных активных/
//Вернуть стоимость корзины покупателя по его идентификатору если он активен/
//Вернуть среднюю стоимость продукта в корзине покупателя по его идентификатору если он активен/
//Добавить товар в корзину покупателя по их идентификаторам если оба активны/
//Удалить товар из корзины покупателя по их идентификаторам/
//Полностью очистить корзину покупателя по его идентификатору если он активен

    Customer save(String customerName);
    List<Customer> getAllActiveCustomer();
    Customer getActiveCustomerById(long id);
    void updateCustomer(long id, String newName);
    void deleteCustomerById(long id);
    void deleteCustomerByName(String name);
    void restoreCustomerById(long id);
    long getAllActiveCustomersCount();
    double getCustomerOrderTotalPrice(long id);
    double getCustomerOrderAveragePrice(long id);
    void  addActivePizzaToCustomerOrder(long customerId, long pizzaId);
    void  removePizzaFromCustomerOrder(long customerId, long pizzaId);
    void  clearActiveCustomerOrder(long customerId);





}
