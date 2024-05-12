public class MelonTime {

    private String times;
    private String times1;

    public MelonTime(String times, String times1) {
        this.times = times;
        this.times1 = times1;
    }


    @Override
    public String toString() {
        return "Timer{" +
                "time='" + times + '\'' +
                ", times1='" + times1 + '\'' +
                '}';
    }
}
