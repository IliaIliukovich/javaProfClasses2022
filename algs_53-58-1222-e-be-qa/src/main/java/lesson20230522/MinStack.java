package lesson20230522;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();

    public void push(int element) {
        stack.push(element);
        if (stackMin.empty()){
            stackMin.push(element);
        } else {
            stackMin.push(Math.min(stackMin.peek(), element));
        }
    }

    public int pop(){
        stackMin.pop();
        return stack.pop();
    }

    public int getMin(){
        return stackMin.peek();
    }


    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(10);
        System.out.println(minStack.getMin());
        minStack.push(5);
        System.out.println(minStack.getMin());
        minStack.push(3);
        System.out.println(minStack.getMin());
        minStack.push(8);
        System.out.println(minStack.getMin());
        minStack.push(11);
        System.out.println(minStack.getMin());
        minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }





}
