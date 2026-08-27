class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int n = s.length();

        // Store positions of all 1s
        int[] ones = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ones[count++] = i;
            }
        }

        // Not enough 1s
        if (count < k) {
            return "";
        }

        String answer = "";

        int minLength = Integer.MAX_VALUE;

        // Consider every group of k consecutive 1s
        for (int i = 0; i + k - 1 < count; i++) {

            int start = ones[i];
            int end = ones[i + k - 1];

            int length = end - start + 1;

            // Found a shorter substring
            if (length < minLength) {
                minLength = length;
                answer = s.substring(start, end + 1);
            }

            // Same length -> choose lexicographically smaller
            else if (length == minLength) {

                String candidate = s.substring(start, end + 1);

                if (candidate.compareTo(answer) < 0) {
                    answer = candidate;
                }
            }
        }

        return answer;
    }
}