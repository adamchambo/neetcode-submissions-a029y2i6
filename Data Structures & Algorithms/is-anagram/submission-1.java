class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>(); 

        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        if (sMap.size() != tMap.size()) return false; 
        
        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();

            if (tMap.get(key) == null || tMap.get(key) != value) return false;
        }
        return true;
    }
}
