package com.weiyuze.class05;

import java.util.HashSet;

public class Code01_BitMap {
    static class BitMap {
        long[] bits;

        public BitMap(int max) {
            this.bits = new long[(max + 64) >> 6];
        }

        void add(int num) {
            bits[num >> 6] |= (1L << (num & 63));
        }

        void delete(int num) {
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        boolean contains(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("测试开始");
        int max = 100000;
        BitMap bits = new BitMap(max);
        HashSet<Integer> set = new HashSet<>();
        int testTime = 1000000;
        for (int i = 1; i < testTime; i++) {
            double decide = Math.random();
            int num = (int) (Math.random() * max);
            if (decide < 0.33) {
                bits.add(num);
                set.add(num);
            } else if (decide < 0.66) {
                bits.delete(num);
                set.remove(num);
            } else {
                if (bits.contains(num) != set.contains(num)) {
                    System.out.println("contains");
                    break;
                }
            }
        }
        for (int i = 0; i < max; i++) {
            if (bits.contains(i) != set.contains(i)) {
                System.out.println("contains1");
            }
        }
        System.out.println("测试结束");
    }
}
