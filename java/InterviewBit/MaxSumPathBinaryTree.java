package InterviewBit;

import java.util.ArrayList;

/**
 * Created by shyamsunderpandita on 16/01/17.
 */
public class MaxSumPathBinaryTree {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode a) {
        if(a!=null) {
            sumInPath(a);
        }
        return maxSum;
    }

    private int sumInPath(TreeNode a){
        if(a == null){
            return 0;
        }

        int sum1 = sumInPath(a.left);
        int sum2 = sumInPath(a.right);
        int sum3 = a.val;
        int sum4 = Math.max(Math.max(sum1,sum2) + sum3,sum3);
        int sum5 = Math.max(sum4,sum1+sum2+sum3);

        maxSum = Math.max(maxSum,sum5);

        return sum4;

    }

    public static void main(String... args){
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(20);
        node.left.right = new TreeNode(1);
        node.right = new TreeNode(10);
        node.right.right = new TreeNode(-25);
        node.right.right.right = new TreeNode(4);
        node.right.right.left = new TreeNode(3);

        MaxSumPathBinaryTree sum = new MaxSumPathBinaryTree();
        System.out.println(sum.maxPathSum(node));
    }
}
