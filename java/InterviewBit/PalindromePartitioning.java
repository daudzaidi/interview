package InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by shyamsunderpandita on 09/01/17.
 * Given a string s, partition s such that every string of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["a","a","b"]
 ["aa","b"],
 ]
 Ordering the results in the answer : Entry i will come before Entry j if :
 len(Entryi[0]) < len(Entryj[0]) OR
 (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
 *
 *
 *
 (len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
 In the given example,
 ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")
 */
public class PalindromePartitioning {
    private int isPalin[][];
    private int N;
    private ArrayList<ArrayList<String>> mRes;
    private String mString;


    public ArrayList<ArrayList<String>> partition(String A) {

        mRes = new ArrayList<>();
        N = A.length();

        if (N == 0)
            return null;

        mString = A;
        isPalin = new int[N][N];

        System.out.println("mString (main string) = " + A);

        for (int i = 0; i < N; i++) {
            Arrays.fill(isPalin[i], -1);
        }
        System.out.println("INITIALIZING PALINDROME MATRIX ===>");
        System.out.println();
        display(isPalin,N);

        ArrayList<String> str = new ArrayList<>();

        System.out.println("INITIALLY mRes is EMPTY ===>");
        display(mRes);
        System.out.println();
        rec(str, 0);
        System.out.println();
        return mRes;

    }

    private void display(ArrayList<ArrayList<String>> mRes) {
        for(ArrayList<String> s : mRes)
            System.out.print(s+ "    ");

        System.out.println();
    }

    private void display(int[][] isPalin, int n) {
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                System.out.print(isPalin[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public void rec(ArrayList<String> str, int index) {

        if (index == N) {
            mRes.add(new ArrayList(str));
            System.out.println("INDEX ("+index+") == N ("+N+")" +"====>" );
            display(mRes);
            return;
        }

        for (int i = index; i < N; i++) {
            boolean isPa = isPalindrome(index,i);
            System.out.println("index = "+index+"   :  i = "+i+ "   : isPalindrome = "+isPa);
            if (isPa) {
                str.add(mString.substring(index, i + 1));
                System.out.println("str before going to recursion step === > + i = "+i);
                displayL(str);
                rec(str, i + 1);
                System.out.println("str after recursion step === > i = "+i + "   : Index = "+index);
                displayL(str);
                str.remove(str.size() - 1);
                System.out.println("str after removal step === >  i = "+i+ "   : Index = "+index);
                displayL(str);
            }
        }


    }

    private void displayL(ArrayList<String> str) {

        for(String s : str)
            System.out.print(s);

        System.out.println();
    }

    public boolean isPalindrome(int start, int end) {

        if (start < 0 || start >= N || end < 0 || end >= N)
            return false;

        if (isPalin[start][end] != -1)
            return isPalin[start][end] == 1;

        int i, j;

        for (i = start, j = end; i < j; i++, j--) {
            if (mString.charAt(i) != mString.charAt(j)) {
                isPalin[start][end] = 0;
                return false;
            }
        }

        isPalin[start][end] = 1;

        System.out.println("UPDATED PALINDROME MATRIX ===>");
        System.out.println();
        display(isPalin,N);
        System.out.println();
        return true;

    }

    public static void main(String... args){
        PalindromePartitioning p = new PalindromePartitioning();
        //System.out.println(p.partition("Hello"));
        System.out.println(p.partition("helloo"));
    }
}
