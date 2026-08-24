package org.practice.ds;

import java.util.Stack;
//Leet - 232
public class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    MyQueue(){}

    void push(int x){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }
    int pop(){
        return stack1.pop();
    }
    int peek(){
        return stack1.peek();
    }
    boolean isEmpty(){
        return stack1.isEmpty();
    }
}
