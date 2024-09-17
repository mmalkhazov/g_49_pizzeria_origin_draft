package pizzeria.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import pizzeria.domain.Pizza;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PizzaRepositoryFile implements PizzaRepository {
    private File database;
    private ObjectMapper mapper;
    private long currentId;


    public PizzaRepositoryFile() {
        database = new File("pizza_database.txt");
        mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            database.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getMaxId();
    }

    private void getMaxId() {
        List<Pizza> pizzasList = findAll();
        if (!pizzasList.isEmpty()) {
            Pizza lastPizza = pizzasList.get(pizzasList.size() - 1);
            currentId = lastPizza.getId();
        }

    }
//????????? ????? ?????? ? ???? ?????? . ??? ???? ??????? ?????? ??????? ????????????? ??????
//????????????? ???????????????????? ?????????? ?????????????


    @Override
    public Pizza save(Pizza pizza) {
        List<Pizza> pizzasList = findAll();
        pizza.setId(++currentId);
        pizza.setActive(true);
        pizzasList.add(pizza);
        try {
            mapper.writeValue(database, pizzasList);
            return pizza;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public List<Pizza> findAll() {
        try {
            Pizza[] pizzasArray = mapper.readValue(database, Pizza[].class);
            List<Pizza> pizzasList = new ArrayList<>();
            Collections.addAll(pizzasList, pizzasArray);
            return pizzasList;
        } catch (IOException e) {
            return new ArrayList<>();
        }

    }

    //??????? ???? ?????? ?? ??? ??????????????
    @Override
    public Pizza findById(long id) {
        return findAll()
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
    }



    @Override
    public void update(Pizza pizza) {
        List<Pizza> pizzasList = findAll();

        pizzasList
                .stream()
                .filter(x -> x.getId() == pizza.getId())
                .limit(1)
                .forEach(x -> {
                    x.setPrice(pizza.getPrice());
                    x.setActive(true);

                });
        try {
            mapper.writeValue(database, pizzasList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        long idToUpdate = pizza.getId();
//        double newPrice = pizza.getPrice();
//            boolean active = pizza.isActive()  ????????? active ??-?? ?????? "public void restorePizzaById" ? ?????? PizzaServiceImpl
//
//        List<Pizza> pizzasList = findAll();
//
//        for (Pizza currentPizza : pizzasList) {
//            if (currentPizza.getId() == idToUpdate) {
//                currentPizza.setPrice(newPrice);
//                currentPizza.setActive(active); ????????? active ??-?? ?????? "public void restorePizzaById" ? ?????? PizzaServiceImpl
//                break;
//            }
//        }
//        try {
//            mapper.writeValue(database,pizzasList);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


    }



    @Override
    public void deleteById(long Id) {
        List<Pizza> pizzasList = findAll();

        pizzasList
                .stream()
                .filter(x -> x.getId() == Id)
                .limit(1)
                .forEach(x -> x.setActive(false));


        try {
            mapper.writeValue(database, pizzasList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    }
