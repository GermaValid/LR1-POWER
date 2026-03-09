package ru.bmstu.iu3.service;
import java.util.Scanner;
public class Reader implements InputReader {
     Scanner scanner = new Scanner(System.in);
   @Override
     public int readInt(String message) {
        if (message != null) System.out.println(message);
        else System.out.println("Введите число: ");
        try {
            return scanner.nextInt();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный ввод. Пожалуйста, введите целое число.");
        }
        
     }
     @Override
     public String readString(String message) {
        if (message != null) System.out.println(message);
        else System.out.println("Введите строку: ");
        return scanner.next();
     }

    public void close() {
        scanner.close();
    }
}
