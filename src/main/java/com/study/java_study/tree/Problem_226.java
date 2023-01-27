package com.study.java_study.tree;

import com.study.java_study.tree.entity.TreeNode;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;

/**
 * 反转二叉树
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
@SpringBootTest
public class Problem_226 {

    @Test
    public void testSpiralOrder() {
        TreeNode res = invertTree(null);
        System.out.println(res);
    }

    // 递归解法
    // https://leetcode.cn/problems/invert-binary-tree/solutions/73159/dong-hua-yan-shi-liang-chong-shi-xian-226-fan-zhua/
    public TreeNode invertTree(TreeNode root) {
        //递归函数的终止条件，节点为空时返回
        if (root == null) {
            return root;
        }

        //下面三句是将当前节点的左右子树交换
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }

    //  迭代解法
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        //将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //每次都从队列中拿一个节点，并交换这个节点的左右子树
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            //如果当前节点的左子树不为空，则放入队列等待后续处理
            if (current.left != null) {
                queue.add(current.left);
            }
            //如果当前节点的右子树不为空，则放入队列等待后续处理
            if (current.right != null) {
                queue.add(current.right);
            }

        }
        //返回处理完的根节点
        return root;

    }


}
