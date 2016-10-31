package BehavioralDP.IteratorDesign;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by shalvi on 09/04/16.
 */
public class SongOfThe80s implements SongIterator{

    SongInfo[] bestSongs;
    int arrayIndex =0;

    public SongOfThe80s(){

        bestSongs = new SongInfo[3];
        addSong("Roam","leone",1981);
        addSong("American Too","mclean",1985);
        addSong("great","gaynoe",1989);
    }

    public void addSong(String songName, String bandName, int yearReleased) {

        SongInfo songInfo = new SongInfo(songName,bandName,yearReleased);
        bestSongs[arrayIndex]=songInfo;
        arrayIndex++;
    }


    public SongInfo[] getBestSongs() {
        return bestSongs;
    }

    @Override
    public Iterator createIterator() {
        return Arrays.asList(bestSongs).iterator();
    }
}
