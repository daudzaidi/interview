package BehavioralDP.IteratorDesign;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * Created by shalvi on 09/04/16.
 */
public class SongOfThe90s implements  SongIterator {

    Hashtable<Integer,SongInfo> bestSongs;
    Integer index=0;
    public SongOfThe90s(){

        bestSongs = new Hashtable<>();
        addSong("Work","leone",1991);
        addSong("Runnin Low","mclean",1995);
        addSong("Faded","gaynoe",1999);
    }

    public void addSong(String songName, String bandName, int yearReleased) {

        SongInfo songInfo = new SongInfo(songName,bandName,yearReleased);
        bestSongs.put(index++,songInfo);
    }

    public Hashtable<Integer, SongInfo> getBestSongs() {
        return bestSongs;
    }

    @Override
    public Iterator createIterator() {
        return bestSongs.values().iterator();
    }
}
