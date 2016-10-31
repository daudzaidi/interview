package DocPractice;

import java.util.Arrays;

/**
 * Created by shalvi on 31/05/16.
 */
public class StackImpl{
    public int[] stack;

    public int stackSize;

    public int[] stackMin;

    int top = 0;

    public StackImpl(int n){
        this.stack = new int[n];
        this.stackSize = n;
        this.stackMin = new int[n];
    }

    public void push (int x){
        if(this.top > this.stackSize){
            System.out.println("Stack Overflow");
            return ;
        }
        System.out.println("Element pushed --> "+ x);
        stack[this.top++] = x;
        if(this.top ==1){
            stackMin[top -1] = x;
        }
        else{
            int min = min(x,stackMin[this.top - 2]);
            stackMin[top -1] = min;
        }

    }

    public Integer pop (){
        if(this.top < 0){
            System.out.println("Stack Underflow");
            return null;
        }

        System.out.println("Element popped --> "+ stack[this.top-1]);
        return stack[--this.top];
    }

    public int getMin(){
        System.out.println("Min element --> "+ stackMin[this.top-1]);
        return stackMin[this.top-1];
    }

    public int min(int a, int b){
        return a > b ? b : a;
    }

    public static void main(String... args){
        StackImpl stack = new StackImpl(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(-1);
        stack.getMin();
        stack.pop();
        stack.getMin();


    }
}
