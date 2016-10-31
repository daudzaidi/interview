package old.java.Sorting;

/**
 * Created by pandita on 9/28/2015.
 */
public class QuickSort<T> {

    public <T extends Comparable<T>> void quicksort(T[] arr, int start, int end){
        if(arr==null || end==start){
            return;
        }

        int pivot = start+(end-start)/2;
        int left=start;
        int right=end;

        while(left<pivot){
            if(arr[left].compareTo(arr[pivot])>0){
                break;
            }
        left++;
        }
        while(right>pivot){
            if(arr[right].compareTo(arr[pivot])<0){
                break;
            }
            right--;
        }

        //swap
        T temp = arr[left];
        arr[left]=arr[right];
        arr[right]=temp;

        quicksort(arr,start,pivot);
        quicksort(arr,pivot+1,end);
    }

    public static void main (String args[]){
        QuickSort<Integer> sort = new QuickSort<Integer>();
        Integer[] arr = new Integer[]{2,1,3,6,7,12,0};
        sort.quicksort(arr,0,6);

        for(int i =0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
