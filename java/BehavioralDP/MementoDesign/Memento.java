package BehavioralDP.MementoDesign;

/**
 * Created by shalvi on 10/04/16.
 */
public class Memento {
    //basic objects

    private String article;

    public Memento(String article) {
        this.article = article;
    }

    public String getSavedArticle() {
        return article;
    }
}
