package com.weiyuze.class07;

public class Code05_IsBinarySearchTree {
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
        //需要返回isBST max min 定义class Info
        class Info {
            boolean isBST;
            int max;
            int min;

            public Info(boolean isBST, int max, int min) {
                this.isBST = isBST;
                this.max = max;
                this.min = min;
            }
        }

        public boolean isValidBST(TreeNode root) {
            //返回Info的isBST
            return process(root).isBST;
        }

        //process方法传root 返回Info
        Info process(TreeNode root) {
            //判断当root为空时 返回null
            if (root == null) {
                return null;
            }
            //没有子树 向上传自己 所以先定义max和min为root.val
            int max = root.val;
            int min = root.val;
            Info leftNode = process(root.left);
            Info rightNode = process(root.right);
            //判断左子树最大值小于根节点 右子树最小值大于根节点
            //定义isBST
            boolean isBST = true;
            //左右子树不为空的时候获取最大值和最小值 向上传
            if (leftNode != null) {
                min = leftNode.min;
                //判断左右子树是否都为true
                if (!leftNode.isBST || leftNode.max >= root.val) {
                    isBST = false;
                }
            }
            if (rightNode != null) {
                max = rightNode.max;
                if (!rightNode.isBST || rightNode.min <= root.val) {
                    isBST = false;
                }
            }
            //返回new Info
            return new Info(isBST, max, min);
        }
    }
}
