class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        
        for (int mult = k; ; mult += k) {
            if (!set.contains(mult)) {
                return mult;
            }
        }
    }
}