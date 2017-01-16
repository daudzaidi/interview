package InterviewBit;

import java.util.ArrayList;

/**
 * Created by shyamsunderpandita on 10/01/17.
 */
public class GenerateAllvalidParentheses {
    public ArrayList<String> generateParenthesis(int n) {
        if(n == 0){
            return null;
        }

        ArrayList<String> res = new ArrayList<>();
        String output = "";
        getPermutations(res,output,n,0,0);

        return res;
    }

    private void getPermutations(ArrayList<String> res, String output, int n, int open, int close) {
        System.out.println("OUTPUT == > "+output + "     : openIndex = "+open + "    :closeIndex = "+close);
        if(open == n && close == n){
            res.add(output);
            return;
        }
        else{
            if(open < n) {
                getPermutations(res, output + "(", n, open + 1, close);
            }

            if(close < open) {
                getPermutations(res, output + ")", n, open, close + 1);
            }
        }
    }

    public static void main(String... args){
        GenerateAllvalidParentheses g = new GenerateAllvalidParentheses();
       // System.out.println(g.generateParenthesis(1));
        //System.out.println(g.generateParenthesis(2));
        System.out.println(g.generateParenthesis(3));
        //System.out.println(g.generateParenthesis(4));
    }
}
