package DocPractice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shalvi on 28/05/16.
 */
public class isBinarySearchTree<T> {

    public boolean isBST(node<T> root){
        if(root == null) return true;
        if(root.getRight() == null && root.getLeft() == null) return true;
        if(root.getLeft()!= null && root.getLeft().getKey() > root.getKey()){
           return false;
        }
        if(root.getRight()!=null && root.getRight().getKey() < root.getKey()){
            return false;
        }
        return (isBST(root.getLeft()) && isBST(root.getRight()));
    }

    public boolean isValidBST(node root) {
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public boolean isValidBST(node p, double min, double max){
        if(p==null)
            return true;

        if(p.getKey() <= min || p.getKey() >= max)
            return false;

        return isValidBST(p.getLeft(), min, p.getKey()) && isValidBST(p.getRight(), p.getKey(), max);
    }


    private node<T> root;

    private node<T> createNewNode(int key, T value){
        node<T> nd = new node<T>();
        nd.setValue(value);
        nd.setKey(key);
        return nd;
    }
    public void addNode(int key , T value){
        node<T> nd = createNewNode(key,value);
        if(root==null){
            root=nd;
        }
        else {
            addNodeAtPos(key,nd);
        }
    }

    private void addNodeAtPos(int key, node<T> nd){
        node<T> parent;
        node<T>tmp = root;
        while(true){
            parent=tmp;
            if(tmp.getKey()>=key){
                tmp=tmp.getLeft();
                if(tmp==null){
                    parent.setLeft(nd);
                    break;
                }
            }
            else{
                tmp=tmp.getRight();
                if(tmp==null){
                    parent.setRight(nd);
                    break;
                }
            }
        }
    }
    /* INORDER : LEFT -> ROOT -> RIGHT */
    public void inOrderRecursive(node<T> root){
        if(root==null){
            return;
        }
        inOrderRecursive(root.getLeft());
        System.out.println(root.getValue());
        inOrderRecursive(root.getRight());
    }

    public boolean isvalidBSTIterative(node root){
        if(root == null)
            return true;
        LinkedList<nodeM> queueList = new LinkedList<nodeM>();
        queueList.add(new nodeM(root,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY));
        while (!queueList.isEmpty()){
            nodeM temp = queueList.poll();
            if(temp!=null) {
                if (temp.node.getKey() < temp.left || temp.node.getKey() > temp.right) return false;
                if (temp.node.getLeft() != null) {
                    queueList.add(new nodeM(temp.node.getLeft(), temp.left, temp.node.getKey()));
                }
                if (temp.node.getRight() != null)
                    queueList.add(new nodeM(temp.node.getRight(), temp.node.getKey(), temp.right));
            }
        }
        return true;
    }

    class nodeM{
        node node;
        double left;
        double right;
        public nodeM(node n, double left, double right){
            this.node = n;
            this.left = left;
            this.right = right;
        }
    }

    boolean isBSTInorder(node node)
    {
        // traverse the tree in inorder fashion and
        // keep a track of previous node
        node prev = null;
        if (node != null)
        {
            if (!isBST(node.getLeft()))
                return false;

            // allows only distinct values node
            if (prev != null && node.getKey() <= prev.getKey() )
                return false;
            prev = node;

            return isBST(node.getRight());
        }
        return true;
    }


    public static void main(String args[]) {
        isBinarySearchTree<Integer> tree = new isBinarySearchTree<Integer>();
        tree.addNode(20, 20);
        tree.addNode(15, 15);
        tree.addNode(25, 25);
        tree.addNode(10, 10);
        tree.addNode(18, 18);
        tree.addNode(17, 17);
        tree.addNode(12, 12);
        tree.addNode(19, 19);
        tree.addNode(16, 16);

        tree.inOrderRecursive(tree.root);
        System.out.println("Is Binary Tress a BST ? Wrong Way---> "+tree.isBST(tree.root));
        System.out.println("Is Binary Tress a BST ? Correct way ---> "+tree.isValidBST(tree.root));
        System.out.println("Is Binary Tress a BST ? Ierative Way ---> "+tree.isvalidBSTIterative(tree.root));
        System.out.println("Is Binary Tress a BST ? Inorder Way ---> "+tree.isBSTInorder(tree.root));

        isBinarySearchTree<Integer> tree2 = new isBinarySearchTree<Integer>();
        node<Integer> r = new node<>();
        r.setValue(3);
        node<Integer> r1 = new node<>();
        r1.setValue(2);
        node<Integer> r2 = new node<>();
        r2.setValue(1);
        node<Integer> r3 = new node<>();
        r3.setValue(4);
        node<Integer> r4 = new node<>();
        r4.setValue(5);
        tree2.root=r;

        tree2.root.setLeft(r1);
        tree2.root.setRight(r4);
        tree2.root.getLeft().setLeft(r2);
        tree2.root.getLeft().setRight(r3);

        System.out.println("False case : ======>>>");
        tree2.inOrderRecursive(tree2.root);
        System.out.println("Is Binary Tress a BST ? Wrog way ---> "+tree2.isBST(tree2.root));
        System.out.println("Is Binary Tress a BST ? Correct way ---> "+tree2.isValidBST(tree2.root));
        System.out.println("Is Binary Tress a BST ? Ierative Way ---> "+tree2.isvalidBSTIterative(tree.root));
        System.out.println("Is Binary Tress a BST ? Inorder Way ---> "+tree.isBSTInorder(tree.root));

    }
    }

