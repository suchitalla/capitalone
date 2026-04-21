package org.practice;

import java.util.*;
public class Main {
    public List<String> letterCombinations(String digits) {

        HashMap<Integer, List<String>> repo = new HashMap<Integer, List<String>>();
        repo.put(2, List.of("a", "b", "c"));
        repo.put(3, List.of("d", "e", "f"));
        repo.put(4, List.of("g", "h", "i"));
        repo.put(5, List.of("j", "k", "l"));
        repo.put(6, List.of("m", "n", "o"));
        repo.put(7, List.of("p", "q", "r", "s"));
        repo.put(8, List.of("t", "u", "v"));
        repo.put(9, List.of("w", "x", "y", "z"));

        int len = digits.length();
        int[] digichar = Arrays.stream(digits.split("")).mapToInt(Integer::parseInt).toArray();
        switch (len) {
            case 1:
                return repo.get((int) digichar[0]);
            case 2:
                List<String> first = repo.get((int) digichar[0]);
                List<String> sec = repo.get((int) digichar[0]);
                ArrayList<String> third = new ArrayList<>();
                for (String label : first) {
                    for (String label2 : sec) {
                        third.add(label + label2);
                    }
                }
                return third;

        }


        return null;
    }

    public static void main(String args[]) {
        Main s = new Main();
        s.letterCombinations("23").forEach(System.out::println);
    }
}
