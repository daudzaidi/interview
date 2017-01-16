package old.java.Sorting;

/**
 * Created by shalvi on 03/01/17.
 * TIME COMPLEXITY :
 *
 * BEST CASE - O(n) when sorted in increasing order
 * WORST CASE - O(n^2) when sorted in dexcreasing order
 *
 *
 * SPACE COMPLEXITY : O(1)
 *
 * In bubble sort we scan elements from left to right multiple times and keep swapping adjacent elements
 * until we place the largest element in the end. In this the elements start falling in sorted order from
 * right side
 */
public class BubbleSort {
    public int[] sort (int [] arr){
        boolean swapped = false;
        for(int i = arr.length-1 ; i >= 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j]  = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }

            // after 1 pass if swapped is false then the whole array is sorted - BEST CASE O(1)
            if(swapped == false){
                System.out.println("BEST CASE - sorted in increasing order");
                return arr;
            }

        }
        return arr;
    }

    public static void main(String... args){
        int count = 1;
        System.out.println("CASE :" + count++);

        //CASE 1 : Duplicate Elements
        int[]arr = new int[]{3,1,4,2,8,5,6,9,0,0,9,8};
        BubbleSort bubbleSort = new BubbleSort();
        arr = bubbleSort.sort(arr);
        for(int i = 0 ; i<arr.length ; i++){
            System.out.println(arr[i]);
        }

        System.out.println("CASE :" + count++);
        //CASE 2 : Sorted in increasing order
        int[]arr1 = new int[]{1,2,3,4,5,6,7,8,9};
        arr1 = bubbleSort.sort(arr1);
        for(int i = 0 ; i<arr1.length ; i++){
            System.out.println(arr1[i]);
        }

        System.out.println("CASE :" + count++);
        //CASE 3 : Sorted in decreasing order
        int[]arr2 = new int[]{100,90,80,70,60,50,40,30,20,10,9,8,7,6,5,4,3,2,1,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
        arr2 = bubbleSort.sort(arr2);
        for(int i = 0 ; i<arr2.length ; i++){
            System.out.println(arr2[i]);
        }

        System.out.println("CASE :" + count++);
        //CASE 4 : Unique Elements
        int[]arr3 = new int[]{5,2,7,3,8,4,9,1,0};
        arr3 = bubbleSort.sort(arr3);
        for(int i = 0 ; i<arr3.length ; i++){
            System.out.println(arr3[i]);
        }
    }
}

