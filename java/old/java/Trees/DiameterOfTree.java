package old.java.Trees;

/**
 * Created by pandita on 9/1/2015.
 */
public class DiameterOfTree<T> {

    public int diameter(Node<T> root){

        if(root== null){
            return 0;
        }

        //Three Cases :
        //  a. The longest path passes through the root, (calculated via height of trees
        //  b. The longest path is entirely contained in the left sub-tree,
        //  c. The longest path is entirely contained in the right sub-tree.

        HeightOfTree<T> height = new HeightOfTree<T>();
        int h = height.height(root.getLeft()) + height.height(root.getRight());
        int ldia = diameter(root.getLeft());
        int rdia = diameter(root.getRight());
        return Math.max(h+1,Math.max(ldia,rdia));
    }

    public static void main(String args[]){
        BinaryTreeImpl<Integer> tree = new BinaryTreeImpl<Integer>();
        tree.addNode(20,20);
        tree.addNode(15,15);
        tree.addNode(25,25);
        tree.addNode(10,10);
        tree.addNode(18,18);
        tree.addNode(17,17);
        tree.addNode(12,12);
        tree.addNode(19, 19);
        tree.addNode(16, 16);

        DiameterOfTree<Integer> dia = new DiameterOfTree<Integer>();
        System.out.println("Diameter of Tree (number of nodes passing through longest path) :"+ dia.diameter(tree.getRoot()));

    }

}
