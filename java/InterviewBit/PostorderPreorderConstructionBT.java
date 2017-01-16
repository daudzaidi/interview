package InterviewBit;

import java.util.ArrayList;

/**
 * Created by shyamsunderpandita on 13/01/17.
 */
public class PostorderPreorderConstructionBT {
    int count = 0;

    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        if(postorder == null || inorder == null || postorder.size() == 0 || inorder.size() == 0){
            return null;
        }

        if(postorder.size()!=inorder.size()){
            return null;
        }

        count = postorder.size()-1;
        TreeNode r = buildTree(postorder,inorder,0,inorder.size()-1);
        return r;
    }


    public TreeNode buildTree(ArrayList<Integer> postorder, ArrayList<Integer> inorder, int start, int end) {
        if(start > end || count< 0){
            return null;
        }

        int r = postorder.get(count);
        count--;

        int i = start;

        for (; i <= end; i++) {
            if (inorder.get(i).intValue() == r)
                break;
        }

        TreeNode root = new TreeNode(r);

        root.right = buildTree(postorder,inorder,i+1,end);
        root.left = buildTree(postorder,inorder,start,i-1);

        return root;
    }

    public static void main(String... args){
        PostorderPreorderConstructionBT o = new PostorderPreorderConstructionBT();

        ArrayList<Integer> postorder = new ArrayList<>();
        postorder.add(2);
        postorder.add(3);
        postorder.add(1);

        ArrayList<Integer> inorder = new ArrayList<>();
        inorder.add(2);
        inorder.add(1);
        inorder.add(3);

        o.buildTree(inorder,postorder);
    }
}
