class TwoSums {

    public static void main(String[] args) {
        int target = 6;
        int arr[] = {2,7,11,15};
        int arr2[] = {3,2,4};
        int arr3[] = {3,3};
        int arr4[] = {9,7,11,1,15,5};


        int res[] = twoSum(arr4, target);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }

    // Straightforward approach
    // O(N^2) time, O(1) space
    public static int[] twoSum(int[] nums, int target) {
        int arr[] = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            int x = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == x) {
                    arr[0] = i;
                    arr[1] = j;
                    break;
                }
            }

        }
        return arr;
    }

    // 2nd attempt: optimize - hash table
    // O(N) time, O(N) space
}
