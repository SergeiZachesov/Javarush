package com.javarush.task.task18.task1813;


import java.io.*;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";

    FileOutputStream fileOutputStream;



    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        this.fileOutputStream=fileOutputStream;
    }

    @Override
    public void write(int b) throws IOException {
        this.fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        this.fileOutputStream.write(b);
    }

    @Override
    public void flush() throws IOException {
        this.fileOutputStream.flush();
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        this.fileOutputStream.write(b, off, len);
    }

    @Override
    public void close() throws IOException {

        this.fileOutputStream.flush();
        String string = "JavaRush © All rights reserved.";
        this.fileOutputStream.write(string.getBytes());
        this.fileOutputStream.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
