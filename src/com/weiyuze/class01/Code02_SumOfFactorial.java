package com.weiyuze.class01;

public class Code02_SumOfFactorial {
    public static void main(String[] args) {
        System.out.println(f1(10));
        System.out.println(f2(10));
    }

    static long f1(int N) {
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans += factorial(i);
        }
        return ans;
    }

    private static long factorial(int num) {
        int ans = 1;
        for (int i = 1; i <= num; i++) {
            ans *= i;
        }
        return ans;
    }

    static long f2(int N) {
        int ans = 0;
        int cur = 1;
        for (int i = 1; i <= N; i++) {
            cur = cur * i;
            ans += cur;
        }
        return ans;
    }

}
