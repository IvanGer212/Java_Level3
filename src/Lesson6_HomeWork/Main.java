package Lesson6_HomeWork;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        /**1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
         * Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
         * идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе
         * необходимо выбросить RuntimeException. Написать набор тестов для этого метода (по 3-4 варианта входных данных).
         * Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
         *
         2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или
         единицы, то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
         */
    }
    public static int[] extractAfterLastFour(int[] array){
        int count=0;
        int index=-1;
        if (array == null || array.length == 0){
            throw new IllegalArgumentException("Array could not be empty or null");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i]==4){
                count++;
                index=i+1;
            }
        }
        if (count==0){
            throw new RuntimeException("No four digit in array");
        }
        int[] newArray = new int[array.length-index];
        System.arraycopy(array,index,newArray,0,newArray.length);
        return newArray;
    }

    public static boolean checkArrayWithDigitsFourAndOne(int[] array){
        if (array == null || array.length == 0){
            throw new IllegalArgumentException("Array could not be empty or null");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1 || array[i] == 4){
                return true;
            }
        }
        return false;
    }
}
