package InterviewBit;

import java.util.ArrayList;

/**
 * Created by shyamsunderpandita on 16/11/16.
 */
public class Infinite2DGrid {

    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        if(X.size() == 0 || Y.size() == 0) return 0;
        if(X.size()!=Y.size()) return 0;

        int c = 0;

        int curX = X.get(0);
        int curY = Y.get(0);

        for(int i = 1; i<X.size(); i++){
            int nextX = X.get(i);
            int nextY = Y.get(i);

            int disX = Math.abs(curX - nextX);
            int disY = Math.abs(curY - nextY);

            c+=Math.max(disX, disY);
            curX = nextX;
            curY = nextY;
        }
        return c;
    }

    public static void main(String... args){
        Infinite2DGrid grid  = new Infinite2DGrid();

    }
}
