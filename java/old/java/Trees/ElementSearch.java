package old.java.Trees;

/**
 * Created by pandita on 9/1/2015.
 */
public class ElementSearch<T> {

    public Node<T> SearchValue(Node<T> root,int key){
        if(root==null)
            return null;
        if(root.getKey()==key){
            return root;
        }

        Node<T>left = SearchValue(root.getLeft(),key);
        if(left==null){
            Node<T>right =SearchValue(root.getRight(),key);
            if(right!=null){
                return right;
            }
        }
        else {
            return left;
        }
        return null;
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
        ElementSearch<Integer> search = new ElementSearch<Integer>();
        Node<Integer> val = search.SearchValue(tree.getRoot(),18);
        if(val!=null){
            System.out.println("ELEMENT Is Present:");
        }
        else{
            System.out.println("ELEMENT Is Not Present:");
        }

    }
}
