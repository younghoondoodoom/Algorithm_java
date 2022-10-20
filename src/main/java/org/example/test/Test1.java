package org.example.test;

public class Test1 {

    public static void main(String[] args) {
        System.out.println(solution("zeRobAsE!2#4"));
        System.out.println(solution("Pas$W0rd!321"));
        System.out.println(solution("DDDdfssfa123!"));
    }

    public static boolean solution(String s) {
        return checkLength(s) && checkContain(s) && checkRepetition(s) && checkContinuous(s);
    }

    private static boolean checkLength(String s) {
        return s.length() >= 6 && s.length() <= 20;
    }

    private static boolean checkContain(String s) {
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;
        boolean hasNum = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('a' <= c && 'z' >= c) {
                hasLower = true;
            } else if ('A' <= c && 'Z' >= c) {
                hasUpper = true;
            } else if (c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '^' || c == '&' || c == '*' || c == '(' || c == ')') {
                hasSpecial = true;
            } else if ('0' <= c && '9' >= c) {
                hasNum = true;
            }
        }
        return hasLower && hasUpper && hasSpecial && hasNum;
    }

    private static boolean checkRepetition(String s) {
        int cnt = 1;
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == prev) {
                cnt++;
            } else {
                c = 1;
            }
            prev = c;
            if (cnt >= 3) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkContinuous(String s) {
        int cnt = 1;
        s = s.toLowerCase();
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (prev + 1 == c) {
                cnt++;
            } else {
                cnt = 1;
            }
            prev = c;
            if (cnt >= 3) {
                return false;
            }
        }
        cnt = 1;
        prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (prev - 1 == c) {
                cnt++;
            } else {
                cnt = 1;
            }
            prev = c;
            if (cnt >= 3) {
                return false;
            }
        }
        return true;
    }
    
}

