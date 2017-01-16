package InterviewBit;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by shyamsunderpandita on 12/01/17.
 */
public class GetSuccessorInTree {




    public TreeNode getSuccessor(TreeNode a, int b) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = a;

        while(!stack.isEmpty() || tmp !=null){
            if(tmp!=null){
                stack.push(tmp);
                tmp = tmp.left;
            }
            else{
                TreeNode pop = stack.pop();
                result.add(pop);
                tmp = pop.right;
            }
        }

        int i;
        for(i =0 ; i < result.size() ; i++){
            if(result.get(i).val == b){
                break;
            }
        }

        if(i < result.size()-1){
            return result.get(i+1);
        }

        return null;
    }

    public static void main(String... args){
        GetSuccessorInTree g = new GetSuccessorInTree();
        TreeNode node = new TreeNode(12);
        node.left = new TreeNode(10);
        node.right = new TreeNode(30);
        node.right.left= new TreeNode(25);
        node.right.right = new TreeNode(40);
        System.out.println(g.getSuccessor(node,25).val);
        System.out.println(g.getSuccessor(node,40));
        System.out.println(g.getSuccessor(node,30).val);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}