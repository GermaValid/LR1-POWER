package ru.bmstu.iu3.service;

import ru.bmstu.iu3.order.*;
import ru.bmstu.iu3.menu.*;

public class OrderService {
    private final OrderManager order;
    private final MenuRepository menu;
    private final InputReader reader;
    
    public OrderService(OrderManager order, MenuRepository menu, InputReader reader) {
        this.order = order;
        this.menu = menu;
        this.reader = reader;
    }

    public void makeOrder() {
        boolean flag = true;
        System.out.println("------------------------------------------");
        while(flag)
            {
                order.addDish(menu.getDishByNumber(reader.readInt("Выберите номер блюда для добавления в заказ:")));
                System.out.println();
                if (reader.readInt("Хотите добавить еще блюдо? 1 - Да, 0 - Нет") == 0) {
                    flag = false;
                }
            }
    }

    public int getBill() {
        return order.getPrice();
    }

    public void showBill() {
        order.showBill();
    }

    public void clearOrder() {
        order.clear();
    }
}
