package bd.psu.edu.team11.finalproj.controller;

import bd.psu.edu.team11.finalproj.Controllers.AccountController;
import bd.psu.edu.team11.finalproj.Controllers.ReviewsController;
import bd.psu.edu.team11.finalproj.Models.Account;
import bd.psu.edu.team11.finalproj.Models.Review;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Vector;

import static org.hamcrest.CoreMatchers.is;

public class ReviewsControllerTest {

    private ReviewsController reviewsController;
    private Review review;
    String token;
    Integer accountID;

    @Before
    public void setUp() throws Exception
    {
        reviewsController = new ReviewsController();
        AccountController accountController = new AccountController();
        Account account = new Account();
      	account.setAuthorization(true);
        accountID = accountController.createAccount(account);
        token = accountController.Login(accountID, "password");

    }

    @After
    public void tearDown(){

    }

    /**
     * Happy path test for getDummyReview
     */
    @Test
    public void getDummyReviewHappy()
    {
        review = new Review();
        Assert.assertTrue(reviewsController.getDummyReview().getUsername() == review.getUsername());
    }

    /**
     * Happy path test for createReview
     */
    @Test
    public void createReviewHappy()throws Exception
    {
        review = new Review();
        reviewsController.createReview(token, "noodle", review);
        Vector<Review> reviewVector = reviewsController.getReviewList(token, "noodle");
        Assert.assertNotNull(reviewVector);
    }

    /**
     * Sad path test for createReview
     */
    @Test(expected = Exception.class)
    public void createReviewSad()throws Exception
    {
        review = new Review();
        int output = reviewsController.createReview(token, "wrong food name", review);
    }

    /**
     * Happy path test for getReviewsList
     */
    @Test
    public void getReviewsListHappy()throws Exception
    {
        review = new Review();
        Review review1 = new Review();
        reviewsController.createReview(token, "noodle", review);
        reviewsController.createReview(token, "noodle", review1);
        Vector<Review> reviewVector = reviewsController.getReviewList(token, "noodle");
        Assert.assertNotNull(reviewVector);
        Assert.assertTrue(reviewVector.get(1).getUsername() == "DummyUser");
    }

    /**
     * Sad path test for getReviewsList
     */
    @Test(expected = Exception.class)
    public void getReviewsListSad()throws Exception
    {
        review = new Review();
        reviewsController.createReview(token, "noodle", review);
        reviewsController.getReviewList(token, "wrong foodname");
    }

    /**
     * Happy path test for updateReview
     */
    @Test
    public void updateReviewHappy()throws Exception
    {
        review = new Review();
        int reviewID = reviewsController.createReview(token, "noodle", review);
        int reviewID2 = reviewsController.createReview(token, "noodle", review);
        Review newReview = new Review();
        newReview.setUsername("Test Username");
        String output = reviewsController.updateReview(token, "noodle", reviewID2, newReview);
        Vector<Review> reviewVector = reviewsController.getReviewList(token, "noodle");
        Assert.assertNotNull(reviewVector);
        Assert.assertTrue(reviewVector.get(1).getUsername() == "DummyUser");
    }

    /**
     * Sad path test for updateReview
     */
    @Test(expected = Exception.class)
    public void updateReviewSad()throws Exception
    {
        review = new Review();
        reviewsController.createReview(token, "noodle", review);
        Account account = new Account();
        AccountController accountController = new AccountController();
        int accountID = accountController.createAccount(account);
        String tokenNew = accountController.Login(accountID, "password");
        String output = reviewsController.updateReview(tokenNew, "noodle", accountID+1, review);
    }

    /**
     * Happy path test for deleteReview
     */
    @Test
    public void deleteReviewHappy()throws Exception
    {
        review = new Review();
        int reviewId = reviewsController.createReview(token, "noodle", review);
        String output = reviewsController.deleteReview(token, "noodle", reviewId);
        Assert.assertTrue(output == "Review Deleted");
        Vector<Review> reviewVector = reviewsController.getReviewList(token, "noodle");
        Assert.assertTrue(reviewVector.isEmpty());

    }

    /**
     * Sad path test for deleteReview
     */
    @Test(expected = Exception.class)
    public void deleteReviewSad()throws Exception
    {
        review = new Review();
        int reviewId = reviewsController.createReview(token, "noodle", review);

        Account account = new Account();
        account.setUsername("Test User");
        AccountController accountController = new AccountController();
        int accountID = accountController.createAccount(account);
        String tokenNew = accountController.Login(accountID, "password");


        String output = reviewsController.deleteReview(tokenNew, "noodle", reviewId);
    }

}
