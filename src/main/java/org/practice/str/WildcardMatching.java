package org.practice.str;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int sIdx = 0, pIdx = 0;
        int matchIdx = 0;
        int starIdx = -1;            
        
        while (sIdx < s.length()) {
            // Case 1: Characters match, or pattern has '?'
            if (pIdx < p.length() && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
                sIdx++;
                pIdx++;
            } 
            // Case 2: Pattern has '*', record the position and try matching 0 characters first
            else if (pIdx < p.length() && p.charAt(pIdx) == '*') {
                starIdx = pIdx;
                matchIdx = sIdx;
                pIdx++; // Advance pattern pointer past '*'
            } 
            // Case 3: Current characters don't match, but a previous '*' was encountered.
            // Backtrack: assume the '*' matches one more character in string s.
            else if (starIdx != -1) {
                pIdx = starIdx + 1; // Reset pattern pointer to just after the '*'
                matchIdx++;         // Advance the match start in s
                sIdx = matchIdx;    // Reset string pointer to the new match position
            } 
            // Case 4: Characters don't match and no previous '*' to fall back on
            else {
                return false;
            }
        }
        
        // Check for remaining trailing characters in the pattern.
        // They must all be '*' to match the end of the string.
        while (pIdx < p.length() && p.charAt(pIdx) == '*') {
            pIdx++;
        }
        
        // If we successfully consumed the entire pattern, it's a match.
        return pIdx == p.length();
    }

    public static void main(String[] Brass) {
        WildcardMatching wm = new WildcardMatching();
        
        // Test Cases
        System.out.println(wm.isMatch("aa", "a"));   // Output: false
        System.out.println(wm.isMatch("aa", "*"));   // Output: true
        System.out.println(wm.isMatch("cb", "?a"));  // Output: false
        System.out.println(wm.isMatch("adceb", "*a*b")); // Output: true
    }
}