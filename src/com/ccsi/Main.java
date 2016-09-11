package com.ccsi;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	MyQueue myQueue=new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        while(!myQueue.empty()){
            System.out.println(myQueue.peek());
            myQueue.pop();
        }
    }
}
//Implement the following operations of a queue using stacks.
//push(x)--push element x to the back of queue
//pop()--removes the elements from in front of queue.
//peek()--Get the front element;
//empty()--return whether the queue is empty
class MyQueue{
    Stack<Integer> myStack=new Stack<>();   //stack
    Stack<Integer> myQueue=new Stack<>();   //help stack

    public void push(int x){
        myStack.push(x);
    }
    public void pop(){                     //来回倒腾
        while (!myStack.isEmpty()){
            myQueue.push(myStack.pop());
        }
        myQueue.pop();
        while (!myQueue.isEmpty()){
            myStack.push(myQueue.pop());
        }
    }
    public int peek(){                     //来回倒腾
        while (!myStack.isEmpty()){
            myQueue.push(myStack.pop());
        }
        int res=myQueue.peek();
        while(!myQueue.isEmpty()){
            myStack.push(myQueue.pop());
        }
        return res;
    }
    public boolean empty(){
        return myStack.isEmpty();
    }
}

