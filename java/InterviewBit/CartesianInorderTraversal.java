package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shyamsunderpandita on 13/01/17.
 */
public class CartesianInorderTraversal {
    public TreeNode buildTree(ArrayList<Integer> a) {
        return buildTree (a,0,a.size()-1);
    }

    public TreeNode buildTree(ArrayList<Integer> a, int start, int end) {
        if(start > end){
            return null;
        }

        int index = getLargestNumberIndex(a,start,end);
        TreeNode root = new TreeNode(a.get(index));

        root.left = buildTree(a,start,index-1);
        root.right = buildTree(a,index+1,end);
        return root;
    }

    public int getLargestNumberIndex(ArrayList<Integer> a, int start, int end){

        ArrayList<Integer> ar = new ArrayList<Integer>();
        for(int i = start ; i <=end ; i++){
            ar.add(a.get(i));
        }
        Collections.sort(ar);
        return a.indexOf(ar.get(ar.size()-1));
    }

    public static void main(String... args){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        CartesianInorderTraversal c = new CartesianInorderTraversal();
        TreeNode n = c.buildTree(a);
        preOrder(n);
    }

    private static void preOrder(TreeNode n) {
        if(n == null){
            return;
        }

        System.out.println(n.val);
        preOrder(n.left);
        preOrder(n.right);
    }
}
