/**
 * @author ${USER}
 * @Description TODO
 * @date ${DATE}-${TIME}
 */
public class Main {
        public static boolean canJump(int[] nums) {
            int n = nums.length;
            boolean[] dp = new boolean[n];

            dp[n-1] = true;
            for(int i=n-2;i>=0;i--) {
                if (nums[i] != 0) {
                    for (int diff = 1; diff <= nums[i] && (i + diff) < n; diff++) {
                        dp[i] = dp[i + diff];
                        if (dp[i] == true) break;
                    }
                }
            }

            return dp[0];
        }
    public static void main(String[] args) {
        int[] arr = {3,2,1,0,4};
        System.out.println(canJump(arr));
    }
}