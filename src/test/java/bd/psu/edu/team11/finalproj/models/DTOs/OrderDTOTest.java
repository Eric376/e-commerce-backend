package bd.psu.edu.team11.finalproj.models.DTOs;

import bd.psu.edu.team11.finalproj.Models.DTOs.OrderDTO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderDTOTest {

    private OrderDTO orderDTO;

    @Before
    public void setUp(){
        orderDTO = new OrderDTO();
    }

    @After
    public void tearDown(){

    }

    /**
     * Happy path for constructor
     */
    @Test
    public void OrderDTO()
    {
        OrderDTO orderDTO = new OrderDTO(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        Assert.assertTrue(orderDTO.getChickenSandwich()==10);
        Assert.assertTrue(orderDTO.getBeefSandwich()==9);
        Assert.assertTrue(orderDTO.getTurkeySandwich()==8);
        Assert.assertTrue(orderDTO.getVeggieSandwich()==7);
        Assert.assertTrue(orderDTO.getRoastPork()==6);
        Assert.assertTrue(orderDTO.getPizza()==5);
        Assert.assertTrue(orderDTO.getFries()==4);
        Assert.assertTrue(orderDTO.getIceCream()==3);
        Assert.assertTrue(orderDTO.getDrink()==2);
        Assert.assertTrue(orderDTO.getNoodle()==1);
    }

    /**
     * Happy paths for all getters and setters
     */
    @Test
    public void chickenSand()
    {
        orderDTO.setChickenSandwich(10);
        Assert.assertTrue(orderDTO.getChickenSandwich()==10);
    }

    @Test
    public void beefSand()
    {
        orderDTO.setBeefSandwich(10);
        Assert.assertTrue(orderDTO.getBeefSandwich()==10);
    }

    @Test
    public void turkeySand()
    {
        orderDTO.setTurkeySandwich(10);
        Assert.assertTrue(orderDTO.getTurkeySandwich()==10);
    }

    @Test
    public void veggieSand()
    {
        orderDTO.setVeggieSandwich(10);
        Assert.assertTrue(orderDTO.getVeggieSandwich()==10);
    }

    @Test
    public void roastPork()
    {
        orderDTO.setRoastPork(5);
        Assert.assertTrue(orderDTO.getRoastPork()==5);
    }

    @Test
    public void pizza()
    {
        orderDTO.setPizza(5);
        Assert.assertTrue(orderDTO.getPizza()==5);
    }

    @Test
    public void fries()
    {
        orderDTO.setFries(3);
        Assert.assertTrue(orderDTO.getFries()==3);
    }

    @Test
    public void iceCream()
    {
        orderDTO.setIceCream(6);
        Assert.assertTrue(orderDTO.getIceCream()==6);
    }

    @Test
    public void drink()
    {
        orderDTO.setDrink(4);
        Assert.assertTrue(orderDTO.getDrink()==4);
    }

    @Test
    public void noodle()
    {
        orderDTO.setNoodle(8);
        Assert.assertTrue(orderDTO.getNoodle()==8);
    }
}

