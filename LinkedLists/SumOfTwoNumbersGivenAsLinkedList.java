/*
Problem Description
You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the one’s digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.

Input format:
First line contains N, number of elements in the first linked list.

Next line contains N space separated integers, elements of that linked list.

First line contains M, number of elements in the second linked list.

Next line contains M space separated integers, elements of that linked list.

Output format
Print the sum of the given numbers.

Sample Input 1
3

7 1 6

3

5 9 2

Sample Output 1
2 1 9

Explanation 1
617 + 295 = 912

Sample Input 2
2

4 9

2

0 5

Sample Output 2
4 4 1

Explanation 1
94 + 50 = 144

Constraints
1 <= M, N <= 10^5

0 <= A[i] < 10
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

class SumOfTwoNumbersGivenAsLinkedList {
    public static ListNode sumLists1(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode temp = null;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;

            if (temp == null) {
                temp = head = node;
            }

            else {
                temp.next = node;
                temp = temp.next;
            }
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        return head;
    }
}
