package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileOutputStream fileOutput = new FileOutputStream("C:\\Users\\mdv106u\\YandexDisk\\Программирование\\Java\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2014\\Файл.dat");
        FileInputStream fiStream = new FileInputStream("C:\\Users\\mdv106u\\YandexDisk\\Программирование\\Java\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2014\\Файл.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        Solution savedObject = new Solution(4);
        outputStream.writeObject(savedObject);
        fileOutput.close();
        outputStream.close();

        Solution loadedObject = new Solution(4);
        loadedObject = (Solution)objectStream.readObject();
        fiStream.close();
        objectStream.close();

        System.out.println(loadedObject.string.equals(savedObject.string));

        System.out.println(new Solution(4));
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
