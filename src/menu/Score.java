package menu;
// the score in the menu
public class Score implements java.io.Serializable, Comparable<Score> {

    private String name;
    private int scores;

    public Score() {
    }

    public Score(String name, int scores) {
        this.name = name;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    @Override
    public int compareTo(Score o) {
        return o.scores - this.scores;
    }
}
