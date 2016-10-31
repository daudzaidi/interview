package old.java.Trees;

import old.java.Queues.QueueImpl;

/**
 * Created by pandita on 9/1/2015.
 */
public class HeightOfTree<T> {

    public int height(Node<T> root){
        if(root==null){
            return 0;
        }

        int left = height(root.getLeft());
        int right = height(root.getRight());
        if(left > right){
            return left +1;
        }
        else{
            return right+1;
        }
    }

    public int heightIterative(Node<T> root){
        QueueImpl<Node<T>> queue = new QueueImpl<Node<T>>(10);
        if(root==null){
            return 0;
        }
        queue.enqueue(root);
        //Completion of first level
        Node<T> tmp = root;
        queue.enqueue(null);
        int level= 1;
        while(!queue.isQueueEmpty()){
            Node<T> deq = queue.dequeue();
            if(deq==null){
                if(!queue.isQueueEmpty()){
                    queue.enqueue(null);
                }
                level++;
            }
            else
            {
                if(deq.getLeft()!=null){
                    queue.enqueue(deq.getLeft());
                }
                if(deq.getRight()!=null){
                    queue.enqueue(deq.getRight());
                }

            }
        }
return level;
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
        HeightOfTree<Integer> height = new HeightOfTree<Integer>();
        int h = height.height(tree.getRoot());
        System.out.println("HEIGHT: "+ h);
        h = height.heightIterative(tree.getRoot())-1;
        System.out.println("HEIGHT: "+ h);

    }
}
