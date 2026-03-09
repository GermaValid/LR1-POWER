package ru.bmstu.iu3.menu;
import java.util.ArrayList;
import java.util.List;

public class Menu implements MenuRepository {
    /* По хорошему тут должен быть файл меню внешний
    который бы считывался этой имбой, но мне лееееееееееееень */
    List<Dish> menuItems = new ArrayList<Dish>();
    @Override
    public void addDish(Dish dish) 
    {
        menuItems.add(dish);
    }
    @Override
    public void removeDish(Dish dish) 
    {
            menuItems.remove(dish);
    }
    @Override
    public void showMenu() 
    {
        for (Dish dish : menuItems) {
            System.out.println(dish.getName() + " --------------------------------- " + dish.getPrice() + " руб.\n Описание: " + dish.getDescription());
        }
    }
    @Override
    public Dish getDishByNumber(int number) {
        try{
        return menuItems.get(number - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Неверный номер блюда. Пожалуйста, выберите номер от 1 до " + menuItems.size() + ".");
            return null;
        }
    }
}
