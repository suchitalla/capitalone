package org.practice.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class LargestNum {
    public String largestNumber(int[] nums) {
        String result = Arrays.stream(nums)
                .boxed()
                .sorted(java.util.Comparator.reverseOrder()) // Sorts Integers descending
                .map(Object::toString)
                .collect(Collectors.joining(""));

        return result;




    }

    public static void main(String args[]){
        LargestNum ln = new LargestNum();
        System.out.println(ln.largestNumber(new int[]{1,34,45,6}));

    }
}
