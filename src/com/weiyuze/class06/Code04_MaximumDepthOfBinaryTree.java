package com.weiyuze.class06;

public class Code04_MaximumDepthOfBinaryTree {
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
        public int maxDepth(TreeNode root) {
            //如果当前节点为空 返回0
            if (root == null) {
                return 0;
            }
            //否则返回 左右节点 调递归函数长度大的 +1
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
