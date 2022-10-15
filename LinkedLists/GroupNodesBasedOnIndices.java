/*
Problem Description
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

Input format
First line contains an integer N - Number of nodes in the linked list.

Second line contains N integers representing the linked list.

Output format
Return the head of the reordered linked list.

Sample Input 1
5

1 5 3 4 8

Sample Output 1
1 3 8 5 4

Explanation
Arranging the odd nodes first i.e. 1st, 3rd, 5th node and then the even nodes i.e. 2nd, 4th will give us 1, 3, 8, 5, 4.

Constraints
0 <= N <= 10^5

-10^9 <= Value of node <= 10^9
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

public class GroupNodesBasedOnIndices {
    public ListNode oddEvenLinkedList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenStart = null;
        ListNode evenEnd = null;

        ListNode oddStart = null;
        ListNode oddEnd = null;

        int i = 1;

        while (head != null) {
            if (i % 2 == 0) {
                if (evenStart == null) {
                    evenStart = evenEnd = head;
                } else {
                    evenEnd.next = head;
                    evenEnd = evenEnd.next;
                }
            } else {
                if (oddStart == null) {
                    oddStart = oddEnd = head;
                } else {
                    oddEnd.next = head;
                    oddEnd = oddEnd.next;
                }
            }

            head = head.next;
            i++;
        }
        if (evenEnd != null)
            evenEnd.next = null;

        oddEnd.next = evenStart;
        return oddStart;
    }
}