package DocPractice;
import Amazon.Set1.Node;

/**
 * Created by shalvi on 22/05/16.
 */
// Implementation of a Singly Linked List in Java



/**
 Making SinglyLinkedList Class
 Basic Operations:
 Add Node - Front , End, Between
 Delete Node - Front, End, Between
 Search Node
 Display Node
 **/

public class SinglyLinkedListImpl<T>{

   public  Node<T> start = null;

    public Node<T> createNewNode(T value){
        Node<T> node = new Node<T>(value);
        node.setNext(null);
        return node;
    }

    public void addNode(Node<T> node){
        if(start == null){
            start = node;
        }
        else{
            Node<T> tmp  = start;
            while(tmp.getNext()!=null){
                tmp = tmp.getNext();
            }
            tmp.setNext(node);
        }
    }

    public void searchNode(Node<T> node){
        Node<T> tmp = start;
        while(tmp!=null || tmp.getData() != node.getData()){
            tmp = tmp.getNext();
        }
        if(tmp!=null){
            System.out.println("Node Found !");
        }
        else{
            System.out.println("Node Not Found !");

        }
    }

    public boolean deleteNode(T value){

        Node<T> tmp = start;
        while(tmp.getNext()!=null && tmp.getNext().getData()!= value ){
            tmp = tmp.getNext();
        }
        if(tmp.getNext()!=null){
            Node<T> node = tmp.getNext();
            tmp.setNext(node.getNext());
            node = null;
            return true;
        }
        System.out.println("Node to be deleted not found");
        return false;
    }

    public void displayList(){
        Node<T> tmp = start;
        int count =0;
        while (tmp!=null){
            ++count;
            System.out.println("Node "+count +": "+ tmp.getData());
            tmp = tmp.getNext();
        }
    }


    public void displayList(Node<T> head){
        Node<T> tmp = head;
        int count =0;
        while (tmp!=null){
            ++count;
            System.out.println("Node "+count +": "+ tmp.getData());
            tmp = tmp.getNext();
        }
    }

    public int length(){
        Node<T> tmp = start;
        int count =0;
        while (tmp!=null){
            ++count;
            System.out.println("Node "+count +": "+ tmp.getData());
            tmp = tmp.getNext();
        }
        return count;
    }

    public Node<T> getRefNode(T value){
        Node<T> tmp = start;
        Node<T> refNode =null;
        while(tmp!=null){
            if(tmp.compareTo(value)==0){
                refNode=tmp;
                break;
            }
            tmp=tmp.getNext();
        }
        return refNode;
    }

    public  Node<T> getNthLastElement (SinglyLinkedListImpl list, int N){
        if(list == null || N > list.length()) return null;
        Node<T> root = list.start;
        Node<T> ptrN = list.start;
        int k = list.length();
        int move = 0;
        while(move < N){
            root = root.getNext();
            move++;
        }

        while(root!=null){
            ptrN = ptrN.getNext();
            root = root.getNext();
        }
        return ptrN;
    }

    public Node<Integer> addNumbers(Node<Integer> n1, Node<Integer> n2, int len1, int len2){
        if(n1 == null && n2 == null) return null;
        if(n1 == null) return n2;
        if (n2 == null) return n1;
        SinglyLinkedListImpl<Integer> result = new SinglyLinkedListImpl();
        int carry = 0;
        while(n1!=null && n2!=null){
            if(n1!=null && n2!=null){
                int sum = n1.getData() + n2.getData() + carry;
                if(sum >=10){

                    result.addNode(new Node(sum%10));
                    carry = 1;
                }
                else{
                    result.addNode(new Node(sum));
                    carry = 0;
                }

                n1 = n1.getNext();
                n2 = n2.getNext();
            }
        }

        if(len1 > len2){
            while(n1!=null){
                if(carry ==1){
                    result.addNode(new Node(n1.getData()+1));
                    carry = 0;
                }
                else{
                    result.addNode(new Node(n1.getData()));
                }

                n1 = n1.getNext();
            }
        }
        else{
            while(n2!=null){
                if(carry ==1){
                    result.addNode(new Node(n2.getData()+1));
                    carry = 0;
                }
                else{
                    result.addNode(new Node(n2.getData()));
                }
                n2 = n2.getNext();
            }
        }

        return result.start;
    }


    public static void main(String... args){
        SinglyLinkedListImpl<Integer> list = new SinglyLinkedListImpl<>(); // java 8
        for(int i = 0; i< 10 ;i++){
            list.addNode(list.createNewNode(i));
        }
        list.displayList();
        list.addNode(list.createNewNode(11));
        list.displayList();
        list.deleteNode(6);
        list.displayList();
        Node<Integer> node =list.getNthLastElement(list,4);
        System.out.println("4th last element of the list is = "+ node.getData());

        System.out.println("Adding two numbers ----->");
        SinglyLinkedListImpl<Integer> n1 = new SinglyLinkedListImpl<>(); // java 8
        for(int i = 5; i< 8 ;i++){
            n1.addNode(n1.createNewNode(i));
        }
        System.out.println("Number 1 ----->");
        n1.displayList();

        SinglyLinkedListImpl<Integer> n2 = new SinglyLinkedListImpl<>(); // java 8
        for(int i = 4; i< 9 ;i++){
            n2.addNode(n1.createNewNode(i));
        }
        System.out.println("Number 2 ----->");
        n2.displayList();

        System.out.println("SUM ----->");
        SinglyLinkedListImpl<Integer> result = new SinglyLinkedListImpl<>();
        result.start = result.addNumbers(n1.start,n2.start,3,3);
        result.displayList();

    }

}
