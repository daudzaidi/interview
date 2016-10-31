package Amazon.Set2;

import java.util.ArrayList;
import java.util.List;

/**
 * What happens there when you pass the path (instead of new ArrayList(path) is that you use a single object in
 * all methods call, which means that, when you return to the original caller, the object is not in the same state
 * as it was. You just need to create a new object and initialize it to the original values. This way the original
 * object does not get modified.
 */
public class PrintRootToLeaves<T> {

    static int pathCount=0;
    public void print(Node<T> root, List<Node<T>> path){
       // System.out.println("Size of Path = "+path.size());

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
        int sum =0;
        for(int i=0;i<path.size();i++){
            System.out.println((path.get(i).getValue()));
            sum = sum+(Integer)path.get(i).getValue();
        }
        System.out.println("Sum of PATH # "+pathCount+" is ===> "+sum);
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
