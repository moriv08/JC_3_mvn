package ru.hw_7;

public class Matrix {
    public static void main(String[] args) {
        int [][] arr = new int[35][15];
        fillRight(arr, 0, 0, 0);
        print(arr);
    }

    public static void fillRight(int[][] arr, int y, int x, int count){

        for (int i = y; i < arr.length; i++) {
            for (int j = x; j < arr[y].length; j++) {
                if (i == y){
                    if(arr[i][j] == 0)
                        arr[i][j] = ++count;
                }else {
                    if (j == endLine(arr)) {
                        if (arr[i][j] == 0)
                            arr[i][j] = ++count;
                    }
                }
            }
        }

        if (chek(arr))
            fillLeft(arr, findBottomLine(arr), findBottomRow(arr), count);
    }

    public static void fillLeft(int[][]arr, int bottomLine, int bottomRow, int count){

        int line = bottomLine;
        int row = bottomRow;

        while (row >= 0 && arr[line][row] == 0)
            arr[line][row--] = ++count;

        int curentLine = curentLine(arr);
        int curentRow = curentRow(arr);

        while (curentLine > 0 && arr[curentLine][curentRow] == 0)
            arr[curentLine--][curentRow] = ++count;

        if (chek(arr))
            fillRight(arr, startLine(arr), startLine(arr), count);
    }

    private static int findBottomRow(int[][] arr){
        for (int i = arr.length - 1; i > 0; i--)
            for (int j = arr[i].length - 1; j > 0; j--)
                if (arr[i][j] == 0)
                    return j;
        return 0;
    }

    private static int findBottomLine(int[][]arr){
        for (int i = arr.length - 1; i > 0; i--)
            for (int j = arr[i].length - 1; j > 0; j--)
                if (arr[i][j] == 0)
                    return i;
        return 0;
    }

    public static int curentLine(int[][]arr){
        for (int i = arr.length - 1; i > 0; i--)
            for (int j = 0; j < arr[i].length; j++)
                if (arr[i][j] == 0)
                    return i;
        return 0;
    }

    public static int curentRow(int[][] arr){
        for (int i = arr.length - 1; i > 0; i--)
            for (int j = 0; j < arr[i].length; j++)
                if (arr[i][j] == 0)
                    return j;
        return 0;
    }

    private static int startLine(int[][] arr){
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                if (arr[i][j] == 0)
                    return i;
        return 0;
    }

    private static int endLine(int[][] arr){
        for (int i = arr.length - 1; i > 0; i--)
            for (int j = arr[i].length -1; j > 0; j--)
                if(arr[i][j] == 0)
                    return j;
        return 0;
    }

    private static boolean chek(int[][] arr){
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                if (arr[i][j] == 0)
                    return true;
        return false;
    }

    public static void print(int arr[][]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < 10)
                    System.out.print("  " + arr[i][j] + " ");
                else if (arr[i][j] > 9 && arr[i][j] < 100)
                    System.out.print(" " + arr[i][j] + " ");
                else
                    System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
