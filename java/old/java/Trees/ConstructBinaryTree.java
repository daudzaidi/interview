package old.java.Trees;

import java.util.ArrayList;

/**
 * Created by pandita on 9/3/2015.
 */
public class ConstructBinaryTree <T>{

    Node<T> root;
    public Node<T> createNewNode(T value){
        Node<T> nd = new Node<T>();
        nd.setValue(value);
        return nd;
    }
    int preIndex=0;
    public Node<T> FromPreorderInorder(ArrayList<T> pre, ArrayList<T> in, int inStart, int inEnd){
        if(preIndex>=pre.size() || inStart==in.size())
            return null;

        T val = pre.get(preIndex++);
        Node<T>nd = createNewNode(val);
        if(inStart == inEnd)
            return nd;

        int j=0;
        while(in.get(j)!=val)
            j++;

        if(root==null){
            root=nd;
        }
         nd.setLeft(FromPreorderInorder(pre,in,inStart,j-1));
         nd.setRight(FromPreorderInorder(pre,in,j+1,inEnd));

        return nd;
    }
    Node<T>rootPost;
    static ArrayList<Character>post = new ArrayList<Character>();
    int postIndex=post.size()-1;
    public Node<T> FromPostorderInorder(ArrayList<T> post, ArrayList<T> in , int inStart, int inEnd){
        if(postIndex<0 || inStart==in.size())
            return null;

        T val = post.get(postIndex--);
        Node<T>nd = createNewNode(val);
        if(inEnd==inStart)
            return nd;

        int j =0;
        while(in.get(j)!=val)
            j++;

        if(rootPost==null)
            rootPost=nd;

        nd.setRight(FromPostorderInorder(post, in, j + 1, inEnd));
        nd.setLeft(FromPostorderInorder(post, in, inStart, j - 1));
        return nd;
    }

    int levelIndex=0;
    Node<T> rootLevel;
    public Node<T> FromLevelorderInorder(ArrayList<T> level, ArrayList<T> in , int inStart, int inEnd){
        if(inEnd==0 || inEnd < inStart || levelIndex >=level.size())
            return null;

        T val = level.get(levelIndex++);
        Node<T> nd = createNewNode(val);
        if(inStart==inEnd)
            return nd;
        int j =0;
        while(in.get(j)!=val)
            j++;
        if(root==null)
            root=nd;
        nd.setLeft(FromLevelorderInorder(level,in,inStart,j-1));
        nd.setRight(FromLevelorderInorder(level,in,j+1,inEnd));
        return nd;
    }


    public static void main(String args[]){
        ArrayList<Character> pre = new ArrayList<Character>();
        pre.add('A');
        pre.add('B');
        pre.add('D');
        pre.add('E');
        pre.add('C');
        pre.add('F');

        ArrayList<Character> in = new ArrayList<Character>();
        in.add('D');
        in.add('B');
        in.add('E');
        in.add('A');
        in.add('F');
        in.add('C');

        post.add('D');
        post.add('E');
        post.add('B');
        post.add('F');
        post.add('C');
        post.add('A');

        ArrayList<Character> level = new ArrayList<Character>();
        level.add('A');
        level.add('B');
        level.add('C');
        level.add('D');
        level.add('E');
        level.add('F');

        ConstructBinaryTree<Character> tree = new ConstructBinaryTree<Character>();
        Node<Character> val = tree.FromPreorderInorder(pre,in,0,in.size());
        Node<Character> valPost = tree.FromPostorderInorder(post,in,0,in.size());
        Node<Character> vallevel = tree.FromLevelorderInorder(level,in,0,in.size());
        System.out.println("Recahed END");

    }
}
