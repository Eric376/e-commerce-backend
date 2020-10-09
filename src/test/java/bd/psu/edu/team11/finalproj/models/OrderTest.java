package bd.psu.edu.team11.finalproj.models;

import bd.psu.edu.team11.finalproj.Models.Order;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

public class OrderTest {

    private Order order;

    @Before
    public void setUp(){
        order = new Order();
    }

    @After
    public void tearDown(){

    }

    /**
     * Happy path test for constructor
     */
    @Test
    public void Order()
    {
        Order order = new Order("username", "1111222233334444", "08/27", 288, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        Assert.assertTrue(order.getUsername()=="username");
        Assert.assertTrue(order.getCardNumber()=="1111222233334444");
        Assert.assertTrue(order.getExpDate()=="08/27");
        Assert.assertTrue(order.getCVV()==288);
        Assert.assertTrue(order.getChickenSandwich()==10);
        Assert.assertTrue(order.getBeefSandwich()==9);
        Assert.assertTrue(order.getTurkeySandwich()==8);
        Assert.assertTrue(order.getVeggieSandwich()==7);
        Assert.assertTrue(order.getRoastPork()==6);
        Assert.assertTrue(order.getPizza()==5);
        Assert.assertTrue(order.getFries()==4);
        Assert.assertTrue(order.getIceCream()==3);
        Assert.assertTrue(order.getDrink()==2);
        Assert.assertTrue(order.getNoodle()==1);
    }


    /**
     * Happy path tests for all setters and getters
     */
    @Test
    public void expDate()
    {
        order.setExpDate("08/27");
        Assert.assertTrue(order.getExpDate() == "08/27");
    }

    @Test
    public void cardNumber()
    {
        order.setCardNumber("1111222233334444");
        Assert.assertTrue(order.getCardNumber()=="1111222233334444");
    }

    @Test
    public void cvv()
    {
        order.setCVV(9);
        Assert.assertTrue(order.getCVV()==9);
    }

    @Test
    public void chickenSand()
    {
        order.setChickenSandwich(10);
        Assert.assertTrue(order.getChickenSandwich()==10);
    }

    @Test
    public void beefSand()
    {
        order.setBeefSandwich(10);
        Assert.assertTrue(order.getBeefSandwich()==10);
    }

    @Test
    public void turkeySand()
    {
        order.setTurkeySandwich(10);
        Assert.assertTrue(order.getTurkeySandwich()==10);
    }

    @Test
    public void veggieSand()
    {
        order.setVeggieSandwich(10);
        Assert.assertTrue(order.getVeggieSandwich()==10);
    }

    @Test
    public void roastPork()
    {
        order.setRoastPork(5);
        Assert.assertTrue(order.getRoastPork()==5);
    }

    @Test
    public void pizza()
    {
        order.setPizza(5);
        Assert.assertTrue(order.getPizza()==5);
    }

    @Test
    public void fries()
    {
        order.setFries(3);
        Assert.assertTrue(order.getFries()==3);
    }

    @Test
    public void iceCream()
    {
        order.setIceCream(6);
        Assert.assertTrue(order.getIceCream()==6);
    }

    @Test
    public void drink()
    {
        order.setDrink(4);
        Assert.assertTrue(order.getDrink()==4);
    }

    @Test
    public void noodle()
    {
        order.setNoodle(8);
        Assert.assertTrue(order.getNoodle()==8);
    }

    @Test
    public void username()
    {
        order.setUsername("username");
        Assert.assertTrue(order.getUsername()=="username");
    }
}

