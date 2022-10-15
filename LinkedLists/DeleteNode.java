/*
Problem Description
Given only a reference to a node to be deleted in a singly linked list, implement a function to delete the given node. The given node is guaranteed to be neither the first, nor the last node.


Note: The node to be deleted is not necessarily the exact middle node but is one of nodes that is not at the ends.


Note: The input format will accept K, which denotes the position of the node to be deleted. However, in the function definition you’re given, you will not be given K. Instead, you’ll only have a pointer to the node to be deleted, and you have to use only that. You will not be able to use K. The challenge is to figure out how to delete this node without having a reference to the head of the linked list.

Input format
First-line contains N, the number of elements in the linked list.

Next line contains N space-separated integers, elements of the linked list.

Next Line contains K, denotes the position of the node to be deleted.

Output format
A list of N integers after deleting the Kth node.

Constraints
0 <= N <= 10^5

-10^9 <= value <= 10^9

1 < K < N

Sample Input 1
5

1 5 2 4 3

3

Sample Output 1
1 5 4 3

Explanation 1
The 3rd node containing 2 has been removed leading to 1 5 4 3.
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

public class DeleteNode {
    public static void deleteGivenNode(ListNode node) {
        ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
    }
}
