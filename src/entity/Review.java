package entity;

/**
 *  Entità relativa alle recensioni
 *  @author Beccarini Luca, Ludovisi Linda, Paci Andrea
 *  @version 1.0
 */
public class Review
{
    private int ID;
    private String text;
    private int announceID;
    private int userID;

    public Review(int ID, String text, int announceID, int userID) {
        this.ID = ID;
        this.text = text;
        this.announceID = announceID;
        this.userID = userID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getAnnounceID() {
        return announceID;
    }

    public void setAnnounceID(int announceID) {
        this.announceID = announceID;
    }


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

}
