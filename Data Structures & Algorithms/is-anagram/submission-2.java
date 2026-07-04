class Solution {
    public boolean isAnagram(String s, String t) {
        AtomicBoolean anagram = new AtomicBoolean(true);

    // Approach: Count each time a character appears on both maps.
    // If all the characters are even, then this is an anagram, else, not
    HashMap<Character, Integer> firstCharCounter = new HashMap<>();
    for (char c : s.toCharArray()) {
        if (firstCharCounter.containsKey(c)) {
            firstCharCounter.compute(c, (k, charCount) -> charCount + 1);
        } else {
            firstCharCounter.put(c, 1);
        }
    }

    HashMap<Character, Integer> secondCharCounter = new HashMap<>();
    for (char c : t.toCharArray()) {
        if (secondCharCounter.containsKey(c)) {
            secondCharCounter.compute(c, (k, charCount) -> charCount + 1);
        } else {
            secondCharCounter.put(c, 1);
        }
    }

    Set<Character> allChars = s.concat(t).chars()
            .mapToObj(c -> (char)c).collect(Collectors.toSet());

    allChars.forEach((c) -> {
        if (firstCharCounter.containsKey(c) && secondCharCounter.containsKey(c)) {
            if (!firstCharCounter.get(c).equals(secondCharCounter.get(c))) {
                anagram.set(false);
            }
        } else {
            anagram.set(false);
        }
    });

    return anagram.get();
    }
}
