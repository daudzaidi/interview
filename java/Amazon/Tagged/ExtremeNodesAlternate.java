package Amazon.Tagged;

/**
 * Created by shyamsunderpandita on 18/10/16.
 */
public class ExtremeNodesAlternate {

    private static void print(TreeNode root) {
        int counter = 1;
        System.out.print(root.val);
        printRecursive(root, true, counter);

        // for opposite direction
        //System.out.print(root.val);
       // printRecursive(root, false, counter);
    }

    private static void printRecursive(TreeNode root, boolean bool, int counter) {
        TreeNode print = root;
        if (bool) {
            for (int i = 0; i < counter; i++) {
                print = print.left;
            }
            System.out.print(" " + print.val);
            if (print.left != null) {
                counter++;
                printRecursive(root, !bool, counter);
            } else {
                //System.out.println();
            }

        } else {
            for (int i = 0; i < counter; i++) {
                print = print.right;
            }
            System.out.print(" " + print.val);
            if (print.right != null) {
                counter++;
                printRecursive(root, !bool, counter);
            } else {
               // System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);

        root.left.left.left.left = new TreeNode(16);
        root.left.left.left.right = new TreeNode(17);
        root.right.right.right.right = new TreeNode(31);
        print(root);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


