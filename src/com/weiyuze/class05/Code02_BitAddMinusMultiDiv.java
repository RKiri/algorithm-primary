package com.weiyuze.class05;

public class Code02_BitAddMinusMultiDiv {
    static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    static int negNum(int num) {
        return add(~num, 1);
    }

    static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    static boolean isNeg(int num) {
        return num < 0;
    }

    static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            while ((x >> i) >= y) {
                res |= 1 << i;
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (a == Integer.MIN_VALUE) {
            if (b == negNum(1)) {
                return Integer.MAX_VALUE;
            } else {
                int c = div(add(a, 1), b);
                return add(c, div(minus(a, multi(b, c)), b));
            }
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else {
            return div(a, b);
        }
    }

    public static void main(String[] args) {
        int num = divide(7, -3);
        System.out.println(num);
    }
}
