package org.practice.stack;

import java.util.ArrayDeque;
import java.util.Deque;

//Leet - 150
public class EvaluateReversePN {
    public int evalRPN(String[] tokens) {

        Deque<Integer> stk = new ArrayDeque<Integer>();

        for(String s : tokens){

            if(isOperand(s)){
                int b = stk.pop();
                int a = stk.pop();

                switch(s){
                    case "+": stk.push(a+b);break;
                    case "-": stk.push(a-b);break;
                    case "*": stk.push(a*b);break;
                    case "/": stk.push(a/b);break;

                }


            }else{
                stk.push(Integer.parseInt(s));
            }




        }


        return stk.pop();
    }

    boolean isOperand(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public static void main(String args[]){
        EvaluateReversePN erpn = new EvaluateReversePN();
        System.out.println(erpn.evalRPN(new String[]{"4","13","5","/","+"}));

    }
}
