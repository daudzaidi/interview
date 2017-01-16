package InterviewBit;

import java.util.ArrayList;

/**
 * Created by shyamsunderpandita on 12/01/17.
 */
public class RecoverBinaryTree {

    //Solution  1 - O(N) space
    ArrayList<Integer> result = new ArrayList<Integer>();
    public ArrayList<Integer> recoverTree(TreeNode a) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        inorder(a);
        int first = 0,middle =0,end =0;
        for(int i = 0 ; i < result.size()-1 ; i++){
            if(result.get(i) > result.get(i+1)){
                if(middle == 0){
                    middle = result.get(i+1);
                    first = result.get(i);
                }
                else{
                    end = result.get(i+1);
                }
            }
        }
        if(middle!= 0 && end!=0){
            r.add(end);
            r.add(first);
        }

        if(middle!=0 && end == 0){
            r.add(middle);
            r.add(first);
        }

        return r;
    }

    public void inorder(TreeNode a){
        if(a == null){
            return;
        }
        inorder(a.left);
        result.add(a.val);
        inorder(a.right);
    }

    //Solution 2 - O(1) space
    TreeNode first;
    TreeNode second;
    TreeNode pre;

    public ArrayList<Integer> recoverTreeEfficient(TreeNode root) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        inorderEfficient(root);
        if(second!=null && first !=null){
            r.add(second.val);
            r.add(first.val);
        }
        return r;
    }



    public void inorderEfficient(TreeNode root){
        if(root==null)
            return;

        inorderEfficient(root.left);

        if(pre==null){
            pre=root;
        }else{
            if(root.val<pre.val){
                if(first==null){
                    first=pre;
                }

                second=root;
            }
            pre=root;
        }

        inorderEfficient(root.right);
    }

    public static void main(String... args){
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        RecoverBinaryTree r = new RecoverBinaryTree();
        System.out.println(r.recoverTree(node));
        System.out.println(r.recoverTreeEfficient(node));
    }
}
