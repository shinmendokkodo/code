/*
Problem Description
N friends attended a birthday party. Their ages are specified in the array and they are arranged in the order of arrival. For each of the people, find the next younger person who arrived after them. If there is no younger person, return -1.

Input format
There are 2 lines of input:

The first line contains an integer N denoting the number of friends.

The second line contains N space separated positive integers denoting the ages of friends arranged in order of arrival in the array A.

Output format
Print N space separated integers, which are the next younger person for each person who attended the party. If no such person exists, output -1.

Sample Input 1
5

8 2 5 10 4

Sample Output 1
2 -1 4 4 -1

Explanation
For 8, person with age 2 arrived after him.

For 5 and 10, person with age 4 arrived after him.

For all other people, no younger person arrived after them.

Constraints
1 <= N <= 10^5

0 < Values in the array <= 10^9
*/

import java.util.*;

class BirthdayParty {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] ans = birthdayParty(arr, n);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

        sc.close();
    }

    static int[] birthdayParty(int arr[], int n) {
        Stack<Integer> stack = new Stack<>();

        int nextLarger[] = new int[n];

        Arrays.fill(nextLarger, -1);

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] > num) {
                nextLarger[stack.pop()] = num;
            }

            stack.push(i);
        }
        return nextLarger;
    }
}