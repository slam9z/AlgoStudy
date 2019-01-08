/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 *
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
 *
 * algorithms
 * Hard (36.40%)
 * Total Accepted:    64.3K
 * Total Submissions: 176.7K
 * Testcase Example:  '[5,2,6,1]'
 *
 * You are given an integer array nums and you have to return a new counts
 * array. The counts array has the property where counts[i] is the number of
 * smaller elements to the right of nums[i].
 * 
 * Example:
 * 
 * 
 * Input: [5,2,6,1]
 * Output: [2,1,1,0] 
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * 
 * 
 */
class Solution {

    static class ArgumentedTreeNode {
        int segmentLeftCount;
        int val;
        ArgumentedTreeNode left;
        ArgumentedTreeNode right;
        
        public ArgumentedTreeNode(int value) {
            val = value;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res; 
        ArgumentedTreeNode root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, 0, res);
        }

        return res;
    }


    private ArgumentedTreeNode insert(int num, ArgumentedTreeNode node, int prefixSum, List<Integer> res) {
        if (node == null) {
            res.add(0, prefixSum);
            return new ArgumentedTreeNode(num);
        }

        
        if (num >= node.val) {
            // go right increase the prefix sum
            node.right  = insert(num, node.right, prefixSum + node.segmentLeftCount + ((num > node.val) ? 1 : 0), res);
        } else {
            
            node.segmentLeftCount++;
            node.left = insert(num, node.left, prefixSum, res);
        }
        return node;
    }
}
