package DocPractice;

/**
 * Created by shalvi on 27/05/16.
 */
public class setElementsToZero {
    public void  ElementsToZero (int[][] arr, int m, int n){
        if(arr == null || (m==0 && n==0)) return;

        int[][]indices = new int[m][n];
        int count =0;
        for(int i = 0 ;i < m ; i++){
            for(int j = 0; j<n ; j++ ){
                if(arr[i][j] == 0) indices[i][j] = 1; // set that location as 1
            }
        }

        //traversing again
        for(int i = 0 ;i < m ; i++){
            for(int j = 0; j<n ; j++ ){
                if(indices[i][j] == 1) {
                    // setting row as 0
                    for(int k = 0 ;k < n ; k++){
                        arr[i][k] = 0;
                    }
        //setting column as 0
                    for(int k = 0 ;k < m ; k++){
                        arr[k][i] = 0;
                    }
                }
            }
        }

    }

    public void scanElementsZeroWithRowColumn (int[][] arr, int m, int n){
        if (arr == null || (m==0 && n==0)) return;

        int [] row = new int [m];
        int[] column = new int[n];

        //scan the matrix once to find the rows and columns
        for(int i =0 ;i < m ;i++){
            for(int j = 0; j< n; j++){
                if(arr[i][j] == 0){
                    row[i] = 1;
                    column[j] =1;
                }
            }
        }

//scanning the matrix again and setting elements to 0 for which either row or column is 0

        for(int i =0 ;i < m ;i ++){
            for(int j = 0; j< n; j++){
                if(row[i] == 1 || column[j]==1){
                    arr[i][j] = 0;
                }
            }
        }

    }


    public void display(int[][]arr,int m,int n){
        for(int i =0 ;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String... args){
        setElementsToZero matrix = new setElementsToZero();
        int [][] arr = {
                {1,2,0,4},
                {5,6,7,8},
                {0,10,11,12},
                {13,14,15,16}
        };

        matrix.display(arr,4,4);

        System.out.println("After setting Elements to zero");
        matrix.ElementsToZero(arr,4,4);

        matrix.display(arr,4,4);

    }

}
