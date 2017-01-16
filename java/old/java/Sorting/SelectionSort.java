package old.java.Sorting;

/**
 * Created by shalvi on 9/28/2015.
 * TIME COMPLEXITY :
 *
 * BEST CASE : O(n^2) - increasing order elements
 * WORST CASE : O(n^2) - decreasing order elements
 *
 * SPACE COMPLEXITY : O(1)
 *
 * In Selection Sort we start with first element and make it as currentMinimum and then traverse the array to check if
 * any element is smaller than current minimum, if yes we swap the positions and then repeat the process from second element
 * of the array until we reach end
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

        int count = 1;
        System.out.println("CASE :" + count++);

        //CASE 0 : Unique Elements
        SelectionSort<Integer> selectionSort = new SelectionSort<Integer>();
        Integer[] arr = new Integer[]{2,1,3,6,7,12,30,3,4,5};
        arr=selectionSort.sort(arr);
        for(int i =0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        System.out.println("CASE :" + count++);

        //CASE 1 : Duplicate Elements
        SelectionSort<Integer> selectionSort1 = new SelectionSort<Integer>();
        Integer[] arr1 = new Integer[]{2,1,3,2,2,6,7,12,6,30,3,6,4,5};
        arr1=selectionSort1.sort(arr1);
        for(int i =0;i<arr1.length;i++){
            System.out.println(arr1[i]);
        }

        System.out.println("CASE :" + count++);

        //CASE 3 : Increasing Order
        SelectionSort<Integer> selectionSort2 = new SelectionSort<Integer>();
        Integer[] arr2 = new Integer[]{1,2,3,4,5,6,7,8,9};
        arr2=selectionSort2.sort(arr2);
        for(int i =0;i<arr2.length;i++){
            System.out.println(arr2[i]);
        }

        System.out.println("CASE :" + count++);

        //CASE 4 : Decreasing Order
        SelectionSort<Integer> selectionSort3 = new SelectionSort<Integer>();
        Integer[] arr3 = new Integer[]{100,90,80,70,60,50,40,30,20,10};
        arr3=selectionSort3.sort(arr3);
        for(int i =0;i<arr3.length;i++){
            System.out.println(arr3[i]);
        }

        System.out.println("CASE :" + count++);

        //CASE 5 : Characters

        SelectionSort<Character> selSortC = new SelectionSort<Character>();
        Character[] arrC = new Character[]{'z','Z','a','B','p','b','o','g','e'};
        arrC=selSortC.sort(arrC);
        for(int i =0;i<arrC.length;i++){
            System.out.println(arrC[i]);
        }
    }
}
