package com.weiyuze.class06;

import java.util.HashMap;

public class Code05_ConstructBinaryTreeFromPreorderAndInorderTraversal {
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            //边界条件
            if (preorder == null || inorder == null || preorder.length != inorder.length) {
                return null;
            }
            //现将中序遍历的数存到表中 直接读 减少循环查找
            HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                valueIndexMap.put(inorder[i], i);//要根据值获取位置 将值传入key 位置传入value
            }
            return f(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, valueIndexMap);
        }

        TreeNode f(int[] preorder, int L1, int R1, int[] inorder, int L2, int R2, HashMap<Integer, Integer> valueIndexMap) {
            //当左、右子树为空时 L1>R1,L2>R2 返回null
            if (L1 > R1) {
                return null;
            }
            //先序遍历第一个是头节点
            TreeNode head = new TreeNode(preorder[L1]);
            if (L1 == R1) {
                return head;
            }
            //根据头节点的值在中序遍历里找所在位置 位置左侧的是左子树 右侧是右子树 递归调用 方法需要传递左右子树具体位置
            int find = valueIndexMap.get(preorder[L1]);
            //当有这种+1的时候要考虑条件 防止越界
            //当左、右子树为空时 L1>R1,L2>R2 加判断条件
            head.left = f(preorder, L1 + 1, L1 + find - L2, inorder, L2, find - 1, valueIndexMap);
            head.right = f(preorder, L1 + find - L2 + 1, R1, inorder, find + 1, R2, valueIndexMap);
            return head;
        }
    }

}
