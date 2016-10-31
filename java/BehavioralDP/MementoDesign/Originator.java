package BehavioralDP.MementoDesign;

/**
 * Created by shalvi on 10/04/16.
 */
public class Originator {

    private String article;

    public void setArticle(String article) {
        System.out.println("From Originator: Current Version of article \n"+ article+"\n");
        this.article = article;
    }

    public Memento storeinMemento(){
        System.out.println("From Originator: Saving to memento\n");
        return new Memento(article);
    }

    public String restoreMemento(Memento memento){
        article = memento.getSavedArticle();
        System.out.println("From Originator: Previous article saved to memento\n");
        return article;
    }
}
