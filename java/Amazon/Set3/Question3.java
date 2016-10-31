package Amazon.Set3;

import Amazon.Set2.BinaryTreeImpl;
import Amazon.Set2.Node;

/**
 * Created by shalvi on 04/07/16.
 */
public class Question3 {

    public static boolean isSubtree(Node root1, Node root2){
       if(root2 == null)
           return true;
        if(root1 == null)
            return false;
        if(areIdentical(root1,root2))
            return true;
        return  isSubtree(root1.getLeft(),root2) || isSubtree(root1.getRight(),root2);
    }

    public static boolean areIdentical(Node root1, Node root2){
        if(root1 == null && root2 == null) return true;

        if(root1 == null || root2==null) return false;

        return ((Integer)root1.getValue() == (Integer)root2.getValue() && areIdentical(root1.getLeft(),root2.getLeft()) && areIdentical(root1.getRight() , root2.getRight()));
    }

    public static void main(String... args){
        BinaryTreeImpl<Integer> tree = new BinaryTreeImpl<Integer>();
        tree.addNode(20,20);
        tree.addNode(15,15);
        tree.addNode(25,25);
        tree.addNode(10,10);
        tree.addNode(18,18);
        tree.addNode(17,17);
        tree.addNode(12,12);
        tree.addNode(19,19);
        tree.addNode(16,16);

        BinaryTreeImpl<Integer> tree2 = new BinaryTreeImpl<Integer>();
        tree2.addNode(18,18);
        tree2.addNode(17,17);
        tree2.addNode(19,19);
        tree2.addNode(16,16);

        System.out.println("Is Tree 2 a subtree of Tree ===> "+ isSubtree(tree.getRoot(),tree2.getRoot()));
    }

}
