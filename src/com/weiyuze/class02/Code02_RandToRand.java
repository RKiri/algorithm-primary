package com.weiyuze.class02;

public class Code02_RandToRand {
    public static void main(String[] args) {
        //[0，1)随机分布
        int testTimes = 10000000;
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() < 0.1) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        System.out.println("=======================");

        //[0,8)随机分布
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() * 8 < 5) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println((double) 5 / (double) 8);

        System.out.println("======================");

        //int 0~8 随机分布
        int K = 9;
        int[] counts = new int[K];
        for (int i = 0; i < testTimes; i++) {
            int ans = (int) (Math.random() * K);
            counts[ans]++;
        }
        for (int i = 0; i < K; i++) {
            System.out.println(i + "出现了" + counts[i] + "次");
        }

        System.out.println("======================");

        //由[0,x) 变为[0,x^2)
        count = 0;
        double x = 0.9;

        for (int i = 0; i < testTimes; i++) {
            if (xMin() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        //System.out.println(Math.pow(x,3));
        System.out.println(1 - Math.pow(1 - x, 2));

        System.out.println("======================");

        //从1-5随机到1-7随机
        counts = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int ans = g();
            counts[ans]++;
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(i + "出现了" + counts[i] + "次");
        }

        System.out.println("======================");

        counts = new int[2];
        //01固定概率返回 改为01等概率返回
        for (int i = 0; i < testTimes; i++) {
            int ans = y();
            counts[ans]++;
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(i + "出现了" + counts[i] + "次");
        }
    }

    static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }

    static double xToXPower3() {
        return Math.max(Math.random(), Math.max(Math.random(), Math.random()));
    }

    static double xMin() {
        return Math.min(Math.random(), Math.random());
    }

    // lib里的，不能改！
    static int f1() {
        return (int) (Math.random() * 5 + 1);
    }

    //01选择器
    static int f2() {
        int ans = 0;
        do {
            ans = f1();
        } while (ans == 3);
        return ans > 3 ? 1 : 0;
    }

    static int f3() {
        return (f2() << 2) + (f2() << 1) + f2();
    }

    static int g() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans == 0);
        return ans;
    }

    static int x() {
        return Math.random() > 0.84 ? 1 : 0;
    }

    //两次返回01和10概率相同 返回相同值重新开始
    static int y() {
        int ans = 0;
        do {
            ans = x();
        } while (ans == x());
        return ans;
    }
}
