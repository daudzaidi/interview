package Amazon.Set2;

import java.util.Stack;

/**
 * Created by pandita on 8/31/2015.
 */
public class BinaryTreeImpl<T> {
    public Node<T> getRoot() {
        return root;
    }

    private Node<T> root;

    private Node<T> createNewNode(int key, T value){
        Node<T> nd = new Node<T>();
        nd.setValue(value);
        nd.setKey(key);
        return nd;
    }
    public void addNode(int key , T value){
        Node<T> nd = createNewNode(key,value);
        if(root==null){
            root=nd;
        }
        else {
            addNodeAtPos(key,nd);
        }
    }

    private void addNodeAtPos(int key, Node<T> nd){
        Node<T> parent;
        Node<T>tmp = root;
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

    /* PREORDER : ROOT -> LEFT -> RIGHT */
    public void preOrderRecursive(Node<T> root){
    if(root==null){
        System.out.println("No tree present !!");
        return;
    }
        System.out.println(root.getValue());
        preOrderRecursive(root.getLeft());
        preOrderRecursive(root.getRight());
    }


    /* INORDER : LEFT -> ROOT -> RIGHT */
    public void inOrderRecursive(Node<T> root){
        if(root==null){
            return;
        }
        inOrderRecursive(root.getLeft());
        System.out.println(root.getValue());
        inOrderRecursive(root.getRight());
    }


    /* PREORDER : LEFT -> RIGHT -> ROOT*/
    public void postOrderRecursive(Node<T> root){
        if(root==null){
            return;
        }
        postOrderRecursive(root.getLeft());
        postOrderRecursive(root.getRight());
        System.out.println(root.getValue());
    }

    public void preOrderIterative(Node<T> root){
        Stack<Node<T>> stack = new Stack<Node<T>>();
        Node<T> tmp = root;
        stack.push(tmp);
        while(!stack.isEmpty() && tmp!=null){
            System.out.println(stack.pop().getValue());
            if(tmp.getRight()!=null){
                stack.push(tmp.getRight());
            }
            if(tmp.getLeft()!=null){
                stack.push(tmp.getLeft());
                tmp=tmp.getLeft();
            }
            else if(tmp.getRight()!=null){
                tmp=tmp.getRight();
            }
            else{
                if(!stack.isEmpty()){
                    tmp=stack.peek();
                }
            }
        }

    }

    public void inOrderIterative(Node<T> root){
        Stack<Node<T>> stack = new Stack<Node<T>>();
        Node<T> tmp = root;
        if(tmp==null){
            System.out.println("No Tree Present");
            return;
        }
        while(!stack.isEmpty() || tmp!=null){
            if(tmp!=null) {
                stack.push(tmp);
                tmp = tmp.getLeft();
            }
            else{
                Node<T> n = stack.pop();
                System.out.println(n.getValue());
                tmp=n.getRight();
            }
        }
    }

    public void postOrderIterative(Node<T> root){
        Stack<Node<T>> stack1 = new Stack<Node<T>>();
        Stack<Node<T>> stack2 = new Stack<Node<T>>();
        Node<T> tmp = root;
        stack1.push(tmp);
        while(!stack1.isEmpty()){
            Node<T> n1 = stack1.pop();
            stack2.push(n1);
            if(n1.getLeft()!=null){
                stack1.push(n1.getLeft());
            }
            if(n1.getRight()!=null){
                stack1.push(n1.getRight());
            }
        }
        while(!stack2.isEmpty()){
            System.out.println(stack2.pop().getValue());
        }
    }

    private void deleteCaseA(Node<T> tmp, Node<T> parent) {
       if(parent.getLeft()==tmp){
           parent.setLeft(null);
       }
        else{
           parent.setRight(null);
       }
    }

    private void deleteCaseB(Node<T> tmp, Node<T> parent, boolean left) {
        if(left){
            if(parent.getRight()==tmp){
                parent.setRight(tmp.getLeft());
            }
            else{
                parent.setLeft(tmp.getLeft());
            }
        }
        else{
            if(parent.getRight()==tmp){
                parent.setRight(tmp.getRight());
            }
            else{
                parent.setLeft(tmp.getRight());
            }
        }
    }

    private void deleteCaseC(Node<T> tmp, Node<T> parent) {
        Node<T> inorderSuccessor = findSuccessor(tmp);
            if(parent.getLeft()==tmp){
                parent.setLeft(inorderSuccessor);
            }
            else{
                parent.setRight(inorderSuccessor);
            }

            inorderSuccessor.setRight(tmp.getRight());
            inorderSuccessor.setLeft(tmp.getLeft());
            tmp=null;
        }


    private Node<T> findSuccessor(Node<T> tmp) {
        Node<T> parent=null;
        if (tmp.getRight() == null) {
            return null;
        }
        else{
            tmp=tmp.getRight();
            while( tmp.getLeft()!=null){
                parent=tmp;
                tmp=tmp.getLeft();
            }
            if(parent.getRight()==tmp){
                parent.setRight(null);
            }
            else{
                parent.setLeft(null);
            }
        }
        return tmp;
    }

    public void deleteNode(int key, T value){
        Node<T> tmp = root;
        if(tmp==null){
            System.out.println("No tree Present. Cannot Delete");
            return;
        }
        Node<T> parent = tmp;
        while(tmp!=null){

            if(tmp.getKey() > key){
                parent=tmp;
                tmp=tmp.getLeft();
            }
            else{
                parent=tmp;
                tmp=tmp.getRight();
            }
            if(tmp==null){
                System.out.println("No Node Present. Cannot Delete");
                return;
            }
            //CASE A: Node to be deleted is a leaf node
            if(tmp.getKey()==key && tmp.getRight()==null && tmp.getLeft()==null){
                deleteCaseA(tmp,parent);
                break;
            }
            //CASE B : Node to be deleted has either a left side NULL
            else if(tmp.getKey()==key && tmp.getRight()!=null && tmp.getLeft()==null){
                deleteCaseB(tmp, parent, false);
                break;
            }
            //CASE B : Node to be deleted has either a right side NULL
            else if (tmp.getKey()==key && tmp.getRight()==null && tmp.getLeft()!=null){
                deleteCaseB(tmp, parent, true);
                break;
            }
            //CASE C : Node to be deleted has no null children
            else if(tmp.getKey()==key && tmp.getRight()!=null && tmp.getLeft()!=null){
                deleteCaseC(tmp, parent);
                break;
            }

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
        tree.addNode(19,19);
        tree.addNode(16,16);

        System.out.println("LEVELORDER TRAVERSAL:");


        System.out.println("PREORDER TRAVERSAL:");
        tree.preOrderRecursive(tree.getRoot());
        System.out.println("INORDER TRAVERSAL:");
        tree.inOrderRecursive(tree.getRoot());
        System.out.println("POSTORDER TRAVERSAL:");
        tree.postOrderRecursive(tree.getRoot());
        System.out.println("PREORDER ITERATIVE TRAVERSAL:");
        tree.preOrderIterative(tree.getRoot());
        System.out.println("POSTORDER ITERATIVE TRAVERSAL:");
        tree.postOrderIterative(tree.getRoot());
        System.out.println("INORDER ITERATIVE TRAVERSAL:");
        tree.inOrderIterative(tree.getRoot());

        //CASE C
        tree.deleteNode(15,15);
        System.out.println("INORDER TRAVERSAL After deletion:");
        tree.inOrderRecursive(tree.getRoot());

        //CASE A
        tree.deleteNode(17,17);
        System.out.println("INORDER TRAVERSAL After deletion:");
        tree.inOrderRecursive(tree.getRoot());

        //CASE B
        tree.deleteNode(10,10);
        System.out.println("INORDER TRAVERSAL After deletion:");
        tree.inOrderRecursive(tree.getRoot());
    }


}
