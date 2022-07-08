import Protect.ProtectClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException, InstantiationException {
        ProtectClass protectClass = new ProtectClass();

        Field numberFive = ProtectClass.class.getDeclaredField("numberFive");
        numberFive.setAccessible(true);
        numberFive.set(protectClass, 6);
        System.out.println(numberFive.get(protectClass));

        Method setNumber = ProtectClass.class.getDeclaredMethod("setNumber", Integer.class);
        setNumber.setAccessible(true);
        System.out.println(setNumber.invoke(protectClass, 7));

        Class.forName("Protect.ProtectClass");
        Constructor<?> declaredConstructor = Class.forName(ProtectClass.class.getName()).getDeclaredConstructor(new Class[]{String.class});
        declaredConstructor.setAccessible(true);
        ProtectClass h_world = (ProtectClass) declaredConstructor.newInstance("h world");

        System.out.println(protectClass);
        System.out.println(h_world);
    }

}
