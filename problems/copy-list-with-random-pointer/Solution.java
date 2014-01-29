/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return head;
        RandomListNode node = head;
        while (node != null) {
            RandomListNode next = new RandomListNode(node.label);
            next.next = node.next;
            node.next = next;
            node = next.next;
        }
        node = head;
        while (node != null) {
            if (node.random != null)
                node.next.random = node.random.next;
            node = node.next.next;
        }
        RandomListNode newHead = head.next;
        node = head;
        while (node != null && node.next != null) {
            RandomListNode next = node.next;
            node.next = next.next;
            node = next;
        }
        return newHead;
    }
}