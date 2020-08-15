package lessons.les7;

import ru.hw_7.AfterSuite;
import ru.hw_7.BeforeSuite;
import ru.hw_7.Test;

import static java.lang.String.valueOf;

public class TestHomeWork {

    private int numb_1;
    public int numb_2;
    private String str_1;

//    @BeforeSuite
//    public void startMeths(){
//        System.out.println("Start");
//    }

    @Test
    public int sum(int a, int b){
        return a + b;
    }

    @Test(priority = 9)
    public String findYear(int year){
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? "Высокосный" : "Не высокосный";
    }

    @Test(priority = 10)
    public String reverseString(String str){
        String s = "";
        for (int i = str.length() - 1; i >= 0; i--)
            s += valueOf(str.charAt(i));

        return s;
    }

//    @AfterSuite
//    public void after(){
//        System.out.println("End");
//    }
}
