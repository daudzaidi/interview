package DocPractice;

/**
 * Created by shalvi on 31/05/16.
 */
public class DivideArrayStack {

    public int[] array ;

    public int[] top = new int[3];

    public int arraySize;

    public int stackSize;

    public DivideArrayStack(int n){
        this.array = new int[n];
        this.stackSize = divideArrayToStack(this.array);
        this.arraySize = n;
    }

    public Integer divideArrayToStack(int[] arr){
        if(arr == null) return null;
        int len = arr.length;
        if(len <=2) return null; // can't divide the array in three parts

        top[0] = arr[0];
        top[1] = arr[len/3];
        top[2] = arr[(2*len)/3];
        return len/3;
    }

    public void push(int n,int end){
        int top1 = getTopFromEnd(end);
        if(this.top[top1] >= end-1){
            System.out.println("Stack overflow");
            return;
        } // stack overflow
        System.out.println("Element pushed --> "+ n+ " at the position arr["+top+"]");
        array[this.top[top1]++] = n;
    }

    public Integer pop (int start){
        int top1 = getTopFromStart(start);
        if(this.top[top1] <= start) {// stack underflow
            System.out.println("Stack Underflow");
            return null;
        }

        int pop = this.top[top1];
        System.out.println("Element popped -->"+ pop);
        this.top[top1]--;
        return pop;
    }

    public int getEnd(int top){
        if(top == 0) return arraySize/3;
        if(top == (arraySize/3) +1) return (2*arraySize)/3;
        return arraySize;
    }

    public int getTopFromEnd(int end){
        if(end == arraySize/3) return 0;
        if(end == (2*arraySize)/3) return 1;
        return 2;
    }

    public int getTopFromStart(int start){
        if(start == 0) return 0;
        if(start == (arraySize)/3) return 1;
        return 2;
    }

    public int getStart(int top){
        if(top >= 0 && top < arraySize/3) return 0;
        if(top >= arraySize/3 && top < (2*(arraySize/3) +1)) return arraySize/3;
        return (2*arraySize)/3;
    }

    public static void main(String args[]){
        DivideArrayStack arr = new DivideArrayStack(12);
        arr.push(1,arr.getEnd(0));
        arr.push(2,arr.getEnd(0));
        arr.push(3,arr.getEnd(0));
        arr.push(4,arr.getEnd(0));
        arr.pop(arr.getStart(0));
        arr.pop(arr.getStart(0));
        arr.pop(arr.getStart(0));
        arr.pop(arr.getStart(0));
    }

}
