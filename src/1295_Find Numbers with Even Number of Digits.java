class FindNumbersWithEvenNumberofDigits {
    public static void main(String[] args) {
        int nums[] = {12,345,2,6,7896};
        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        // countEven stores our output result
        int countEven = 0;

        // loop through every number in the array
        for (int val : nums) {
            // in each iteration, we check the number of digits of 1 number
            // countDigits to store number of digits in number x at index i
            int countDigits = 0;

            // How to count digits?
            // 1000/10 = 100 (1 digit)
            // => 100/10 = 10 (2 digits)
            // => 10/10 = 1  (3 digits)
            // => 1/10 = 0 (4 digits)
            // ===> 1000 has 4 digits

            // loop until val / 10 = 0
            while (val != 0) {
                val = val / 10;
                ++countDigits;
                // increase then assign, no copies, less expensive
                // although insignificant,
                // we maybe better than 90% of submissions on leetcode

            }

            // then check if the countDigits of the current number is even
            // if yes
            // increase countEven by one to record the occurrences of numbers with even digits
            if (countDigits % 2 == 0) countEven++; // assign then increase, return a copy
        }
        return countEven;
    }


    // Digit count of N = upper bound of log10(N).
    public static int findNumbers2(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int digits = (int) Math.floor(Math.log10(num) + 1);
            if (digits % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}