package ru.hw_7;

import lessons.les7.TestHomeWork;
import java.lang.reflect.Method;
import static java.lang.String.valueOf;

public class MainClass_7 {

    public static void main(String[] args){

        try {
            start(TestHomeWork.class);
        }catch (Exception e){

        }
    }

    public static void before(Method[] methods, Class c){

//        int before = 0;
//        int after = 0;

        for (int i = 0; i < methods.length - 1; i++) {

//            if(methods[i].getAnnotation(BeforeSuite.class).equals("BeforeSuite")){
//            before++;
//            if (before > 1)
//                throw new RuntimeException("More than one meth AfterSute");
//            }

//            if(methods[i].getAnnotation(AfterSuite.class).equals("AfterSuite")){
//                after++;
//                if (after > 1)
//                    throw new RuntimeException("More than one meth AfterSute");
//            }
                if (methods[i].getAnnotation(Test.class).priority() < methods[i + 1].getAnnotation(Test.class).priority()){
                Method tmp = methods[i];
                methods[i] = methods[i + 1];
                methods[i + 1] = tmp;
                i = -1;
            }
        }
    }


    public static void start(Class c) throws Exception {
        //        Class hw = URLClassLoader.newInstance(new URL[] {new File("C:/Users/scher/OneDrive/Desktop/tests/lessons/les7/")
//                .toURL()}).loadClass("HomeWork");

        Class test = c;
//        TestHomeWork instance = new TestHomeWork(5, 5, "test");
        TestHomeWork instance = new TestHomeWork();
        Method[] methods = test.getDeclaredMethods();

        before(methods, c);

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)){

                if (method.getName().equals("sum")){
                    for (int i = 0; i < 10; i++) {
                        int a = (int) (Math.random() * 100);
                        int b = (int) (Math.random() * 100);
                        if (((int)method.invoke(instance, a, b)) != testSumMeth(a, b)) {
                            String msg = "Error in " + method.getName() + " test";
                            throw new RuntimeException(msg);
                        }
                    }
                    System.out.println("Method " + method.getName() + " is ok");

                }else if (method.getName().equals("findYear")) {
                    if (!testYearMeth(instance)) {
                        String msg = "Error in " + method.getName() + " test";
                        throw new RuntimeException(msg);
                    }
                    System.out.println("Method " + method.getName() + " is ok");
                }else if (method.getName().equals("reverseString")){
                    for (int i = 0; i < 30; i++) {
                        String str = "";
                        String rev = "";
                        for (int j = 0; j < 30; j++) {
                            int a = (int)(Math.random() * 90 + 33);
                            char letter = (char) a;
                            str += valueOf(letter);
                        }
                        for (int j =  str.length() - 1; j >= 0; j--)
                            rev += valueOf(str.charAt(j));

                        if (!method.invoke(instance, str).equals(rev)) {
                            String msg = "Error in " + method.getName() + " test";
                            throw new RuntimeException(msg);
                        }
                    }
                    System.out.println("Method " + method.getName() + " is ok");
                }

            }
        }

        System.out.println("___________________");
        System.out.println("All tests is ok");
    }

    public static int testSumMeth(int a, int b){
        return a + b;
    }

    public static boolean testYearMeth(TestHomeWork t){

        int[] bissextileYears = {2000, 2004, 2008, 2012, 2016, 2020, 2024, 2028, 2032, 2036, 2040, 2044, 2048, 2052, 2056, 2060,2064, 2068, 2072, 2076, 2080, 2084, 2088, 2092, 2096};
        
        for(int i = 0; i < bissextileYears.length; i++)
            if (!t.findYear(bissextileYears[i]).equals("Высокосный"))
                return false;

        for (int i = 0; i < bissextileYears.length; i++)
            if (!t.findYear(bissextileYears[i] + 1).equals("Не высокосный"))
                return false;
        
        return true;
    }
}
