package StructuralDP.CompositeDesign;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by shalvi on 09/04/16.
 */
public class SongGroup extends SongComponent {

    ArrayList songComponents;

    String groupName;
    String groupDescription;

    public SongGroup(String newGroupName, String newGroupDescription){
        this.groupDescription=newGroupDescription;
        this.groupName=newGroupName;
        songComponents = new ArrayList();

    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void addComponent(SongComponent newSongComponent){
        songComponents.add(newSongComponent);
    }

    public void removeComponent(SongComponent deleteSongComponent){
        songComponents.remove(deleteSongComponent);
    }

    public SongComponent getComponent(int index){
        return (SongComponent)songComponents.get(index);
    }

    public void displaySongInfo(){
        System.out.println(getGroupName()+ " "+ getGroupDescription()+"\n");

        Iterator songIterator = songComponents.iterator();

        while(songIterator.hasNext()){
            SongComponent songComponent = (SongComponent) songIterator.next();
            songComponent.displaySongInfo();
        }
    }

}
