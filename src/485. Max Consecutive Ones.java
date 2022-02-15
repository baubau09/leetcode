class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int nums[] = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int val : nums) {
            if (val == 1) {
                count++;
                max = Math.max(count,max);
            } else {
                count = 0;
            }
        }
        return max;
    }
}
