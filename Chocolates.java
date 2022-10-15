/*
Problem Description
Given an integer array 'nums' where each element of the array represents the number of chocolates each shop gets. It has been found that the number of chocolates given to each shop is different. Rohan is a guy who wants to buy some chocolates from any shop. His mother has given him a list . The list contains shop numbers from where Rohan is allowed to buy chocolates. Print all the possible combinations of the shops which can be there on that list.The list can also be empty.

The solution set must not contain duplicate combinations. You can print the combinations in any order.

Input format
Given an integer n.

Given n space separated integers.

Output format
Print all the possible combinations.

Sample Input 1
3

1 2 3

Sample Output 1
1

2

1 2

3

1 3

2 3

1 2 3

Explanation
Print all the possible combinations including no shop on the list.First line is an empty combiantion.

Constraints
1 <= nums.length <= 10

-10 <= nums[i] <= 10

All the numbers of nums are unique.
*/

import java.util.*;

class Chocolates {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans = chocolates(n, nums);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    static List<List<Integer>> result = null;

    static List<List<Integer>> chocolates(int n, int[] nums) {
        result = new ArrayList<>();
        // Arrays.sort(nums);
        subsets(nums, new ArrayList<Integer>(), 0);
        return result;
    }

    static void subsets(int[] nums, List<Integer> tempList, int index) {

        if (index == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        tempList.add(nums[index]);
        subsets(nums, tempList, index + 1);
        tempList.remove(tempList.size() - 1);
        subsets(nums, tempList, index + 1);
    }
}