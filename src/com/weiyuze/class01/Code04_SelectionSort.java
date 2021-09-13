package com.weiyuze.class01;

public class Code04_SelectionSort {
    static void SelectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int minIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] < arr[j] ? minIndex : j;
            }
            swap(arr, i, minIndex);
        }
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 3, 9, 2, 8, 4, 6};
        SelectionSort(arr);
        printArray(arr);
    }
}
