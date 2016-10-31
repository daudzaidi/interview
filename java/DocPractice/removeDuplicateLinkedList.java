package DocPractice;

import Amazon.Set1.Node;

import java.util.HashMap;

/**
 * Created by shalvi on 29/05/16.
 */
public class removeDuplicateLinkedList {

    public Node removeDuplicates(SinglyLinkedListImpl list){
        if(list == null) return null;
        if(list.length() == 1) return null;
        Node tmp = list.start;
        Node tail =tmp.getNext();
        Node tailParent = list.start;
        while(tmp != null){
            Node j = list.start;
            while(j !=tail){
                if(tmp.getData() == j.getData()) break;
                j = j.getNext();
            }
            if(j == tail){
                int t = (int)tmp.getData();
                tmp.setData ( j.getData());
                j.setData(t);
                tailParent = tail;
                tail = tail.getNext();
            }

            tmp = tmp.getNext();
        }

        tailParent.setNext(null);

    return list.start;

    }

    public Node removeDuplicateHashTable(SinglyLinkedListImpl list){
        if(list == null || list.length() == 1) return null;
        HashMap<Integer,Integer> map = new HashMap<>();
        Node tmp = list.start;
        Node prev = tmp;
        Node next = prev.getNext();
        map.put((int)list.start.getData(),(int)list.start.getData());
        while(next!=null){
            if(map.containsKey(next.getData())){
                prev.setNext(next.getNext());
            }
            else{
                map.put((int)next.getData(),(int)next.getData());
                prev = next;
            }
            next = next.getNext();
        }
        return list.start;
    }

    public static void main(String... args){
        SinglyLinkedListImpl<Integer> list = new SinglyLinkedListImpl<>(); // java 8
        for(int i = 0; i< 10 ;i++){
            list.addNode(list.createNewNode(i));
        }
        list.addNode(list.createNewNode(1));
        list.addNode(list.createNewNode(2));
        list.addNode(list.createNewNode(3));
        list.addNode(list.createNewNode(9));
        list.displayList();

        removeDuplicateLinkedList r = new removeDuplicateLinkedList();
        //list.start   = r.removeDuplicates(list);
        list.start   = r.removeDuplicateHashTable(list);
        list.displayList();
    }

}
