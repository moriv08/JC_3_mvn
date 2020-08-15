package lessons.les7;


import lessons.les7.testCat.Cat;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class MainClass_7 {

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {


//        Class human = URLClassLoader.newInstance(new URL[]{ new File("C:/Users/scher/OneDrive/Desktop/tests/lessons/les7/")
//                .toURL()}).loadClass("Human");
//        Constructor constuctor = human.getConstructor(String.class);
//        Object bob = constuctor.newInstance("Bob");
//        Method m = human.getDeclaredMethod("info");
//        m.invoke(bob);



//        PrivateFieldsTestClass test = new PrivateFieldsTestClass("Constructor", 1111111111, "someString");
//        Class t = PrivateFieldsTestClass.class;
//        Field fNumb = t.getDeclaredField("number");
//        Field fName = t.getDeclaredField("name");
//
//        fName.set(test, "Test name");
//        fNumb.setAccessible(true);
//        fNumb.set(test, 99999999);

//        Method m = t.getDeclaredMethod("info2");
//        m.setAccessible(true);
//        m.invoke(test);
//        test.info();






//        Field[] fields = t.getDeclaredFields();
//        Method[] methods = t.getDeclaredMethods();
//        System.out.println("___________methods________________");
//        for (Method m: methods) {
//            System.out.println(m);
//        }
//        System.out.println("___________methods________________");
//
//        System.out.println("___________fields________________");
//        for (Field f: fields) {
//            System.out.println(f);
//        }
//        System.out.println("___________fields________________");


//        Constructor constructor2 = t.getConstructor(String.class, int.class, String.class);
//        PrivateFieldsTestClass instance = (PrivateFieldsTestClass) constructor.newInstance("textt", 111, "src");

//        Constructor<PrivateFieldsTestClass> constructor = t.getConstructor(String.class, int.class, String.class);
//        PrivateFieldsTestClass instance = constructor.newInstance("name_1", 111, "src");
//
//        instance.publicMeth(" << from the public method");


//        Method[] methods = t.getDeclaredMethods();
//        methods = t.getMethods();

//        for (Method m: methods) {
//            System.out.println(m);
//        }

//        Method mInfo = t.getMethod("info");
//        Method mGetNumb = t.getMethod("getNumber");
//        Method mPublic = t.getMethod("publicMeth", String.class);

//        System.out.println(mGetNumb.invoke(instance));
//        mPublic.invoke(instance);

//        mInfo.invoke(instance);

//        Field fName = t.getField("name");
//        System.out.println(fName.get(instance));
//
//        Field fNumber = t.getField("number");
//        fNumber.setAccessible(true);
//        System.out.println(fNumber.get(instance));

        // СОЗДАЕМ ССЫЛКУ НА КЛАСС
        Class cat_1 = Cat.class;
//        Class cat_2 = new Cat("barsic", 5, "white").getClass();
//        Class cat_3 = Class.forName("testCat.Cat");

//        Constructor constructor = cat_1.getConstructor(String.class, int.class, String.class);
//        Cat cat = (Cat) constructor.newInstance("Matrosscin", 30, "strips");

        Constructor<Cat> constructor = cat_1.getConstructor(String.class, int.class, String.class);
        Cat cat = constructor.newInstance("Matrosscin", 30, "strips");
        cat.info();

//        Method[] methods = cat_1.getDeclaredMethods();
//        for (Method m: methods) {
//            System.out.println(m);
//        }

        Method mInfo = cat_1.getDeclaredMethod("info2");
        mInfo.setAccessible(true);
        mInfo.invoke(cat);

//        Field[] fields = cat_1.getDeclaredFields();
//        for (Field f: fields) {
//            System.out.println(f);
//        }

        Field field = cat_1.getDeclaredField("color");
        field.setAccessible(true);
        field.set(cat, "yellow");
        System.out.println(field.get(cat));

        mInfo.invoke(cat);


    }

}
