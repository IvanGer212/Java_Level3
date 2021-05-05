package Lesson1_HomeWork;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        /**
         1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
        2. Написать метод, который преобразует массив в ArrayList;
        3. Большая задача:
        a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
        b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
        c. Для хранения фруктов внутри коробки можете использовать ArrayList;
        d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
        e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
        g. Не забываем про метод добавления фрукта в коробку.
         */

        // Part 1
        //ChangerPlace<String> changerPlace = new ChangerPlace<>(new String[]{"lemon", "night", "grass", "time", "black"});
        ChangerPlace<Integer> changerPlace = new ChangerPlace<>(new Integer[]{15,47,52,34,17,59});
        System.out.println(changerPlace.toString());
        Integer[] finalArr = changerPlace.changePlace(2, 4);

        for (int i = 0; i <finalArr.length ; i++) {
            System.out.print(finalArr[i] + " ");
        }
        System.out.println();
        System.out.println();

        //Part 2
        //ArrayToArrayList<Double> arrayToArrayList = new ArrayToArrayList<>(new Double[]{15.0, 13.0, 25.0, 45.0, 78.0});
        ArrayToArrayList<String> arrayToArrayList = new ArrayToArrayList<>(new String[]{"Lemon","tea","Time","Sun","snow"});
        ArrayList list = arrayToArrayList.changeArrToArrList();
        System.out.println(list.toString());
        System.out.println();

        // Part 3
        Box<Apple> box = new Box<Apple>(new ArrayList<>());
        Box<Orange> box1 = new Box<Orange>(new ArrayList<>());
        Box<Apple> box2 = new Box<Apple>(new ArrayList<>());
        Orange orange1 = new Orange();
        Apple apple1 = new Apple();
        box.putFruit(apple1);
        box.putFruit(apple1);
        box1.putFruit(orange1);
        box1.putFruit(orange1);
        box.putFruit(apple1);

        System.out.println("Вес коробки 1 = "+box.getWeight());
        System.out.println("Вес коробки 2 = "+box1.getWeight());

        System.out.println(box1.compareTo(box));
        System.out.println(box1.compareBox(box));
        System.out.println("Before pour");
        System.out.println("Box2: "+box2.toString());
        System.out.println("Box: "+box.toString());
        box2.pour(box);
        System.out.println("After pour");
        System.out.println("Box2: "+box2.toString());
        System.out.println("Box: "+box.toString());
    }



}
