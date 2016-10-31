package old.java.Stacks;

import old.java.SinglyLinkedList.Node;
import old.java.SinglyLinkedList.SinglyLinkedListImpl;

import java.util.Stack;

/**
 * Created by pandita on 8/15/2015.
 */
public class ParanthesisBalancing <T> {

    public boolean isBalanced(SinglyLinkedListImpl list){
        Node<T> tmp = list.getHead();
        Stack stack = new Stack();
        while(tmp!=null){
            if(tmp.getValue().equals('{') || tmp.getValue().equals('[') || tmp.getValue().equals('(')){
                stack.push(tmp.getValue());
            }

            if(tmp.getValue().equals('}') || tmp.getValue().equals(']') || tmp.getValue().equals(')')){
                if(stack==null){
                    return false;
                }

                if(isMatchingPair(tmp.getValue(), (T) stack.pop())){
                    tmp=tmp.getNextRef();
                    continue;
                }
                else{
                    return false;
                }
            }
            tmp=tmp.getNextRef();
        }

        if (stack.size()!=0){
            return false;
        }
        return true;
    }

    public boolean isMatchingPair(T a, T b){
        if(a.equals(')') && b.equals('(')){
            return true;
        }

        if(a.equals(']') && b.equals('[')){
            return true;
        }

        if(a.equals('}') && b.equals('{')){
            return true;
        }

        return false;
    }

    public static void main(String args[]){
        SinglyLinkedListImpl<Character> sl = new SinglyLinkedListImpl<Character>();
        sl.add('{');
        sl.add('[');
        sl.add('(');
        sl.add(')');
        sl.add(']');
        sl.add('}');
        ParanthesisBalancing list = new ParanthesisBalancing();
        if(list.isBalanced(sl)){
            System.out.println("Balanced");
        }
        else{
            System.out.println("Not Balanced");
        }
    }
}
