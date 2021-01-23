package entity;

/**
 *  Entità relativa alla segnalazione
 *  @author Beccarini Luca, Ludovisi Linda, Paci Andrea
 *  @version 1.0
 */
public class SignalInfo
{
    private int userID;
    private int announceID;
    private int reviewID;
    private int signalerID;

    public SignalInfo(int userID, int announceID, int reviewID, int signalerID) {
        this.userID = userID;
        this.announceID = announceID;
        this.reviewID = reviewID;
        this.signalerID = signalerID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getAnnounceID() {
        return announceID;
    }

    public void setAnnounceID(int announceID) {
        this.announceID = announceID;
    }

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public int getSignalerID() {
        return signalerID;
    }

    public void setSignalerID(int signalerID) {
        this.signalerID = signalerID;
    }
}
