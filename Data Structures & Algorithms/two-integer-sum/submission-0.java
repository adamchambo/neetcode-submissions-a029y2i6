class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i]; 

            if (hashMap.containsKey(need)) {
                return new int[] {hashMap.get(need), i};
            }

            hashMap.put(nums[i], i);
        }
        return new int[]{};
    }
}
