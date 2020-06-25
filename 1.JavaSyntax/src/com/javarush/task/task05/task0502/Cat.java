package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {

    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        int n = 0, m = 0;
        if (this.age > anotherCat.age) {
            n++;
        } else if (this.age < anotherCat.age) {
            m++;
        }
        if (this.weight > anotherCat.weight) {
            n++;
        } else if (this.weight < anotherCat.weight) {
            m++;
        }
        if (this.strength > anotherCat.strength) {
            n++;
        } else if (this.strength < anotherCat.strength) {
            m++;
        }
        if (n > m) {
            return true;
        } else if (n < m) {
            return false;
        } else {
            return false;
        }

    }


    public static void main(String[] args) {
    Cat cat1 = new Cat();
    cat1.age = 1;
    cat1.weight = 1;
    cat1.strength = 8;
    Cat cat2 = new Cat();
    cat2.age = 2;
    cat2.weight = 2;
    cat2.strength = 2;

    System.out.println (cat1.fight(cat2));
    System.out.println (cat2.fight(cat1));


    }
}
