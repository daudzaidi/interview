package InterviewBit;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by shyamsunderpandita on 06/01/17.
 */
public class EvaluateExpression {
    public int evalRPN(ArrayList<String> a) {

        int res ;

        Stack<Integer> stack = new Stack<>();
        int size = a.size();
        if(size<3){
            return 0;
        }

        for(int i = 0 ; i < size ; i++){
            if(isOperator(a.get(i)) == true){
                if(!stack.isEmpty()){
                    int operand1 = stack.pop();
                    int operand2 = stack.pop();
                    res = returnOperation(operand2,operand1,a.get(i));
                    stack.push(res);
                }
            }
            else{
                stack.push(Integer.parseInt(a.get(i)));
            }
        }
        return stack.pop();
    }

    public boolean isOperator(String str){
        if(str.equals("/")  || str.equals("*")  || str.equals("+")  || str.equals("-") )
            return true;

        return false;
    }

    public int returnOperation(int a, int b, String e){
        if(e.equals("/")){
            return a/b;
        }
        else if(e.equals("*")){
            return a*b;
        }
        else if(e.equals("-")){
            return a-b;
        }
        else{
            return a+b;
        }
    }

    public static void main(String... args){
        EvaluateExpression expr = new EvaluateExpression();

        ArrayList<String> a = new ArrayList<>();
        a.add("5");
        a.add("1");
        a.add("2");
        a.add("+");
        a.add("4");
        a.add("*");
        a.add("+");
        a.add("3");
        a.add("-");

        System.out.println(expr.evalRPN(a));

        ArrayList<String> b = new ArrayList<>();
        b.add("2");
        b.add("1");
        b.add("+");
        b.add("3");
        b.add("*");



        System.out.println(expr.evalRPN(b));

        ArrayList<String> c = new ArrayList<>();
        c.add("4");
        c.add("13");
        c.add("5");
        c.add("/");
        c.add("+");



        System.out.println(expr.evalRPN(c));
    }
}
