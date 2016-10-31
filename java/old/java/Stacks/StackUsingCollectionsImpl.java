package old.java.Stacks;

import java.util.Stack;

/**
 * Created by pandita on 8/13/2015.
 */
public class StackUsingCollectionsImpl<T> {

    public  static void main(String args[]){

        Stack stack = new Stack();
        stack.push(12);
        stack.push(14);

        System.out.println(stack.pop());
    }
}
