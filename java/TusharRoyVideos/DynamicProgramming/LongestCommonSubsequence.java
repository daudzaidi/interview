package TusharRoyVideos.DynamicProgramming;

import java.util.List;

/**
 * Given two strings , how do we find the length of the longest common subsequence not necessarily in order or contiguous
 * Also find the longest common subsequence]
 * length finding ALGO:
 * a matrix T [i][j] consists of column with characters of input1 and row with characters of input2 or vice versa
 * i -> row , j -> column
 *  if (input1[i] == input2[j])
 *      T[i][j] = T[i-1][j-1] + 1
 *  else
 *      T[i][j] = Max (T[i][j-1], T[i-1][j])
 *
 *  Trace Back Logic
 *
 *  while (i > 0 && j > 0){
 *      if(T[m][n] != T[m-1][n] && T[m][n] != T[m][n-1]){
 *          add T[m][n] to result ; m-- , n--
 *      }
 *      else{
 *          if (T[m][n] == T[m-1][n]){
 *              m--;
 *          }
 *          else{
 *              n--;
 *          }
 *      }
 *  }
 */
public class LongestCommonSubsequence {

    public static void main(String... args){
        LongestCommonSubsequence problem = new LongestCommonSubsequence();
        problem.findLCS("abcdaf","acbcf");
        problem.findLCS("AGGTAB","GXTXAYB");
    }

    public void findLCS (String input1, String input2){
        //validate the input
        if(!validateData(input1, input2))
            return;

        //calculate lengths of the strings
        int len1 = input1.length();
        int len2 = input2.length();

        //create a matrix to store results
        int[][] T = new int[len1+1][len2+1];

        //fill the matrix
        for(int i = 0; i< len1+1 ; i++){
            for(int j = 0 ;j< len2+1 ; j++){
                if(i ==0 || j==0){
                    T[i][j] = 0;
                    continue;
                }
                if(input1.charAt(i-1) == input2.charAt(j-1)){
                    T[i][j] = 1+T[i-1][j-1];
                }
                else{
                    T[i][j] = Math.max(T[i-1][j],T[i][j-1]);
                }
            }
        }

        //last element of the matrix is the length
        printMatrix(T,len1,len2);

        //trace back to find subsequence
        String result = traceBackMatrix(T,len1,len2,input1);

        System.out.println("Longest Common Subsequence = "+result);

    }

    private String traceBackMatrix(int[][] T, int m, int n,String input1){
        StringBuilder builder = new StringBuilder();
        while(m>0 && n>0){
            if(T[m][n] == T[m-1][n]){
                m--;
            }
            else if (T[m][n] == T[m][n-1]){
                n--;
            }
            else{
                builder.append(input1.charAt(m-1));
                m--; n--;
            }
        }
        return builder.toString();
    }

    private void printMatrix(int[][] T, int m, int n){
        for(int i =0 ;i<=m;i++){
            for(int j =0 ;j<=n ;j++){
                System.out.print(T[i][j]+"\t");
            }
            System.out.println();
        }

        System.out.println("Length of the longest common subsequence = "+T[m][n]);
    }

    private boolean validateData(String input1, String input2) {
        if(input1 == null && input2 == null)
            return  false;
        if(input1 == null || input2==null)
            return false;
        return true;
    }
}
