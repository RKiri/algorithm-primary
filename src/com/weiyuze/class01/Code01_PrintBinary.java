package com.weiyuze.class01;

public class Code01_PrintBinary {

    static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int num = 4;
//        print(4);

//        int test = 124132;
//        print(test);
//        print(test<<1);
//        print(test<<2);
//        print(test<<8);

//        int a = Integer.MAX_VALUE;
//        System.out.println(a);

//        print(-1);
//        int a = Integer.MIN_VALUE;
//        print(a);

//        int b = 123545;
//        int c = ~b;
//        print(b);
//        print(c);

//        print(-5);

//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Integer.MAX_VALUE);

//        int a = 1543728;
//        int b = 9824399;
//        print(a);
//        print(b);
//        System.out.println("============");
//        print(a | b);
//        print(a & b);
//        print(a ^ b);

//        int a = Integer.MIN_VALUE;
//        print(a);
//        print(a>>1);
//        print(a>>>1);

        int c = Integer.MIN_VALUE;
        int d = -c;
        print(c);
        print(d);

    }
}
