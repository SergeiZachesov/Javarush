package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Zerg strack1 = new Zerg();
        strack1.name = "strack1";
        Zerg strack2 = new Zerg();
        strack2.name = "strack2";
        Zerg strack3 = new Zerg();
        strack3.name = "strack3";
        Zerg strack4 = new Zerg();
        strack4.name = "strack4";
        Zerg strack5 = new Zerg();
        strack5.name = "strack5";

        Protoss kyri1 = new Protoss();
        kyri1.name = "kyri1";
        Protoss kyri2 = new Protoss();
        kyri2.name = "kyri2";
        Protoss kyri3 = new Protoss();
        kyri3.name = "kyri3";

        Terran salas1 = new Terran();
        salas1.name = "salas1";
        Terran salas2 = new Terran();
        salas2.name = "salas2";
        Terran salas3 = new Terran();
        salas3.name = "salas3";
        Terran salas4 = new Terran();
        salas4.name = "salas4";
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
