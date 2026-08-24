package org.practice.stringmanu;

import java.util.*;


public class SolutionStrings {

    private int gcd(int num1 , int num2){
        if(num2 == 0)
            return num1;
        return gcd(num2,num1%num2);
    }

    public String gcdOfStrings(String str1,String str2){
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }

        int num1 = str1.length();
        int num2 = str2.length();
        int gcd = gcd(num1,num2);

        return str1.substring(0,gcd);

    }

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> answers = new HashMap();


        for(int i=0; i<strs.length;i++){
            String actual = strs[i];
            char[] actualch = actual.toCharArray();
            Arrays.sort(actualch);
            String newactual = String.valueOf(actualch);
            if(!answers.containsKey(newactual))
                answers.put(newactual,new ArrayList());

            answers.get(newactual).add(strs[i]);
        }

        System.out.println(answers.toString());


        return new ArrayList(answers.values());
    }

    public void printString() {
        List<String> as = List.of("1","2","3");

        int i = Arrays.compare(new int[]{1, 2},new int[]{3});




    }


//    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//    An input string is valid if:
//
//    Open brackets must be closed by the same type of brackets.
//    Open brackets must be closed in the correct order.
//    Every close bracket has a corresponding open bracket of the same type.
    public boolean isValidNested(String s){

        if(s.length() % 2 != 0)
            return false;

        Stack<Character> stk = new Stack<>();
        int ss=0;
        for(char c: s.toCharArray()){
            if(c == '(')
                stk.push(')');
            else if ( c == '[')
                stk.push(']');
            else if(c == '{')
                stk.push('}');
            else if(stk.isEmpty() || stk.pop() != c) {
                    return false;
            }
        }


            //all brackets matched correctly
            return stk.isEmpty();


    }

//    Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.
//
//
//
//    Example 1:
//
//    Input: s = "(()"
//    Output: 2
//    Explanation: The longest valid parentheses substring is "()".
//    Example 2:
//
//    Input: s = ")()())"
//    Output: 4
//    Explanation: The longest valid parentheses substring is "()()".
//    Example 3:
//
//    Input: s = ""
//    Output: 0
public int longestValidParentheses (String s){



    Stack<Character> stk = new Stack<>();
    int ss=0;
    char pop;
    for(char c: s.toCharArray()){
        if(c == '(')
            stk.push(')');
        else if ( c == '[')
            stk.push(']');
        else if(c == '{')
            stk.push('}');
        else if(stk.isEmpty() || ((pop = stk.pop()) != c)) {
            continue;
        } else if ( pop == c){
            ss++;
        }
    }



    return ss*2;


}


    public static void main(String args[]){
        SolutionStrings ss = new SolutionStrings();
//        System.out.println(ss.gcdOfStrings("ABCABCABC","ABC"));
//        System.out.println(ss.gcdOfStrings("LEET","CODE"));
//        ss.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});

//        System.out.println(ss.isValidNested("(()()"));
        System.out.println(ss.longestValidParentheses(")()())"));
    }

}
