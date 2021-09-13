package com.weiyuze.class01;

public class Code05_BubbleSort {
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int second = 1; second <= end; second++) {
                if (arr[second - 1] > arr[second]) swap(arr, second - 1, second);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 3, 9, 2, 8, 4, 6};
        bubbleSort(arr);
        printArray(arr);
    }
}
