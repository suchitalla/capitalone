package org.practice.intmanu;


public class ReverseInt {
    public static void main(String args[]) {
        System.out.println(reverse(123));
    }

    //2ms
    public static int reverse(int x) {

        try {
            if (x > 0) {
                StringBuilder xstr = new StringBuilder(String.valueOf(x));
                return Integer.parseInt(xstr.reverse().toString());
            } else {
                x = -1 * x;
                StringBuilder xstr = new StringBuilder(String.valueOf(x));
                return -1 * Integer.parseInt(xstr.reverse().toString());
            }
        } catch (Exception e) {

            return 0;
        }


    }

    //1ms
    public static int reverse2(int x) {

        int rev =0;
        while(x != 0){
            int pop = x%10;
            x = x/10;
            //Overflow Integer.MAX_VALUE (2,147,483,647)
            if ( rev > Integer.MAX_VALUE / 10 ||
                            (rev == Integer.MAX_VALUE / 10 && pop > 7)
            ) return 0;
            //Overflow Integer.MIN_VALUE (-2,147,483,648):
            if (
                    rev < Integer.MIN_VALUE / 10 ||
                            (rev == Integer.MIN_VALUE / 10 && pop < -8)
            ) return 0;

            rev = rev*10 + pop;
        }
        return rev;
    }
}

