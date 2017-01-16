package InterviewBit;

/**
 * Created by shyamsunderpandita on 13/01/17.
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right== null)){
            return root;
        }

        invert(root);
        return root;
    }

    public void invert(TreeNode node1){
        if(node1 == null){
            return;
        }

        TreeNode temp = node1.left;
        node1.left = node1.right;
        node1.right = temp;

        if(node1.left!=null){
            invert(node1.left);
        }

        if(node1.right!=null){
            invert(node1.right);
        }

    }

    public static void main(String... args){
        TreeNode node = new TreeNode(12);
        node.left = new TreeNode(10);
        node.right = new TreeNode(30);
        node.right.left= new TreeNode(25);
        node.right.right = new TreeNode(40);

        InvertTree t = new InvertTree();
        t.invertTree(node);
    }
}
