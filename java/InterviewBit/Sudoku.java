package InterviewBit;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by shyamsunderpandita on 11/01/17.
 */
public class Sudoku {

    private int n;
    private ArrayList<ArrayList<Character>> A;
    private HashSet<Character> hashSet;

    public void solveSudoku(ArrayList<ArrayList<Character>> A) {

        n = A.size();
        this.A = A;
        hashSet = new HashSet<>();
        backtrack(0, 0);
    }


    public boolean backtrack(int row, int col) {

        if (row == n)
            return true;

        char c = A.get(row).get(col);
        int rr, cc;
        rr = row;
        cc = col + 1;

        if (cc == n) {
            rr++;
            cc = 0;
        }

        if (c == '.') {

            for (char ch = '1'; ch <= '9'; ch++) {
                A.get(row).set(col, ch);

                if (isValid(row, col)) {
                    boolean status = backtrack(rr, cc);
                    if (status)
                        return true;
                }

                A.get(row).set(col, '.');
            }

        } else {
            return backtrack(rr, cc);
        }

        return false;
    }


    public boolean isValid(int row, int col) {
        hashSet.clear();
        char c;

        for (int i = 0; i < n; i++) {
            c = A.get(row).get(i);
            if (hashSet.contains(c))
                return false;
            if (c != '.')
                hashSet.add(c);
        }

        hashSet.clear();

        for (int i = 0; i < n; i++) {
            c = A.get(i).get(col);
            if (hashSet.contains(c))
                return false;
            if (c != '.')
                hashSet.add(c);
        }

        int sRow = (row / 3) * 3;
        int sCol = (col / 3) * 3;
        hashSet.clear();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                int rr = sRow + i;
                int cc = sCol + j;
                c = A.get(rr).get(cc);

                if (hashSet.contains(c))
                    return false;
                if (c != '.')
                    hashSet.add(c);

            }
        }


        return true;

    }
    public static void main(String... args){
        ArrayList<ArrayList<Character>> A = new ArrayList<ArrayList<Character>> ();
        ArrayList<Character> r1 = new ArrayList<>();
        r1.add('5');
        r1.add('3');
        r1.add('.');
        r1.add('.');
        r1.add('7');
        r1.add('.');
        r1.add('.');
        r1.add('.');
        r1.add('.');

        ArrayList<Character> r2 = new ArrayList<>();
        r2.add('6');
        r2.add('.');
        r2.add('.');
        r2.add('1');
        r2.add('9');
        r2.add('5');
        r2.add('.');
        r2.add('.');
        r2.add('.');

        ArrayList<Character> r3 = new ArrayList<>();
        r3.add('.');
        r3.add('9');
        r3.add('8');
        r3.add('.');
        r3.add('.');
        r3.add('.');
        r3.add('.');
        r3.add('6');
        r3.add('.');

        ArrayList<Character> r4 = new ArrayList<>();
        r4.add('8');
        r4.add('.');
        r4.add('.');
        r4.add('.');
        r4.add('6');
        r4.add('.');
        r4.add('.');
        r4.add('.');
        r4.add('3');

        ArrayList<Character> r5 = new ArrayList<>();
        r5.add('4');
        r5.add('.');
        r5.add('.');
        r5.add('8');
        r5.add('.');
        r5.add('3');
        r5.add('.');
        r5.add('.');
        r5.add('1');

        ArrayList<Character> r6 = new ArrayList<>();
        r6.add('7');
        r6.add('.');
        r6.add('.');
        r6.add('.');
        r6.add('2');
        r6.add('.');
        r6.add('.');
        r6.add('.');
        r6.add('6');

        ArrayList<Character> r7 = new ArrayList<>();
        r7.add('.');
        r7.add('6');
        r7.add('.');
        r7.add('.');
        r7.add('.');
        r7.add('.');
        r7.add('2');
        r7.add('8');
        r7.add('.');

        ArrayList<Character> r8 = new ArrayList<>();
        r8.add('.');
        r8.add('.');
        r8.add('.');
        r8.add('4');
        r8.add('1');
        r8.add('9');
        r8.add('.');
        r8.add('.');
        r8.add('5');

        ArrayList<Character> r9 = new ArrayList<>();
        r9.add('.');
        r9.add('.');
        r9.add('.');
        r9.add('.');
        r9.add('8');
        r9.add('.');
        r9.add('.');
        r9.add('7');
        r9.add('9');

        A.add(r1);
        A.add(r2);
        A.add(r3);
        A.add(r4);
        A.add(r5);
        A.add(r6);
        A.add(r7);
        A.add(r8);
        A.add(r9);

        Sudoku s = new Sudoku();
        s.solveSudoku(A);
        System.out.println(A);
    }
}
