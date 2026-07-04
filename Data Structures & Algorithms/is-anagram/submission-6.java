class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> charCounter = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCounter.put(c, charCounter.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!charCounter.containsKey(c) || charCounter.get(c) == 0) return false;

            charCounter.put(c, charCounter.get(c) - 1);
        }

        return true;
    }
}
