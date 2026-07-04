class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> duplicateChecker = new HashSet<>();
        for (int num : nums) {
            if (duplicateChecker.contains(num)) return true;

            duplicateChecker.add(num);
        }
        return false;
    }
}