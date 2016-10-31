package old.java.Trees;

/**
 * Created by pandita on 9/3/2015.
 */
public class SumOfAllElements<T> {

    public int sumElements(Node<T> root){
        if(root==null){
            return 0;
        }
        return ((Integer)root.getValue() + sumElements(root.getRight())+ sumElements(root.getLeft()));
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
        SumOfAllElements<Integer> sum = new SumOfAllElements<Integer>();
        System.out.println("Sum of all elements is : "+ sum.sumElements(tree.getRoot()));
    }
}
