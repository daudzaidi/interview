package Amazon.RecentQuestions;

/**
 * Created by shyamsunderpandita on 03/01/17.
 */
public class LeftViewBinaryTree {
    static Node root;
    static int max_level = 0 ;

    public static void printLeftView(Node node, int level){
        if(node == null)
            return;;

        if(level > max_level){
            System.out.println(node.data);
            max_level = level;
        }

        printLeftView(node.left,level+1);
        printLeftView(node.right,level+1);
    }

    public static void leftViewUtil(){
        printLeftView(root,1);
    }

    public static void main(String... args){
        Node node = new Node(12);
        root = node;
        node.left = new Node(10);
        node.right = new Node(30);
        node.right.left= new Node(25);
        node.right.right = new Node(40);

        leftViewUtil();
    }
}

class Node{
    int data;
    Node left;
    Node right;
    public Node(int val){
        data = val;
    }
}
