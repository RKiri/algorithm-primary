package com.weiyuze.class06;

public class Code02_SameTree {
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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            //如果都为空 相同
            if (p == null && q == null) {
                return true;
            }
            //一个为空另一个不为空 不同
            else if (p == null ^ q == null) {
                return false;
            }
            //都不为空：
            else {
                return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
            //判断当前节点的值是否相同 判断左节点 右节点 递归调函数

        }
    }
}
