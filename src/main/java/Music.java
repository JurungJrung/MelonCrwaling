public class Music {

    private String rank;
    private String title;
    private String singer;
    private String alum;

    public Music() {
    }

    public Music(String rank, String title, String singer, String alum){
        this.rank = rank;
        this.title = title;
        this.singer = singer;
        this.alum = alum;
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

    public String getAlum() {
        return alum;
    }

    public void setAlum(String alum) {
        this.alum = alum;
    }

    @Override
    public String toString() {
        return "Music{" +
                "rank='" + rank + '\'' +
                ", title='" + title + '\'' +
                ", singer='" + singer + '\'' +
                ", alum='" + alum + '\'' +
                '}';
    }


}
