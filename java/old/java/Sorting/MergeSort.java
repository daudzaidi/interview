package old.java.Sorting;

/**
 * Created by pandita on 9/28/2015.
 */
public class MergeSort<T> {

    T[] Arr;
    T[] TempArr;

    public void Merge_Sort(int start, int end){
        if(this.Arr==null || start==end){
            return;
        }
        if(start<end) {
            int middle = start + (end - start) / 2;
            Merge_Sort(start, middle);
            Merge_Sort(middle + 1, end);
            Merge(start, middle, end);
        }
    }

    public<T extends Comparable<T>> void Merge(int start, int middle, int end) {

        for(int i=0;i<=end;i++)
            this.TempArr[i]=this.Arr[i];
        T[] temp = (T[])TempArr;
        int i=start, k = start;
        int j =middle+1;

        while(i<=middle && j<=end){
            if(temp[i].compareTo(temp[j])>0){
                this.Arr[k]=TempArr[j];
                j++;
            }
            else{
                //this.Arr[k]=TempArr[i];
                i++;
            }
            k++;
        }

        while(i<=middle){
            this.Arr[k]=TempArr[i];
            i++;
            k++;
        }
    }

    public static void main(String args[]){
        MergeSort<Integer> sort = new MergeSort<Integer>();
        Integer[] arr = new Integer[]{2,1,3,6,7,12};
        sort.Arr =arr;
        sort.TempArr = new Integer[arr.length];
        sort.Merge_Sort(0,5);

        for(int i =0; i< sort  .Arr.length;i++){
            System.out.println(sort.Arr[i]);
        }
    }
}
