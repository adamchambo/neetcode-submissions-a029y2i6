class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
            if (i >= k) maxHeap.poll();
        }

        if (maxHeap.size() == 0) return -1;
        return maxHeap.poll();
    }
}
