package old.java.Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pandita on 9/2/2015.
 */
public class PrintRootToLeaves<T> {

    static int pathCount=0;
    public void print(Node<T> root, List<Node<T>> path){
        if(root==null){
            return;
        }
        path.add(root);
        if(root.getLeft()==null && root.getRight()==null){
            display(path);
            //pathlen=0;
        }
        else{
            print(root.getLeft(),new ArrayList<Node<T>>(path));
            print(root.getRight(),new ArrayList<Node<T>>(path));
        }
    }

    private void display(List<Node<T>>path) {
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
        PrintRootToLeaves<Integer> print = new PrintRootToLeaves<Integer>();
        List<Node<Integer>> nodelist = new ArrayList<Node<Integer>>();
        print.print(tree.getRoot(),nodelist);
    }

}
