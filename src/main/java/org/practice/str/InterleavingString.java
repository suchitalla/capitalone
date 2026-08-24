package org.practice.str;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Edge case: If the combined lengths don't match, it's impossible
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int m = s1.length();
        int n = s2.length();
        
        // dp[i][j] will be true if s3[0..i+j-1] is an interleaving of s1[0..i-1] and s2[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // Base case: both s1 and s2 are empty
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                }
                // Case 1: s1 is empty, check if s2 matches s3
                else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                }
                // Case 2: s2 is empty, check if s1 matches s3
                else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                }
                // Case 3: Both s1 and s2 have remaining characters
                else {
                    boolean matchS1 = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                    boolean matchS2 = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                    dp[i][j] = matchS1 || matchS2;
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        InterleavingString solver = new InterleavingString();
        
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        
        System.out.println("Is Interleaved? " + solver.isInterleave(s1, s2, s3)); // Output: true
    }
}