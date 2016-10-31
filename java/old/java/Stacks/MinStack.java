package old.java.Stacks;

/**
 * Created by pandita on 8/18/2015.
 */
public class MinStack{

    private int topS;
    private int topMS;
    private int stackSSize;
    private int stackMSize;
    private Integer[] stackSArr;
    private Integer[] stackMArr;

    public MinStack(int size){
        topMS=-1;
        topS=-1;
        this.stackMSize=size;
        this.stackSSize=size;
        stackSArr = new Integer[stackSSize];
        stackMArr = new Integer[stackMSize];
    }

    public boolean isStackFull(){
        return (topS==stackSSize-1);
    }

    public boolean isStackEmpty(){
        return (topS==-1);
    }

    public void push(int value){
        if(isStackFull()){
            increaseStackCapacity();
        }

        if(topMS==-1){
            stackMArr[++topMS]=value;
        }
        else if(stackMArr[topMS]>value){
            stackMArr[++topMS]=value;
        }
        else{
            stackMArr[++topMS]=stackMArr[topMS-1];
        }

        stackSArr[++topS]=value;
    }

    public Integer pop(){
        if(isStackEmpty()){
            System.out.println("Empty Stack ...");
            return null;
        }

        topMS--;
        return stackSArr[topS--];
    }

    public Integer getMin(){
        return stackMArr[topMS];
    }

    private void increaseStackCapacity(){
        Integer[] arr = new Integer[stackSSize*2];
        for(int i =0;i<stackSSize;i++){
            arr[i] = stackSArr[i];
        }
        stackSArr=arr;
        stackSSize=stackSSize*2;

        Integer[] arrM = new Integer[stackMSize*2];
        for(int i =0;i<stackMSize;i++){
            arrM[i] = stackMArr[i];
        }
        stackMArr=arrM;
        stackMSize*=stackMSize*2;
    }

    public static void main(String args[]){

        MinStack stack = new MinStack(5);
        stack.push(5);
        stack.push(0);
        stack.push(1);
        stack.push(6);
        stack.push(9);
        stack.push(10);
        System.out.println("Minimum Value in O(1) Time : "+ stack.getMin());
    }
}
