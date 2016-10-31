package StructuralDP.CompositeDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public class DiscJockey {

    SongComponent songList;

    public DiscJockey(SongComponent newSonglist){
        songList = newSonglist;
    }

    public void getSongList(){
        songList.displaySongInfo();
    }
}
