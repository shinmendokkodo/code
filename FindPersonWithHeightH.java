/*
Problem Description
N People are standing in a queue in increasing order of their height. K people from the front side left the queue and joined it from the back (in the same order).

For example- if 2 people from the queue (1,2,3,4,5,6) left and joined it from the back, the new queue will be (3,4,5,6,1,2).

Given the new sequence of people's height in the form of an array, determine the index of the person with a given height H. If no such person exists, return -1.

Input format
First line will have a single integer N denoting the size of the array.

Second line will contain N space separated integers - The new sequence.

Third line will contain a single integer Q - Number of queries.

Next Q line will have a single integer H in each line denoting the height to be found.

Output format
For each query, print the index of the person with the given height in a separate line. If no person found print -1.

Sample Input 1
6

4 5 6 7 1 2

2

1

3

Sample Output 1
4

-1

Explanation
The index of 1 is 4 in the new sequence.

The person with height 3 is not present so we print -1.

Sample Input 2
5

1 2 3 4 7

2

1

2

Sample Output 2
0

1

Constraints
1 <= N <= 10^5

0 < height values < 2^31

1 <= Q <= 10^5

0 < H < 2^31
*/

import java.util.*;

class FindPersonWithHeightH {

    // Complete the function implementation below
    public int findPersonWithHeightH(int[] seq, int H) {
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == H) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int seq[] = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        while (q > 0) {
            int H = scanner.nextInt();
            int result = new FindPersonWithHeightH().findPersonWithHeightH(seq, H);
            System.out.println(result);
            q--;
        }

        scanner.close();
    }
}