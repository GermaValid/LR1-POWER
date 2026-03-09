package ru.bmstu.iu3.service;

public class CafeService {
    private final MenuService menuService;
    private final OrderService orderService;
    private final PaymentService paimentService;

    public CafeService(MenuService menuService, OrderService orderService, PaymentService paimentService) {
        this.menuService = menuService;
        this.orderService = orderService;
        this.paimentService = paimentService;
    }

    public void run() {
        menuService.displayMenu();
        orderService.makeOrder();
        paimentService.payService(orderService.getBill());
    }
}