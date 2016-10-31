package old.java.Trees;

import java.util.ArrayList;

/**
 * Created by pandita on 9/3/2015.
 */
public class CheckSumInPath<T> {
    int CurrSum = 0;
    static int pathCount = 0;
    public void checkSum(Node<T> root,int sum, ArrayList<Node<T>> path){
        if(root==null){
            return;
        }
        path.add(root);
        sum=sum-(Integer)root.getValue();
        if(sum==0){
            display(path);
            //CurrSum=0;
        }else {
            checkSum(root.getLeft(), sum, new ArrayList<Node<T>>(path));
            checkSum(root.getRight(),sum,new ArrayList<Node<T>>(path));
        }
    }

    private void display(ArrayList<Node<T>> path) {
        System.out.println("PATH #  "+pathCount++);
        for(int i=0;i<path.size();i++){
            System.out.println((path.get(i).getValue()));
        }
    }

    public static void main(String args[]){
        BinaryTreeImpl<Integer> tree = new BinaryTreeImpl<Integer>();
        tree.addNode(20,20);
        tree.addNode(15,15);
        tree.addNode(25,25);
        tree.addNode(10,10);
        tree.addNode(18,18);
        tree.addNode(17,17);
        tree.addNode(12,12);
        tree.addNode(19, 19);
        tree.addNode(16, 16);
        CheckSumInPath<Integer> print = new CheckSumInPath<Integer>();
        ArrayList<Node<Integer>> nodelist = new ArrayList<Node<Integer>>();
        print.checkSum(tree.getRoot(),45,nodelist);
    }
}
