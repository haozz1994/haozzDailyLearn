package com.haozz.dailylearn.dailylearn201912.dailylearn_20191214;

import java.util.Stack;

/**
 * @author
 * @date 2019/12/14 14:21
 **/
public class StackDemo {

    static void showpush(Stack<Integer> stack, int a){
        stack.push(a);
        System.out.println("push("+stack+")");
        System.out.println("stack:"+stack);
    }

    static void showpop(Stack<Integer> st) {
        System.out.print("pop -> ");
        Integer a = (Integer) st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
//        System.out.println("stack:"+stack);
//
//
        showpush(stack,42);
        showpush(stack,56);
        showpush(stack,99);
        showpush(stack,111);
        showpop(stack);


    }



}
