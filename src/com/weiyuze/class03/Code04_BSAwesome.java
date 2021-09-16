package com.weiyuze.class03;

public class Code04_BSAwesome {
    //arr 整体无序 相邻的数不相等
    static int oneMinIndex(int[] arr) {
        int N = arr.length;
        if (arr == null || N == 0) {
            return -1;
        }
        if (N == 1) {//当长度为1时 直接返回0位置
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }
        int L = 0;
        int R = N - 1;
        // 除去上述情况 L...R 肯定有局部最小
        while (L < R - 1) {//至少三个数 mid左右各一个 防止数组越界
            int mid = (L + R) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            }
            if (arr[mid] > arr[mid - 1]) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return arr[L] > arr[R] ? R : L;

    }

    //生成随机数组 且相邻数不相等
    static int[] randomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];//new 定义空数组
        if (len > 0) {//数组不能为空 防止下方arr[0]越界
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    static boolean check(int[] arr, int num) {
        if (arr.length == 0) {
            return num == -1;
        }
        int left = num - 1;
        int right = num + 1;
        boolean leftBigger = left >= 0 ? arr[left] > arr[num] : true;//判断左右是有有数 没有就返回true 不用判断
        boolean rightBigger = right <= arr.length - 1 ? arr[num] < arr[right] : true;
        return leftBigger && rightBigger;

    }

    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 1000000;
        int maxLen = 100;
        int maxValue = 200;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLen, maxValue);
            int num = oneMinIndex(arr);
            if (!check(arr, num)) {
                printArray(arr);
                System.out.println(num);
                break;//
            }
        }
        System.out.println("测试结束");

    }
}
