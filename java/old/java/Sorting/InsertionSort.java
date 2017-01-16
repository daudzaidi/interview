package old.java.Sorting;

/**
 * Created by shalvi on 9/28/2015.
 * TIME COMPLEXITY
 *
 * BEST CASE : O(n) - all in increasing order
 * WORST CASE : O(n^2) - all in decreasing order
 *
 * SPACE COMPLEXITY : O(1)
 *
 * In Insertion sort we traverse each element and place it at the right position by comparing it with elements from the left
 * which keep on getting sorted.
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

        int count = 1;
        System.out.println("CASE :" + count++);

        //CASE 0 : Unique Elements
        InsertionSort<Integer> insertioSort = new InsertionSort<Integer>();
        Integer[] arr = new Integer[]{2,1,3,6,7,12,30,3,4,5};
        arr=insertioSort.sort(arr);
        for(int i =0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        System.out.println("CASE :" + count++);

        //CASE 1 : Duplicate Elements
        InsertionSort<Integer> insertioSort1 = new InsertionSort<Integer>();
        Integer[] arr1 = new Integer[]{2,1,3,2,2,6,7,12,6,30,3,6,4,5};
        arr1=insertioSort1.sort(arr1);
        for(int i =0;i<arr1.length;i++){
            System.out.println(arr1[i]);
        }

        System.out.println("CASE :" + count++);

        //CASE 3 : Increasing Order
        InsertionSort<Integer> insertioSort2 = new InsertionSort<Integer>();
        Integer[] arr2 = new Integer[]{1,2,3,4,5,6,7,8,9};
        arr2=insertioSort2.sort(arr2);
        for(int i =0;i<arr2.length;i++){
            System.out.println(arr2[i]);
        }

        System.out.println("CASE :" + count++);

        //CASE 4 : Decreasing Order
        InsertionSort<Integer> insertioSort3 = new InsertionSort<Integer>();
        Integer[] arr3 = new Integer[]{100,90,80,70,60,50,40,30,20,10};
        arr3=insertioSort.sort(arr3);
        for(int i =0;i<arr3.length;i++){
            System.out.println(arr3[i]);
        }

        System.out.println("CASE :" + count++);

        //CASE 5 : Characters
        InsertionSort<Character> insertioSortC = new InsertionSort<Character>();
        Character[] arrC = new Character[]{'z','Z','a','B','p','b','o','g','e'};
        arrC=insertioSortC.sort(arrC);
        for(int i =0;i<arrC.length;i++){
            System.out.println(arrC[i]);
        }
    }
}
