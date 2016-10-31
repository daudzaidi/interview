package old.java.Trees;

/**
 * Created by pandita on 9/1/2015.
 */
public class DeleteTree<T> {

    public Node<T> deleteTree(Node<T> root){
        if(root==null){
            return null;
        }

        deleteTree(root.getLeft());
        deleteTree(root.getRight());
        root=null;
        return root;
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
        DeleteTree<Integer> del = new DeleteTree<Integer>();
        Node<Integer> newTree = del.deleteTree(tree.getRoot());
        System.out.println("PREORDER TRAVERSAL:");
        tree.preOrderRecursive(newTree);

    }
}
