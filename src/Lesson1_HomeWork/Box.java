package Lesson1_HomeWork;


import java.util.ArrayList;

public class Box <E extends Fruit> implements Comparable<Box<? extends Fruit>> {
    private ArrayList<E> arrayList;


    public Box(ArrayList<E> arrayList) {
        this.arrayList = arrayList;
    }

    public ArrayList<E> getArrayList() {
        return arrayList;
    }

    public Float getWeight(){
        Float weight = 0f;
        for (E fruit:arrayList) {
            weight += fruit.getWeight();

        }
            return weight;
    }

    public void putFruit (E fruit){
        arrayList.add(fruit);
    }

    public boolean compareBox (Box<? extends Fruit> inBox){
        float weight1, weight2;
        weight1 = this.getWeight();
        weight2 = inBox.getWeight();
        return weight1==weight2;
        //return this.getWeight() == inBox.getWeight(); Почему-то не работает???!!!
    }

    public void pour (Box<E> inBox){
        arrayList.addAll(inBox.getArrayList());
        inBox.getArrayList().clear();
    }

    @Override
    public String toString() {
        return "Box{" +
                "arrayList=" + arrayList +
                '}';
    }

    @Override
    public int compareTo(Box<? extends Fruit> inBox) {
        return Float.compare(this.getWeight(), inBox.getWeight());
    }
}
