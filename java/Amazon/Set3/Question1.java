package Amazon.Set3;

import Amazon.Set2.Node;

import java.util.*;

/**
 * Created by shalvi on 01/07/16.
 */
public class Question1 {

    public static void main(String... args){
        HeapImpl heap = new HeapImpl();
        Node node = new Node();
        node.setValue(10);
        heap.addNodeToHeap(node);
        node = new Node();
        node.setValue(1);
        heap.addNodeToHeap(node);
        node = new Node();
        node.setValue(100);
        heap.addNodeToHeap(node);
        node = new Node();
        node.setValue(5);
        heap.addNodeToHeap(node);
        node = new Node();
        node.setValue(11);
        heap.addNodeToHeap(node);
        node = new Node();
        node.setValue(2);
        heap.addNodeToHeap(node);
        node = new Node();
        node.setValue(9);
        heap.addNodeToHeap(node);

        System.out.println("Min Value of the heap is "+heap.getMinNode().getValue());
        heap.removeNodeFromHeap(heap.getMinNode());
        System.out.println("Min Value of the heap is "+heap.getMinNode().getValue());

        heap.removeNodeFromHeap(heap.getMinNode());
        System.out.println("Min Value of the heap is "+heap.getMinNode().getValue());

        heap.removeNodeFromHeap(heap.getMinNode());
        System.out.println("Min Value of the heap is "+heap.getMinNode().getValue());

        heap.removeNodeFromHeap(heap.getMinNode());
        System.out.println("Min Value of the heap is "+heap.getMinNode().getValue());

        heap.removeNodeFromHeap(heap.getMinNode());
        System.out.println("Min Value of the heap is "+heap.getMinNode().getValue());

        heap.removeNodeFromHeap(heap.getMinNode());
        System.out.println("Min Value of the heap is "+heap.getMinNode().getValue());


        heap.removeNodeFromHeap(heap.getMinNode());


        System.out.println("ROPE QUESTION");

        node = new Node();
        node.setValue(1);
        heap.addNodeToHeap(node);
        node = new Node();
        node.setValue(100);
        heap.addNodeToHeap(node);
        node = new Node();
        node.setValue(5);
        heap.addNodeToHeap(node);
        node = new Node();
        node.setValue(11);
        heap.addNodeToHeap(node);
        node = new Node();
        node.setValue(2);
        heap.addNodeToHeap(node);
        node = new Node();
        node.setValue(9);
        heap.addNodeToHeap(node);
        node = new Node();
        node.setValue(7);
        heap.addNodeToHeap(node);

        while(heap.heapList.size()!=1){
            int rope1 = (Integer)heap.getMinNode().getValue();
            heap.removeNodeFromHeap(heap.getMinNode());
            int rope2 = (Integer)heap.getMinNode().getValue();
            heap.removeNodeFromHeap(heap.getMinNode());
            node = new Node();
            node.setValue(rope1+rope2);
            heap.addNodeToHeap(node);
        }

        System.out.println("The Minimum cost is = "+heap.getMinNode().getValue());


    }


}

class HeapImpl{

    /**
     * In a min heap parent node is always less than its both children
     **/
    List<Node> heapList = new ArrayList<>();


    public void addNodeToHeap(Node node){
        if(heapList.size() == 0){
            heapList.add(node);
        }
        else{
            heapList.add(node);
            bubbleUp(node);
        }
    }

    private void bubbleUp(Node node) {
        int index = heapList.indexOf(node);
        while(index >=0 && (Integer)heapList.get(parentIndex(index)).getValue() > (Integer)heapList.get(index).getValue()){
            Node temp = heapList.get(parentIndex(index));
            heapList.set(parentIndex(index),node);
            heapList.set(index,temp);
            index = parentIndex(index);
        }

    }

    public void removeNodeFromHeap(Node node){

        int posDel= heapList.indexOf(node);
        int i;
        for(i =posDel+1;i<heapList.size();i++){
            heapList.set(i-1,heapList.get(i));
        }
        heapList.remove(i-1);
        if(heapList.size()>1) {
            bubbleDown(heapList.get(posDel));
        }
    }

    private void bubbleDown(Node root) {
        if(root == null)return;
        int index = heapList.indexOf(root);
        int left = leftIndex(index);
        int right = rightIndex(index);

        if(left >= heapList.size() &&  right >= heapList.size()){
            return;
        }

        int smallest = index;

        if(left < heapList.size() && (Integer)heapList.get(index).getValue()>(Integer)heapList.get(left).getValue()){
            smallest = left;
        }

        if(right < heapList.size() && (Integer)heapList.get(smallest).getValue()>(Integer)heapList.get(right).getValue()){
            smallest = right;
        }

        if(smallest!=index){
            Node temp = heapList.get(smallest);
            heapList.set(smallest,root);
            heapList.set(index,temp);
        }
        if(left<heapList.size())
            bubbleDown(heapList.get(left));

        if(right<heapList.size())
            bubbleDown(heapList.get(right));

    }

    public Node getMinNode(){
        return heapList.get(0);
    }

    public Node createNewNodeForHeap(int data){
        Node node = new Node();
        node.setValue(data);
        return node;
    }

    public int parentIndex(final int i) {
        return (i-1)/2;
    }

    public int leftIndex(final int i) {
        return (2*i)+1;
    }

    public int rightIndex(final int i) {
        return (2*i)+2;
    }

}


