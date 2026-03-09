package ru.bmstu.iu3.order;
import ru.bmstu.iu3.menu.Dish;

public interface OrderManager {
    void showBill();
    void addDish(Dish dish);
    void removeDish(Dish dish);
    int getPrice();
}
