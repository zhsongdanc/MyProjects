package com.demussong.lc;

import java.util.Stack;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/7/12 19:16
 */
public class TreeVisit {

    public void inVisit(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            if (stack.peek().left != null) {
                stack.push(root.left);
            } else {
                TreeNode pop = stack.pop();
                System.out.println(pop.val);
                if (pop.right != null) {
                    stack.push(pop.right);
                }
            }
        }
    }

}
class TreeNode{
    public TreeNode(){

    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int val;
    public TreeNode left;
    public TreeNode right;
}
