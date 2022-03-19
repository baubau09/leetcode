/*
* Dynamic Programming Knapsack problem
* Consider this problem as:
Given a list of numbers, multiply each number with 1 or 0 or -1,
* make the sum of all numbers to 0. Find a combination which has the largest sum of all positive numbers.
e.g. Given [1,2,3,4,5,6], we have 1*0 + 2 + 3 - 4 + 5 - 6 = 0,
* the sum of all positive numbers is 2 + 3 + 5 = 10. The answer is 10.
*
* First line input = number of rebar rods
* Second line input = height of each rebar rods
* Sample Input:
* 4
* 1 2 3 6
*
* Sample Output:
* 6
* */

import java.util.*;
class ShopeeCodeLeague2022_Billboard {
    public static void main(String[] args) {
        //Scanner
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println(highestInstall(arr));
    }

    public static int highestInstall(int[] arr) {
        int sum = 0;

        for (int r : arr) {
            sum += r;
        }

        int possibleSums = 2 * sum + 1;
        int[]dp = new int[possibleSums];
        Arrays.fill(dp, -1);
        dp[sum] = 0;

        for (int i = 0; i < arr.length; i++) {
            int[]tmp = new int[possibleSums];
            Arrays.fill(tmp, -1);
            int len = arr[i];

            for(int s = 0; s < possibleSums; s++) {

                //add
                if (s - len >= 0 && dp[s - len] != -1) {
                    tmp[s] = Math.max(dp[s - len] + len, tmp[s]);
                }

                //subtract
                if (s + len < possibleSums  && dp[s + len] != -1) {
                    tmp[s] = Math.max(tmp[s], dp[s + len]);
                }

                tmp[s] = Math.max(tmp[s], dp[s]);
            }

            dp = tmp;
        }

        return dp[sum];
    }
}

