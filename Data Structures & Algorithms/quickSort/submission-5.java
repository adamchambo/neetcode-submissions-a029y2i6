// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }

// choose right pivot
class Solution {

    public List<Pair> quickSort(List<Pair> pairs) {
        if (pairs.size() <= 1 || pairs == null) return pairs; 
        quickSort(pairs, 0, pairs.size() - 1);
        return pairs;
    }

    private void quickSort(List<Pair> pairs, int lo, int hi) {
        if (lo >= hi) return;
        int pi = partition(pairs, lo, hi); 
        quickSort(pairs, lo, pi-1);
        quickSort(pairs, pi+1,  hi); 
    }

    private int partition(List<Pair> pairs, int lo, int hi) {
        int pi = hi;
        Pair pivot = pairs.get(pi); 
        int insert = lo;
        for (int i = lo; i <= pi; i++) {
            if (pairs.get(i).key < pivot.key) {
                swap(pairs, i, insert);
                insert++;
            }
        }
        swap(pairs, pi, insert); 
        return insert; 
    }

    private void swap(List<Pair> pairs, int a, int b) {
        Pair temp = pairs.get(a);
        pairs.set(a, pairs.get(b));
        pairs.set(b, temp);
    }

}

// median of 3 
// class Solution {

//     public List<Pair> quickSort(List<Pair> pairs) {
//         if (pairs.size() <= 1 || pairs == null) return pairs; 
//         quickSort(pairs, 0, pairs.size() - 1);
//         return pairs;
//     }

//     private void quickSort(List<Pair> pairs, int lo, int hi) {
//         if (lo > hi) return;
//         int pi = partition(pairs, lo, hi); 
//         quickSort(pairs, lo, pi-1);
//         quickSort(pairs, pi+1,  hi); 
//     }

//     private int partition(List<Pair> pairs, int lo, int hi) {
//         int mid = hi / 2;
//         int pi = getMedianOfThree(pairs, lo, mid, hi);
//         swap(pairs, pi, hi);
//         pi = hi; 
//         Pair pivot = pairs.get(pi); 
//         int insert = lo;
//         for (int i = lo; i <= hi; i++) {
//             if (pairs.get(i).key < pivot.key) {
//                 swap(pairs, i, insert);
//                 insert++;
//             }
//         }
//         swap(pairs, pi, insert); 
//         return insert; 
//     }

//     private void swap(List<Pair> pairs, int a, int b) {
//         Pair temp = pairs.get(a);
//         pairs.set(a, pairs.get(b));
//         pairs.set(b, temp);
//     }

//     private int getMedianOfThree(List<Pair> pairs, int si, int mi, int ei) {
//         int s = pairs.get(si).key, m = pairs.get(mi).key, e = pairs.get(ei).key;
//         if ((s > m && s < e) || (s < m && s > e)) return si;
//         if ((m > s && m < e) || (m < s && m > e)) return mi;
//         return ei; 
//     }
// }


