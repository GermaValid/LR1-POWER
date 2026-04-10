package ru.bmstu.iu3.service;

import ru.bmstu.iu3.exception.ValidationException;
import ru.bmstu.iu3.menu.DefaultDishFactory;
import ru.bmstu.iu3.menu.DishFactory;
import ru.bmstu.iu3.menu.Menu;
import ru.bmstu.iu3.menu.MenuCsvLoader;
import ru.bmstu.iu3.menu.MenuUnitOfWork;

import java.io.IOException;
import java.io.InputStream;

public class MenuService {
    private final Menu menu;
    private final DishFactory dishFactory;

    public MenuService() {
        this.menu = new Menu();
        this.dishFactory = new DefaultDishFactory();
        initializeMenu();
    }

    private void initializeMenu() {
        MenuUnitOfWork uow = new MenuUnitOfWork(menu, dishFactory);
        try (InputStream in = MenuService.class.getResourceAsStream("/data/menu.csv")) {
            if (in != null) {
                try {
                    MenuCsvLoader.loadInto(in, uow);
                } catch (ValidationException e) {
                    seedDefaultMenu(uow);
                }
            } else {
                seedDefaultMenu(uow);
            }
        } catch (IOException e) {
            uow.rollback();
            seedDefaultMenu(uow);
        }
        uow.commit();
    }

    private static void seedDefaultMenu(MenuUnitOfWork uow) {
        uow.registerNew("Кофе", 100, "Горячий и ароматный кофе");
        uow.registerNew("Чай", 50, "Прохладный чай");
        uow.registerNew("Пирожное", 200, "Вкусное пирожное");
    }

    public Menu getMenu() {
        return menu;
    }

    public void displayMenu() {
        menu.showMenu();
    }
}