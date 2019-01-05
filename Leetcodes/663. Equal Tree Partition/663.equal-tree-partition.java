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
    public boolean checkEqualTree(TreeNode root) {
        if (root == null) return true;
        Map<Integer, Integer> map = new HashMap<>();
        int total = getSum(root, map);
        if (total == 0) {
            return map.getOrDefault(total, 0) > 1;
        }
        
        return total % 2 == 0 && map.containsKey(total/2);
    }
    
    private int getSum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int curSum = root.val;
        if (root.left != null)
            curSum += getSum(root.left, map); 
        if (root.right != null)
            curSum += getSum(root.right, map);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        return curSum;
    }
}