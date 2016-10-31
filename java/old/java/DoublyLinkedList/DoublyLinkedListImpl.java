package old.java.DoublyLinkedList;

/**
 * Created by pandita on 8/4/2015.
 */
public class DoublyLinkedListImpl<T> {

    private Node<T> head=null;
    private Node<T> tail=null;

    public Node<T> createNewNode(T value){
        Node<T> nd = new Node<T>();
        nd.setValue(value);
        return nd;
    }
    public void addFirst(T value){
        Node<T> nd = createNewNode(value);
        if(head==null){
            head=nd;
            tail=nd;
           // nd.setNextRef(null);
           // nd.setPrevRef(null);
        }
        else
        {
            nd.setNextRef(head);
            head.setPrevRef(nd);
            nd.setPrevRef(null);
            head=nd;
        }
        System.out.println("Added First: "+ nd.getValue());
    }

    public void addLast(T value){
        Node<T> nd = createNewNode(value);
        if(head==null){
            head=nd;
            tail=nd;
            nd.setNextRef(null);
            nd.setPrevRef(null);
        }
        else{
            tail.setNextRef(nd);
            nd.setPrevRef(tail);
            nd.setNextRef(null);
            tail=nd;
        }
        System.out.println("Added Last: "+ nd.getValue());
    }

    public void addAfter(T value, T after){
        if(head==null){
            System.out.println("No elements present");
            return;
        }
        //traverse the list
        Node<T> nd = createNewNode(value);
        Node<T> tmp = head;
        Node<T> refNode=null;
        while(tmp!=null){
            if(tmp.compareTo(after)==0){
                refNode=tmp;
                break;
            }
            tmp=tmp.getNextRef();
        }
        if(refNode!=null){
            nd.setPrevRef(tmp);
            nd.setNextRef(tmp.getNextRef());
            tmp.setNextRef(nd);
            nd.getNextRef().setPrevRef(nd);
            if(nd.getNextRef()==null){
                tail=nd;
            }
            System.out.println("Added : "+ nd.getValue() +" after : "+tmp.getValue());
        }
    }

    public void traverseForward(){
        System.out.println("Forward Traversing");
        if(head==null){
            System.out.println("No element present");
        }
        Node<T> tmp = head;
        while(tmp!=null){
            System.out.println(tmp.getValue());
            tmp=tmp.getNextRef();
        }
    }

    public void traverseBackward(){
        System.out.println("Backward Traversing");
        if(head==null){
            System.out.println("No element present");
        }
        Node<T> tmp = tail;
        while(tmp!=null){
            System.out.println(tmp.getValue());
            tmp=tmp.getPrevRef();
        }
    }

    public void deleteFront(){
        if(head==null){
            System.out.println("No element present");
            return;
        }
        Node<T> tmp = head;
        head=tmp.getNextRef();
        head.setPrevRef(null);
        if(head==null){
            tail=null;
        }
    }

    public void deleteLast(){
        if(head==null){
            System.out.println("No element present");
            return;
        }
        tail=tail.getPrevRef();
        if(tail==null){
            head=null;
            return;
        }
        tail.setNextRef(null);
    }

    public void deleteAfter(T after){
        if(head==null){
            System.out.println("No element present");
            return;
        }
        //Traverse nodes
        Node<T>tmp = head;
        Node<T>refNode=null;
        while(tmp!=null){
            if(tmp.compareTo(after)==0){
                refNode=tmp;
                break;
            }
            tmp=tmp.getNextRef();
        }
        if(refNode!=null && refNode.getNextRef()!=null){

            refNode.setNextRef(refNode.getNextRef().getNextRef());
            if(refNode.getNextRef()==null){
                tail=refNode;
                return;
            }
            refNode.getNextRef().setPrevRef(refNode);
        }
    }

    public void deleteBefore(T before){
        if(head==null){
            System.out.println("No element present");
            return;
        }
        //Traverse nodes
        Node<T>tmp = head;
        Node<T>refNode=null;
        while(tmp!=null){
            if(tmp.compareTo(before)==0){
                refNode=tmp;
                break;
            }
            tmp=tmp.getNextRef();
        }
        if(refNode!=null && refNode.getPrevRef()!=null){
            refNode.setPrevRef(refNode.getPrevRef().getPrevRef());
            if(refNode.getPrevRef()==null){
                head=refNode;
                return;
            }
            refNode.getPrevRef().setNextRef(refNode);
        }
    }

    public static void main(String args[]){
        DoublyLinkedListImpl<Integer> list = new DoublyLinkedListImpl<Integer>();
        list.addFirst(1);
        list.addFirst(0);
        list.addLast(2);
        list.addLast(5);
        list.addAfter(3,2);
        list.addAfter(4,3);
        list.traverseForward();
        list.traverseBackward();
        list.deleteFront();
        list.deleteLast();
        list.traverseForward();
        list.traverseBackward();
        list.addLast(5);
        list.addFirst(0);
        list.deleteAfter(4);
        list.traverseForward();
        list.traverseBackward();
        list.addLast(5);
        list.addFirst(0);
        list.deleteBefore(5);
        list.deleteBefore(1);
        list.deleteBefore(4);
        list.traverseForward();
        list.traverseBackward();
    }
}
