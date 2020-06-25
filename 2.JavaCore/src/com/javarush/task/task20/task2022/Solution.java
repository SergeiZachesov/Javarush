package com.javarush.task.task20.task2022;

import java.io.*;

/*
Переопределение сериализации в потоке
*/

//C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task20\task2022\Файл.txt

public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {

        String f = "D:\\test\\Файл.bin";

        Solution solution = new Solution(f);
        solution.writeObject("something");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(f));
        outputStream.writeObject(solution);
        outputStream.close();
        solution.close();

        ObjectInputStream objectStream = new ObjectInputStream(new FileInputStream(f));
        Solution loadedObject = (Solution) objectStream.readObject();
        loadedObject.writeObject("something modified");
        loadedObject.close();
        objectStream.close();

    }
}
