class Solution {
    public void sortColors(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num); 
            max = Math.max(max, num);
        } 
        int[] bucket = new int[(max-min)+1];

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i] - min; 
            bucket[n]++; 
        }

        int k = 0; 
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                nums[k++] = i + min; 
            }
        }
    }
}