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
    public int findClosestLeaf(TreeNode root, int k) {
        if (root == null) return 0;
        Map<TreeNode, TreeNode> map = new HashMap<>();
        
        TreeNode kNode = findKNode(root, k, map);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(kNode);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            
            // case1 : no child 
            if (cur.left == null && cur.right == null) return cur.val;
            
            // case2 : has left child
            if (cur.left != null && visited.add(cur.left)) {
                queue.offer(cur.left);
            }
            
            // case3 : has rigt child
            if (cur.right != null && visited.add(cur.right)) {
                queue.offer(cur.right);
            }
            
            if (map.containsKey(cur) && visited.add(map.get(cur))) {
                queue.offer(map.get(cur));
            }
        }
        return -1;
    }
    
    private TreeNode findKNode(TreeNode root, int k, Map<TreeNode, TreeNode> map) {
        if (root == null || root.val == k) return root;
        
        if (root.left != null) {
            map.put(root.left, root);
            TreeNode leftSub = findKNode(root.left, k, map);
            if (leftSub != null) {
                return leftSub;
            }
        }
        
        if (root.right != null) {
            map.put(root.right, root);
            TreeNode rightSub = findKNode(root.right, k, map);
            if (rightSub != null) {
                return rightSub;
            }
        }
        return null;
    }
    
}