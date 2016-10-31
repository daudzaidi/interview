package TusharRoyVideos.DynamicProgramming;

/**
 * Created by shalvi on 27/09/16.
 */
/**
 * Given two strings , how do we find the length of the longest common substring not necessarily in order or contiguous
 * Also find the longest common substring]
 * ALGO:
 * a matrix T [i][j] consists of column with characters of input1 and row with characters of input2 or vice versa
 * i -> row , j -> column
 *  if (input1[i] == input2[j])
 *      T[i][j] = T[i-1][j-1] + 1
 *  else
 *      T[i][j] = 0;
 *
 *
 *  Trace Back Logic
 *
 * Find block with largest number in matrix T which is formed above
 * int i_max = 0 , j_max=0, max = 0;
 * for(int i = 0 ; i< m ;i++){
 *     for(int j = 0 ;j< n ;j++){
 *         if(T[i][j] > max){
 *             i_max = i;
 *             j_max = j;
 *             max = T[i][j];
 *         }
 *     }
 * }
 *
 * Stack - to store characters of longest common substring
 * while (i > 0 && j > 0){
 *      if(T[i][j] != 0){
 *          stack.push(input1[i])
 *          i = i -1;
 *          j = j-1;
 *      }
 *  }
 *
 *  print stack in to revers the order of characters to get the answer
 */
public class LongestCommonSubstring {

    public static void main(String... args){
        LongestCommonSubstring problem = new LongestCommonSubstring();
        problem.findLCS("abcdaf","zbcdf");
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
                    T[i][j] = 0;
                }
            }
        }

        //last element of the matrix is the length
        printMatrix(T,len1,len2);

        //trace back to find substring
        String result = traceBackMatrix(T,len1,len2,input1);

        System.out.println("Longest Common Substring = "+result);

    }

    private String traceBackMatrix(int[][] T, int m, int n,String input1){
        int i_max = 0 , j_max=0, max = 0;
        for(int i = 0 ; i< m ;i++){
             for(int j = 0 ;j< n ;j++){
                 if(T[i][j] > max){
                         i_max = i;
                         j_max = j;
                         max = T[i][j];
                     }
                 }
        }
        System.out.println("Length of longest common substring is : "+max);

        //printing out characters
        StringBuilder builder = new StringBuilder();
        while(i_max>1 && j_max>1){
            if(T[i_max][j_max] != 0){
                builder.append(input1.charAt(i_max-1));
                i_max --;
                j_max --;
            }
            else{
                break;
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

        System.out.println("Length of the longest common substring = "+T[m][n]);
    }

    private boolean validateData(String input1, String input2) {
        if(input1 == null && input2 == null)
            return  false;
        if(input1 == null || input2==null)
            return false;
        return true;
    }
}
