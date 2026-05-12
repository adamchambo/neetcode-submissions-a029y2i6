class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        dfs(image, sr, sc, original, color);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int original, int color) {
        if (sr < 0 || sr >= image.length ||
            sc < 0 || sc >= image[0].length) {
            return;
        }
        if (original == color) return;
        if (image[sr][sc] != original) return;

        image[sr][sc] = color;

        dfs(image, sr+1, sc, original, color);
        dfs(image, sr-1, sc, original, color);
        dfs(image, sr, sc+1, original, color);
        dfs(image, sr, sc-1, original, color);
    }
}