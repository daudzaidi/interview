package InterviewBit;

/**
 * Created by shyamsunderpandita on 12/01/17.
 *
 * Given a binary tree, determine if it is height-balanced.

 Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 Return 0 / 1 ( 0 for false, 1 for true ) for this problem

 Example :

 Input :
 1
 / \
 2   3

 Return : True or 1

 Input 2 :
 3
 /
 2
 /
 1

 Return : False or 0
 Because for the root node, left subtree has depth 2 and right subtree has depth 0.
 Difference = 2 > 1.

 */
public class IsBalancedTree {
    public int isBalanced(TreeNode a) {

        if(a == null){
            return 1;
        }

        int left = height(a.left);
        int right = height(a.right);

        if(Math.abs(left-right) == 0  ||  Math.abs(left-right) ==1){
            if (isBalanced(a.left) ==1 && isBalanced(a.right) == 1){
                return 1;
            }
        }



        return 0;
    }

    public int height (TreeNode a){
        if(a == null){
            return 0;
        }


        int left = height(a.left);
        int right = height(a.right);

        return Math.max(left,right)+1;
    }

    public static void main(String... args){
        IsBalancedTree b = new IsBalancedTree();
        TreeNode node = new TreeNode(12);
        node.left = new TreeNode(10);
        node.right = new TreeNode(30);
        node.right.left= new TreeNode(25);
        node.right.right = new TreeNode(40);
        System.out.println(b.isBalanced(node));

    }
}
