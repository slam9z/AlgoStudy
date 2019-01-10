import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (31.91%)
 * Total Accepted:    315.1K
 * Total Submissions: 985.9K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * 
 * Time Complexity:(nlogk) // k is the number of the linked list
 * - every pop and insertion to priority queue O(logk)
 * - finding the node with the smallest value just costs O(1) time
 * - there are N nodes in the list
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (ListNode node: lists) {
            if (node != null)
                minHeap.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while(!minHeap.isEmpty()) {
            ListNode tmp = minHeap.poll();
            cur.next = tmp;
            cur = cur.next;
            if (tmp.next != null) {
                minHeap.offer(tmp.next);
            } 

        }
        return dummy.next;
    }
}


