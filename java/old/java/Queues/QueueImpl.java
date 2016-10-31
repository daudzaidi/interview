package old.java.Queues;

/**
 * Created by pandita on 8/28/2015.
 */
public class QueueImpl<T> {

    private int queueCapacity;
    T[] queueArr;
    int front =0;
    int rear =0;

    public QueueImpl(int size){
        this.queueCapacity=size;
        queueArr = (T[])new Object[size];
    }
    public boolean isQueueEmpty(){
        return (front==-1 || front==rear );
    }

    public boolean isQueueFull(){
        return (rear==queueCapacity-1);
    }

    private void increaseCapacity(){
        System.out.println("Increasing array capacity to Double");
        T[] newArr = (T[]) new Object[queueCapacity*2];
        for(int i =0;i<queueCapacity;i++){
            newArr[i]=queueArr[i];
        }
        this.queueCapacity=queueCapacity*2;
        this.queueArr=newArr;
    }

    public void enqueue(T value){
        if(isQueueFull()){
            //increase queue capacity
            increaseCapacity();
        }
        System.out.println("Enqueueing value : " + value);
        queueArr[rear++]=value;
    }

    public T dequeue(){
        if(isQueueEmpty()){
            System.out.println("Cannot Dequeue more.. Queue Underflow");
            return null;
        }
        T deq = queueArr[front++];
        System.out.println("Dequeuing : " + deq);
        return deq;
    }

    public static void main(String args[]){
        QueueImpl<Integer> queue = new QueueImpl<Integer>(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.enqueue(11);
        queue.enqueue(12);

        for (int i =0 ;i<13;i++){
            queue.dequeue();
        }
    }

}
