package menu;


import java.util.ArrayList;
import java.util.Collections;
// the record in the high score
public class Record implements java.io.Serializable {

    private String str ="&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;";
    public Record() {
        scoress = new ArrayList<>();
    }
   
    public boolean isjinru10(int fenshu) {

        if (scoress.size() < 10) {
            return true;
        }

        Collections.sort(scoress);
        if (scoress.get(9).getScores() < fenshu) {
            return true;
        }
        return false;
    }


    private ArrayList<Score> scoress;

    public ArrayList<Score> getFenshus() {
        return scoress;
    }

    public void setFenshus(ArrayList<Score> fenshuses) {
        this.scoress = fenshuses;
    }


    public String getAllName(){
        StringBuffer stringBuffer = new StringBuffer();
        Collections.sort(scoress);
        int len = Math.min(scoress.size(), 10);
        stringBuffer.append("<html>");
        for (int i = 0; i < len; i++) {
            stringBuffer.append("<p>"+ scoress.get(i).getName() + "</p>");
        }
        for (int i = len; i < 10; i++) {
            stringBuffer.append("<p>"+"player"   + "</p>");
        }

        stringBuffer.append("</html>");

        return stringBuffer.toString();
    }
    public String getAllFenshu(){
        StringBuffer stringBuffer = new StringBuffer();
        Collections.sort(scoress);
        int len = Math.min(scoress.size(), 10);
        stringBuffer.append("<html>");
        for (int i = 0; i < len; i++) {
            stringBuffer.append("<p>"+ scoress.get(i).getScores() + "</p>");
        }
        for (int i = len; i < 10; i++) {
            stringBuffer.append("<p>"+"0"   + "</p>");
        }

        stringBuffer.append("</html>");

        return stringBuffer.toString();
    }

}
