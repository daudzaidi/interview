package Amazon.Set2;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by shalvi on 30/06/16.
 */
public class Question5 {

    public String serialize(Node root){
        StringBuilder builder = new StringBuilder();
        builder = buildStringFromTree(root,builder);
        System.out.println("Tree Serialized ===>"+builder.toString());
        return builder.toString();
    }

    private StringBuilder buildStringFromTree(Node root, StringBuilder builder) {
        if(root == null)
            builder.append("null,");
        else{
            builder.append(root.getValue()+ ",");
            buildStringFromTree(root.getLeft(),builder);
            buildStringFromTree(root.getRight(),builder);
        }
        return builder;
    }

    public Node deserialize(String data){
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        Node root = buildTreeFromString(nodes);
        System.out.println("Tree deserialized===>"+root.getValue());
        return root;
    }

    private Node buildTreeFromString(Deque<String> nodes) {
        String val = nodes.remove();
        if(val.equals("null")) return null;
        Node node = new Node();
        node.setValue(val);
        node.setLeft(buildTreeFromString(nodes));
        node.setRight(buildTreeFromString(nodes));
        return node;
    }

    public static void main(String... args){
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
        Question5 question = new Question5();
        String str = question.serialize(tree.getRoot());
        Node node = question.deserialize(str);

    }

}
