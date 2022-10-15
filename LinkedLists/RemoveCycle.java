/*
Problem Description
Given only the head of a linked list, check whether the linked list contains cycle or not. If the linked list does not contain a cycle return false, otherwise remove the cycle and return true.

Input format
First line contains an integer N - Number of nodes in the linked list.

Second line contains N integers representing the linked list.

Third line contains one integer K - The index to which the tail connects to (-1 in case of no cycle).

Output format
Return true or false depending on whether the linked list contains cycle or not. If the answer is true modify the linked list and remove the cycle.

Sample Input 1
5

1 2 3 4 5

2

Sample Output 1
true

1 2 3 4 5

Explanation
Visualization:

1-2-3-4-5
  ^     |
  |_____|

After removing cycle: 1-->2-->3-->4-->5-->NULL

Sample Input 2
4

2 3 4 2

-1

Sample Output 2
false

Explanation
Visualization: 2-->3-->4-->2-->NULL

Constraints
1 <= N <= 10^5

-10^9 <= Value of node <= 10^9

-1 <= K <= N-1
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

public class RemoveCycle {
    public boolean detectAndRemoveCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                if (slow != fast) {
                    while (slow.next != fast.next) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    fast.next = null;
                } else {
                    while (fast.next != slow) {
                        fast = fast.next;
                    }
                    fast.next = null;
                }
                return true;
            }
        }

        return false;
    }
}
