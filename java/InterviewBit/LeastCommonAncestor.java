package InterviewBit;

import java.util.ArrayList;

/**
 * Created by shyamsunderpandita on 12/01/17.
 * Find the lowest common ancestor in an unordered binary tree given two values in the tree.

 Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.
 Example :


 _______3______
 /              \
 ___5__          ___1__
 /      \        /      \
 6      _2_     0        8
        /   \
        7    4
 For the above tree, the LCA of nodes 5 and 1 is 3.

 LCA = Lowest common ancestor
 Please note that LCA for nodes 5 and 4 is 5.

 You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
 No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
 There are no duplicate values.
 You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.
 See Expected Output

 */
public class LeastCommonAncestor {


    public int lca(TreeNode a, int val1, int val2) {

        if(isPresent(a,val1) && isPresent(a,val2)){
            return lca(a,val1,val2,true);
        }

        return -1;
    }

    public int lca(TreeNode a, int val1, int val2, boolean isPresent){

        if(a==null)
            return -1;

        if(a.val==val1 || a.val == val2){
            return a.val;
        }

        int l = lca(a.left, val1, val2,isPresent);
        int r = lca(a.right, val1, val2,isPresent);

        if(l!=-1&&r!=-1){
            return a.val;
        }else if(l==-1&&r==-1){
            return -1;
        }else{
            return l==-1?r:l;
        }
    }
    private boolean isPresent(TreeNode root, int x) {
        if (root != null) {

            // check if current node has the element we are looking for
            if (root.val == x) {
                return true;
            } else {
                // check if the sub trees
                return isPresent(root.left, x) || isPresent(root.right, x);
            }
        }
        return false;

    }


    public static void main(String... args){
        LeastCommonAncestor lca = new LeastCommonAncestor();
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(5);
        node.right = new TreeNode(1);
        node.right.left= new TreeNode(0);
        node.right.right = new TreeNode(8);
        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(2);
        node.left.right.left = new TreeNode(7);
        node.left.right.right = new TreeNode(4);
        System.out.println(lca.lca(node,5,1));
        System.out.println(lca.lca(node,7,4));
        System.out.println(lca.lca(node,5,4));
        System.out.println(lca.lca(node,6,2));
        System.out.println(lca.lca(node,6,20));

    }

}
