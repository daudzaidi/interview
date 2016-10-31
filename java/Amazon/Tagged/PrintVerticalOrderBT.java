package Amazon.Tagged;

import java.util.*;

/**
 * Created by shyamsunderpandita on 25/10/16.
 */
public class PrintVerticalOrderBT {

    static Map<Node,Integer> rootDistance = new HashMap<>();
    static int hd = 0;
    public static void printVertical(Node root){
        if(root == null)
            return;
        storeDistance(root,hd);

        Map<Integer,List<Node>> map = new TreeMap<>();

        for(Node node : rootDistance.keySet()){
            if(map.containsKey(rootDistance.get(node))){
                map.get(rootDistance.get(node)).add(node);
            }
            else{
                List<Node> nodes = new ArrayList<>();
                nodes.add(node);
                map.put(rootDistance.get(node),nodes);
            }
        }

        for(Integer dist : map.keySet()){
            List<Node> nodes = map.get(dist);
            for(Node node : nodes)
                System.out.print(node.key + " ");

            System.out.println();
        }

    }

    private static void storeDistance(Node root,int dist) {
        if(root == null)
            return;

        rootDistance.put(root,dist);
        storeDistance(root.left,dist-1);
        storeDistance(root.right,dist+1);
    }

    public static void main(String... args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.right = new Node(8);
        root.right.right = new Node(7);
        root.right.right.right = new Node(9);

        printVertical(root);
    }
}
