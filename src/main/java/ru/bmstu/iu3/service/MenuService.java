package ru.bmstu.iu3.service;

import ru.bmstu.iu3.menu.Dish;
import ru.bmstu.iu3.menu.Menu;

public class MenuService {
    private final Menu menu;

    public MenuService() {
        this.menu = new Menu();
        initializeMenu();
    }

    private void initializeMenu() {
        // Инициализация меню (перенесено из CafeService)
        // т.к. проект маленький, то нет смысла делать отдельный класс для загрузки меню из файла
        // в реальной жизни была бы бд 
        menu.addDish(new Dish("Кофе", 100, "Горячий и ароматный кофе"));
        menu.addDish(new Dish("Чай", 50, "Прохладный чай"));
        menu.addDish(new Dish("Пирожное", 200, "Вкусное пирожное"));
    }

    public Menu getMenu() {
        return menu;
    }

    public void displayMenu() {
        menu.showMenu();
    }
}