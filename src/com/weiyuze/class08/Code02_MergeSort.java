package com.weiyuze.class08;

import java.util.Arrays;

public class Code02_MergeSort {
    //归并排序
    static void mergeSort(int[] arr) {
        //边界条件判断
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    //非递归
    static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //引入步数概念 从1开始 2的倍数增长
        int step = 1;
        //当步数超过数组长度时退出 因为上一次步数循环已经让其有序
        int N = arr.length;
        while (step < N) {
            //L从0开始 当L超出数组长度时停止
            int L = 0;
            while (L < N) {
                //循环调用merge(arr L M R)方法 参数需要挨个获取
                //判断末尾项(N-1)-L+1剩余元素个数是否大于等于步数 防止越界
                int M;
                if (((N - 1) - L + 1) >= step) {
                    M = L + step - 1;//M = L+步数-1
                } else {
                    M = N - 1;//否则M为N-1
                }
                //如果M=N-1是边界 直接break
                if (M == N - 1) {
                    break;
                }
                //判断当右侧是否够一个步数 (N-1)-(M+1)+1 N-M-1是否大于等于步数
                int R = 0;
                if ((N - M - 1) >= step) {
                    //是的话R为M+1+步数-1 否则为N-1
                    R = M + step;
                } else {
                    R = N - 1;
                }
                merge(arr, L, M, R);
                if (R == N - 1) {
                    break;
                }
                //每次调完后L变为R+1 (判断R是否是N-1边界 是的话直接break)
                L = R + 1;

            }
            //判断步数是否大于N/2 防止越界
            //如果大于直接结束
            if (step > N / 2) {
                break;
            }
            //步数乘以2
            step <<= 1;
        }


    }

    //定义一个方法process 传数组arr[] 开始结束位置L R 变为有序
    static void process(int[] arr, int L, int R) {
        //如果只有一个元素 有序
        if (L == R) {
            return;
        }
        //否则取中间mid
        int mid = L + ((R - L) >> 1);//右移加括号**********
        //调方法从L到min有序
        process(arr, L, mid);
        //mid+1到R有序
        process(arr, mid + 1, R);
        //将两部分合并
        merge(arr, L, mid, R);
    }

    //定义方法merge 将两部分合并
    //传数组arr[] L Mid R
    static void merge(int[] arr, int L, int M, int R) {
        //定义个help数组 因为两部分已经是排好序 只需从头比较 然后将小的放到help数组中
        int[] help = new int[R - L + 1];
        //定义两个指针动态移动 直到其中一个移出
        int p1 = L;
        int p2 = M + 1;
        int i = 0;//*****************
        //判断 将未移出的直接依次添加到help数组
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        //将help数组的内容传回arr
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }

    //生成随机数组
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
        int maxSize = 1000;
        int maxValue = 10000;
        int testTime = 10000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            mergeSort(arr1);
            mergeSort1(arr2);
            Arrays.sort(arr3);
            if (!isEqual(arr2, arr3)) {//!*****************
                printArray(arr2);
                printArray(arr3);
                System.out.println("异常");
                break;
            }
        }
        System.out.println("测试结束");
    }
}



