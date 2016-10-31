package old.java.Amazon.Set234;

/**
 * Created by pandita on 12/9/2015.
 */

class Clock{
    long currentTime;
    public Clock(){
        this.currentTime=System.currentTimeMillis();
    }

    public  long elapsedTime(){
        return System.currentTimeMillis()-this.currentTime;
    }
}
public class EditDistanceDP {

    public int editDistance(String str1, String str2, int len1, int len2){
        if(len1==0)
            return len2;  // len2 number of insert operations required
        if(len2==0)
            return len1;  // len1 number of insert operations required

        if(str1.charAt(len1-1)==str2.charAt(len2-1)){
            return editDistance(str1,str2,len1-1,len2-1);
        }

        return 1+min(editDistance(str1,str2,len1-1,len2-1),editDistance(str1,str2,len1-1,len2),editDistance(str1,str2,len1,len2-1));
    }

    public int editDistanceDP(String str1, String str2, int len1, int len2){
        int dp[][] = new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++)
        {
            for (int j=0;j<=len2;j++){
                if (i==0)
                    dp[i][j]=j;
                else if (j==0)
                    dp[i][j]=i;
                else if (str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=1+min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[len1][len2];
    }

    private int min(int i, int j, int k) {
        int min =i;
        if(j<min)
            min=j;
        if(k<min)
            min=k;

        return min;
    }

    public static void main(String args[]){
        String str1="sunday";
        String str2="saturday";
        EditDistanceDP edit = new EditDistanceDP();
        Clock clock = new Clock();
        System.out.println(edit.editDistance(str1,str2,str1.length(),str2.length()));
        System.out.println("Elapsed Time: NON DP :"+ clock.elapsedTime());

        Clock clock2= new Clock();
        System.out.println(edit.editDistanceDP(str1,str2,str1.length(),str2.length()));
        System.out.println("Elapsed Time: DP :"+ clock2.elapsedTime());
    }
}
