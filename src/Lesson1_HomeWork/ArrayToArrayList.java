package Lesson1_HomeWork;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayToArrayList <T>{
    private T[] array;
    private ArrayList<T> arrayList = new ArrayList<>();


    public ArrayToArrayList(T[] array) {
        this.array = array;
    }

    public ArrayList<T> changeArrToArrList(){
        for (T array: array) {
            arrayList.add(array);
        }
        return arrayList;
    }

}
