package old.java.Trees;

/**
 * Created by pandita on 9/3/2015.
 */
public class MirrorTree<T> {

    Node<T> mirrorRoot;
    public Node<T> createMirror(Node<T> root){
        if(root==null)
            return null;
        createMirror(root.getLeft());
        createMirror(root.getRight());
        mirrorRoot=root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(mirrorRoot);
        return root;
    }

    public boolean checkMirror(Node<T> root1, Node<T> root2){
        if(root1==null && root2==null)
            return true;


        if(root1==null || root2==null)
            return false;

        else
            return (root1.getValue()==root2.getValue() && checkMirror(root1.getLeft(),root2.getRight()) && checkMirror(root1.getRight(),root2.getLeft()));
    }

    /* PREORDER : ROOT -> LEFT -> RIGHT */
    public void preOrderRecursive(Node<T> root){
        if(root==null){
            //System.out.println("No tree present !!");
            return;
        }
        System.out.println(root.getValue());
        preOrderRecursive(root.getLeft());
        preOrderRecursive(root.getRight());
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
        MirrorTree<Integer> mirr = new MirrorTree<Integer>();
        Node<Integer> mirror = mirr.createMirror(tree.getRoot());
        mirr.preOrderRecursive(mirror);

        BinaryTreeImpl<Integer> tree2 = new BinaryTreeImpl<Integer>();
        tree2.addNode(20,20);
        tree2.addNode(15,15);
        tree2.addNode(25,25);
        tree2.addNode(10,10);
        tree2.addNode(18,18);
        tree2.addNode(17,17);
        tree2.addNode(12,12);
        tree2.addNode(19, 19);
        tree2.addNode(16, 16);

        System.out.println("The trees are mirrors of each other : "+ mirr.checkMirror(tree2.getRoot(),mirror));
    }
}
