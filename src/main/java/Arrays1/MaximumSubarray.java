package Arrays1;

public class MaximumSubarray {

    public static int maxSubArrayBrute(int[] nums) {
        int max = 0;
        int n = nums.length;

        for (int i = 0;i<n;i++){
            int sum = 0;
            for (int j = i;j<n;j++){
                sum += nums[j];

                max = Math.max(sum,max);
            }
        }

        return max;
    }

    public static int maxSubArrayOptima(int[] nums) {

        int n = nums.length;
        long max = 0;
        long sum = 0;

        for (int i =0;i<n;i++){
            sum+= nums[i];

            if (sum > max){
                max = sum;
            }

            if (sum < 0 ) sum = 0;
        }

        // To consider the sum of the empty subarray
        // uncomment the following check:

        //if (maxi < 0) maxi = 0;

        return (int) max;
    }

    public static void maxSubArrayOptimaPrint(int[] nums) {

        int n = nums.length;
        long max = 0;
        long sum = 0;



        int startIndex = 0;

        int ansIndex = -1,endIndex = -1;

        for (int i =0;i<n;i++){

            if (sum == 0) startIndex = i;

            sum+= nums[i];

            if (sum > max){
                ansIndex = startIndex;
                max = sum;
                endIndex = i;
            }

            if (sum < 0 ) sum = 0;
        }

        //printing the subarray:
        System.out.print("The subarray is: [");
        for (int i = ansIndex; i <= endIndex; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print("]n");
    }


    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        int maxSum = maxSubArrayBrute(arr);
        System.out.println("The maximum subarray sum is: " + maxSum);
        System.out.println(maxSubArrayOptima(arr));

        maxSubArrayOptimaPrint(arr);
    }
}
