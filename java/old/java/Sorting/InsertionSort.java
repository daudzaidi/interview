package old.java.Sorting;

/**
 * Created by pandita on 9/28/2015.
 */
public class InsertionSort <T> {

    public <T extends Comparable<T>> T[] sort(T[] ar){
        T[] arr = ar;
        for(int i =1;i<arr.length;i++){
            T key = arr[i];
            int j =i-1;
            while(j>= 0 && key.compareTo(arr[j])<0){
                arr[j+1] = arr[j];
                j=j-1;
            }
            arr[j+1]=key;
        }
        return arr;
    }

    public static void main(String args[]){

        InsertionSort<Integer> insertioSort = new InsertionSort<Integer>();
        Integer[] arr = new Integer[]{2,1,3,6,7,12,30,3,4,5};
        arr=insertioSort.sort(arr);
        for(int i =0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        InsertionSort<Character> insertioSortC = new InsertionSort<Character>();
        Character[] arrC = new Character[]{'z','Z','a','B','p','b','o','g','e'};
        arrC=insertioSortC.sort(arrC);
        for(int i =0;i<arrC.length;i++){
            System.out.println(arrC[i]);
        }
    }
}
