/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        
        TreeLinkNode nil = new TreeLinkNode(0);
        queue.add(nil);
        
        TreeLinkNode last = nil;
        while (queue.size() > 1) {
            TreeLinkNode cur = queue.poll();
            if (cur == nil) {
                queue.add(nil);
                last = nil;
            } else {
                last.next = cur;
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
                last = cur;
            }
        }
    }
}