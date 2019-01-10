class Morris {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        TreeNode cur = root, ptr = null;

        while(cur != null) {
            ptr = cur.left;
            if (ptr != null) {
                while (ptr.right != null && ptr.right != cur) {
                    ptr = ptr.right;
                }

                if (ptr.right == null){
                    ptr.right = cur;
                    cur = cur.left;
                    continue;
                }
                // case for ptr.right != null;
                ptr.right = null;
            }
            res.add(cur.val);
            cur = cur.right; 
        }
    }

    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        TreeNode cur = root, ptr = null;

        while (cur != null) {
            ptr = cur.left;
            if (ptr != null) {
                while (ptr.right != null && ptr.right != cur) {
                    ptr = ptr.right;
                }
                if (ptr.right != null) {
                    res.add(cur.val);
                    ptr.right = cur;
                    cur = cur.left;
                    
                } else {
                    ptr.right = null;
                    cur = cur.right;
                }
            } else {
                res.add(cur.val);
                cur = cur.right;
            }
        }
    }
}