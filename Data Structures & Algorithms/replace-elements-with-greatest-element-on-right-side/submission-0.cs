public class Solution {
    public int[] ReplaceElements(int[] arr) {
        int greatest = -1;
        for (int i = arr.Length - 1; i >= 0; i--) {
            int hold = arr[i];
            arr[i] = greatest;
            if (hold > greatest) greatest = hold;
        }
        return arr;
    }
}