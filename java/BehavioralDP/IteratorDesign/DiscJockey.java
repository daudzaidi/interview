package BehavioralDP.IteratorDesign;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * Created by shalvi on 09/04/16.
 */
public class DiscJockey {

    SongOfThe70s song70s;
    SongOfThe80s song80s;
    SongOfThe90s song90s;

    SongIterator itr70s;
    SongIterator itr80s;
    SongIterator itr90s;


    public DiscJockey(SongIterator song70s,SongIterator song80s, SongIterator song90s){
        this.itr70s = song70s;
        this.itr80s = song80s;
        this.itr90s = song90s;
    }

    public void showTheSongs(){
        ArrayList aL70sSongs = song70s.getBestSongs();

        System.out.println("Songs of the 70s\n");

        for(int i=0; i < aL70sSongs.size(); i++){

            SongInfo bestSongs = (SongInfo) aL70sSongs.get(i);

            System.out.println(bestSongs.getSongName());
            System.out.println(bestSongs.getBandName());
            System.out.println(bestSongs.getYearReleased() + "\n");

        }

        SongInfo[] array80sSongs = song80s.getBestSongs();

        System.out.println("Songs of the 80s\n");

        for(int j=0; j < array80sSongs.length; j++){

            SongInfo bestSongs = array80sSongs[j];

            System.out.println(bestSongs.getSongName());
            System.out.println(bestSongs.getBandName());
            System.out.println(bestSongs.getYearReleased() + "\n");

        }

        Hashtable<Integer, SongInfo> ht90sSongs = song90s.getBestSongs();

        System.out.println("Songs of the 90s\n");

        for (Enumeration<Integer> e = ht90sSongs.keys(); e.hasMoreElements();)
        {
            SongInfo bestSongs = ht90sSongs.get(e.nextElement());

            System.out.println(bestSongs.getSongName());
            System.out.println(bestSongs.getBandName());
            System.out.println(bestSongs.getYearReleased() + "\n");

        }

    }

    public void showTheSongs2(){

        Iterator songs70s = itr70s.createIterator();
        Iterator songs80s = itr80s.createIterator();
        Iterator songs90s = itr90s.createIterator();

        System.out.println("Print 70s Songs: \n");
        printTheSongs(songs70s);

        System.out.println("Print 80s Songs: \n");
        printTheSongs(songs80s);

        System.out.println("Print 90s Songs: \n");
        printTheSongs(songs90s);
    }

    private void printTheSongs(Iterator iterator) {
        while(iterator.hasNext()){
            SongInfo songInfo = (SongInfo) iterator.next();
            System.out.println(songInfo.getSongName());
            System.out.println(songInfo.getBandName());
            System.out.println(songInfo.getYearReleased() + "\n");
        }
    }
}
