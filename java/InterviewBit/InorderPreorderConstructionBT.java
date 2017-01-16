package InterviewBit;

import java.util.ArrayList;

/**
 * Created by shyamsunderpandita on 13/01/17.
 */
public class InorderPreorderConstructionBT {
    public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
        if (preorder == null || inorder == null || preorder.size() == 0 || inorder.size() == 0)
            return null;

        if (preorder.size() != inorder.size())
            return null;

        TreeNode r = buildTree(preorder,inorder,0,inorder.size()-1);
        return r;
    }

    int count = 0;
    public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder, int start, int end) {
        if(start > end || count >= preorder.size()){
            return null;
        }

        int r = preorder.get(count);
        count++;
        int i = start;

        for (; i <= end; i++) {
            if (inorder.get(i).intValue() == r)
                break;
        }

        TreeNode root = new TreeNode(r);

        root.left = buildTree(preorder,inorder,start,i-1);
        root.right = buildTree(preorder,inorder,i+1,end);

        return root;
    }

    public static void main(String... args){
        InorderPreorderConstructionBT o = new InorderPreorderConstructionBT();

        ArrayList<Integer> preorder = new ArrayList<>();
        preorder.add(1);
        preorder.add(2);
        preorder.add(3);

        ArrayList<Integer> inorder = new ArrayList<>();
        inorder.add(2);
        inorder.add(1);
        inorder.add(3);

        o.buildTree(preorder,inorder);
    }
}
