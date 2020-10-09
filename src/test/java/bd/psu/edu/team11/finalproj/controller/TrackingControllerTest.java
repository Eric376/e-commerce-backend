package bd.psu.edu.team11.finalproj.controller;

import bd.psu.edu.team11.finalproj.Controllers.AccountController;
import bd.psu.edu.team11.finalproj.Controllers.OrderController;
import bd.psu.edu.team11.finalproj.Controllers.TrackingController;
import bd.psu.edu.team11.finalproj.Models.Account;
import bd.psu.edu.team11.finalproj.Models.Order;
import bd.psu.edu.team11.finalproj.Models.Tracking;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class TrackingControllerTest {

    private TrackingController trackingController;
    private Tracking tracking;
    String token;
    Integer accountID;
    Integer orderID;

    @Before
    public void setUp() throws Exception
    {
        trackingController = new TrackingController();
        AccountController accountController = new AccountController();
        Account account = new Account();
        account.setAuthorization(true);
        accountID = accountController.createAccount(account);
        token = accountController.Login(accountID, "password");
        OrderController orderController = new OrderController();
        Order order = new Order();
        order.setUsername("Test User");
        order.setCardNumber("1111222233334444");
        orderID = orderController.createOrder(token, order);
    }

    @After
    public void tearDown(){

    }

    /**
     * Happy path test to get dummyTracking
     */
    @Test
    public void getTestTrackHappy()
    {
        Tracking newTracking = new Tracking();
        Assert.assertTrue(newTracking.getId() == trackingController.getTestTrack().getId());
    }


    /**
     * Happy path test for createOrderTracking
     */
    @Test
    public void createOrderTrackingHappy()throws Exception
    {
        tracking = new Tracking();
        String output = trackingController.createOrderTracking(token, orderID, tracking);
        Assert.assertTrue(output == "Tracking Created!");
    }

    /**
     * Sad path test for createOrderTracking
     */
    @Test(expected = Exception.class)
    public void createOrderTrackingSad()throws Exception
    {
        tracking = new Tracking();
        String output = trackingController.createOrderTracking(token, 2, tracking);
    }

    /**
     * Happy path test for getOrderTracking
     */
    @Test
    public void getOrderTrackingHappy()throws Exception
    {
        tracking = new Tracking();
        tracking.setStatus("Completed!");
        String output = trackingController.createOrderTracking(token, orderID, tracking);
        Tracking newTrack = trackingController.getOrderTracking(token, orderID);
        Assert.assertTrue(newTrack.getStatus() == "Completed!");
    }

    /**
     * Sad path test for getOrderTracking
     */
    @Test(expected = Exception.class)
    public void getOrderTrackingSad()throws Exception
    {
        tracking = new Tracking();
        Account account = new Account();
        account.setAuthorization(false);
        AccountController accountController = new AccountController();
        int accountID = accountController.createAccount(account);
        String tokenNew = accountController.Login(accountID, "password");
        String output = trackingController.createOrderTracking(tokenNew, orderID, tracking);
    }

    /**
     * Happy path test for updateOrderTracking
     */
    @Test
    public void updateOrderTrackingHappy()throws Exception
    {
        tracking = new Tracking();
        String output = trackingController.createOrderTracking(token, orderID, tracking);
        tracking.setStatus("Completed!");
        trackingController.updateOrderTracking(token, orderID, tracking);
        Assert.assertTrue(trackingController.getOrderTracking(token, orderID).getStatus() == "Completed!");

    }

    /**
     * Sad path test for updateOrderTracking
     */
    @Test(expected = Exception.class)
    public void updateOrderTrackingSad()throws Exception
    {
        tracking = new Tracking();
        String output = trackingController.createOrderTracking(token, orderID, tracking);
        trackingController.updateOrderTracking(token, orderID+1, tracking);
    }

    /**
     * Happy path test for deleteOrderTracking
     */
    @Test
    public void deleteOrderTrackingHappy()throws Exception
    {
        tracking = new Tracking();
        trackingController.createOrderTracking(token, orderID, tracking);
        String output = trackingController.deleteOrderTracking(token, orderID);
        Assert.assertTrue(output == "Order Removed Successfully!");
    }

    /**
     * Sad path test for deleteOrderTracking
     */
    @Test(expected = Exception.class)
    public void deleteOrderTrackingSad()throws Exception
    {
        tracking = new Tracking();
        trackingController.createOrderTracking(token, orderID, tracking);
        Account account = new Account();
        account.setAuthorization(false);
        AccountController accountController = new AccountController();
        int accountID = accountController.createAccount(account);
        String tokenNew = accountController.Login(accountID, "password");
        String output = trackingController.deleteOrderTracking(tokenNew, orderID);
    }

}
