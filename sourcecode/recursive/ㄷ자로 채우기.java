package org.example;



public class Main {

    public static void main(String[] args) {
        int result = solution(4, 1, 3);
        System.out.println("result = " + result);
    }

    public static int solution(int n, int i, int j) {
        return recursion(0, n, i, j);
    }

    public static int recursion(int count, int n, int i, int j) {
        if (n == 2) {
            if (i == 0 && j == 1) { // 우측 상단
                return count + 1;
            } else if (i == 0 && j == 0) { // 좌측 상단
                return count + 2;
            } else if (i == 1 && j == 0) { // 좌측 하단
                return count + 3;
            } else {
                return count + 4;
            }
        }

        int m = n / 2;
        if (i < m && j >= m) { // 우측 상단
            return recursion(count, m, i, j - m);
        } else if (i < m && j < m) { // 좌측 상단
            count += m * m;
            return recursion(count, m, i, j);
        } else if (i >= m && j < m) { // 좌측 하단
            count += 2 * m * m;
            return recursion(count, m, i - m, j);
        } else {
            count += 3 * m * m;
            return recursion(count, m, i - m, j - m);
        }

    }

}

