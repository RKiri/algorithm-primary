package com.weiyuze.class01;

public class Code06_InsertionSort {
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void insertionSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //0~0有序 0~1 0~2...0~end
        for (int end = 1; end < arr.length; end++) {
            //从end开始和前一个数比较 当越界或前面的小则跳出循环
            while (end - 1 >= 0 && arr[end - 1] > arr[end]) {
                swap(arr, end, end - 1);
                end--;
            }
        }
    }

    //优化
    public void insertionSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = 1; end < arr.length; end++) {
            for (int pre = end - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
                swap(arr, pre, pre + 1);
            }
        }
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 3, 9, 2, 8, 4, 6};
        //insertionSort2(arr);
        printArray(arr);
    }


}
