class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0,4,4,0,4,4,4,0,2};

        int val = 4;

        System.out.println(removeElement(nums,val));

    }

    // approach 1: straighforward
    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    //approach 2: two pointers
    public static int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
