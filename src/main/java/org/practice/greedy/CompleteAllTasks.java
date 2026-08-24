package org.practice.greedy;

import java.util.HashMap;

//Minimum Rounds to Complete All Tasks
//Leet-2244
public class CompleteAllTasks {

    public static int compTasks(int[] tasks){
        HashMap<Integer,Integer> hm = new HashMap();
        for(int task:tasks){
            hm.put(task,hm.getOrDefault(task,0)+1);
        }

        int totalRounds =0;
        for(int count:hm.values()){
            if(count == 1)
                return -1;

            totalRounds +=(count+2)/3;
        }

        return totalRounds;
    }

    public static void main(String[] args) {

        System.out.println( CompleteAllTasks.compTasks(new int[]{3,3,4,4,4,4,5,5,5,5}));
    }
}
