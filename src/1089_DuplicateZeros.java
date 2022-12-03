class DuplicateZeros {
    public static void main(String[] args) {
        //Input: arr = [1,0,2,3,0,4,5,0]
        //Output: [1,0,0,2,3,0,0,4]
        //Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
        int arr[] = {1,0,2,3,0,4,5,0};
//        int arr[] = {1,0,2,0,3,0,4,5,0,6};
//        int arr[] = {8,4,5,0,0,0,0,7};

        duplicateZeros(arr);


        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // straightforward solutions
    // O(n^2) time, O(1) space (in-place)
    public static void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 2; j >= i+1 ; j--) {
                    arr[j+1] = arr[j];
                }
                arr[i+1] = 0;
                i++;
            }
        }
    }
    //// improvement 1
    // Same complexity, slightly different approach
    // Cleaner and easier to understand
    // In java, empty space in int array will be automatically assigned a 0 value
    public static void duplicateZeros2(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0){
                for (int j = arr.length-1; j > i; j--){
                    arr[j] = arr[j-1];
                }
                i++;
            }
        }
    }
    //// improvement 2
    // O(N) time, O(1) space


}
