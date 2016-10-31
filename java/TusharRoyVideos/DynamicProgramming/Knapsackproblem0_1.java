package TusharRoyVideos.DynamicProgramming;

/**
 * Created by shalvi on 04/08/16.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Question : Given a bag which can only take certain weight W.
 * Given list of items with their weights and price.
 * How do you fill this bag to maximize value of items in the bag.
 * Value total should be maximum and sum of weights should be less than equal to acceptable weight
 * We have 1 qty of each items with given weight and price
 * 0/1 means either you pick the item or you don't pick
 *
 * Mathematical Formula:
 * considering a 2D matrix where rows correspond to items and columns correspond to total weight
 * allowed in a bag starting from 0
 * i -> row
 * j -> col
 *
 * if( j < wt(i)){
 *     T[i][j] = T [i-1][j]
 * }
 * else{
 *     T[i][j] = Max(T[i-1][j] , val(i)+T[i-1][j - wt(i)]);
 * }
 *
 * After we have  created the table , we trace back from last entry and check which items were selected
 * */

public class Knapsackproblem0_1 {

    public static void main(String... args){
        Knapsackproblem0_1 problem = new Knapsackproblem0_1();
        List<Item> items = problem.getItems();
        int totaWeight = problem.getTotalWeight();
        if(problem.validateData(items,totaWeight)){
            problem.solveKnapsack(items,totaWeight);
        }
    }

    public List<Item> getItems(){
        List<Item> items = new ArrayList<>();
        items.add(new Item(1,1,"Item1"));
        items.add(new Item(3,4,"Item2"));
        items.add(new Item(4,5,"Item3"));
        items.add(new Item(5,7,"Item4"));
        return items;
    }

    public int getTotalWeight(){
        int totalWeight = 7;
        return totalWeight;
    }

    public void solveKnapsack(List<Item> items, int totalWeight){

        //calculate length of the items
        int lenItems = items.size();

        //create a 2D matrix
        int[][] T = new int [lenItems][totalWeight+1];

        //filling first column with 0 since no matter what total items selected will be 0 if total weight is 0
        for(int i=0; i< lenItems ;i++){
            T[i][0] =0;
        }

        //filling first row
        for(int j =1 ;j<=totalWeight;j++){
            if(items.get(0).weight > j)
                T[0][j] = 0;
            else
                T[0][j] = items.get(0).weight;
        }

        //filling rest of the elements
        for(int i = 1 ; i< lenItems ; i++){
            for(int j = 1 ; j<=totalWeight ; j++){
                if(items.get(i).weight > j){
                    T[i][j] = T[i-1][j];
                }
                else{
                    T[i][j] = Math.max ( T[i-1][j] , items.get(i).value + T[i-1][j-items.get(i).weight]);
                }
            }
        }

        //print matrix
        printMatrix(T,lenItems,totalWeight+1);

        //trace back matrix to find the items
        List<Item> result = traceBackMatrix(T,lenItems-1,totalWeight,items);

        //print result
        printResultantItems(result);
    }

    public void printResultantItems(List<Item> items){
        System.out.println("Following Items can be added to Maximize value with Allowed Weight ==> ");
        for(Item item : items){
            System.out.println(item.id);
        }
    }

    public List<Item> traceBackMatrix(int[][] T, int m, int n, List<Item> items){
      List<Item>result = new ArrayList<>() ;
        while(T[m][n] > 0 || (m > 0 && n > 0)){
            if(T[m][n] == T[m-1][n]){
                m = m-1;
            }
            else{
                result.add(items.get(m));
                n = n - items.get(m).value +1;
                m = m - 1;
            }
        }
        return result;
    }

    public void printMatrix (int[][] T, int m, int n){
        for(int i =0 ;i<m;i++){
            for(int j =0 ;j<n ;j++){
                System.out.print(T[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public boolean validateData(List<Item> items, int totalWeight){
        if(items == null)
            return false;

        if(totalWeight < 0 || totalWeight > Integer.MAX_VALUE)
            return  false;

        return true;
    }
}

class Item{
    int weight;
    int value;
    String id;
    public Item(int wt, int val, String iid){
        weight = wt;
        value = val;
        id=iid;
    }
}