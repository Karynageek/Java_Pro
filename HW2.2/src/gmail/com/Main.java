package gmail.com;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args){
        TextContainer ct = new TextContainer();
        Class<?> cls = ct.getClass();
        SaveTo annSaveTo = cls.getAnnotation(SaveTo.class);
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Saver.class)) {
                try {
                    method.invoke(ct, annSaveTo.path());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}