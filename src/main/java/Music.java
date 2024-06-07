public class Music {

    private String rank;
    private String title;
    private String singer;
    private String album;

    public MelonTime getMelonTime() {
        return melonTime;
    }

    public Music(MelonTime melonTime) {
        this.melonTime = melonTime;
    }

    public void setMelonTime(MelonTime melonTime) {
        this.melonTime = melonTime;
    }

    private MelonTime melonTime;

    public Music() {
    }

    public Music(String rank, String title, String singer, String album){
        this.rank = rank;
        this.title = title;
        this.singer = singer;
        this.album = album;
    }



    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String alum) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Music{" +
                "rank='" + rank + '\'' +
                ", title='" + title + '\'' +
                ", singer='" + singer + '\'' +
                ", alum='" + album + '\'' +
                '}';
    }


}
