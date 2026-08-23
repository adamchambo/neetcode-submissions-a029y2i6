// Definition for a pair
// public class Pair {
//     public int Key;
//     public string Value;
//
//     public Pair(int key, string value) {
//         Key = key;
//         Value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> InsertionSort(List<Pair> pairs) {
        var history = new List<List<Pair>>();
        var list = pairs;
        if (list.Count > 0) history.Add(new List<Pair>(list));
        for (int i = 1; i < pairs.Count; i++) {
            int j = i - 1;
            while (j >= 0 && list[j+1].Key < list[j].Key) {
                Pair temp = list[j+1];
                list[j+1] = list[j];
                list[j] = temp;
                j--;
            }
            history.Add(new List<Pair>(list));
        }
        return history;
    }
}
