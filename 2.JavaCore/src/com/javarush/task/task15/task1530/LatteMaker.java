package com.javarush.task.task15.task1530;

public class LatteMaker extends DrinkMaker {
    @Override
    void getRightCup() {
        System.out.print("Берем чашку для латте");
    }

    @Override
    void putIngredient() {
        System.out.print("Делаем кофе");
    }

    @Override
    void pour() {
        System.out.print("Заливаем молоком с пенкой");
    }
}
