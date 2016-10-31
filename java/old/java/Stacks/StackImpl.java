package old.java.Stacks;

/**
 * Created by pandita on 8/10/2015.
 */
public class StackImpl<T> {

    private int stackSize;
    private T [] stackArr;
    private int top;

    public StackImpl(int size){
        this.stackSize=size;
        this.stackArr=(T[])new Object [stackSize];
        int top =-1;
    }

    public boolean isStackFull(){
        return (top==stackSize-1);
    }

    public boolean isStackEmpty(){
        return (top==-1 || top==0);
    }
    public void push(T value){
        if(isStackFull()){
            System.out.println("Stacks Full.. Increasing Stacks Capacity");
            increaseStackCapacity();
        }
        System.out.println("Adding: " + value);
        this.stackArr[++top]=value;
    }

    public T pop(){
        if(isStackEmpty()){
            System.out.println("Underflow... cannot remove element");
            return null;
        }
        T value = this.stackArr[top--];
        System.out.println("Removed: "+value);
        return value;
    }

    public T peek(){
        return this.stackArr[top];
    }

    private void increaseStackCapacity(){
        T[] newStack = (T[]) new Object[this.stackSize*2];
        for(int i=0;i<stackSize;i++){
            newStack[i] = this.stackArr[i];
        }
        this.stackArr = newStack;
        this.stackSize = this.stackSize*2;
    }
    public static void main(String a[]){
        StackImpl<String> stringStack = new StackImpl<String>(2);
        stringStack.push("java2novice");
        StackImpl<Integer> integerStack = new StackImpl<Integer>(2);
        integerStack.push(23);
    }

}
