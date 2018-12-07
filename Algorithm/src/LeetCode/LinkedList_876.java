package LeetCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 876. Middle of the Linked List
    Given a non-empty, singly linked list with head node head, return a middle node of linked list.
    If there are two middle nodes, return the second middle node.

    Example 1:
    Input: [1,2,3,4,5]
    Output: Node 3 from this list (Serialization: [3,4,5])
    The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
    Note that we returned a ListNode object ans, such that:
    ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.

    Example 2:
    Input: [1,2,3,4,5,6]
    Output: Node 4 from this list (Serialization: [4,5,6])
    Since the list has two middle nodes with values 3 and 4, we return the second one.

    Note:
    The number of nodes in the given list will be between 1 and 100.

 */
public class LinkedList_876 {

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
        Solution1.ListNode listNode1 = new Solution1.ListNode(1);
        Solution1.ListNode listNode2 = new Solution1.ListNode(2);
        Solution1.ListNode listNode3 = new Solution1.ListNode(3);
        Solution1.ListNode listNode4 = new Solution1.ListNode(4);
        Solution1.ListNode listNode5 = new Solution1.ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        Solution1.ListNode result = solution1.middleNode(listNode1);

        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }

	}

}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution1 {
    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }
    public ListNode middleNode(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head.next != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }

}