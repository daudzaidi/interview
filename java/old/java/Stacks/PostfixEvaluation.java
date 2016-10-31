package old.java.Stacks;

import old.java.SinglyLinkedList.Node;
import old.java.SinglyLinkedList.SinglyLinkedListImpl;

import java.util.Stack;

/**
 * Created by pandita on 8/16/2015.
 */
public class PostfixEvaluation {

    public int EvaluatePostfixExpr(SinglyLinkedListImpl list){
        Stack stack = new Stack();
        Node<Character> tmp = list.getHead();
        int result = 0;
        while(tmp!=null){
            if(operator(tmp.getValue())==0){
                stack.push(tmp.getValue());
            }
            else{
                if(!stack.isEmpty()) {
                    Character aC = (Character)stack.pop();
                    int a = Character.getNumericValue(aC);

                    if(!stack.isEmpty() && tmp.getValue().equals('+')){
                        Character bC = (Character)stack.pop();
                        int b = Character.getNumericValue(bC);
                        result = a+b;
                        char res = (char)result;
                        stack.push(res);
                    }
                    if(!stack.isEmpty() && tmp.getValue().equals('-')){
                        Character bC = (Character)stack.pop();
                        int b = Character.getNumericValue(bC);
                        result = a-b;
                        char res = (char)result;
                        stack.push(res);
                    }
                    if(!stack.isEmpty() && tmp.getValue().equals('/')){
                        Character bC = (Character)stack.pop();
                        int b = Character.getNumericValue(bC);
                        result = a/b;
                        char res = (char)result;
                        stack.push(res);
                    }
                    if(!stack.isEmpty() && tmp.getValue().equals('*')){
                        Character bC = (Character)stack.pop();
                        int b = Character.getNumericValue(bC);
                        result=a*b;
                        char res = (char)result;
                        stack.push(res);
                    }
                }
            }
            tmp=tmp.getNextRef();
        }
        if(stack.isEmpty()){
            return result;
        }
        result=Character.getNumericValue((Character)stack.pop());
        return result;
    }

    public int operator(Character val){
        switch (val){
            case '+' : return 2;
            case '-' : return 2;
            case '*' : return 3;
            case '/' : return 3;
            case '%' : return 3;
            case '^' : return 4;
            default: return 0;
        }
    }
    public static void main(String args[]) {
        SinglyLinkedListImpl<Character> sl = new SinglyLinkedListImpl<Character>();
        sl.add('1');
        sl.add('2');
        sl.add('*');
        sl.add('5');
        sl.add('6');
        sl.add('+');
        sl.add('-');
        sl.add('7');
        sl.add('+');

        PostfixEvaluation eval = new PostfixEvaluation();
        int result = eval.EvaluatePostfixExpr(sl);
        System.out.print(result);
    }

}
