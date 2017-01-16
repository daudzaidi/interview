package InterviewBit;

/**
 * Created by shyamsunderpandita on 12/01/17.
 */
public class IsSymmetricTree {
    public int isSymmetric(TreeNode a) {
        return isMirror(a,a);
    }

    public int isMirror (TreeNode n1, TreeNode n2){
        if (n1 == null && n2 == null){
            return 1;
        }

        if(n1!=null && n2!=null && n1.val == n2.val){
            int l = isMirror(n1.left,n2.right);
            int r = isMirror(n1.right,n2.left);

            if(l == 1 && r == 1){
                return 1;
            }

        }
        return 0;
    }

    public static void main(String... args){
        IsSymmetricTree b = new IsSymmetricTree();
        TreeNode node = new TreeNode(12);
        node.left = new TreeNode(10);
        node.right = new TreeNode(30);
        node.right.left= new TreeNode(25);
        node.right.right = new TreeNode(40);
        System.out.println(b.isSymmetric(node));

    }
}
