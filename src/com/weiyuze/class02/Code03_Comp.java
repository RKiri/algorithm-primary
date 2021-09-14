package com.weiyuze.class02;

import com.weiyuze.class01.Code06_InsertionSort;

public class Code03_Comp {
    public static void main(String[] args) {
        int maxLen = 10;
        int maxValue = 1000;
        int[] arr = lenRandomValueRandom(maxLen, maxValue);
        int[] temp = copyArray(arr);
        Code06_InsertionSort is = new Code06_InsertionSort();
        //print(arr);
        is.insertionSort2(arr);
        //print(arr);
        if (!isSort(arr)){
            print(temp);//当出现问题时 可以拿拷贝的数组当例子 带入查看问题
            System.out.println("插入排序有问题！");
        }

    }

    static int[] lenRandomValueRandom(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        return arr;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static boolean isSort(int[] arr) {
        if (arr.length < 2) {
            return true;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max > arr[i]) {
                return false;
            }
            max = Math.max(max, arr[i]);
        }
        return true;
    }

    static int[] copyArray(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }
}
