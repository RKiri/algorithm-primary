package com.weiyuze.class07;

public class Code03_PathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        //因为是判断是否有 所以先定义没有 遍历一遍如果有就true
        boolean isSum = false;

        public boolean hasPathSum(TreeNode root, int targetSum) {
            //首先如果root为空 返回false
            if (root == null) {
                return false;
            }
            //process传root 当前和 tergetSum
            process(root, 0, targetSum);
            return isSum;
        }

        //定义process方法无需返回值
        void process(TreeNode root, int preSum, int targetSum) {
            //判断当前是不是叶子节点 root.left\right是否都为空
            if (root.left == null && root.right == null) {
                //为空计算判断当前值是否达到
                if (preSum + root.val == targetSum) {
                    isSum = true;
                }
            }
            //将值加到当前值里
            preSum += root.val;
            //不为空继续向下调左子树和右子树
            if (root.left != null) {
                process(root.left, preSum, targetSum);
            }
            if (root.right != null) {
                process(root.right, preSum, targetSum);
            }
        }
    }
}
