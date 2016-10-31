package old.java.Trees;

/**
 * Created by pandita on 9/1/2015.
 */
public class TreeSize <T>{

    public int TreeSizeCalc(Node<T> root){
        if(root==null){
           return 0;
        }
        return (TreeSizeCalc(root.getLeft())+TreeSizeCalc(root.getRight())+1);
    }

    public static void main(String args[]) {
        BinaryTreeImpl<Integer> tree = new BinaryTreeImpl<Integer>();
        tree.addNode(20, 20);
        tree.addNode(15, 15);
        tree.addNode(25, 25);
        tree.addNode(30, 30);
        tree.addNode(34, 34);
        tree.addNode(70, 70);
        tree.addNode(10, 10);
        tree.addNode(18, 18);
        tree.addNode(17, 17);
        tree.addNode(12, 12);
        tree.addNode(19, 19);
        tree.addNode(16, 16);
        System.out.println("Size of Tree is : "+ (new TreeSize<Integer>()).TreeSizeCalc(tree.getRoot()));
    }
}
