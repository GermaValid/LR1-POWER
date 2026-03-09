package ru.bmstu.iu3;
import ru.bmstu.iu3.order.Order;
import ru.bmstu.iu3.service.*;

import java.util.ArrayList;
import java.util.List;

import ru.bmstu.iu3.payment.*;

/**
 * Hello world!
 *
 */
public class App 
{

public static void main(String[] args) {
    Order order = new Order();
    Reader reader = new Reader();
    List<Payment> paiments = new ArrayList<>();
    paiments.add(new CardPayment());
    paiments.add(new CashPayment());
    MenuService menuService = new MenuService();
    OrderService orderService = new OrderService(order, menuService.getMenu(),  reader);
    PaymentService paimentService = new PaymentService(paiments, reader);
    CafeService cafeService = new CafeService(menuService, orderService, paimentService);
    cafeService.run();
    reader.close();
}
}
