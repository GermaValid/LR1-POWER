package ru.bmstu.iu3.service;

import java.util.List;

import ru.bmstu.iu3.payment.*;

public class PaymentService {
    private final List<Payment> paiments;
    private final InputReader reader;

    public PaymentService(List<Payment> paiments, InputReader reader) {
        this.paiments = paiments;
        this.reader = reader;
    }

    public void addPaiment(Payment paiment) {
        paiments.add(paiment);
    }

    public void payService(int amount) {
        for (Payment paiment : paiments) {
            paiment.description();
        }
        int choice = reader.readInt("Выберите способ оплаты (введите номер):");
        if (choice >= 1 && choice <= paiments.size()) {
            paiments.get(choice - 1).pay(amount, reader);
        } else {
            throw new IllegalArgumentException("Неверный выбор. Пожалуйста, выберите номер от 1 до " + paiments.size() + ".");
        }
    }
}
