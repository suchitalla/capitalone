package org.practice.str;



public class Palin {
    public static void main(String args[]){

        System.out.println(isPalindrome("babab"));
        System.out.println(longestPalindrome("babab"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));


    }

    public static boolean isPalindrome(String abs){
        int right = abs.length() -1 ;
        for(int left=0;left<abs.length()/2;left++){
            if(abs.charAt(left) != abs.charAt(right)){
                return false;
            }
            right--;
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        String longestPal = "";

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindromes (e.g., "aba")
            String pal1 = expandAroundCenter(s, i, i);
            // Even length palindromes (e.g., "abba")
            String pal2 = expandAroundCenter(s, i, i + 1);

            if (pal1.length() > longestPal.length()) {
                longestPal = pal1;
            }
            if (pal2.length() > longestPal.length()) {
                longestPal = pal2;
            }
        }
        return longestPal;
    }

    private static String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
