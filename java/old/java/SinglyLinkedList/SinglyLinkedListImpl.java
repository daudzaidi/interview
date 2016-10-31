package old.java.SinglyLinkedList;

/**
 * Created by pandita on 8/4/2015.
 */
//Will implement add / delete operations
public class SinglyLinkedListImpl<T> {

    private Node<T> head=null;
    private Node<T> tail=null;

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getHead() {
        return head;
    }


    //Creating New Node
    public Node<T> createNewNode(T Element){
        Node<T> nd = new Node<T>();
        nd.setValue(Element);
        return nd;
    }

    //Add Elements in the end
    public void add (T Element){
        Node<T>nd = createNewNode(Element);
        System.out.println("Added : "+ nd.getValue());
        if(head==null){
            nd.setNextRef(null);
            head=nd;
            tail=nd;
        }
        else{
            tail.setNextRef(nd);
            tail=nd;
        }
    }

    public void addAfter(T Element, T after){
        // Traverse all nodes and check if the element exists
        Node <T> tmp = head;
        Node <T> getRefNode=null;
        Node <T> nd = createNewNode(Element);
        while(tmp!=null){
            if(tmp.compareTo(after)==0) {
               getRefNode = tmp;
                break;
            }
            tmp=tmp.getNextRef();
        }
        if(getRefNode!=null){
            Node<T>getRef = getRefNode.getNextRef();
            tmp.setNextRef(nd);
            nd.setNextRef(getRef);
            System.out.println("Added : "+ nd.getValue() +" after : "+tmp.getValue());
        }
        else{
            System.out.println("Unable to find Element after which we had to add");
        }

    }

    public void deleteFront(){
        if(head==null){
            System.out.println("No Element Present");
        }
        else{
            Node<T> tmp = head;
            System.out.println("Deleting : "+ tmp.getValue());
            head=tmp.getNextRef();
            if(head==null){
                tail=null;
            }
        // all references with null value will be collected by Garbage Collector
        }
        }

    public void deleteAfter(T after){
        if(head==null){
            System.out.println("No Element Present");
        }
        else{
            //Traverse all nodes to find the reference node
            Node<T> refNode=null;
            Node<T> tmp = head;
            while(tmp!=null){
                if(tmp.compareTo(after)==0){
                    refNode=tmp;
                    break;
                }
                tmp=tmp.getNextRef();
            }
            if(refNode!=null){
                System.out.println("Deleting : "+ refNode.getNextRef().getValue() +" after:"+refNode.getValue());
                refNode.setNextRef(refNode.getNextRef().getNextRef());
                if(refNode.getNextRef()==null){
                    tail=refNode;
                }

            }
            else{
                System.out.println("No Element Present");
            }

        }
    }

    public Node<T> getRefNode(T value){
        Node<T> tmp = head;
        Node<T> refNode =null;
        while(tmp!=null){
            if(tmp.compareTo(value)==0){
                refNode=tmp;
                break;
            }
            tmp=tmp.getNextRef();
        }
        return refNode;
    }

    public int getLengthList(SinglyLinkedListImpl list){
        int len =0;
        Node<T> tmp = getHead();
        while(tmp!=null){
            tmp=tmp.getNextRef();
            len++;
        }
        return  len;
    }

    public void traverse(){
        Node<T> tmp=head;
        if(tmp==null){
            System.out.println("No Element Present");
        }
        while(tmp!=null){
            System.out.println(tmp.getValue());
            tmp=tmp.getNextRef();
        }
    }

    public int length(SinglyLinkedListImpl list){
        int len =0;
        Node<T> tmp = list.getHead();
        while(tmp!=null){
            len++;
            tmp=tmp.getNextRef();
        }

        return len;
    }

    public static void main(String a[]){
        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        sl.traverse();
        sl.addAfter(76, 54);
        sl.deleteFront();
        sl.deleteAfter(76);
        sl.traverse();

    }
}
