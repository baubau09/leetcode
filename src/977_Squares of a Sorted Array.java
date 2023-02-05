class SquaresOfASortedArray{
    public static void main(String []argh){
        int nums[] = {-4,-1,0,3,10};
        int res[] = sortedSquares(nums);

        for (int val : res) {
            System.out.printf("%d ", val);
        }

    }

    public static void squareNums(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.pow(nums[i], 2);
        }
    }

    // approach 1:
    // square then merge sort for N+NlogN time and N space
    // however there are other approachs I will try after this
    static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using merge
    // merge()
    static void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }



    // approach 2:
    // O(N) time, O(N) Space
    // two pointers
    // [-3, -2, -1 ,2 ,4, 5, 6]
    // the largest number after square will either be on the far left or far right
    // so we can iterate reversely
    // and compare the absolute values of the two ends of the original array
    // for example |-3| and |6| => |6| is larger
    // => send 6 the end of the resulting array
    // then |-3| and |5| => |5| is larger
    // then -3 and 4, and so on
    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int[] res = new int[nums.length];

        for (int i = nums.length - 1; i >= 0 ; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[i] = nums[left] * nums[left];
                left++;
            } else {
                res[i] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }
}
