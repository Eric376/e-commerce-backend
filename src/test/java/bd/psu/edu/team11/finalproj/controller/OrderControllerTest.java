package bd.psu.edu.team11.finalproj.controller;

import bd.psu.edu.team11.finalproj.Controllers.AccountController;
import bd.psu.edu.team11.finalproj.Controllers.OrderController;
import bd.psu.edu.team11.finalproj.Models.Account;
import bd.psu.edu.team11.finalproj.Models.DTOs.OrderDTO;
import bd.psu.edu.team11.finalproj.Models.Order;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;

public class OrderControllerTest {

    Order order;
    OrderController orderController;
    String token;
    Integer accountID;

    @Before
    public void setUp()throws Exception
    {
        orderController = new OrderController();
        AccountController accountController = new AccountController();
        Account account = new Account();
        accountID = accountController.createAccount(account);
        token = accountController.Login(accountID, "password");
    }

    @After
    public void tearDown()
    {

    }

    /**
     * Happy path test for getOrderJSON to get a dummyAccount
     * @throws Exception
     */
    @Test
    public void getOrderJSONHappy()throws Exception
    {
        order = new Order();
        Order orderNew = orderController.getOrderJSON();
        Assert.assertTrue(order.getUsername() == orderNew.getUsername());
    }

    /**
     * Happy path test for createOrder
     */
    @Test
    public void createOrderHappy()throws Exception
    {
        order = new Order();
        order.setUsername("Test Username");
        order.setCardNumber("0000111122223333");
        int orderID = orderController.createOrder(token, order);
        Assert.assertTrue(orderID == 1);
    }

    /**
     * Sad path test for createOrder
     */
    @Test(expected = Exception.class)
    public void createOrderSad()throws Exception
    {
        order = new Order();
        order.setUsername("Test Username");
        order.setCardNumber("000011112222");
        int orderID = orderController.createOrder(token, order);
    }

    /**
     * Happy path test for getOrder
     */
    @Test
    public void getOrderHappy()throws Exception
    {
        order = new Order();
        order.setUsername("Test Username");
        order.setIceCream(10);
        order.setCardNumber("0000111122223333");
        int orderID = orderController.createOrder(token, order);
        OrderDTO orderDTO = orderController.getOrder(token, orderID);
        Assert.assertTrue(order.getIceCream() == orderDTO.getIceCream());
    }

    /**
     * Sad path test for getOrder
     */
    @Test(expected = Exception.class)
    public void getOrderSad()throws Exception
    {
        order = new Order();
        order.setUsername("Test Username");
        order.setCardNumber("0000111122223333");
        int orderID = orderController.createOrder(token, order);
        orderID++;
        OrderDTO orderDTO = orderController.getOrder(token, orderID);
    }

    /**
     * Happy path test for changeOrder
     */
    @Test
    public void changeOrderHappy()throws Exception
    {
        order = new Order();
        order.setUsername("Test Username");
        order.setIceCream(2);
        order.setCardNumber("0000111122223333");
        int orderID = orderController.createOrder(token, order);

        order.setIceCream(10);
        orderController.changeOrder(token, orderID, order);
        Assert.assertTrue(orderController.getOrder(token, orderID).getIceCream() == 10);
    }

    /**
     * Sad path test for changeOrder
     */
    @Test(expected = Exception.class)
    public void changeOrderSad()throws Exception
    {
        order = new Order();
        order.setUsername("Test Username");
        order.setIceCream(2);
        order.setCardNumber("0000111122223333");
        int orderID = orderController.createOrder(token, order);
        int temp = orderID + 1;
        orderController.changeOrder(token, temp, order);
    }

    /**
     * Happy path test for deleteOrder
     * @throws Exception
     */
    @Test(expected = Exception.class)
    public void deleteOrderHappy()throws Exception
    {
        order = new Order();
        order.setUsername("Test Username");
        order.setIceCream(2);
        order.setCardNumber("0000111122223333");
        int orderID = orderController.createOrder(token, order);

        orderController.DeleteOrder(token, orderID);
        orderController.getOrder(token, orderID);
    }

    /**
     * Sad path test for deleteOrder
     */
    @Test(expected = Exception.class)
    public void deleteOrderSad()throws Exception
    {
        order = new Order();
        order.setUsername("Test Username");
        order.setIceCream(2);
        order.setCardNumber("0000111122223333");
        int orderID = orderController.createOrder(token, order);
        orderID++;
        orderController.DeleteOrder(token, orderID);
    }

}
