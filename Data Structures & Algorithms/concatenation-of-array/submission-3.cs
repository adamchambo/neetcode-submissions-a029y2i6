public class Solution {
    public int[] GetConcatenation(int[] nums) {
        int l = nums.Length;
        int[] ans = new int[l * 2];
        for (int i = 0; i < l; i++) {
            ans[i] = nums[i];
            ans[i + l] = nums[i];
        }
        return ans;
    }
}