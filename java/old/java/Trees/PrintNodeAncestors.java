package old.java.Trees;

/**
 * Created by pandita on 9/5/2015.
 */
public class PrintNodeAncestors<T> {

    public void PrintAncestors(Node<T> node, Node<T> root){
    if(node.getValue() == root.getValue()){
        System.out.println(node.getValue());
        return;
    }
        Node<T> tmp = root;
        if(tmp.getKey()>node.getKey()){
            System.out.println(tmp.getValue());
            PrintAncestors(node, tmp.getLeft());
        }
        else{
            System.out.println(tmp.getValue());
            PrintAncestors(node,tmp.getRight());
        }

    }

    public Node<T> LeastCommonAncestor(Node<T> node1, Node<T>node2, Node<T>root){
        if(root==null)
            return null;

        if(root.getKey()==node1.getKey() || root.getKey()==node2.getKey()){
            return root;
        }

        if((node1.getKey()>root.getKey() && node2.getKey()<node1.getKey()) ||(node1.getKey()<root.getKey() && node2.getKey() > root.getKey()) ){
            return root;
        }
        else if(node1.getKey()<root.getKey() && node2.getKey()<root.getKey()){
           return LeastCommonAncestor(node1,node2,root.getLeft());
        }
        else{
            return LeastCommonAncestor(node1,node2,root.getRight());
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
        tree.addNode(19, 19);
        tree.addNode(16, 16);
        PrintNodeAncestors<Integer> p = new PrintNodeAncestors<Integer>();
        ElementSearch<Integer> search = new ElementSearch<Integer>();
        Node<Integer> val = search.SearchValue(tree.getRoot(), 16);
        if(val!=null){
            p.PrintAncestors(val,tree.getRoot());
        }
        else{
            System.out.println("ELEMENT Is Not Present:");
        }

        Node<Integer> val1 = search.SearchValue(tree.getRoot(), 25);
        Node<Integer> val2 = search.SearchValue(tree.getRoot(), 12);
        Node<Integer>res=p.LeastCommonAncestor(val1,val2,tree.getRoot());
        System.out.println("Least Common Ancestor: "+res.getValue());
    }
}
