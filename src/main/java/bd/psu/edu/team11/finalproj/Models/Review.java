package bd.psu.edu.team11.finalproj.Models;

import java.util.Calendar;
import java.util.Date;

public class Review
{
    private String username;
    private int rating;
    private String reviewText;
    private Date timestamp;

    public Review()
    {
        this.username = "DummyAuthor";
        this.rating = 1;
        this.reviewText = "Test Review Text";
        this.timestamp = Calendar.getInstance().getTime();
    }

    public Review(String author, int rating, String reviewText, Date timestamp)
    {
        this.username = author;
        this.rating = rating;
        this.reviewText = reviewText;
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String author) {
        this.username = author;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
