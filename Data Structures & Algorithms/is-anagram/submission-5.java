class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> charCounter = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (charCounter.containsKey(c)) {
                charCounter.compute(c, (k, count) -> count + 1);
                continue;
            }

            charCounter.put(c, 1);
        }

        for (char c : t.toCharArray()) {
            if (!charCounter.containsKey(c)) return false;

            charCounter.compute(c, (k, count) -> count - 1);
        }

        for (int count : charCounter.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
