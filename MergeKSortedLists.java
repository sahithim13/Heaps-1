/* Time Complexity: O(Nlogk), N is total no of nodes in k lists
 * Space Complexity:O(k), k is min heap size 
 * 					O(N) for result list
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode head: lists){
            if(head != null){
                pq.add(head);
            }
        }
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null){
                pq.add(min.next);
            }
        }
        return result.next;
    }
}   