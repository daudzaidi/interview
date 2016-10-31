package Amazon.Tagged;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by shyamsunderpandita on 20/10/16.
 */
public class SerializeDeserializeBinarryTree {

    List<Integer> res = new ArrayList<>();

    public List<Integer> serializeTree(Node root){
        if(root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        Node temp = root;
        queue.offer(temp);
        while(!queue.isEmpty()){
            Node dequeue = queue.poll();
            res.add(dequeue.key);
            if(dequeue.left!=null)
                queue.offer(dequeue.left);

            if(dequeue.right != null)
                queue.offer(dequeue.right);
        }

        for(Integer elem : res)
            System.out.print(elem + " ");

        return res;
    }

    public Node deserializeTree(List<Integer> arr){
        if(arr == null || arr.size() == 0 )
            return null;

        Node root = new Node(arr.get(0));
        int i = 0 ;
        int size = arr.size();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty() && i < size){

            Node temp = queue.poll();

            int l = 2*i + 1;
            int r = 2*i + 2;

            if(l < size){
                temp.left = new Node(arr.get(l));
                queue.offer(temp.left);
            }

            if(r < size){
                temp.right = new Node(arr.get(r));
                queue.offer(temp.right);
            }
            i++;
        }

        return root;
    }

    public void printInorder (Node root){
        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(root.key+" ");
        printInorder(root.right);
    }
    public static void main (String... args){
        Node tree = new Node(6);
        tree.left = new Node(3);
        tree.right = new Node(8);
        tree.left.left = new Node(1);
        tree.left.right = new Node(5);
        tree.right=new Node(8);

        SerializeDeserializeBinarryTree process = new SerializeDeserializeBinarryTree();

        System.out.println("BINARY TREE BEFORE SERIALIZING");
        process.printInorder(tree);
        System.out.println();
        System.out.println("ARRAY AFTER SERIALIZING");
        List<Integer> res = process.serializeTree(tree);
        System.out.println();
        System.out.println("BINARY TREE AFTER DESERIALIZING");
        Node r = process.deserializeTree(res);
        process.printInorder(r);

    }
}
