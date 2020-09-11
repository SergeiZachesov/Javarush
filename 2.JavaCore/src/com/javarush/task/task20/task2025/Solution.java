package com.javarush.task.task20.task2025;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/* 
Алгоритмы-числа
*/
public class Solution {

    private static long[][] numDeg;
    private static Set<Long> set;

    public static long[] getNumbers(long N) {

        long[] result = null;
        set = new TreeSet<>();

        //Если приходящее значение равно 1
        if (N == 1) {
            //result = new long[]{1};
            return result;
        }


        int charNum = numsInNum(N - 1);

        if (charNum > 0 && N > 0) {

            int[] arrayNum = arrNumsInNum(N - 1, charNum);

            //Массив со всеми цифрами, возведенные в степень столько раз, сколько цифр в числе
            numDeg = new long[10][charNum];
            long exponBuf;
            for (int i = 0; i < 10; i++) {
                exponBuf = 1;
                for (int j = 0; j < charNum; j++) {
                    exponBuf *= i;
                    numDeg[i][j] = exponBuf;
                }
            }

            //Создание треугольного двухмерного массива
            int[][] triangleMatrix = new int[charNum][];
            for (int i = 0; i < charNum; i++) {
                triangleMatrix[i] = new int[i + 1];
            }
            triangleMatrix[triangleMatrix.length - 1] = arrayNum;
            for (int i = 0; i < charNum - 1; i++) {
                for (int j = 0; j < triangleMatrix[i].length; j++) {
                    triangleMatrix[i][j] = 9;
                }
            }

            //Перебор треугольного двухмерного массива
            for (int i = triangleMatrix.length - 1; i >= 0; i--) {
                generateNums(triangleMatrix[i], N);
            }
        }
        result = new long[set.size()];
        int count = 0;
        for (long number : set) {
            result[count] = number;
            count++;
        }
        return result;
    }

    private static void generateNums(int[] arr, long N) {
        int last = arr.length - 1;
        if (arr.length > 1) {
            do {
                if (arr[last] >= arr[last - 1]) {
                    if (arr[last] == 0 & arr[0] == 0) break;
                    checkAddToArr(arr, N);
                }
                arr[last]--;
                for (int i = last - 1; i > -1; i--) {
                    if (arr[i] > arr[i + 1]) {
                        arr[i]--;
                        arr[i + 1] = 9;
                    }
                }
            } while (arr[last] > 0);
        } else {
            for (long i = arr[0]; i > 0; i--) {
                if (i < N) {
                    set.add(i);
                }
            }
        }
    }

    private static void checkAddToArr(int[] arr, long N) {

        long resultNum = 0;
        long resultArr = 0;
        for (int n = 0; n < arr.length; n++) {
            resultArr += numDeg[arr[n]][arr.length - 1];
        }
        //System.out.println(resultArr);
        int charN = numsInNum(N - 1);
        int charNum = numsInNum(resultArr);
        if (charN > 0 && charN >= charNum) {
            int[] arrayNum = arrNumsInNum(resultArr, charNum);
            for (int n = 0; n < arrayNum.length; n++) {
                resultNum += numDeg[arrayNum[n]][arrayNum.length - 1];
            }

            if (resultNum == resultArr && resultNum < N) {
                set.add(resultNum);
            }
        }
    }

    //Количесто цифр в числе
    private static int numsInNum(long numb) {
        int charNum = 0;
        while (numb > 0) {
            charNum++;
            numb = numb / 10;
        }
        return charNum;
    }

    //Запись в массив цифры числа
    private static int[] arrNumsInNum(long numb, int numsInNum) {
        int[] result = new int[numsInNum];
        for (int i = numsInNum - 1; i >= 0; i--) {
            result[i] = (int) (numb % 10);
            numb = numb / 10;
        }
        return result;
    }

    public static void main(String[] args) {

        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        long b = System.currentTimeMillis();
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/1000000 + " MB");
        System.out.println("time = " + (b - a) / 1000+"s");

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1)));
        b = System.currentTimeMillis();
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/1000000 + " MB");
        System.out.println("time = " + (b - a) / 1000+"s");

    }
}
