// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }

class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        if (pairs == null || pairs.size() <= 1) return pairs; 
        int middle = pairs.size() / 2; 
        List<Pair> left = new ArrayList<Pair>(pairs.subList(0, middle));
        List<Pair> right = new ArrayList<Pair>(pairs.subList(middle, pairs.size())); 
        left = mergeSort(left); 
        right = mergeSort(right); 
        return merge(left, right);
    }

    private List<Pair> merge(List<Pair> left, List<Pair> right) {
        List<Pair> result = new ArrayList<>(); 
        int l = 0;
        int r = 0;
        while(l < left.size() && r < right.size()) {
            if (left.get(l).key <= right.get(r).key) {
                result.add(left.get(l));
                l++;
            } else {
                result.add(right.get(r));
                r++;
            }
        }

        while(l < left.size()) {
            result.add(left.get(l));
            l++;
        }

        while (r < right.size()) {
            result.add(right.get(r));
            r++; 
        }

        return result; 
    }
}
