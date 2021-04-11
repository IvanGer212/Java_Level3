package Lesson1_HomeWork;

import java.util.Arrays;

public class ChangerPlace<T> {
    private T[] array;

    public ChangerPlace(T[] array) {
        this.array = array;
    }

    public T[] changePlace(int firstElem, int secondElem){
        T temp = null;
        temp = array[firstElem];
        array[firstElem]=array[secondElem];
        array[secondElem]=temp;
        return array;
    }

    @Override
    public String toString() {
        return "ChangerPlace{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
