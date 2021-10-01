package com.weiyuze.class08;

import java.awt.*;
import java.util.Arrays;
import java.util.Stack;

public class Code03_PartitionAndQuickSort {
    static void splitNum(int[] arr) {
        int lessEqualR = -1;
        int index = 0;
        int p = arr.length - 1;
        while (index < p) {
            if (arr[index] <= arr[p]) {
                swap(arr, index++, ++lessEqualR);
            } else {
                index++;
            }
        }
        swap(arr, ++lessEqualR, p);
    }

    static void splitNum1(int[] arr) {
        int index = 0;
        int lessR = -1;
        int moreL = arr.length - 1;
        int p = arr.length - 1;
        while (index < moreL) {
            if (arr[index] < arr[p]) {
                swap(arr, index++, ++lessR);
            } else if (arr[index] > arr[p]) {
                swap(arr, index, --moreL);
            } else {
                index++;
            }
        }
        swap(arr, moreL, p);
    }

    //快速排序
    //经过上述方法得到的中间等于的位置一定是正确的 返回小于和大于的边界 递归此方法
    //传数组 和L R
    //得到一个包含两个元素的数组
    //重新调此方法

    static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {//边界条件
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    static int[] pratation(int[] arr, int L, int R) {
        int index = L;
        int lessR = L - 1;
        int moreL = R;
        int p = R;
        while (index < moreL) {
            if (arr[index] < arr[p]) {
                swap(arr, index++, ++lessR);
            } else if (arr[index] > arr[p]) {
                swap(arr, index, --moreL);
            } else {
                index++;
            }
        }
        swap(arr, moreL, p);
        int[] equal = {lessR + 1, moreL};
        return equal;
    }

    static void process(int[] arr, int L, int R) {
        if (L >= R) {//不是有效范围直接返回
            return;
        }
        int[] equal = pratation(arr, L, R);
        process(arr, L, equal[0] - 1);
        process(arr, equal[1] + 1, R);
    }

    //非递归版本 设置一个任务类 包含L R
    //定义一个栈 最开始将初始任务添加进去 循环直到栈为空
    //栈不为空 弹出 执行任务 然后得到返回的区间 判断时候有小于和大于区间
    //有的话将其添加进栈 继续循环
    static class job {
        int L;
        int R;

        public job(int l, int r) {
            L = l;
            R = r;
        }
    }

    static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        Stack<job> stack = new Stack<>();
        stack.push(new job(0, arr.length - 1));
        while (!stack.isEmpty()) {
            job job = stack.pop();
            int[] equal = pratation(arr, job.L, job.R);
            if (equal[0] > job.L) {
                stack.push(new job(job.L, equal[0] - 1));
            }
            if (equal[1] < job.R) {
                stack.push(new job(equal[1] + 1, job.R));
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    static int[] copyArray(int[] arr) {
        //过滤当数组为空时
        if (arr == null) {
            return null;
        }
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 == null ^ arr2 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*int[] arr = {3, 6, 2, 4, 4, 7, 1, 5, 4};//
        splitNum(arr);
        splitNum1(arr);
        printArray(arr);*/

        int maxSize = 10;
        int maxValue = 10000;
        int testTime = 10000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            //quickSort(arr1);
            quickSort2(arr2);
            Arrays.sort(arr3);
            if (!isEqual(arr2, arr3)) {//!*****************
                //printArray(arr1);
                printArray(arr2);
                printArray(arr3);
                System.out.println("异常");
                break;
            }
        }
        System.out.println("测试结束");
    }
}
