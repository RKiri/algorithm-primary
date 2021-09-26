package com.weiyuze.class06;

public class Code03_SymmetricTree {
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
        public boolean isSymmetric(TreeNode root) {
            //整颗树的头节点不会破坏镜面关系
            return isMirror(root.left, root.right);
        }

        boolean isMirror(TreeNode p, TreeNode q) {
            //当两个节点都为空 true
            if (p == null && q == null) {
                return true;
            }
            //一个为空一个不为空 false
            else if (p == null ^ q == null) {
                return false;
            }
            //当两个都不空时
            else {
                //判断两个节点p，q的值是否相同
                //p的左节点和q的右节点；p的右节点和q的左节点是否相同 调用isMirror(node,node) 递归
                return p.val == q.val && isMirror(p.left, q.right) && isMirror(p.right, q.left);
            }
        }
    }
}
