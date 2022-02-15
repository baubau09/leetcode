class FindNumbersWithEvenNumberofDigits {
    public static void main(String[] args) {
        int nums[] = {12,345,2,6,7896};
        System.out.println(findNumbers(nums));
    }
    public static int findNumbers(int[] nums) {
        int countEven = 0;
        for (int val : nums) {
            int countDigits = 0;
            while (val != 0) {
                val = val / 10;
                ++countDigits;
            }
            if (countDigits % 2 == 0) countEven++;
        }
        return countEven;
    }
}