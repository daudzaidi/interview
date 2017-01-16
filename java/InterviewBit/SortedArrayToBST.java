package InterviewBit;

import java.util.List;

/**
 * Created by shyamsunderpandita on 13/01/17.
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(final List<Integer> a) {
        return convert(a,0,a.size()-1);
    }

    private TreeNode convert(List<Integer> a, int start, int end) {
        if(start > end){
            return null;
        }

        int mid = (start + end)/2;
        TreeNode node = new TreeNode(a.get(mid));
        node.left = convert(a,start,mid-1);
        node.right = convert(a,mid+1,end);
        return node;
    }
}
