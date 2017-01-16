package InterviewBit;

import java.util.ArrayList;

/**
 * Created by shyamsunderpandita on 13/01/17.
 */
public class RootToLeafPathSum {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {

        checkSum(root,sum,new ArrayList<Integer>());
        return result;
    }

    public void checkSum(TreeNode a , int b, ArrayList<Integer> temp){
        if(a == null){
            return;
        }

        temp.add(a.val);
        b = b - a.val;
        if(a.left == null && a.right == null){
            if(b == 0){
                result.add(new ArrayList<Integer>(temp));

            }
        }
        else{
            checkSum(a.left,b,new ArrayList<Integer>(temp));
            checkSum(a.right,b,new ArrayList<Integer>(temp));
        }
    }

    public static void main(String... args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.right.right.right = new TreeNode(1);
        node.right.right.left = new TreeNode(5);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        RootToLeafPathSum r = new RootToLeafPathSum();
        System.out.println(r.pathSum(node,22));
    }
}
