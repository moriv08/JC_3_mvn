package ru.hw_5.race.calcul;

import java.util.Scanner;

public class MainClass {

    private static int checker = 0;

    public static void main(String[] args) {

        Simple s = null;
        int first;
        String simb;
        int second;

        first = digit("Введите первое число");
        simb = simbol("Введите знак + - * или /");
        second = digit("Введите второе число");

        if(checker == -1)
            System.out.println("Введены некорректные данные");
        else {
            if (simb.equals("+"))
                s = (i, k) -> i + k;
            else if (simb.equals("-"))
                s = (i, k) -> i - k;
            else if (simb.equals("*"))
                s = (i, k) -> i * k;
            else if (simb.equals("/"))
                s = (i, k) -> i / k;
            else
                System.out.println("Введены некорректные данные");

            if (s != null)
                System.out.println("Ответ = " + s.oneMeth(first, second));
        }
    }

    private static int digit(String src){
        Scanner scan = new Scanner(System.in);

        System.out.println(src);
        String str = scan.nextLine().trim();

        if (str.length() == 0){
            checker = -1;
            return -1;
        }

        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) > 57 || str.charAt(i) < 48){
                checker = -1;
                return -1;
            }
        return Integer.parseInt(str);
    }

    private static String simbol(String src){
        Scanner scan = new Scanner(System.in);

        System.out.println(src);
        String simb = scan.nextLine();

        return simb.trim();
    }

    private void longVariant(){

        Additionable a;
        Subtractable t;
        Multipliable m;
        Dividable d;

        int first = digit("Введите первое число");
        String simb = simbol("Введите знак + - * или /");
        int second = digit("Введите второе число");

        if(checker == -1){
            System.out.println("Введены некорректные данные");
            return;
        }

        a = (i, k) -> i + k;
        t = (i, k) -> i - k;
        m = (i, k) -> i * k;
        d = (i, k) -> i / k;

        if (simb.equals("+"))
            System.out.println("Ответ = " + a.add(first, second));
        else if (simb.equals("-"))
            System.out.println("Ответ = " + t.take(first, second));
        else if (simb.equals("*"))
            System.out.println("Ответ = " + m.multiple(first, second));
        else if (simb.equals("/"))
            System.out.println("Ответ = " + d.divide(first, second));
        else
            System.out.println("Введены некорректные данные");
    }
}
