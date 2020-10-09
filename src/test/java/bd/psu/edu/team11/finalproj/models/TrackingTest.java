package bd.psu.edu.team11.finalproj.models;

import bd.psu.edu.team11.finalproj.Models.Order;
import bd.psu.edu.team11.finalproj.Models.Tracking;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrackingTest {

    private Tracking tracking;

    @Before
    public void setUp(){
        tracking = new Tracking();
    }

    @After
    public void tearDown(){

    }

    /**
     * Happy path test for constructor
     */
    @Test
    public void Tracking()
    {
        Order order = new Order();
        tracking = new Tracking(8, "status", order);
        Assert.assertTrue(tracking.getId()==8);
        Assert.assertTrue(tracking.getStatus()=="status");
        Assert.assertTrue(tracking.getOrder().getUsername() == order.getUsername());
    }

    /**
     * Happy path test for all setters and getters
     */
    @Test
    public void id()
    {
        tracking.setId(10);
        Assert.assertTrue(tracking.getId()==10);
    }

    @Test
    public void status()
    {
        tracking.setStatus("test status");
        Assert.assertTrue(tracking.getStatus()=="test status");
    }

    @Test
    public void order()
    {
        Order order = new Order();
        tracking.setOrder(order);
        Assert.assertTrue(tracking.getOrder().getUsername() == order.getUsername());
    }
}

