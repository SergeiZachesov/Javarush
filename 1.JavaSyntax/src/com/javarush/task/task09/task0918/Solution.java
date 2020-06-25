package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

import java.io.IOException;

public class Solution {
    public static void main(String[] args) {

            MyException myException  = new MyException();
            MyException2 myException2  = new MyException2();
            MyException3 myException3  = new MyException3();
            MyException4 myException4  = new MyException4();

    }
    
    static class MyException extends IOException { }

    static class MyException2 extends Error{
    }

    static class MyException3 extends IOException {
    }

    static class MyException4 extends Error {
    }
}

