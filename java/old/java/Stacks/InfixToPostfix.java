package old.java.Stacks;

import old.java.SinglyLinkedList.Node;
import old.java.SinglyLinkedList.SinglyLinkedListImpl;

import java.util.Stack;

/**
 * Created by pandita on 8/16/2015.
 */

//considering only + - * / ( ) ^
public class InfixToPostfix{


    public static void InfixToPostfixImpl(SinglyLinkedListImpl list){
        Node<Character> tmp = list.getHead();
        Stack stack = new Stack();
        while(tmp!=null){
            //condition 1 - if operand just output it
            if(precedence(tmp.getValue())==0){
                System.out.print(tmp.getValue());
            }
            //Condition 2 - if operator is ')' , pop and output until '(' discovered
            else if(tmp.getValue().equals(')')){

                while(!stack.isEmpty() && !(stack.peek().equals('('))){
                    System.out.print(stack.pop());
                }
                if(!stack.isEmpty() && stack.peek().equals('(')){
                    stack.pop();
                }
            }
            //Condition 3 - if it is an operator or left parenthesis , check and push
            else{
                int precTmp = precedence(tmp.getValue());
                Character stackprecchar=null;
                int stackPrec = 0;
                if(!stack.isEmpty()){
                    stackprecchar = (Character)stack.peek();
                    stackPrec= precedence(stackprecchar);
                }

                while(!stack.isEmpty() && (stackPrec!=5) && stackPrec >= precTmp){
                    Character pop = (Character)stack.pop();
                    if(pop!='(') {
                        System.out.print(pop);
                    }
                    if(!stack.isEmpty()) {
                        stackprecchar = (Character) stack.peek();
                        stackPrec = precedence(stackprecchar);
                    }
                }
                stack.push(tmp.getValue());
            }
            tmp=tmp.getNextRef();
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }

    public static int precedence(Character val){
        switch (val){
            case '+' : return 2;
            case '-' : return 2;
            case '*' : return 3;
            case '/' : return 3;
            case '%' : return 3;
            case ')' : return 5;
            case '(' : return 5;
            case '^' : return 4;
            default: return 0;
        }
    }
    public static void main(String args[]) {
        SinglyLinkedListImpl<Character> sl = new SinglyLinkedListImpl<Character>();
        sl.add('A');
        sl.add('*');
        sl.add('B');
        sl.add('-');
        sl.add('(');
        sl.add('C');
        sl.add('+');
        sl.add('D');
        sl.add(')');
        sl.add('+');
        sl.add('E');


        InfixToPostfix.InfixToPostfixImpl(sl);
    }

}
