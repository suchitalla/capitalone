package org.practice.intmanu;

import java.util.HashMap;
//Leet - 13
public class RomanToInteger {


    public static int rtoi(String rom){

        HashMap<Character,Integer> roman = new HashMap<>();
        roman.put('I',1);
        roman.put('V',5);
        roman.put('X',10);
        roman.put('L',50);
        roman.put('C',100);
        roman.put('D',500);
        roman.put('M',1000);

        char[] romanchar = rom.toCharArray();
        int i=0;int j=1;
        int result =0;
        for(i=0,j=1; j< romanchar.length;i++,j++){
            if(roman.get(romanchar[i]) >= roman.get(romanchar[j])){
                result += roman.get(romanchar[i]);
            } else{
                result -= roman.get(romanchar[i]);
            }
        }
        result += roman.get(romanchar[i]);
        return result;
    }

    public static void main(String args[]){
        System.out.println(rtoi("III"));
    }
}
