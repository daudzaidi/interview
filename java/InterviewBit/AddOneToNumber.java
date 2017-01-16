package InterviewBit;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by shyamsunderpandita on 17/11/16.
 */
public class AddOneToNumber {
    public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        if(a == null){
            return null;
        }

        int k = 0 ;
        ArrayList<Integer> number = new ArrayList<Integer>();
        while(k < a.size()-1){
            if(a.get(k)!=0){
                break;
            }
            k++;
        }

        while(k < a.size()){
            number.add(a.get(k));
            k++;
        }

        int div = (number.get(number.size()-1) + 1) %10;
        int carry = (number.get(number.size()-1) + 1) / 10;

        ArrayList<Integer> output = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(div);

        for(int i = number.size()-2 ; i >=0 ; i--){
            div = number.get(i) + carry;
            if(div >= 10){
                carry = div/10;
                div = div %10;
            }
            else{
                carry = 0;
            }
            stack.push(div);
        }

        if(carry != 0){
            stack.push(carry);
        }

        while(!stack.isEmpty()){
            output.add(stack.pop());
        }

        return output;
    }

    public static void main(String... args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(9);
        list.add(9);
        list.add(9);
        list.add(9);
        list.add(9);
        list.add(9);
        list.add(9);
        // list.add(3);
        //list.add(2);

        System.out.println(plusOne(list));
    }
}
