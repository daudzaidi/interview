package Amazon.Tagged;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shyamsunderpandita on 25/10/16.
 */
public class OddEvenLevelDifference {

    public static int getDifference(Node root){
        if(root == null)
            return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int level = 1;
        int oddSum = 0 ;
        int evenSum = 0;
        while(!queue.isEmpty()){
            Node pop = queue.poll();
            if(!queue.isEmpty() && pop == null){
                pop = queue.poll();
                if(!queue.isEmpty()){
                    queue.offer(null);
                }

                level = (level == 1) ? 0 : 1;
            }

            if(pop == null && queue.isEmpty())
                break;

            if(pop.left!=null)
                queue.offer(pop.left);

            if(pop.right!=null)
                queue.offer(pop.right);

            if(level == 1){
                oddSum+=pop.key;
            }
            else{
                evenSum+=pop.key;
            }
        }
        return oddSum-evenSum;
    }

    public static void main(String... args){
        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(5);
        //root.left.left = new Node(4);
        //root.left.right = new Node(5);

        System.out.println("DIFFERENVCE IS = "+getDifference(root));
    }
}
