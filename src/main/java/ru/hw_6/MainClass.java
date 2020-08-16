package ru.hw_6;

public class MainClass {


    public static void main(String[] args) {

//        int[] arr = { 1, 2, 4, 4, 2, 3, 4, 1, 7, 2, 3, 3, 2, 3};
            int[] arr = {1, 2 ,3, 4, 5, 6, 7, 8, 9};
//        int[] array2 = {1, 7, 2, 3, 3, 2, 3};
//        int[] arr = { 1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] copy = forePlus(arr);
        print(arr);
        System.out.println();
        print(copy);
        System.out.println();

        System.out.println(foreOne(arr));

    }

    public static int[] forePlus(int[] array) throws RuntimeException{

        int[] arr = null;
        int length = 0;
        int k = 0;

        for (int i = 0; i < array.length; i++)
            if (array[i] == 4)
                length = array.length - i;


        if (length == 0)
            throw new RuntimeException();

        arr = new int[--length];

        for (int i = array.length - length; i < array.length; i++)
            arr[k++] = array[i];

        return arr;
    }

    public static boolean foreOne(int[] arr){

        boolean fore = false;
        boolean one = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) fore = true;
            if (arr[i] == 1) one = true;
        }
        return (fore && one);
    }

    private static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
