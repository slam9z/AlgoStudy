import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=671 lang=java
 *
 * [671] Second Minimum Node In a Binary Tree
 *
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
 *
 * algorithms
 * Easy (42.92%)
 * Total Accepted:    38.9K
 * Total Submissions: 90.6K
 * Testcase Example:  '[2,2,5,null,null,5,7]'
 *
 * 
 * Given a non-empty special binary tree consisting of nodes with the
 * non-negative value, where each node in this tree has exactly two or zero
 * sub-node. If the node has two sub-nodes, then this node's value is the
 * smaller value among its two sub-nodes. 
 * 
 * 
 * 
 * Given such a binary tree, you need to output the second minimum value in the
 * set made of all the nodes' value in the whole tree. 
 * 
 * 
 * 
 * If no such second minimum value exists, output -1 instead.
 * 
 * 
 * Example 1:
 * 
 * Input: 
 * ⁠   2
 * ⁠  / \
 * ⁠ 2   5
 * ⁠    / \
 * ⁠   5   7
 * 
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 
 * ⁠   2
 * ⁠  / \
 * ⁠ 2   2
 * 
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest
 * value.
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        long firstMin = Long.MAX_VALUE;
        long secondMin = Long.MAX_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            if (firstMin > cur.val) {
                secondMin = firstMin;
                firstMin = cur.val;
            } else if (firstMin != cur.val && secondMin > cur.val) {
                secondMin = cur.val;
            }
        }

        if (secondMin == firstMin || secondMin == Long.MAX_VALUE) {
            return -1;
        }
        return (int) secondMin;
    }
}