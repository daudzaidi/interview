package InterviewBit;

import java.util.ArrayList;

/**
 * Created by shyamsunderpandita on 12/01/17.
 */
public class TwoSumBinaryTree {
    ArrayList<Integer> result = new ArrayList<>();

    public int t2Sum(TreeNode A, int B) {
        int res = 0;
        if(A.val == B){
            return 0;
        }

        inorder(A);
        int size = result.size();
        if(result.size() >=2){
            int start = 0 ;
            int end = size-1;

            while(start < end){
                int sum = result.get(start) + result.get(end);
                if (sum == B){
                    res = 1;
                    break;
                }

                if(sum < B){
                    start++;
                }
                else{
                    end--;
                }
            }
        }

        return res;
    }

    private void inorder(TreeNode A) {
        if(A == null){
            return ;
        }
        inorder(A.left);
        result.add(A.val);
        inorder(A.right);
    }

    public static void main(String... args){
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        TwoSumBinaryTree b = new TwoSumBinaryTree();

        System.out.println(b.t2Sum(node,19));

        TreeNode node2 = new TreeNode(7);
        node2.left = new TreeNode(1);
        node2.right = new TreeNode(14);
        node2.right.right = new TreeNode(20);
        System.out.println(b.t2Sum(node2,21));
        System.out.println(b.t2Sum(node2,34));
        System.out.println(b.t2Sum(node2,64));
    }
}
