package jp.ac.asojuku.st.anbayasiroulette;

/**
 * Created by satakenaoto on 2016/10/07.
 */
public class AnbayasiData {
    private int number;
    private int addition;
    private String comment;

    //Constructer
    public AnbayasiData(int number, int addition, String comment) {
        this.number = number;
        this.addition = addition;
        this.comment = comment;
    }

    public int getNumber() {
        return number;
    }

    public int getAddition() {
        return  addition;
    }

    public String getComment() {
        return comment;
    }
}
