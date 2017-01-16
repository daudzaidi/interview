package InterviewBit;

import java.util.ArrayList;

/**
 * Created by shyamsunderpandita on 13/01/17.
 */
public class SumRootToLeafNumbers {
    private static final int MOD = 1003;

    public int sumNumbers(TreeNode A) {

        return sum(A, 0) % MOD;

    }

    public int sum(TreeNode node, int num) {

        if (node == null)
            return 0;

        if (node.left == null && node.right == null) {
            int newNum = num * 10 + node.val;
            newNum %= MOD;
            return newNum;
        }

        num = num * 10 + node.val;
        num %= MOD;

        int leftSum = sum(node.left, num);
        int rightSum = sum(node.right, num);

        return (leftSum + rightSum) % MOD;

    }

    public static void main(String... args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(1);
/*        node.right = new TreeNode(8);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.right.right.right = new TreeNode(1);*/
       /* node.right.right.left = new TreeNode(5);*/
        node.left.left = new TreeNode(2);
       /* node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);*/
        SumRootToLeafNumbers r = new SumRootToLeafNumbers();
        System.out.println(r.sumNumbers(node));
    }
}
