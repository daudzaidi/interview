package BehavioralDP.IteratorDesign;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by shalvi on 09/04/16.
 */
public class SongOfThe70s implements SongIterator {


    ArrayList<SongInfo> bestSongs;

    public SongOfThe70s(){

        bestSongs = new ArrayList<>();
        addSong("Imagine","leone",1971);
        addSong("American Pie","mclean",1975);
        addSong("I Will Survive","gaynoe",1979);
    }

    public void addSong(String songName, String bandName, int yearReleased) {

        SongInfo songInfo = new SongInfo(songName,bandName,yearReleased);
        bestSongs.add(songInfo);
    }


    public ArrayList<SongInfo> getBestSongs() {
        return bestSongs;
    }

    @Override
    public Iterator createIterator() {
        return bestSongs.iterator();
    }
}
