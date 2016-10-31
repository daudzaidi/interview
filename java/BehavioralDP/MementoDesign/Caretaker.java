package BehavioralDP.MementoDesign;

import java.util.ArrayList;

/**
 * Created by shalvi on 10/04/16.
 */
public class Caretaker {
    ArrayList<Memento> savedArticles = new ArrayList<>();

    public void addMemento(Memento m ){
        savedArticles.add(m);
    }

    public Memento getMemento(int index){
        return savedArticles.get(index);
    }
}
