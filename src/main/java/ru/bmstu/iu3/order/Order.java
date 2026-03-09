package ru.bmstu.iu3.order;

import java.util.HashMap;
import java.util.Map;
import ru.bmstu.iu3.menu.Dish;

public class Order implements OrderManager {

    Map<Dish, Integer> orderedDishes = new HashMap<Dish, Integer>();
    int price = 0;
    
    @Override
    public void showBill() {
        price = 0;
        for (Dish dish : orderedDishes.keySet()) {
            int quantity = orderedDishes.get(dish);
            int dishTotal = dish.getPrice() * quantity;
            System.out.println(dish.getName() + " x " + quantity + " = " + dishTotal + " руб.");
            price +=dishTotal;
        }
        System.out.println("Итоговая стоимость: " + price + " руб.");
        System.out.println("-=--------------------------------------=-");
    }


    @Override
    public void addDish(Dish dish) {
        orderedDishes.put(dish, orderedDishes.getOrDefault(dish, 0) + 1);
    }

    @Override
    public void removeDish(Dish dish) {
        orderedDishes.put(dish, orderedDishes.getOrDefault(dish, 0) - 1);
         if (orderedDishes.get(dish) <= 0) {
            orderedDishes.remove(dish);
        }
    }

    public int getPrice() {
        return price;
    }   
}
