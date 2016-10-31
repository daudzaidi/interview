package old.java.Amazon.Set234;

/**
 * Created by pandita on 12/7/2015.
 */
public class CommonElement3SortedArrays {

    public void PrintCommon(int[]a1, int[]a2, int[]a3){
        if(a1==null || a2==null||a3==null){
            System.out.println("Can't find Common : Reason Null array");
            return;
        }
        int a1Len = a1.length;
        int a2Len = a2.length;
        int a3Len = a3.length;
        int i=0,j=0,k=0;
        while(i!=a1Len && j!=a2Len && k!=a3Len){
            if(a1[i]==a2[j] && a1[i]==a3[k]){
                System.out.println(a1[i]);
                i++; j++; k++;
            }
            else if(a2[j]<a1[i])
                    j++;
            else if(a3[k]<a1[i])
                    k++;
            else
                i++;
            }
    }

    public void PrintCommonNArrays(int[]... args){
        if(args==null){
            return;
        }
        int n = args.length;
        int[] x = new int[n];

        for( x[0]=0 ; x[0] < n; x[0]++ ) {
            int val = args[0][x[0]];
            boolean print = true;
            for( int i = 1; i < n; i++ ) {
                while (args[i][x[i]] < val && x[i] < n-1) x[i]++;
                if (args[i][x[i]] != val) print = false;
            }
            if (print) System.out.println(val);
        }



    }

    public static void main (String... args) {
        CommonElement3SortedArrays arr=new CommonElement3SortedArrays();
        int a1[]={1,5,10,20,40,80};
        int a2[]={6,7,20,80,100};
        int a3[]={3,4,15,20,30,70,80,120};
        arr.PrintCommon(a1,a2,a3);

        int a4[]={1,5,5};
        int a5[]={3,4,5,5,10};
        int a6[]={5,5,10,20};
        arr.PrintCommon(a4,a5,a6);

        int[][] a = {
                { 10, 160, 200, 500, 500 },
                { 4, 150, 160, 170, 500 },
                { 2, 160, 200, 202, 203 },
                { 3, 150, 155, 160, 300 },
                { 3, 150, 155, 160, 301 } };

        arr.PrintCommonNArrays(a[0],a[1],a[2],a[3],a[4]);
    }
}
