package BehavioralDP.IteratorDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public class SongInfo {
    String songName;
    String bandName;
    int yearReleased;

    public SongInfo(String newSongName, String newBandName, int newYearRelease){
        this.songName = newSongName;
        this.bandName= newBandName;
        this.yearReleased = newYearRelease;
    }

    public String getSongName() {
        return songName;
    }

    public String getBandName() {
        return bandName;
    }

    public int getYearReleased() {
        return yearReleased;
    }

}
