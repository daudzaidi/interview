package TusharRoyVideos.Graph.Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by shalvi on 07/10/16.
 */
public class MinHeap implements Comparator<Node> {

    List<Node> heap = new ArrayList<>();
    int position = 0;
    public void insert(Node node){
        node.setPosition(position);
        node.setSize(1);
        heap.add(position,node);
        int k = position;
        position++;

        bubbleUp(node);
        updateTreeSizeOnInsert(k);
    }

    public void updateTreeSizeOnInsert(int k) {
        Node node = heap.get(k);
        int index = node.getPosition();
        int parentIndex = parent(index);

        while(parentIndex > 0){
            Node parentNode = heap.get(parentIndex);
            parentNode.setSize(parentNode.getSize()+1);
            index = parentIndex;
            parentIndex=parent(index);
        }

        if(parentIndex == 0 && index!=0){
            Node parentNode = heap.get(parentIndex);
            parentNode.setSize(parentNode.getSize()+1);
        }
    }

    public void bubbleUp(Node node) {
        int index = node.getPosition();
        int parentIndex = parent(index);
        while(parentIndex>0){
            Node parentNode = heap.get(parentIndex);
            node = heap.get(index);

            if(compare(node,parentNode) < 0){
                swap(index,parentIndex);
            }

            index = parentIndex;
            parentIndex=parent(index);
        }
        if(parentIndex == 0 && index!=0){
            Node parentNode = heap.get(parentIndex);
            if(compare(node,parentNode) < 0){
                swap(index,parentIndex);
            }
        }
    }

    private void swap(int index, int parentIndex) {
        Node node = heap.get(index);
        Node parentNode = heap.get(parentIndex);

        int sizeNode = node.getSize();
        int sizeParent = parentNode.getSize();

        int pos1 = node.getPosition();
        int pos2 = parentNode.getPosition();

        parentNode.setSize(sizeNode);
        node.setSize(sizeParent);

        parentNode.setPosition(pos1);
        node.setPosition(pos2);

        heap.set(parentIndex,node);
        heap.set(index,parentNode);

    }

    public void delete(Node node){
        int index = node.getPosition();

        if(index == -1)
            return;

        int k = index;
        for(int i =k+1;i<heap.size();i++){
            heap.get(i).setPosition(i-1);
        }
        heap.remove(index);

        bubbleDown(index);
        if(index < heap.size()){
            updateTreeSizeOnDelete(index);
        }

    }

    public void updateTreeSizeOnDelete(int k) {
        Node node = heap.get(k);
        int index = node.getPosition();
        int parentIndex = parent(index);

        while(parentIndex > 0){
            Node parentNode = heap.get(parentIndex);
            parentNode.setSize(parentNode.getSize()-1);
            index = parentIndex;
            parentIndex=parent(index);
        }

        if(parentIndex == 0 && index!=0){
            Node parentNode = heap.get(parentIndex);
            parentNode.setSize(parentNode.getSize()-1);
        }

    }

    public void bubbleDown(int index) {
        if(index >= heap.size())
            return;

        int left = left(index);
        int right = right(index);
        if(left >= heap.size() || right >=heap.size())
            return;

        Node node = heap.get(index);
        Node leftNode = heap.get(left);
        Node rightNode = heap.get(right);


            boolean isLeftMin = (leftNode.getVal() <= rightNode.getVal()) ? true : false;
            if (isLeftMin) {
                if (node.getVal() > leftNode.getVal()){
                    swap(index, left);
                    bubbleDown(left);
                }


            } else {
                if (node.getVal() > rightNode.getVal()){
                    swap(index, right);
                    bubbleDown(right);
                }
            }

    }

    private int getIndex(Node n){
        for(Node node : heap){
            if(node.getVal() == n.getVal())
                return node.getPosition();
        }
        return -1;
    }

    @Override
    public int compare(Node o1, Node o2) {
        return o1.val - o2.val;
    }

    private int parent(int i){
        return (i-1)/2;
    }


    private int left(int i){
        return (2*i)+1;
    }

    private int right(int i){
        return (2*i)+2;
    }

    public Node getMin(){
        return heap.get(0);
    }

    public boolean containNode(Node node){
        for(Node n : heap){
            if(node == n)
                return true;
        }

        return false;
    }

    public static void main(String... args){
        MinHeap h = new MinHeap();

        Node n1 = new Node(5);
        Node n2 = new Node(10);
        Node n3 = new Node(1);
        Node n4 = new Node(2);
        Node n5 = new Node(4);
        Node n6 = new Node(6);
        Node n7 = new Node(20);
        Node n8 = new Node(0);
        Node n9 = new Node(-1);

        h.insert(n1);
        h.insert(n2);
        h.insert(n3);
        h.insert(n4);
        h.insert(n5);
        h.insert(n6);
        h.insert(n7);
        h.insert(n8);
        h.insert(n9);
        for(Node node : h.heap){
            System.out.println(node.getVal() + " SIZE OF SUBTREE :"+node.getSize());
        }

        h.delete(n9);
        h.delete(n1);
        h.delete(n4);

        System.out.println("After Deletion : ");
        for(Node node : h.heap){
            System.out.println(node.getVal() + " SIZE OF SUBTREE :"+node.getSize());
        }
    }
}
