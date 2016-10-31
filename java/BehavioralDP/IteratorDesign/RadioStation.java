package BehavioralDP.IteratorDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public class RadioStation {

    public static void main(String... args){
        SongOfThe70s song70s = new SongOfThe70s();
        SongOfThe80s song80s = new SongOfThe80s();
        SongOfThe90s song90s = new SongOfThe90s();
        DiscJockey madMike = new DiscJockey(song70s,song80s,song90s);
        //madMike.showTheSongs();
        madMike.showTheSongs2();
    }
}
