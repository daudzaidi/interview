package InterviewBit;

/**
 * Created by shyamsunderpandita on 13/01/17.
 */
public class HasSumInPathTree {
    int hasSumInPath = 0;
    public int hasPathSum(TreeNode a, int b) {
        checkSum(a,b);
        return hasSumInPath;
    }

    public void checkSum(TreeNode a , int b){
        if(a == null){
            return;
        }

        b = b - a.val;
        if(a.left == null && a.right == null){
            if(b == 0){
                hasSumInPath = 1;
            }
        }
        else{
            checkSum(a.left,b);
            checkSum(a.right,b);
        }
    }

    public static void main(String... args){
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.right.left= new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.right.right.right = new TreeNode(1);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);

        HasSumInPathTree h = new HasSumInPathTree();
        System.out.println(h.hasPathSum(node,22));
    }
}
