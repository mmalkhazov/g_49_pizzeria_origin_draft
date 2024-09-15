package pizzeria.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Customer {

    private long id;
    private String name;
    private boolean isActive;
    private List<Pizza> pizzaList = new ArrayList<>();


    public Customer() {
    }


    public Customer(long id, String name, boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }



//    ФУНКЦИОНАЛ.ПОКУПАТЕЛЯ ЕГО ПОВЕДЕНИЕ

//    Добавить продукт в свой список если активный

    public void addPizza(Pizza pizza){
        if(pizza.isActive()){
            pizzaList.add(pizza);
        }
    }

//    Получение всех продуктов , находящихся в списке активных

    public List<Pizza> getAllActivePizzas(){
        return pizzaList
                .stream()
                .filter(x->x.isActive())
                .toList();
    }


//    Удалить продукт из списка по его идентификатору
public void deletePizzaById(long Id){
        Iterator<Pizza> iterator =pizzaList.iterator();
        while(iterator.hasNext()){
            Pizza currentPizza=iterator.next();
            if(currentPizza.getId()== id){
                iterator.remove();
                break;
            }
        }
}
//Полная очистка списка удаление всех продуктов
public void clearAllPizzas(){
        pizzaList.clear();
}
//Получение общей стоимости списка активных продуктов
public double getActivePizzasTotalPrice(){
        return pizzaList
                .stream()
                .filter(x->x.isActive())
                .mapToDouble(x->x.getPrice())
                .sum();
}


//Получение средней стоимости товара в списке из активных продуктов
public double getActivePizzasAveragePrice(){
        return pizzaList
                .stream()
                .filter(x->x.isActive())
                .mapToDouble(x->x.getPrice())
                .average()
                .orElse(0.0);

}



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && isActive == customer.isActive && Objects.equals(name, customer.name) && Objects.equals(pizzaList, customer.pizzaList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isActive, pizzaList);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Customer: id - ");
        builder
                .append(id)
                .append(", name - ")
                .append(name)
                .append(", active - ")
                .append(isActive ? "yes" : "no")
                .append("\n")
                .append("Pizzas list:\n");

        for (Pizza pizza : pizzaList) {
            builder.append(pizza).append("\n");
        }

        return builder.toString();
    }




}

