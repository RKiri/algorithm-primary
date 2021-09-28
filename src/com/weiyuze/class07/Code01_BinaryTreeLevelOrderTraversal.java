package com.weiyuze.class07;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code01_BinaryTreeLevelOrderTraversal {
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            //定义返回的List<List<Integer>> ans
            List<List<Integer>> ans = new LinkedList<>();//先定义下方为空时才能返回ans
            //边界条件 当root为空时返回null
            if (root == null) {
                return ans;//不能返回null
            }
            //定义动态添加节点的Queue<TreeNode> queue
            Queue<TreeNode> queue = new LinkedList<>();
            //将root添加进去
            queue.add(root);
            //直到queue为空
            while (!queue.isEmpty()) {
                //定义当前Queue大小size
                int size = queue.size();//定义在while里面 每次while更新
                //定义存储一层的List<Integer> curAns
                List<Integer> curAns = new LinkedList<>();
                //1、size是几 就循环几遍2
                for (int i = 0; i < size; i++) {
                    //2、将节点cur弹出 添加进List 判断cur.left\right是否为空 不为空将节点添加到queue
                    TreeNode cur = queue.poll();
                    curAns.add(cur.val);
                    if (cur.left != null) {
                        queue.add(cur.left);
                    }
                    if (cur.right != null) {
                        queue.add(cur.right);
                    }
                }
                //将curAns 添加进 List
                ans.add(0, curAns);
            }
            //返回ans
            return ans;
        }
    }
}
