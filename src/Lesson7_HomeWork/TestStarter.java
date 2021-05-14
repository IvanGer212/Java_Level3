package Lesson7_HomeWork;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestStarter {

    public static void main(String[] args) {
        start1(Test1.class);

    }

    static void start1 (Class testClass) {
        Test1 test1 = new Test1();
        Map<Method, Integer> mapOfMethodAndAnnotation = new HashMap<>();
        ArrayList<Test> listOfAnnotation = new ArrayList<>();
        Method[] declaredMethods = testClass.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            BeforeSuite annotation = declaredMethods[i].getAnnotation(BeforeSuite.class);
            if (annotation != null){
                try {
                    declaredMethods[i].invoke(test1);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            Test annotations1 = declaredMethods[i].getAnnotation(Test.class);
            if (annotations1 != null){
                mapOfMethodAndAnnotation.put(declaredMethods[i], annotations1.priority());
                listOfAnnotation.add(annotations1);
            }
        }
        System.out.println(mapOfMethodAndAnnotation.toString());
        Iterator<Map.Entry<Method, Integer>> iterator1 = mapOfMethodAndAnnotation.entrySet().iterator();
            while (iterator1.hasNext()){
                Integer value = iterator1.next().getValue();
                System.out.println(value);
                Method key = iterator1.next().getKey();
                System.out.println(key);
                for (int i = 1; i < 11; i++) {
                    if (value == i){
                        System.out.println(i);
                try {
                    key.invoke(test1);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }
        }

        //for (int j = 1; j < 11; j++) {
            //if (iteratorAnnotations.hasNext()){
            //    Test nextAnnotation = iteratorAnnotations.next();
            //    System.out.println(nextAnnotation.toString());
            //    if (nextAnnotation.priority() == j){
            //        Iterator<Method> methodIterator = Arrays.stream(declaredMethods).iterator();
            //        if (methodIterator.hasNext()){
            //            Method nextMethod = methodIterator.next();
            //            Test annotation2 = nextMethod.getAnnotation(Test.class);
            //            if (annotation2 != null){
            //                if (annotation2.equals(nextAnnotation)){
            //                    try {
            //                        nextMethod.invoke(test1);
            //                    } catch (InvocationTargetException | IllegalAccessException e) {
            //                        e.printStackTrace();
            //                    }
            //                }
            //            }
            //        }
            //    }
            //}
        //}


    }

    static void start(Class testClass) {
        Test1 test1 = new Test1();
        int indexMin = -1, indexMax = -1;
        int minPrior = 11, maxPrior = 0;
        Method[] declaredMethods = testClass.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            Annotation[] declaredAnnotations = declaredMethods[i].getDeclaredAnnotations();
            for (int j = 0; j < declaredAnnotations.length; j++) {
                BeforeSuite annotation = declaredMethods[i].getAnnotation(BeforeSuite.class);
                //System.out.println(annotation);
                if (annotation != null){
                    //System.out.println(declaredMethods[i]);
                    try {
                        declaredMethods[i].invoke(test1);
                    } catch (InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                Test annotations1 = declaredMethods[i].getAnnotation(Test.class);
                if (annotations1 != null){
                    if (annotations1.priority() < maxPrior){
                        maxPrior = annotations1.priority();
                        indexMax = i;
                    }
                    if (annotations1.priority() > minPrior){
                        minPrior = annotations1.priority();
                        indexMin = i;
                    }


                //    System.out.println(annotations1.priority());
                }
                if (declaredAnnotations[j].annotationType().toString().equals("interface Lesson7_HomeWork.BeforeSuite")) {
                //    System.out.println(declaredMethods[i]);
                }

            }
        }
    }
}
