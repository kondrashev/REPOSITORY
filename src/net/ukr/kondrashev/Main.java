package net.ukr.kondrashev;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Saver sr = new Saver();
        Class<?> Saver = sr.getClass();
        Method method = Saver.getDeclaredMethod("saveText", String.class);
        SaveTo SaveTo = method.getAnnotation(SaveTo.class);
        method.invoke(sr, SaveTo.patch());
    }
}
