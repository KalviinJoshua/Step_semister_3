public class Playlist {
    private String[] songs;
    private int songCount;
    public Playlist(int maxSize) {
        songs = new String[maxSize];
        songCount = 0;
    }
    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        } else {
            System.out.println("Playlist is full.");
        }
    }
    public String[] getSongs() {
        String[] copy = new String[songCount];
        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }
        return copy;
    }
    public int getSongCount() {
        return songCount;
    }
    public static void main(String[] args) {
        Playlist playlist = new Playlist(10);
        playlist.addSong("Song A");
        playlist.addSong("Song B");
        String[] copy = playlist.getSongs();
        copy[0] = "Hacked";
        System.out.println("Songs in playlist:");
        String[] actualSongs = playlist.getSongs();
        for (String song : actualSongs) {
            System.out.println(song);
        }
        System.out.println("Song count: "
                + playlist.getSongCount());
    }
}