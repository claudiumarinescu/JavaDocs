package ro.teamnet.zerotohero.reflection;
import ro.teamnet.zerotohero.reflection.demoobjects.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TODO
 * in order to resolve the exercises below, you will have to create
 * all the needed clasees, with their members and methods
 * (in ro.teamnet.zerotohero.reflection.demoobjects package)
 */
public class ClassReflectionDemoMain {

    public enum Days {FRIDAY, SATURDAY, SUNDAY}

    public static void main(String[] args) {
        Demo demo = new Demo();

        // get the class for a String object, and print it
        String string = new String();
        System.out.println(string.getClass());

        // get the class of an Enum, and print it
        System.out.println(Days.FRIDAY.getClass().getName());

        // get the class of a collection, and print it
        System.out.println(demo.dictionary.getClass());

        // get the class of a primitive type, and print it
        System.out.println(int.class);

        // get and print the class for a field of primitive type
        try {
            Field ageField = demo.getClass().getDeclaredField("age");
            System.out.println(ageField.getType());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        // get and print the class for a primitive type, using the wrapper class
        System.out.println(((Integer) demo.age).TYPE);

        // get the class for a specified class name
        try {
            System.out.println(Class.forName("ro.teamnet.zerotohero.reflection.demoobjects.Demo"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // get the superclass of a class, and print it
        DemoChild demoChild = new DemoChild();
        System.out.println("Superclass of DemoChild: " + demoChild.getClass().getSuperclass());

        // get the superclass of the superclass above, and print it
        System.out.println("Superclass of the superclass of DemoChild: " + demoChild.getClass().getSuperclass().getSuperclass());

        // get and print the declared classes within some other class
        Class[] classes = demo.getClass().getDeclaredClasses();
        System.out.println("Classes within Demo: ");
        for (Class aClass : classes) {
            System.out.println("---" + aClass.getName());
        }

        // print the number of constructors of a class
        System.out.println("Numbers of constructors for Demo: " + demo.getClass().getDeclaredConstructors().length);

        // get and invoke a public constructor of a class
        try {
            Demo demo2 = demo.getClass().getConstructor().newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        // get and print the class of one private field
        try {
            System.out.println("Private field type: "
                    + demo.getClass().getDeclaredField("password").getType());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        // set and print the value of one private field for an object
        try {
            Field privateField = demo.getClass().getDeclaredField("password");
            privateField.setAccessible(true);
            String fieldValue = (String) privateField.get(demo);
            privateField.set(demo, "override");

            System.out.println("New password: " + demo.getPassword());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        // get and print only the public fields class
        Field[] fields = demo.getClass().getFields();
        System.out.println("Public fields in Demo class: ");
        for (Field field : fields) {
            System.out.println("---" + field.getName());
        }

        // get and invoke one public method of a class
        try {
            Method m = demo.getClass().getDeclaredMethod("getPassword");
            System.out.println("Method invoke output: " + m.invoke(demo));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // get and invoke one inherited method of a class
        Class parent = demoChild.getClass().getSuperclass();
        try {
            Method m = parent.getDeclaredMethod("getPassword");
            System.out.println("Superclass method invoke output: " + m.invoke(demo));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // invoke a method of a class the classic way for ten times, and print the timestamp (System.currentTimeMillis())
        System.out.println("---> Test classic way <---");
        long start = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            demo.getPassword();
        }
        long end = System.nanoTime();
        System.out.println("Classic way time(us): " + ((end - start) / 1000));

		// invoke a method of a class by Reflection for 100 times, and print the timestamp
        try {
            Method m = demo.getClass().getDeclaredMethod("getPassword");
            start = System.nanoTime();
            for (int i = 0; i < 100; i++) {
                m.invoke(demo);
            }
            end = System.nanoTime();
            System.out.println("Reflection way time(us): " + ((end - start) / 1000));

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //what do you observe?
		
    }
}
