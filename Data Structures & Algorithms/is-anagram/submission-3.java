class Solution {
    public boolean isAnagram(String s, String t) {
        boolean result = true;

        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> firstCharCounter = new HashMap<>();
        HashMap<Character, Integer> secondCharCounter = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (firstCharCounter.containsKey(c)) {
                firstCharCounter.compute(c, (k, count) -> count + 1);
                continue;
            }

            firstCharCounter.put(c, 1);
        }

        for (char c : t.toCharArray()) {
            if (secondCharCounter.containsKey(c)) {
                secondCharCounter.compute(c, (k, count) -> count + 1);
                continue;
            }

            secondCharCounter.put(c, 1);
        }

        System.out.println(firstCharCounter);
        System.out.println(secondCharCounter);
        for (char c : s.toCharArray()) {
            if (secondCharCounter.get(c) == null || !Objects.equals(firstCharCounter.get(c), secondCharCounter.get(c))) {
                result = false;
            }
        }

        return result;
    }
}
