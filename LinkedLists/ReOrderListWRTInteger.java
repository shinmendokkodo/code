/*
Problem Description
Given a linked list and an integer X, partition the LL around X, such that all nodes less than X come before all nodes greater than X. If X is contained within the list, then those nodes need

to be after the elements less than X and before the elements greater than X, i.e. they should appear between the left and right partitions.


You can also see if you can preserve the order for elements on either side of the partition. For instance, for given LL 2, 6, 5, 7, 1 and X = 5, the answer should be 2, 1, 5, 6, 7 only, instead of 1, 2, 5, 6, 7.

Input format
N - An integer denoting the number of nodes in the linked list.

N integers follow where ith integer denotes the ith node value in the linked list

X - An integer denoting the value that you must use to partition the given list

Output format
Return the head after partitioning the list

Constraints
1 <= N <= 10^5

-10^9 <= value, X <= 10^9

Sample Input 1
7

3 5 8 5 10 2 1

5

Sample Output 1
3 2 1 5 5 8 10

Explanation 1
The nodes [3], [1] and [2] are less than [5] so they are present before [8] and [10].

There are also other possible answers for the same input.

Sample Input 2
5

3 1 3 1 4

2

Sample Output 2
1 1 4 3 3

Explanation 2
All nodes with values less than 2 come before all nodes with values greater than 2.
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

class ReOrderListWRTInteger {
    public static ListNode partition(ListNode head, int x) {
        ListNode equalHead = null;
        ListNode equalTail = null;

        ListNode greaterHead = null;
        ListNode greaterTail = null;

        ListNode lesserHead = null;
        ListNode lesserTail = null;

        while (head != null) {
            if (head.val == x) {
                if (equalHead == null) {
                    equalHead = equalTail = head;
                } else {
                    equalTail.next = head;
                    equalTail = equalTail.next;
                }
            } else if (head.val < x) {
                if (lesserHead == null) {
                    lesserHead = lesserTail = head;
                } else {
                    lesserTail.next = head;
                    lesserTail = lesserTail.next;
                }
            } else {
                if (greaterHead == null) {
                    greaterHead = greaterTail = head;
                } else {
                    greaterTail.next = head;
                    greaterTail = greaterTail.next;
                }
            }

            head = head.next;
        }

        if (greaterTail != null) {
            greaterTail.next = null;
        }

        if (lesserHead == null) {
            if (equalHead == null) {
                return greaterHead;
            }
            equalTail.next = greaterHead;
            return equalHead;
        }

        if (equalHead == null) {
            lesserTail.next = greaterHead;
            return lesserHead;
        }

        lesserTail.next = equalHead;
        equalTail.next = greaterHead;
        return lesserHead;
    }
}