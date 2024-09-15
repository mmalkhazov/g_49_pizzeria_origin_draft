package pizzeria.domain;

import java.util.Objects;

public class Pizza {

    private long id;
    private String title;
    private double price;
    private boolean isActive;


    public Pizza() {
    }

    public Pizza(String title, double price) {
//        this.id = id; удаляем из-за метода "public Pizza save" в классе PizzaServiceImpl
        this.title = title;
        this.price = price;
//        this.isActive = isActive; удаляем из-за метода "public Pizza save" в классе PizzaServiceImpl
    }

    public Pizza(long id, double price) { // coздаем из-за метода "public void updatePizza" в классе PizzaServiceImpl
        this.id = id;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return id == pizza.id && Double.compare(price, pizza.price) == 0 && isActive == pizza.isActive && Objects.equals(title, pizza.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, isActive);
    }


    @Override
    public String toString() {
        return String.format("Pizza: id - %d, title - %s, price - %.2f, active - %s",
                id, title, price, isActive ? "is available":"not available");
    }
}





