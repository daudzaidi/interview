package old.java.Trees;

/**
 * Created by pandita on 9/1/2015.
 */
public class MaximumElement<T> {

    public Node<T> maximumElementRecursive(Node<T> root){
        if(root==null){
            return null;
        }
        if(root.getRight()==null && root.getLeft()==null){
            return root;
        }
        Node<T> max =null;
        Node<T> left = maximumElementRecursive(root.getLeft());
        Node<T> right=maximumElementRecursive(root.getRight());
        if(left!=null && right!=null){
            if((Integer)left.getValue()> (Integer)right.getValue()){
                max=left;
            }
            else{
                max=right;
            }
        }
        else if(right==null){
            max=left;
        }
        else if(left==null){
            max=right;
        }

        if(max!=null) {
            if ((Integer) root.getValue() > (Integer) max.getValue()) {
                max = root;
            }
        }

        return max;
    }
    public static void main(String args[]){
        BinaryTreeImpl<Integer> tree = new BinaryTreeImpl<Integer>();
        tree.addNode(20,20);
        tree.addNode(15,15);
        tree.addNode(25,25);
        tree.addNode(30,30);
        tree.addNode(34,34);
        tree.addNode(70,70);
        tree.addNode(10,10);
        tree.addNode(18,18);
        tree.addNode(17,17);
        tree.addNode(12,12);
        tree.addNode(19,19);
        tree.addNode(16,16);
        MaximumElement<Integer> max=new MaximumElement<Integer>();
        Node<Integer> val = max.maximumElementRecursive(tree.getRoot());
        if(val!=null)
        System.out.println("MAXIMUM ELEMENT:"+val.getValue());
    }

}
