package old.java.Sorting;

/**
 * Created by shalvi on 9/28/2015.
 * TIME COMPLEXITY :
 *
 * BEST CASE : O(nlogn)
 * WORST CASE : O(nlogn)
 *
 * SPACE COMPLEXITY : O(n)
 *
 * Merge sort uses divide and conquer technique
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
        int count = 1;
        System.out.println("CASE :" + count++);

        // CASE 1 : Unique Elements
        MergeSort<Integer> sort = new MergeSort<Integer>();
        Integer[] arr = new Integer[]{2,1,3,6,7,12};
        sort.Arr =arr;
        sort.TempArr = new Integer[arr.length];
        sort.Merge_Sort(0,arr.length-1);

        for(int i =0; i< sort.Arr.length;i++){
            System.out.println(sort.Arr[i]);
        }

        System.out.println("CASE :" + count++);

        //CASE 2 : Increasing Order
        MergeSort<Integer> sort1 = new MergeSort<Integer>();
        Integer[] arr1 = new Integer[]{1,2,3,4,5,6,7,8,9};
        sort1.Arr =arr1;
        sort1.TempArr = new Integer[arr1.length];
        sort1.Merge_Sort(0,arr1.length-1);

        for(int i =0; i< sort1.Arr.length;i++){
            System.out.println(sort1.Arr[i]);
        }

        System.out.println("CASE :" + count++);

        //CASE 3 : DECREASING ORDER
        MergeSort<Integer> sort2 = new MergeSort<Integer>();
        Integer[] arr2 = new Integer[]{100,80,60,40,20,10,4,3,2,1,0};
        sort2.Arr =arr2;
        sort2.TempArr = new Integer[arr2.length];
        sort2.Merge_Sort(0,arr2.length-1);

        for(int i =0; i< sort2.Arr.length;i++){
            System.out.println(sort2.Arr[i]);
        }

        System.out.println("CASE :" + count++);

        //CASE 4 : Duplicate Elements
        MergeSort<Integer> sort3 = new MergeSort<Integer>();
        Integer[] arr3 = new Integer[]{2,1,2,3,2,6,6,6,6,7,12,1};
        sort3.Arr =arr3;
        sort3.TempArr = new Integer[arr3.length];
        sort3.Merge_Sort(0,arr3.length-1);

        for(int i =0; i< sort3.Arr.length;i++){
            System.out.println(sort3.Arr[i]);
        }
    }
}
