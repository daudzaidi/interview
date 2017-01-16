package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shyamsunderpandita on 11/01/17.
 */
public class Permutations {

    ArrayList<ArrayList<Integer>> result = new  ArrayList<ArrayList<Integer>> ();
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        if(a!=null){
            Collections.sort(a);
            solve(a,0,a.size()-1);
        }
        return result;
    }

    private void solve(ArrayList<Integer> a, int start, int end) {
        if(start == end){
            result.add(new ArrayList<>(a));
            return;
        }

        for(int i = start ; i <=end ; i++){
            //SWAP
            int t = a.get(start);
            a.set(start,a.get(i));
            a.set(i,t);

            solve(a,start+1,end);
            //BACKTRACK

             t = a.get(start);
            a.set(start,a.get(i));
            a.set(i,t);
        }


    }

    public static void main(String... args){
        Permutations p = new Permutations();
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        System.out.println(p.permute(a));
    }
}
