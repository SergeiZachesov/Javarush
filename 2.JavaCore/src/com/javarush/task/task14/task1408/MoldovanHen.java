package com.javarush.task.task14.task1408;

class MoldovanHen extends Hen {

    public int getCountOfEggsPerMonth(){
        return 3;
    }

    public String getDescription(){

        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + this.getCountOfEggsPerMonth() +" яиц в месяц."; }

}
