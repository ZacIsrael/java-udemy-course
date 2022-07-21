public class Episode {

    private String title; // episode title
    private double duration; // episode duration (minutes)

    public Episode next; // reference to next episode in the playlist
    public Episode previous; // reference to previous episode in playlist

    public Episode(String title, double duration, Episode next, Episode previous) {
        this.title = title;
        this.duration = duration;
        this.next = next;
        this.previous = previous;
    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "(" + this.title + "|" + this.duration + "MIN)";
    }
}
