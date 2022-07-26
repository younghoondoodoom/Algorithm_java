package org.example;

public class Main {

    static int count = 0;
    static int[][] array;
    public static void main(String[] args) {
        int result = solution(256, 1, 3);
        System.out.println("result = " + result);
//        for (int i = 0; i < array.length + 1; i++) {
//            for (int j = 0; j < array.length; j++) {
//                System.out.print(array[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    public static int solution(int n, int i, int j) {
        array = new int[n + 1][n + 1];
        recursion(n, n, n);
        return array[i + 1][j + 1];
    }

    public static void recursion(int n, int i, int j) {
        if (n == 2) {
            array[i - 1][j] = ++count;
            array[i - 1][j - 1] = ++count;
            array[i][j - 1] = ++count;
            array[i][j] = ++count;
            return;
        }

        recursion(n / 2, i / 2, j);
        recursion(n / 2, i / 2, j / 2);
        recursion(n / 2, i, j / 2);
        recursion(n / 2, i, j);
    }

}

