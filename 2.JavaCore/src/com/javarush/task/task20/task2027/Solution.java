package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        System.out.println(detectAllWords(crossword, "home", "same"));
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {


        char[][] wordChar = new char[words.length][];
        ArrayList<Word> wordArr = new ArrayList<Word>();

        for (int i = 0; i < words.length; i++) {
            wordChar[i] = words[i].toCharArray();
        }

        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {
                //System.out.print(" " + crossword[i][j] + " ");
                for (int k = 0; k < words.length; k++) {
                    if (wordChar[k][0] == crossword[i][j]) {

                        //Поиск слова на ЗАПАД
                        for (int vec2 = j, w = 0; vec2 >= 0 && w < wordChar[k].length; vec2--, w++) {
                            if (wordChar[k][w] == crossword[i][vec2]) {
                                if (w == wordChar[k].length - 1) {
                                    wordArr.add(new Word(words[k]));
                                    wordArr.get(wordArr.size() - 1).setStartPoint(j, i);
                                    wordArr.get(wordArr.size() - 1).setEndPoint(vec2, i);
                                    //System.out.println(wordArr.get(wordArr.size() - 1));
                                    break;
                                }
                            } else {
                                break;
                            }
                        }

                        //Поиск слова на СЕВЕРО-ЗАПАД
                        for (int vec1 = i, vec2 = j, w = 0; vec2 >= 0 && vec1 >= 0 && w < wordChar[k].length; vec2--, vec1--, w++) {
                            if (wordChar[k][w] == crossword[vec1][vec2]) {
                                if (w == wordChar[k].length - 1) {
                                    wordArr.add(new Word(words[k]));
                                    wordArr.get(wordArr.size() - 1).setStartPoint(j, i);
                                    wordArr.get(wordArr.size() - 1).setEndPoint(vec2, vec1);
                                    //System.out.println(wordArr.get(wordArr.size() - 1));
                                    break;
                                }
                            } else {
                                break;
                            }
                        }

                        //Поиск слова на СЕВЕР
                        for (int vec1 = i, w = 0; vec1 >= 0 && w < wordChar[k].length; vec1--, w++) {
                            if (wordChar[k][w] == crossword[vec1][j]) {
                                if (w == wordChar[k].length - 1) {
                                    wordArr.add(new Word(words[k]));
                                    wordArr.get(wordArr.size() - 1).setStartPoint(j, i);
                                    wordArr.get(wordArr.size() - 1).setEndPoint(j, vec1);
                                    //System.out.println(wordArr.get(wordArr.size() - 1));
                                    break;
                                }
                            } else {
                                break;
                            }
                        }

                        //Поиск слова на СЕВЕРО-ВОСТОК
                        for (int vec1 = i, vec2 = j, w = 0; vec1 >= 0 && vec2 < crossword[vec1].length && w < wordChar[k].length; vec1--, vec2++, w++) {
                            if (wordChar[k][w] == crossword[vec1][vec2]) {
                                if (w == wordChar[k].length - 1) {
                                    wordArr.add(new Word(words[k]));
                                    wordArr.get(wordArr.size() - 1).setStartPoint(j, i);
                                    wordArr.get(wordArr.size() - 1).setEndPoint(vec2, vec1);
                                    //System.out.println(wordArr.get(wordArr.size() - 1));
                                    break;
                                }
                            } else {
                                break;
                            }
                        }

                        //Поиск слова на ВОСТОК
                        for (int vec2 = j, w = 0; vec2 < crossword[i].length && w < wordChar[k].length; vec2++, w++) {
                            if (wordChar[k][w] == crossword[i][vec2]) {
                                if (w == wordChar[k].length - 1) {
                                    wordArr.add(new Word(words[k]));
                                    wordArr.get(wordArr.size() - 1).setStartPoint(j, i);
                                    wordArr.get(wordArr.size() - 1).setEndPoint(vec2, i);
                                    //System.out.println(wordArr.get(wordArr.size() - 1));
                                    break;
                                }
                            } else {
                                break;
                            }
                        }

                        //Поиск слова на ЮГО-ВОСТОК
                        for (int vec1 = i, vec2 = j, w = 0; vec1 < crossword.length && vec2 < crossword[vec1].length && w < wordChar[k].length; vec2++, vec1++, w++) {
                            if (wordChar[k][w] == crossword[vec1][vec2]) {
                                if (w == wordChar[k].length - 1) {
                                    wordArr.add(new Word(words[k]));
                                    wordArr.get(wordArr.size() - 1).setStartPoint(j, i);
                                    wordArr.get(wordArr.size() - 1).setEndPoint(vec2, vec1);
                                    //System.out.println(wordArr.get(wordArr.size() - 1));
                                    break;
                                }
                            } else {
                                break;
                            }
                        }

                        //Поиск слова на ЮГ
                        for (int vec1 = i, w = 0; vec1 < crossword.length && w < wordChar[k].length; vec1++, w++) {
                            if (wordChar[k][w] == crossword[vec1][j]) {
                                if (w == wordChar[k].length - 1) {
                                    wordArr.add(new Word(words[k]));
                                    wordArr.get(wordArr.size() - 1).setStartPoint(j, i);
                                    wordArr.get(wordArr.size() - 1).setEndPoint(j, vec1);
                                    //System.out.println(wordArr.get(wordArr.size() - 1));
                                    break;
                                }
                            } else {
                                break;
                            }
                        }

                        //Поиск слова на ЮГО-ЗАПАД
                        for (int vec1 = i, vec2 = j, w = 0; vec2 >= 0 && vec1 < crossword.length && w < wordChar[k].length; vec1++, vec2--, w++) {
                            if (wordChar[k][w] == crossword[vec1][vec2]) {
                                if (w == wordChar[k].length - 1) {
                                    wordArr.add(new Word(words[k]));
                                    wordArr.get(wordArr.size() - 1).setStartPoint(j, i);
                                    wordArr.get(wordArr.size() - 1).setEndPoint(vec2, vec1);
                                    //System.out.println(wordArr.get(wordArr.size() - 1));
                                    break;
                                }
                            } else {
                                break;
                            }
                        }

                    }
                }
            }
        }
        return wordArr;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
