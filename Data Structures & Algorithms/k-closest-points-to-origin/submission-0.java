class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || k == 0) return new int[0][0];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> 
            (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));

        int[][] result = new int[k][2];

        for (int[] point : points) {
            minHeap.offer(point);
        }

        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
