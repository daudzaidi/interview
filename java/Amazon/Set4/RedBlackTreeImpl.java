package Amazon.Set4;

/**
 * Created by shalvi on 04/07/16.
 */
public class RedBlackTreeImpl {
}

class RedBlackTreeNode{

    public static final int BLACK = 0;
    public static final int RED = 1;

    int key;
    RedBlackTreeNode parent;
    RedBlackTreeNode left;
    RedBlackTreeNode right;
    int numLeft = 0;
    int numRight = 0;
    int color;

    RedBlackTreeNode(){
        color = BLACK;
        numLeft = 0;
        numRight = 0;
        parent = null;
        left = null;
        right = null;
    }

    RedBlackTreeNode(int key){
        this.key = key;
    }



}
