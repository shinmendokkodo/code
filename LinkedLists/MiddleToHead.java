/*
Problem Description
Given a singly linked list, find the middle node of the linked list and move that node to the head of the list. Return the head of the list. In the case of a list with an even number of nodes, use the second middle one.

Input format
There are 2 lines of input

N - An integer denoting the number of nodes in the linked list.

N integers follow where ith integer denotes the ith node value in the linked list

Output format
Return the head of the modified list after moving the middle node to head.

Constraints
0 <= N<= 10^5

-10^9 <= value <= 10^9

Sample Input 1
6

2 3 4 5 6 7

Sample Output 1
5 2 3 4 6 7

Explanation 1
The middle node here is [5]. Moving that to the head of the list gives us the output shown.

Sample Input 2
5

1 2 3 4 5

Sample Output 2
3 1 2 4 5

Explanation 2
The middle node here is [3]. Moving that to the head of the list gives us the output shown.

Resource
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

class Solution {
    public ListNode moveMiddleToHead(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        if (head == null || head.next == null) {
            return head;
        }

        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        prev.next = slow.next;
        slow.next = head;
        head = slow;

        return head;
    }
}