package com.javarush.task.task14.task1408;

class UkrainianHen extends Hen {

    public int getCountOfEggsPerMonth(){
        return 2;
    }

    public String getDescription(){

        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + this.getCountOfEggsPerMonth() +" яиц в месяц."; }

}