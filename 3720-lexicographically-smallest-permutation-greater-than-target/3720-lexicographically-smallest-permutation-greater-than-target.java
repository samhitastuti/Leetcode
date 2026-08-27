class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] ans = new char[n];

        // Match target as much as possible
        int i = 0;

        while (i < n) {
            int t = target.charAt(i) - 'a';

            if (freq[t] == 0) {
                break;
            }

            ans[i] = target.charAt(i);
            freq[t]--;
            i++;
        }

        // Case 1:
        // We couldn't match target at position i.
        // Try making this position larger.
        if (i < n) {

            int t = target.charAt(i) - 'a';

            for (int c = t + 1; c < 26; c++) {

                if (freq[c] > 0) {

                    ans[i] = (char) ('a' + c);
                    freq[c]--;

                    fillRemaining(ans, i + 1, freq);

                    return new String(ans);
                }
            }
        }

        // Case 2:
        // We either matched everything or couldn't make
        // the current position larger.
        //
        // Backtrack through the matched prefix.
        for (int j = i - 1; j >= 0; j--) {

            // Put the character at j back
            int current = ans[j] - 'a';
            freq[current]++;

            int t = target.charAt(j) - 'a';

            // Find smallest available character > target[j]
            for (int c = t + 1; c < 26; c++) {

                if (freq[c] > 0) {

                    ans[j] = (char) ('a' + c);
                    freq[c]--;

                    fillRemaining(ans, j + 1, freq);

                    return new String(ans);
                }
            }
        }

        return "";
    }

    private void fillRemaining(char[] ans, int start, int[] freq) {

        int pos = start;

        for (int c = 0; c < 26; c++) {

            while (freq[c] > 0) {
                ans[pos++] = (char) ('a' + c);
                freq[c]--;
            }
        }
    }
}