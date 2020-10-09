package bd.psu.edu.team11.finalproj.models;

import bd.psu.edu.team11.finalproj.Models.Review;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.util.Date;

public class ReviewTest {

    private Review review;


    @Before
    public void setUp(){
        review = new Review();

    }

    @After
    public void tearDown(){

    }

    /**
     * Happy path test for constructor
     */
    @Test
    public void Review()
    {
        Date date = new Date();
        review = new Review("username", 5, "testtext", date);
        Assert.assertTrue(review.getUsername() == "username");
        Assert.assertTrue(review.getRating()==5);
        Assert.assertTrue(review.getReviewText()=="testtext");
        Assert.assertTrue(review.getTimestamp()==date);
    }

    /**
     * Happy path tests for all setters and getters
     */
    @Test
    public void username()
    {
        review.setUsername("username");
        Assert.assertTrue(review.getUsername()=="username");
    }

    @Test
    public void rating()
    {
        review.setRating(10);
        Assert.assertTrue(review.getRating()==10);
    }

    @Test
    public void reviewText()
    {
        review.setReviewText("Test Text");
        Assert.assertTrue(review.getReviewText()=="Test Text");
    }

    @Test
    public void timestamp()
    {
        Date date = new Date();
        review.setTimestamp(date);
        Assert.assertTrue(review.getTimestamp()==date);
    }
}

