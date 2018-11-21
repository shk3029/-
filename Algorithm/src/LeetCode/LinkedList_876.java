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
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis(); 
		System.out.println("start");		

		long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		System.out.println( "실행 시간 : " + ( end - start ));
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
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
    public ListNode middleNode(ListNode head) {
        return head;
    }
}