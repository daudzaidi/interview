package Amazon.Set2;

/**
 * Created by shalvi on 30/06/16.
 */
public class Question1 {
    public static void printalternate(int[][] arr, int n){
        int flip = 0;
        for(int i =0 ;i<n ;i++){
            if(flip ==0 ){
                for(int j =0 ;j<n ;j++){
                    System.out.println(arr[i][j]);
                }
                flip =1;
            }
            else{
                for(int j =n-1 ;j>=0 ;j--){
                    System.out.println(arr[i][j]);
                }
                flip =0;
            }
        }
    }

    public static void printSpiral(int[][]arr, int n){
        int k = 0; //starting row index
        int m =n-1; // ending row index
        int l = 0; //starting column index
        int p = n-1; //ending column index

        while(k<m && l<p){
            //print first row
            for(int i =l ;i<=p;i++){
                System.out.println(arr[k][i]);
            }
            k++;

            //print column
            for(int i = k ;i<=m ;i++){
                System.out.println(arr[i][p]);
            }
            p--;

            if(k<m) {
                for (int i = p; i >= l; i--) {
                    System.out.println(arr[m][i]);
                }
                m--;
            }

            if(l<n) {
                for (int i = m; i >= k; i--) {
                    System.out.println(arr[i][l]);
                }

                l++;
            }
        }
    }

    public static void main(String... args){
        int arr[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        //printalternate(arr,4);
        printSpiral(arr,4);
    }
}
