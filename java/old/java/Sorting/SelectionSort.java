package old.java.Sorting;

/**
 * Created by pandita on 9/28/2015.
 */
public class SelectionSort<T> {

    public <T extends Comparable<T>> T[] sort(T[] array){
        T[] arr = array;
        for(int i =0;i<arr.length;i++){
            int index = i;
            for(int j =i+1; j<arr.length;j++){
                if(arr[j].compareTo(arr[index])<0){
                    index=j;
                }
            }
            T smallest = arr[index];
            arr[index] = arr[i];
            arr[i]=smallest;
        }
        return arr;
    }

    public static void main(String args[]){

        SelectionSort<Integer> selSort = new SelectionSort<Integer>();
        Integer[] arr = new Integer[]{2,1,3,6,7,12};
        arr=selSort.sort(arr);
        for(int i =0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        SelectionSort<Character> selSortC = new SelectionSort<Character>();
        Character[] arrC = new Character[]{'z','Z','a','B','p','b','o','g','e'};
        arrC=selSortC.sort(arrC);
        for(int i =0;i<arrC.length;i++){
            System.out.println(arrC[i]);
        }
    }
}
