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
        int counterBeforeSuit = 0;
        int counterAfterSuit = 0;
        Method beforeSuite = null;
        Method afterSuite = null;
        Map<Integer, List<Method>> mapOfPriorityAndMethod = new HashMap<>();
        ArrayList<Test> listOfAnnotation = new ArrayList<>();
        Method[] declaredMethods = testClass.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            BeforeSuite annotationBefore= declaredMethods[i].getAnnotation(BeforeSuite.class);
            if (annotationBefore != null){
                invorkMethod(declaredMethods[i],test1);
                counterBeforeSuit++;
            }
            Test annotationsTest = declaredMethods[i].getAnnotation(Test.class);
            if (annotationsTest != null){
                Integer priority = annotationsTest.priority();
                if (!mapOfPriorityAndMethod.containsKey(priority)){
                List<Method> methodList = new ArrayList<>();
                methodList.add(declaredMethods[i]);
                    mapOfPriorityAndMethod.put(priority,methodList);
                }
                else {
                    mapOfPriorityAndMethod.get(priority).add(declaredMethods[i]);
                }
            }
        }

        List<Integer> priorities = new ArrayList<>(mapOfPriorityAndMethod.keySet());
        Collections.sort(priorities);
        for(Integer priority: priorities){
            for(Method method: mapOfPriorityAndMethod.get(priority)){
                invorkMethod(method,test1);
            }
        }
        for (int i = 0; i < declaredMethods.length; i++) {
            AfterSuite annotationAfter = declaredMethods[i].getAnnotation(AfterSuite.class);
            if (annotationAfter != null){
                invorkMethod(declaredMethods[i],test1);
                counterAfterSuit++;
            }
        }

        if(counterAfterSuit > 1 || counterBeforeSuit > 1){
            throw new RuntimeException("more than one afterSuit or beforeSuite tests found");
        }


    }

    public static void invorkMethod (Method method, Test1 test) {
            try {
                method.invoke(test);
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
}