package old.java.Trees;

import old.java.Queues.QueueImpl;

/**
 * Created by pandita on 9/2/2015.
 */
public class MaxSumLevel<T> {

    public int maxSum(Node<T> root){

        if(root==null){
            return 0;
        }

        QueueImpl<Node<T>> queue = new QueueImpl<Node<T>>(10);
        queue.enqueue(root);
        int level = 1;
        int maxSum = (Integer)root.getValue();
        queue.enqueue(null);
        int currentSum =  0;
        while (!queue.isQueueEmpty()){

            Node<T> deq = queue.dequeue();
            if(deq==null){
                if(currentSum > maxSum){
                    maxSum=currentSum;
                }
                if(!queue.isQueueEmpty()){
                    queue.enqueue(null);
                    deq=queue.dequeue();
                }
                else{
                    break;
                }
                level++;
                currentSum=0;
            }
            currentSum=currentSum+(Integer)deq.getValue();
            if(deq.getLeft()!=null){
                queue.enqueue(deq.getLeft());
            }

            if(deq.getRight()!=null){
                queue.enqueue(deq.getRight());
            }
        }
        return maxSum;
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

        MaxSumLevel<Integer> i = new MaxSumLevel<Integer>();
        System.out.println("MAX SUM : " + i.maxSum(tree.getRoot()));

    }
}
