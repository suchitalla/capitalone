package org.practice.intmanu;

import java.util.*;

public class WinnerLosser {
    public static void main(String args[]){
        System.out.println(winnerLosser(new int[][]{{1,2},{2,3},{3,4},{4,5},{5,6}}));
    }
    public static List<List<Integer>> winnerLosser(int[][] matchs){
     //first winner, second losser
        HashMap<Integer,Integer> losser = new HashMap<>();
        HashSet<Integer> winner = new HashSet<>();
        for(int[] match: matchs){
            losser.put(match[1],losser.getOrDefault(match[1],0)+1);
        }
        for(int[] match: matchs){
            if(!losser.containsKey(match[0]))
                winner.add(match[0]);
        }

        List<Integer> wins = new ArrayList<>(winner);
        List<Integer> loss = new ArrayList<>();
        for(int losss:losser.keySet()){
            if(losser.get(losss) == 1)
                loss.add(losss);
        }
        Collections.sort(wins);
        Collections.sort(loss);
        List<List<Integer>> x = new ArrayList<>();
        x.add(wins);
        x.add(loss);
        return x;
    }

}
