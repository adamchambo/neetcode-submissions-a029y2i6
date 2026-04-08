class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int l = nums.length - 1; 
        while (s <= l) {
            int m = s + (l - s) / 2; 
            if (nums[m] == target) return m;
            if (nums[m] < target) s = m+1; 
            if (nums[m] > target) l = m-1;
        }
        return -1;
    }
}
