package Amazon.Set1;


import DocPractice.SinglyLinkedListImpl;

/**
 * Created by shalvi on 27/06/16.
 */
public class Question3 {

    static SinglyLinkedListImpl<Integer> result = null;
    static int carry =0;


    public static void calaculate (Node node1, Node node2, int size1, int size2){

        sumList(node1,node2,size1,size2);
        if(carry > 0)result.addNode(new Node<Integer>(carry));

    }
    public static void sumList(Node node1, Node node2, int size1, int size2){
        if(node1!=null && node2!=null && size1==size2){
            sumList(node1.getNext(),node2.getNext(),size1-1,size2-1);
        }
        if(node1!=null && size1>size2){
            sumList(node1.getNext(),node2,size1-1,size2);
        }
        if(node2!=null && size1<size2){
            sumList(node1,node2.getNext(),size1,size2-1);
        }
        if(node1 == null && node2 == null) return;

        addNodes(node1,node2,size1,size2);

    }

    public static void addNodes(Node node1, Node node2, int size1, int size2) {
        int sum = carry + ((node1 != null) ? ((size1 >= size2) ? (Integer) node1.data : 0) : 0) +
                ((node2 != null) ? ((size2 >= size1) ? (Integer)node2.data : 0) : 0);

        carry = (sum>=10)?1:0;

        sum = sum % 10;

        result.addNode(new Node<Integer>(sum));
    }

    public static void main(String... args){
        SinglyLinkedListImpl<Integer> list1 = new SinglyLinkedListImpl<>();
        SinglyLinkedListImpl<Integer> list2 = new SinglyLinkedListImpl<>();
        list1.addNode(new Node<Integer>(5));
        list1.addNode(new Node<Integer>(6));
        list1.addNode(new Node<Integer>(3));

        list2.addNode(new Node<Integer>(8));
        list2.addNode(new Node<Integer>(4));
        list2.addNode(new Node<Integer>(2));

        result = new SinglyLinkedListImpl<>();

        calaculate(list1.start,list2.start,3,3);

        result.displayList();

    }

}



