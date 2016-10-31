package DynamicProgramming;

/**
 * Created by pandita on 1/21/2016.
 */
public class LongestCommonSubsequence {


    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    public static int lcs( Character[] X, Character[] Y, int m, int n )
    {
        if (m == 0 || n == 0)
            return 0;
        if (X[m-1] == Y[n-1]) {
            return 1 + lcs(X, Y, m - 1, n - 1);
        }
        else
            return max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
    }

    /* Utility function to get max of 2 integers */
    public static int max(int a, int b)
    {
        return (a > b)? a : b;
    }


    /** function lcs **/
    public static String Printlcs(String str1, String str2)
    {
        int l1 = str1.length();
        int l2 = str2.length();

        int[][] arr = new int[l1 + 1][l2 + 1];

        for (int i = l1 - 1; i >= 0; i--)
        {
            for (int j = l2 - 1; j >= 0; j--)
            {
                if (str1.charAt(i) == str2.charAt(j))
                    arr[i][j] = arr[i + 1][j + 1] + 1;
                else
                    arr[i][j] = Math.max(arr[i + 1][j], arr[i][j + 1]);
            }
        }

        int i = 0, j = 0;
        StringBuffer sb = new StringBuffer();
        while (i < l1 && j < l2)
        {
            if (str1.charAt(i) == str2.charAt(j))
            {
                sb.append(str1.charAt(i));
                i++;
                j++;
            }
            else if (arr[i + 1][j] >= arr[i][j + 1])
                i++;
            else
                j++;
        }
        return sb.toString();
    }

    /* Driver program to test above function */
    public static void main(String... args)
    {
        Character[] X = {'A','G','G','T','A','B'};
        Character[] Y = {'G','X','T','X','A','Y','B'};

        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is:   " + lcs( X, Y, m, n ) );
        System.out.println("LCS is :   " + Printlcs( "AGGTAB","GXTXAYB" ) );
    }
}

