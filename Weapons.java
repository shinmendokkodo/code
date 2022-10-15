/*
Problem Description

As we know, War has started between Russia and Ukraine.

Putin(President of Russia) has an initial power of P, a rating of 0, and a suitcase of weapons where weapon[i]
is the value of the ith weapon(weapon[] array and P is given).

His objective is to maximize his total rating by using each weapon in one of two ways:
- He may utilize the ith weapon if his current power is at least weapon[i], losing weapon[i] power and gaining 1 rating.
- If he has a higher rating than 0, he can sell weapon[i], gaining weapon[i] power and losing 1 rating.

Each weapon may be used at most once and in any order.

Return the maximum possible rating that Putin can achieve after using any number of weapons. He need not use all the weapons.

Input format
First line contain n - number of weapons and P - Power.

Then next n contains value of ith weapon.

Output format
A single integer denoting maximum rating that Putin can achieve.

Sample Input 1
4 200

300 200 500 100

Sample Output 1
2

Explanation
Use Weapons in this order :-

Use weapon with 100 value, Putin power will become 200-100 = 100 and rating becomes 1 (0+1=1).

Sell weapon with 500 value, Putin power will become 100+500 = 600 and rating becomes 0(as selling will decrease rating by 1).

Use weapon with 300 value, Putin power will become 600-300 = 300 and rating becomes 1.

Use weapon with 200 value, Putin power will become 300-200 = 100 and rating becomes 2.

Constraints
0 <= weapons.length <= 100000

0 <= weapon[i], P < 10^4
*/

import java.util.*;


public class Weapons{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),P = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        System.out.println(weapons(n,P,arr));
        sc.close();
    }

    static int weapons(int n, int power, int[] weapon) {
        Arrays.sort(weapon);
        int i = 0;
        int j = n - 1;

        int rating = 0;

        while (i <= j) {
            if (power >= weapon[i]) {
                power -= weapon[i];
                i++;
                rating++;

            } else if (rating > 0) {
                if (j - 1 >= i) 
                {
                    power += weapon[j];
                    j--;
                    rating--;
                }
                else {
                    break;
                }
                
            } else {
                break;
            }
        }
        
        return rating;
    }   
}