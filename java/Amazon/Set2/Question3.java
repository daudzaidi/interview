package Amazon.Set2;

/**
 * Created by shalvi on 30/06/16.
 */
public class Question3 {

    static int top = -1;
    static int arr[];
    static int size;

    public Question3(int size){
        this.size = size;
        arr = new int[size];
    }

    public void push(int data){
        if(top!=size-1){
            arr[++top] = data;
            System.out.println("Element Pushed : "+data);
            return;
        }
        System.out.println("Stack Overflow");
    }

    public Integer pop(){
        if(top == -1){
            System.out.println("Stack Underflow");
            return null;
        }
        System.out.println("Element Popped : "+arr[top]);
        return arr[top--];
    }

    public static void main(String... args){
        Question3 stack = new Question3(5);
        stack.pop();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}
