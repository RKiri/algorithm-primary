package com.weiyuze.class02;

public class Code01_PreSum {

    public static void main(String[] args) {
        int[] arr = {2, 6, 1, 7, 3, 4, 5};
        RangeSum2 rs = new RangeSum2(arr);
        rs.rangSum(0, 0);
    }

    public static class RangeSum1 {
        int[] arr;

        public RangeSum1(int[] arr) {
            this.arr = arr;
        }

        void rangSum(int L, int R) {
            int sum = 0;
            for (int i = L; i <= R; i++) {
                sum += arr[i];
            }
            System.out.println(sum);
        }
    }

    static class RangeSum2 {
        int[] preSum;

        public RangeSum2(int[] arr) {
            preSum = new int[arr.length];
            preSum[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                preSum[i] = preSum[i - 1] + arr[i];
            }
        }

        void rangSum(int L, int R) {
            System.out.println(L == 0 ? preSum[R] : preSum[R] - preSum[L - 1]);
        }
    }
}
