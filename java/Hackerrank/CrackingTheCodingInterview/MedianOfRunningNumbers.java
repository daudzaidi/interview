package Hackerrank.CrackingTheCodingInterview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by shalvi on 29/09/16.
 */
public class MedianOfRunningNumbers {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    MedianOfRunningNumbers() {
        this.minHeap = new PriorityQueue<Integer>(); //default increasing order comparison - natural ordering
        this.maxHeap = new PriorityQueue<Integer>(10, new MaxComparator());
    }

    private static class MaxComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public void insertInHeap(int sizeCurrentList, int value){
        maxHeap.add(value);

        //if size of list is even
        if((sizeCurrentList & 1) == 0){
            if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
                Integer maxHeapRoot = maxHeap.poll();
                Integer minHeapRoot = minHeap.poll();
                minHeap.add(maxHeapRoot);
                maxHeap.add(minHeapRoot);
            }
        }
        //size of list odd
        else{
            minHeap.add(maxHeap.poll());
        }
    }

    private double findMedian(int sizeOfCurrentList){
        double maxHeapNode = maxHeap.peek();

        //even
        if((sizeOfCurrentList&1) == 0){
            double minHeapNode = minHeap.peek();
            return ((maxHeapNode + minHeapNode) / 2.0);
        }
        //odd
        else{
            return maxHeapNode;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        MedianOfRunningNumbers solution = new MedianOfRunningNumbers();

        for (int i = 1; i <= n; i++) {
            int value = scanner.nextInt();
            solution.insertInHeap(i - 1, value);
            System.out.println(solution.findMedian(i));
        }

        scanner.close();
    }



}
