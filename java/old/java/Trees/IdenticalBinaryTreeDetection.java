package old.java.Trees;

/**
 * Created by pandita on 9/1/2015.
 */
public class IdenticalBinaryTreeDetection<T> {

    public boolean isIdentical(Node<T> tree1, Node<T> tree2){
        if(tree1==null && tree2==null){
            return true;
        }
        if(tree1==null || tree2==null){
            return false;
        }
        return(isIdentical(tree1.getLeft(),tree2.getLeft()) && isIdentical(tree1.getRight(),tree2.getRight()));
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

        BinaryTreeImpl<Integer> tree1 = new BinaryTreeImpl<Integer>();
        tree1.addNode(20,20);
        tree1.addNode(15,15);
        tree1.addNode(25,25);
        tree1.addNode(10,10);
        tree1.addNode(18,18);
        tree1.addNode(17,17);
        tree1.addNode(12,12);
        tree1.addNode(19, 19);
        tree1.addNode(16, 16);

       IdenticalBinaryTreeDetection<Integer> i = new IdenticalBinaryTreeDetection<Integer>();
        System.out.println("Two Trees are Identical : " + i.isIdentical(tree.getRoot(),tree1.getRoot()));

    }
}
