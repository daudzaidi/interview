package old.java.CircularLinkedList;

/**
 * Created by pandita on 8/4/2015.
 */
public class CircularLinkedListImpl<T> {

    private Node<T> head;

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> createNewNode(T value){
        Node<T> nd = new Node<T>();
        nd.setValue(value);
        return nd;
    }

    public Node<T>getRefNode(T value){
        Node<T> refNode = null;
        Node<T> tmp = head;
        if(tmp.getNextRef()==head && tmp.compareTo(value)==0){
            refNode=tmp;
            return refNode;
        }

        while(tmp.getNextRef()!=head){
            if(tmp.compareTo(value)==0){
                refNode=tmp;
                break;
            }
            tmp=tmp.getNextRef();
        }
        if(tmp.getNextRef()==head && tmp.compareTo(value)==0){
            refNode=tmp;
            return refNode;
        }
        return refNode;
    }

    public void addFirst(T value){
        Node<T> nd = createNewNode(value);
        if(head==null){
            head=nd;
            head.setNextRef(head);
        }
        else{
            nd.setNextRef(head);
            head=nd;
        }
        System.out.println("Added First : "+ value);
    }

    public void addLast(T value){
        Node<T> nd = createNewNode(value);
        if(head==null){
            head=nd;
            head.setNextRef(head);
        }
        else
        {
            Node<T>tmp = head;
            while(tmp.getNextRef()!=head) {
                tmp=tmp.getNextRef();
            }
            tmp.setNextRef(nd);
            nd.setNextRef(head);
        }
        System.out.println("Added Last : "+ value);
    }

    public void addAfter(T value, T after){

        Node<T>nd = createNewNode(value);
        if(head==null){
            return;
        }
        Node<T> refNode = getRefNode(after);
        if(refNode!=null){
            nd.setNextRef(refNode.getNextRef());
            if(refNode.getNextRef()==head){
            head=nd;
            }
            refNode.setNextRef(nd);
        }

        System.out.println("Added : " + value + " After: " + after);
    }

    public void deleteFront(){
        if(head==null){
            return;
        }
        Node<T>tmp = head;
        while(tmp.getNextRef()!=head){
            tmp=tmp.getNextRef();
        }
        tmp.setNextRef(head.getNextRef());
        head=tmp.getNextRef();
    }

    public void deleteLast(){
        if(head==null || head.getNextRef()==head){
            head=null;
            return;
        }
        Node<T>tmp =head;
        while(tmp.getNextRef().getNextRef()!=head){
            tmp=tmp.getNextRef();
        }
        tmp.setNextRef(head);
    }

    public void deleteAfter(T value){
        if(head==null){
            return;
        }
        Node<T>refNode=getRefNode(value);
        if(refNode!=null){
            if(refNode.getNextRef()==head){
                refNode.setNextRef(head.getNextRef());
                head=refNode;
                return;
            }
            refNode.setNextRef(refNode.getNextRef().getNextRef());
        }
    }

    public void traverse(){
        Node<T>tmp = head;
        if(tmp==null){
            return;
        }
        System.out.println("Traversing :");
        while(tmp.getNextRef()!=head){
            System.out.println(tmp.getValue());
            tmp=tmp.getNextRef();
        }
        System.out.println(tmp.getValue());
    }


    public static void main(String args[]){
        CircularLinkedListImpl<Integer> list = new CircularLinkedListImpl<Integer>();
        list.addFirst(0);
        list.addLast(1);
        list.addLast(4);
        list.addAfter(2,1);
        list.addAfter(3,2);
        list.addAfter(5,4);
        list.addLast(6);
        list.traverse();
        list.deleteFront();
        list.deleteLast();
        list.deleteAfter(3);
        list.deleteAfter(1);
        list.traverse();
    }
}
