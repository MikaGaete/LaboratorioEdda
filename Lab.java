import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Lab{
    public static void main(String[] args){
        List<Track> tracks = readTracks("tracks.csv");
        for (Track t: tracks) {
            System.out.println(t);
        }
    }
    private static List<Track> readTracks(String fileName){
        List<Track> tracks = new ArrayList<>();
        Path filePath = Paths.get(fileName);
        System.out.println(filePath.toAbsolutePath());

        try (BufferedReader br = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Track track = createTrack(attributes);
                tracks.add(track);
                line = br.readLine();
            }
        }
        catch (IOException ioex){
            ioex.printStackTrace();
        }
        return tracks;
    }

    public static Track createTrack(String[] metadata){
        String id = metadata[0];
        String trackName = metadata[1];
        int popularity = Integer.parseInt(metadata[2]);
        return new Track(id, trackName, popularity);
    }
    public static Track Contador(list<Track> List){
    	//-insertar aca- holi
    }

    static class Track{
        private String id;
        private String trackName;
        private int popularity;

        public Track(String id, String trackName, int popularity){
            this.id = id;
            this.trackName = trackName;
            this.popularity = popularity;
        }
        public String getID(){
            return id;
        }
        public void setId(String id){
            this.id = id;
        }
        public String getTrackName(){
            return trackName;
        }
        public void setTrackName(String trackName){
            this.trackName = trackName;
        }
        @Override
        public String toString(){
            return "Track [ID:" + id + "] [Name:" + trackName + "] [Popularity:" + popularity + "]";
        }
    }
}
