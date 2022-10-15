/*
Problem Description
You’re given two numbers represented by two linked lists, where each node contains a single digit. The digits are stored in forward order i.e the one’s digit is at the tail of the list. Write a function that adds the two numbers and returns the sum as a linked list in the same order.

Input format
There are 4 lines of input.

First line contains N, the size of the first list

Next line contains N space separated integers

Third line contains M, the size of the second list

Next line contains M space separated integers

Output format
Return the resultant list after adding given lists.

Function definition
The given function accepts two arguments - representing the heads of the two lists,and returns the new head.

Constraints
1 <= N <= 1e5

1 <= M <= 1e5

0 <= value <= 9

Sample Input 1
3

6 1 7

3

2 9 5

Sample Output 1
9 1 2

Explanation 1
617 + 295 = 912.

Sample Input 2
2

4 9

1

5

Sample Output 2
5 4

Explanation 2
49 + 5 = 54.
*/

package LinkedLists;

import java.util.*;

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }
}

class AddTwoNumbersGivenAsLinkedList {
    public static ListNode sumLists1(ListNode head1, ListNode head2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        ListNode l1 = head1;
        ListNode l2 = head2;

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode result = null;

        while (!s1.isEmpty() || !s2.isEmpty()) {
            int a = 0;
            int b = 0;

            if (!s1.isEmpty()) {
                a = s1.pop();
            }

            if (!s2.isEmpty()) {
                b = s2.pop();
            }

            int total = a + b + carry;

            ListNode node = new ListNode(total % 10);
            carry = total / 10;

            if (result == null) {
                result = node;
            } else {
                node.next = result;
                result = node;
            }
        }

        if (carry != 0) {
            ListNode node = new ListNode(carry);
            node.next = result;
            result = node;
        }

        return result;
    }
}
