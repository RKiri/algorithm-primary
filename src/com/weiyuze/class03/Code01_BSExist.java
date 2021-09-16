package com.weiyuze.class03;

import java.util.Arrays;

public class Code01_BSExist {
    public static void main(String[] args) {
        int maxLen = 10;
        int maxValue = 1000;
        int testTime = 10000;
        boolean succeed = true;//
        for (int i = 0; i < testTime; i++) {
            int[] arr = lenRandomValueRandom(maxLen, maxValue);
            Arrays.sort(arr);//
            int num = (int) (Math.random() * maxValue);
            if (test(arr, num) != find(arr, num)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "true" : "false");//

    }


    static int[] lenRandomValueRandom(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        return arr;
    }

    static boolean test(int[] sortedArr, int num) {
        for (int cur : sortedArr) {//
            if (cur == num) {
                return true;
            }
        }
        return false;
    }

    static boolean find(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {//
            int mid = (L + R) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }

}
