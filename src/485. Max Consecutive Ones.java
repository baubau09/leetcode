class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int nums[] = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    // brute force
    // O(N) time, O(1) space
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;

        // loop through every number
        for (int val : nums) {
            if (val == 1) {
                // if the number at index i is = 1, increases count by 1 to record 1 occurrence
                count++;
                // then check right away if the current occurrences number (count) is max
                // if yes, replace old max with current count,
                // if no, the max will still be old max
                max = Math.max(count,max);
            } else {
                // if the number at index i is != 1,
                // we don't need to compare with the current max
                // then reset count to 0 to find a new set of 1
                count = 0;
            }
        }
        // return max number of occurrences after finishing the loop
        return max;
    }

    // two pointers
    // O(N) time, O(1) space
    // constantly moving right pointer, conditioned when meets 0
    // left pointer moves at a condition
    // count = right - left + 1
    public static int findMaxConsecutiveOnes2(int[] nums) {
        int left = 0;
        int max = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                left = right + 1;
            }
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
