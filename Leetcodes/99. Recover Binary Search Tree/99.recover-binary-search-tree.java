/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
 *
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 *
 * algorithms
 * Hard (33.36%)
 * Total Accepted:    107.1K
 * Total Submissions: 320.8K
 * Testcase Example:  '[1,3,null,null,2]'
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,3,null,null,2]
 * 
 * 1
 * /
 * 3
 * \
 * 2
 * 
 * Output: [3,1,null,null,2]
 * 
 * 3
 * /
 * 1
 * \
 * 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,1,4,null,null,2]
 * 
 * ⁠ 3
 * ⁠/ \
 * 1   4
 * /
 * 2
 * 
 * Output: [2,1,4,null,null,3]
 * 
 * ⁠ 2
 * ⁠/ \
 * 1   4
 * /
 * ⁠ 3
 * 
 * 
 * Follow up:
 * 
 * 
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
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
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        TreeNode cur = root, ptr = null, pre = null;
        TreeNode first = null, second = null;

        while (cur != null) {
            ptr = cur.left;
            if (ptr != null) {
                while (ptr.right != null && ptr.right != cur) {
                    ptr = ptr.right;
                }

                if (ptr.right == null) {
                    ptr.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    ptr.right = null;
                }
            }
            if (pre != null && pre.val > cur.val) {
                if (first == null) {
                    first = pre;
                }
                second = cur;
            }
            pre = cur;
            cur = cur.right;

        }
        swap(first, second);

    }

    private void swap(TreeNode n1, TreeNode n2) {
        Integer tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }
}
