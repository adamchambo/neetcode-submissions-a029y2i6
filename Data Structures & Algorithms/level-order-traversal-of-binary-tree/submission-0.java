/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>(); 
        if (root == null) return new ArrayList<>();
        queue.add(root);
        List<List<Integer>> outList = new ArrayList<>();  
        List<Integer> inList = new ArrayList<>();
        inList.add(root.val);
        outList.add(inList); 

        while (queue.size() > 0) {
            int qs = queue.size(); 
            inList = new ArrayList<>(); 
            for (int i = 0; i < qs; i++) {
                TreeNode temp = queue.remove();
                if (temp.left != null){ 
                    queue.add(temp.left);
                    inList.add(temp.left.val); 
                }
                if (temp.right != null){ 
                    queue.add(temp.right);
                    inList.add(temp.right.val); 
                }
            }
            if (inList.size() > 0) outList.add(inList);
        }

        return outList; 
    }
}
