/*
Problem Description
You are given N packets of Donuts, each packet containing a varying number of donuts. You have to pick total B packets from either left or right end to get the maximum number of donuts.

Input format
First line will contain two space separated integers N and B respectively.

Second line will contain N space separated A[i] - specifying the number of donuts in each packet.

Output format
Print the answer in a single line.

Sample Input 1
6 4

2 3 1 2 5 1

Sample Output 1
11

Explanation
(2+3) + (5+1) = 11

We will have the maximum donuts for two packets from the left side and two packets from the right.

Constraints
1 <= N <= 10^5

1 <= Ai <= 10^4

1 <= B <= N
*/

import java.util.*;

class Donuts {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();
        List<Integer> A = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            A.add(sc.nextInt());
        }
        long result = donuts(N, B, A);
        System.out.println(result);
        sc.close();
    }

    static long donuts(int N, int B, List<Integer> A) {
        int leftSum = 0;
        int rightSum = 0;
        int totalSum = 0;

        for (int i = 0; i < B; i++) {
            leftSum = leftSum + A.get(i);
        }

        totalSum = leftSum + rightSum;

        for (int i = 0; i < B; i++) {
            leftSum = leftSum - A.get(B - i - 1);
            rightSum = rightSum + A.get(N - 1 - i);
            totalSum = Math.max(totalSum, leftSum + rightSum);
        }

        return totalSum;
    }
}