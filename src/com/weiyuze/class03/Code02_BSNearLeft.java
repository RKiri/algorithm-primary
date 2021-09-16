package com.weiyuze.class03;

import java.util.Arrays;

public class Code02_BSNearLeft {
    public static void main(String[] args) {
        int maxLen = 10;
        int maxValue = 1000;
        int testTime = 10000;
        boolean success = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = lenRandomValueRandom(maxLen, maxValue);
            Arrays.sort(arr);
            int num = (int) (Math.random() * maxValue);
            if (test(arr, num) != mostLeftNoLessNumIndex(arr, num)) {
                System.out.println(num);
                print(arr);
                System.out.println(test(arr, num));
                System.out.println(mostLeftNoLessNumIndex(arr, num));
                success = false;
                break;
            }
        }
        System.out.println(success ? "true" : "false");
    }

    static int[] lenRandomValueRandom(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        return arr;
    }

    static int test(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
                return i;//
            }
        }
        return -1;//
    }

    static int mostLeftNoLessNumIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] >= num) {//
                R = mid - 1;
                ans = mid;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
