package ru.hw_8;

public class MainClass_8 {
    public static void main(String[] args) {
        String str = "5 1 5 2 2 4 1 4 5 1 5 3 2 4 4 4 5 1 3 4 2 2 1 2 4 4 4 5 4 3 5 4 4 5 5 1 4 1 5 3 1 4 5 3 3 4 2 2 4 4 5 5 1 1 1 4 5 5\n" +
                "4 4 2 4 3 1 3 3 1 1 3 1 3 4 4 3 2 2 1 3 4 4 2 3 4 2 4 4 1 4 4 4 2 1 2 4 1 5 2 2 5 4 2 2 3 1 5 5 3 5 3 1 4 5 4 2 1 3\n" +
                "1 2 1 4 1 3 4 2 2 5 2 3 1 1 2 3 3 4 4 2 4 1 2 2 2 5 1 5 1 2 2 1 3 3 4 3 5 3 5 1 2 1 3 3 2 4 1 4 3 5 1 2 1 2 3 2 1 3\n" +
                "2 2 4 3 2 1 5 1 4 5 4 4 5 5 4 2 3 5 1 3 4 3 2 4 5 2 5 2 4 1 4 5 2 3 3 4 4 3 5 2 2 3 5 1 2 4 3 4 4 3 2 2 1 4 5 5 1 5\n" +
                "2 4 5 5 4 2 2 1 5 1 3 4 2 4 2 2 4 3 5 2 2 4 4 4 5 5 2 5 5 2 5 1 1 5 5 4 1 2 4 1 2 2 5 4 5 1 5 4 4 5 5 5 3 3 4 3 3 5\n" +
                "3 2 2 2 2 2 1 2 5 2 3 4 3 5 5 2 4 5 3 4 3 1 3 2 1 1 5 4 4 2 3 1 3 4 2 4 1 3 5 1 5 3 5 2 3 4 4 1 3 1 5 5 1 2 2 1 3 1\n" +
                "5 1 2 2 1 5 1 3 3 2 1 3 2 5 1 1 2 3 5 5 4 3 1 3 3 1 5 4 2 3 4";

        String str_2 = "111111111222222223333333444445555";

        int[] arr = unicDigits(str);
        print(arr);

    }

    private static int[] unicDigits(String str){

        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++)
            arr[i] = -1;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) - 48 >= 0 && str.charAt(i) - 48 <= 9)
                if (arr[str.charAt(i) - 48] == -1) {
                    arr[str.charAt(i) - 48] = str.charAt(i) - 48;
                    arr[(str.charAt(i) - 48) + 10] = 1;
                }else if (arr[str.charAt(i) - 48] == str.charAt(i) - 48)
                    arr[(str.charAt(i) - 48) + 10] += 1;
        }
        return arr;
    }

    private static void print(int[] arr){
        System.out.println("Ответ:");
        for (int i = 0; i < 10; i++)
            if (arr[i] != -1)
                System.out.print(i + " = " + arr[i + 10] + ", ");
    }
}
