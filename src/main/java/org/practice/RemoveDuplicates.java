package org.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveDuplicates {


        public List<Integer> removeDuplicates(int[] nums) {

            List<Double> lin = List.of(1d,2d,3d);
            lin.forEach(System.out::println);
            int[] nums1 = {1,2,3};
            Stream<Integer> sim = Arrays.stream(nums1).boxed();
            Stream<Double>  dim = lin.stream();

            Stream<String> asd = Stream.of("ss","dd","pp");

            Stream<String> asd2 = Stream.of("ss","dd","pp");

            return Arrays.stream(nums).boxed().distinct().sorted().toList();

        }

        public static void main(String args[]){
            RemoveDuplicates s = new RemoveDuplicates();
            List<Integer> sor = s.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
//            sor.forEach(System.out::println);
        }

}
