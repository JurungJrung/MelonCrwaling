public class MelonTime {

    private String yyyymmdd;
    private String hhmm;

    public MelonTime(String yyyymmdd, String hhmm) {
        this.yyyymmdd = yyyymmdd;
        this.hhmm = hhmm;
    }

    public MelonTime() {

    }


    @Override
    public String toString() {
        return "Timer{" +
                "time='" + yyyymmdd + '\'' +
                ", times1='" + hhmm + '\'' +
                '}';
    }
}
