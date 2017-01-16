package InterviewBit;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by shyamsunderpandita on 13/01/17.
 */
public class ZigZagTraversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(a!=null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(a);
            int dir = 0;
            while(!stack.isEmpty()){

                ArrayList<Integer> arr = new ArrayList<>();
                Stack<TreeNode> stackTemp = new Stack<>();

                while(!stack.isEmpty()){
                    TreeNode tmp = stack.pop();
                    arr.add(tmp.val);
                    if(dir == 0){
                        if(tmp.left!=null){
                            stackTemp.push(tmp.left);
                        }

                        if(tmp.right != null){
                            stackTemp.push(tmp.right);
                        }
                    }
                    else{

                        if(tmp.right != null){
                            stackTemp.push(tmp.right);
                        }

                        if(tmp.left!=null){
                            stackTemp.push(tmp.left);
                        }
                    }
                }

                dir = (dir == 0) ? 1 : 0;
                result.add(new ArrayList<>(arr));
                stack = stackTemp;
            }
        }

        return result;
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

        ZigZagTraversal z = new ZigZagTraversal();
        System.out.println(z.zigzagLevelOrder(node));
    }
}
