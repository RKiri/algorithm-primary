package com.weiyuze.class07;

import java.util.LinkedList;
import java.util.List;

public class Code04_PathSumII {
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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> ans = new LinkedList<>();
            if (root == null) {
                return ans;//有返回值 空的是否返回返回值 不能返回null
            }
            List<Integer> path = new LinkedList<>();
            process(root, path, 0, targetSum, ans);
            return ans;
        }

        //定义一个process方法传 root 临时链表path 当前值preSum targetSum 总链表ans
        void process(TreeNode root, List<Integer> path, int preSum, int targetSum, List<List<Integer>> ans) {
            //传入一个节点判断是否是叶子节点
            if (root.left == null && root.right == null) {
                //如果是的话 preSum加上root.val 判断是否等于targetSum
                if (preSum + root.val == targetSum) {
                    //将节点添加到临时链表
                    path.add(root.val);
                    //总链表将临时链表整个添加进去
                    ans.add(copy(path));
                    //临时链表去掉最后一个
                    path.remove(path.size() - 1);
                }
                //返回
                return;
            }
            //将当前节点添加到临时链表
            path.add(root.val);
            //当前值加上root.val
            preSum += root.val;
            //process(左节点)
            if (root.left != null) {//当不为空时
                process(root.left, path, preSum, targetSum, ans);
            }
            //process(右节点)
            if (root.right != null) {
                process(root.right, path, preSum, targetSum, ans);
            }
            //减去最后一个
            path.remove(path.size() - 1);
        }

        //复制方法
        List<Integer> copy(List<Integer> path) {
            List<Integer> ans = new LinkedList<>();
            for (Integer i : path) {
                ans.add(i);
            }
            return ans;
        }
    }
}
