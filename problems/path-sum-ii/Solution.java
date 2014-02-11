/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        deque.addLast(root.val);
        getRes(root, sum - root.val, deque);
        return res;
    }
    
    private void getRes(TreeNode root, int sum, Deque<Integer> deque) {
        if (root.left == null && root.right == null && 0 == sum) {
            res.add(new ArrayList<Integer>(deque));
        } else {
            if (root.left != null) {
                deque.addLast(root.left.val);
                getRes(root.left, sum - root.left.val, deque);
                deque.pollLast();
            }
            if (root.right != null) {
                deque.addLast(root.right.val);
                getRes(root.right, sum - root.right.val, deque);
                deque.pollLast();
            }
        }
    }
}