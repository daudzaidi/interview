package old.java.Trees;

import java.util.Stack;

/**
 * Created by pandita on 9/6/2015.
 */
public class ZigZagTraversal<T> {

    public void ZigZagTraversalImpl(Node<T> root){
        if(root==null)
            return;
        Stack<Node<T>> stack  = new Stack<Node<T>>();
        stack.push(root);
        boolean directionFlag=false;
        while(!stack.isEmpty()){
            Stack<Node<T>> stackTemp  = new Stack<Node<T>>();
            while(!stack.isEmpty()){
                Node<T> tmp = stack.pop();
                System.out.println(tmp.getValue());
                if(!directionFlag){
                    if(tmp.getLeft()!=null)
                        stackTemp.push(tmp.getLeft());
                    if(tmp.getRight()!=null)
                        stackTemp.push(tmp.getRight());
                }
                else{
                    if(tmp.getRight()!=null)
                        stackTemp.push(tmp.getRight());
                    if(tmp.getLeft()!=null)
                        stackTemp.push(tmp.getLeft());
                }
            }
            directionFlag=!directionFlag;
            stack=stackTemp;
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
        ZigZagTraversal<Integer> trav = new ZigZagTraversal<Integer>();
        trav.ZigZagTraversalImpl(tree.getRoot());
    }
}
