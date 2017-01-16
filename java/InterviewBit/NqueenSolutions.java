package InterviewBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shyamsunderpandita on 11/01/17.
 */
public class NqueenSolutions {

    class Position{
        int row;
        int col;
        public Position(int r, int c){
            row = r;
            col = c;
        }
    }
    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Position[] positions = new Position[n];
        solve(0, positions, result, n);
        return result;
    }
    public void solve(int current, Position[] positions, ArrayList<ArrayList<String>> result, int n) {
        if (n == current) {
            StringBuffer buff = new StringBuffer();
            ArrayList<String> oneResult = new ArrayList<>();
            for (Position p : positions) {
                for (int i = 0; i < n; i++) {
                    if (p.col == i) {
                        buff.append("Q");
                    } else {
                        buff.append(".");
                    }
                }
                oneResult.add(buff.toString());
                buff = new StringBuffer();

            }
            result.add(oneResult);
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean foundSafe = true;
            for (int j = 0; j < current; j++) {
                if (positions[j].col == i || positions[j].col - positions[j].row == i - current || positions[j].row + positions[j].col == i + current) {
                    foundSafe = false;
                    break;
                }
            }
            if (foundSafe) {
                positions[current] = new Position(current, i);
                solve(current + 1, positions, result, n);
            }
        }
    }
    public static void main(String... args){
        NqueenSolutions s = new NqueenSolutions();
        System.out.println(s.solveNQueens(0));
        System.out.println(s.solveNQueens(1));
        System.out.println(s.solveNQueens(2));
        System.out.println(s.solveNQueens(4));
        System.out.println(s.solveNQueens(8));
    }
}
