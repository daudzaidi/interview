package StructuralDP.CompositeDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public abstract class SongComponent {

    public void addComponent (SongComponent newSongComponent){
        throw new UnsupportedOperationException();
    }

    public void removeComponent (SongComponent removeSongComponent){
        throw new UnsupportedOperationException();
    }

    public SongComponent getComponent(int componentIndex){
        throw new UnsupportedOperationException();
    }

    public String getSongName(){
        throw new UnsupportedOperationException();
    }

    public String getBandName(){
        throw new UnsupportedOperationException();
    }

    public int getReleaseYear(){
        throw new UnsupportedOperationException();
    }

    public void displaySongInfo(){
        throw new UnsupportedOperationException();
    }
}
