package InterviewBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shyamsunderpandita on 14/01/17.
 */
public class NBulbs {
    public int bulbs(ArrayList<Integer> a) {
        int res = 0;

        for(int i = 0 ; i < a.size() ; i++){
            if(a.get(i) == 1 ){
                continue;
            }
            a.set(i,1);
            res++;
            changeState(i+1,a);
        }

        return res;
    }

    public void changeState (int index , ArrayList<Integer> a){
        for(int i = index ; i < a.size() ; i++){
            if(a.get(i) == 0 ){
                a.set(i,1);
            }
            else{
                a.set(i,0);
            }
        }
    }


    //Optimal Solution

    public int bulbs(List<Integer> a) {
        int count = 0, state = 0;
        for(int i=0; i<a.size(); i++){
            if(a.get(i) == state){
                count++;
                state = 1 - state;
            }
        }
        return count;
    }
}
