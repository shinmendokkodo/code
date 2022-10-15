/*
Problem Description
Rohan is a guy who has N different types of books. Given an integer array which represents the selling price of each type of book. He has an infinite supply of each type of book. Rohan wants to buy a movie ticket, which has a cost of K dollars. Since he has got no money, he decided to sell some of his books. Print the minimum number of books he needs to sell to get exactly K dollars. If the exact amount of money cannot be made by any combination of the books print -1.

Note: He needs exactly K dollars, not more than that.

Input format
First line contains an integer.(Number of types of books)

Second line contains n space separated integers.(Selling price of each type of book)

Third line contains an integer.(Cost of the movie ticket)

Output format
An integer.

Sample Input 1
3

1 2 5

11

Sample Output 1
3

Explanation
11= 5 + 5 + 1.

He needs to sell three of his books to get the exact amount.

Sample Input 2
1

2

3

Sample Output 2
-1

Explanation
The exact amount cannot be made by any combinations.

Constraints
1 <= books.length <= 12

1 <= books[i] <= (2^31) - 1

0 <= Cost of movie ticket <= 10000
*/

import java.util.*;

class MovieTicket {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(movieTicket(n, array, k));
        sc.close();
    }

    static int movieTicket(int n, int[] sellingPrice, int k) {
        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (j >= sellingPrice[i]) {
                    if (dp[i][j - sellingPrice[i]] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - sellingPrice[i]] + 1);
                    }
                }
            }
        }

        return (dp[n - 1][k] == Integer.MAX_VALUE ? -1 : dp[n - 1][k]);
    }
}