package org.practice.arraysum;

public class ReverseArrays{
    public int[] reversearrays(int[] inps){
        int x = 0;
        int y= inps.length;
        while(x<y){
                int temp = inps[x];
                inps[x] = inps[y-1];
                inps[y-1] = temp;
                x++;
                y--;
        }

        return inps;
    }

    public static void main(String args){

        ReverseArrays ra = new ReverseArrays();
//        ra.reversearrays(new int[]{1,2,3,4,5});
        System.out.println(ra.reversearrays(new int[]{1,2,3,4,5}));
    }

}
