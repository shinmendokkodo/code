/*
Problem Description
Given the elements of a linked list, reverse it.


You’ll have to implement the given method, which has the original list’s head pointer as an argument, and return the head of the updated list.

Input format
There are two lines of input.

First line contains N, the number of elements in the linked list.

Second line contains N space separated integers.

Output format
Only line contains N space separated integers

Sample Input 1
5

1 2 3 4 5

Sample Output 1
5 4 3 2 1

Explanation 1
1->2->3->4->5->NULL

5->4->3->2->1->NULL

Constraints
0 <= N <= 10^5

-10^9 <= A[i] <= 10^9
*/

package LinkedLists;

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }
}

public class ReverseLinkedList {
    public ListNode reverseLinkedList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}