package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by shyamsunderpandita on 06/01/17.
 */
public class NearestSmallerElement {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {

        ArrayList<Integer> result = new ArrayList<Integer>();


        Stack<Integer> stack1 = new Stack<>();

        for(int i = 0 ; i < arr.size() ; i++){
            stack1.push(arr.get(i));
        }
        Stack<Integer> stack2 = new Stack<>();

        while(stack1.size() > 1){
            boolean isAdded = false;
            int num = stack1.pop();
            while(!stack1.isEmpty()){
                int pop = stack1.pop();
                stack2.push(pop);
                if(num > pop){
                    result.add(pop);
                    isAdded = true;
                    break;
                }
            }


            if(!isAdded && stack1.isEmpty() && stack2.size() > 0){
                result.add(-1);
            }

            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }



        }

        result.add(-1);
        Collections.reverse(result);
        return result;
    }

    public ArrayList<Integer> prevSmallerEfficient (ArrayList<Integer> arr) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<>();
        int size = arr.size();
        for(int i = 0 ; i < size ; i++){
            while(!stack.isEmpty() && stack.peek() >= arr.get(i)){
                stack.pop();
            }

            if(stack.isEmpty()){
                result.add(-1);
            }
            else{
                result.add(stack.peek());
            }

            stack.push(arr.get(i));
        }
        return result;
    }

    public static void main(String... args){
        NearestSmallerElement n = new NearestSmallerElement();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(5);
        arr.add(2);
        arr.add(10);
       // System.out.println(n.prevSmallerEfficient(arr));

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(3);
        arr2.add(2);
        arr2.add(1);

        //System.out.println(n.prevSmallerEfficient(arr2));

        ArrayList<Integer> a3 = new ArrayList<>();

        int[] arr3 = new int[]{34, 35, 27, 42, 5, 28, 39, 20, 28};
        for(int i = 0 ; i < arr3.length ; i++){
            a3.add(arr3[i]);
        }

        System.out.println(n.prevSmallerEfficient(a3));
    }
}
