package net.ukr.kondrashev;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MyClass mc = new MyClass();
        Class<?> MyClass = mc.getClass();
        Method method = MyClass.getDeclaredMethod("result", int.class, int.class);
        Test Test = method.getAnnotation(Test.class);
        System.out.println("Result-" + method.invoke(mc, Test.paramOne(), Test.paramTwo()) + "!");
    }
}
