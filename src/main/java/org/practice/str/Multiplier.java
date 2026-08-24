package org.practice.str;

public class Multiplier {
    public String multiply(String num1, String num2) {
        // Handle edge case for zero early
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];
        
        // Multiplicand loop (right to left)
        for (int i = m - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0';
            
            // Multiplier loop (right to left)
            for (int j = n - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';
                
                int mul = d1 * d2;
                
                // Position indices in the result array
                int p1 = i + j;
                int p2 = i + j + 1;
                
                // Add current multiplication result to the existing value at p2
                int sum = mul + pos[p2];
                
                // Store the carry at p1 and the remainder unit at p2
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        
        // Convert the integer array back to a String
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            // Skip leading zeros if we haven't added any digits yet
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        
        return sb.toString();
    }

    public static void main(String args[]){
        Multiplier mtl = new Multiplier();
       System.out.println( mtl.multiply("123","456"));
    }
}