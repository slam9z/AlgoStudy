import java.util.ArrayDeque;

/*
 * @lc app=leetcode id=536 lang=java
 *
 * [536] Construct Binary Tree from String
 *
 * https://leetcode.com/problems/construct-binary-tree-from-string/description/
 *
 * algorithms
 * Medium (43.37%)
 * Total Accepted:    14.7K
 * Total Submissions: 33.8K
 * Testcase Example:  '"4(2(3)(1))(6(5))"'
 *
 * You need to construct a binary tree from a string consisting of parenthesis
 * and integers. 
 * 
 * The whole input represents a binary tree. It contains an integer followed by
 * zero, one or two pairs of parenthesis. The integer represents the root's
 * value and a pair of parenthesis contains a child binary tree with the same
 * structure. 
 * 
 * You always start to construct the left child node of the parent first if it
 * exists.
 * 
 * Example:
 * 
 * Input: "4(2(3)(1))(6(5))"
 * Output: return the tree root node representing the following tree:
 * 
 * ⁠      4
 * ⁠    /   \
 * ⁠   2     6
 * ⁠  / \   / 
 * ⁠ 3   1 5   
 * 
 * 
 * 
 * Note:
 * 
 * There will only be '(',  ')',  '-' and  '0' ~ '9' in the input string.
 * An empty tree is represented by "" instead of "()".
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
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 */
class Solution {
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;
        Deque<TreeNode> deque = new ArrayDeque<>();
        int sign = 1;
        int index = 0, N = s.length();
        char[] ch = s.toCharArray();
        while(index < N) {
            switch(ch[index]) {
                case '-':
                    sign *= -1;
                    index++;
                    break;
                case '(':
                    index++;
                    break;
                case ')':
                    TreeNode cur = deque.pop();
                    TreeNode parent = deque.peek();
                    if (parent.left ==  null) {
                        parent.left = cur;
                    } else {
                        parent.right = cur;
                    }
                    index++;
                    break;
                default:
                    int num = 0;
                    while (index < N && ch[index] >= '0' && ch[index] <= '9') {
                        num = num * 10 + (ch[index++] - '0');
                    }
                    TreeNode node = new TreeNode(num * sign);
                    sign = 1;
                    deque.push(node);
                    break;
            }
        }
        if (deque.isEmpty()) return null;
        return deque.peek();
    }
}
