package old.java.DivideAndConquer;

/**
 * Created by pandita on 10/6/2015.
 */
public class CountingInversion<T> {

    T[] arr;
    T[] TempArr;
    public int count(int start, int end) {
        if(arr==null || end==start){
            return 0;
        }
        int x=0,y=0,t=0;
        if(start<end){
            int middle=start+(end-start)/2;
            x = count(start, middle);
            y = count(middle+1, end);
            t = splitCount(start,middle,end);
        }
        return x+y+t;
    }

    public<T extends Comparable<T>> int splitCount( int start, int middle, int end) {

        int count=0;
        for(int i=0;i<=end;i++)
            this.TempArr[i]=this.arr[i];
        T[] temp = (T[])TempArr;
        int i=start, k = start;
        int j =middle+1;

        while(i<=middle && j<=end){
            if(temp[i].compareTo(temp[j])>0){
                this.arr[k]=TempArr[j];
                count=count+(middle+1-i);
                j++;
            }
            else{
                this.arr[k]=TempArr[i];
                i++;
            }
            k++;
        }

        while(i<=middle){
            this.arr[k]=TempArr[i];
            i++;
            k++;
        }
        return count;
    }

    public static void main(String args[]) {
        CountingInversion<Integer> sort = new CountingInversion<Integer>();
        //Integer[] arr = new Integer[]{1, 3, 5, 2, 4, 6,0,8};
        Integer[] arr = new Integer[]{1,1,1,2,2};
        sort.arr = arr;
        sort.TempArr = new Integer[arr.length];
        int c =sort.count(0,4);
        System.out.println(c+ " no. of inversions");
    }
}
