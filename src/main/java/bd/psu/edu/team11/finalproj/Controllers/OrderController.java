package bd.psu.edu.team11.finalproj.Controllers;

import bd.psu.edu.team11.finalproj.Models.DTOs.OrderDTO;
import bd.psu.edu.team11.finalproj.Models.Order;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class OrderController
{
    public static HashMap<Integer, Order> orderHashMap;
    public double total;
    public OrderController()
    {
        orderHashMap=new HashMap<>();
    }

    /**
     * get Dummy to get Intial message content
     * @return
     */
    @GetMapping(path="order/getDummy")
    public Order getOrderJSON(){return new Order();}

    /**
     * create create order path and the method take in the token from token hash map and order id
     * if the tokenhashmap does not contain the key, it will not be authorized.
     * @param token
     * @param newOrder
     * @return
     * @throws Exception
     */
    @PostMapping(path="order/createOrder")
    public Integer createOrder (@RequestParam(name = "token")String token, @RequestBody Order newOrder) throws Exception
    {

        if(!AccountController.tokenHashMap.containsKey(token))
        {
            throw new Exception("Not Authorized");
        }
        else
        {
            if(newOrder.getCardNumber().length()!=16)
            {
                throw new Exception("Your Card Information is Not Correct");
            }
            total=newOrder.getBeefSandwich()*2.5+newOrder.getChickenSandwich()*2.25+newOrder.getDrink()*1.5+newOrder.getFries()*2.15+newOrder.getIceCream()*2.15+newOrder.getPizza()*3.5+newOrder.getRoastPork()*3.15+newOrder.getNoodle()*4.25+newOrder.getTurkeySandwich()*3.15+newOrder.getVeggieSandwich()*3.5;
            int orderID = orderHashMap.size()+1;
            newOrder.setUsername(AccountController.tokenHashMap.get(token).getUsername());
            orderHashMap.put(orderID, newOrder);
            return orderID;
        }

    }

    /**
     * update order and read in token and id
     * @param token
     * @param payNumber
     * @param updatePay
     * @return authorized if the token hash map contains the token and the id is the same, else is not authorized
     * @throws Exception
     */
    @PutMapping(path="order/updateOrder")
    public String changeOrder(@RequestParam(name = "token") String token, @RequestParam(name="id") int payNumber, @RequestBody Order updatePay) throws Exception
    {
        if(!AccountController.tokenHashMap.containsKey(token))
        {
            throw new Exception("Not Authorized");
        }
        else if(!orderHashMap.containsKey(payNumber))
        {
            throw new Exception("Order ID Not Found");
        }
        else if (AccountController.tokenHashMap.get(token).isAuthorization() || orderHashMap.get(payNumber).getUsername()==AccountController.tokenHashMap.get(token).getUsername()&&orderHashMap.containsKey(payNumber))
        {    total = updatePay.getBeefSandwich() * 2.5 + updatePay.getChickenSandwich() * 2.25 + updatePay.getDrink() * 1.5 + updatePay.getFries() * 2.15 + updatePay.getIceCream() * 2.15 + updatePay.getPizza() * 3.5 + updatePay.getRoastPork() * 3.15 + updatePay.getNoodle() * 4.25 + updatePay.getTurkeySandwich() * 3.15 + updatePay.getVeggieSandwich() * 3.5;
            orderHashMap.put(payNumber, updatePay);
            return "Total price: "+ total+". Update Success!";
        } else
        {
            return  "You Are Not Authorized";
        }
    }

    /**
     * to display the order, we will hind the credit card information, and only get the data of food.
     * @param token
     * @param id
     * @return the order DTO with only name of order.
     * @throws Exception
     */
    @GetMapping(path="order/getOrder")
    public OrderDTO getOrder(@RequestParam(name = "token") String token, @RequestParam(name="id") int id) throws Exception
    {
        if(!AccountController.tokenHashMap.containsKey(token))
        {
            throw new Exception("Not Authorized");
        }
        Order order = orderHashMap.get(id);
        return new OrderDTO(order);

    }

    /**
     * the delete order will delete the order from user if they are authorized.
     * @param token
     * @param id
     * @return if authorized print out Delete Successful. Else is not authorized
     * @throws Exception
     */
    @DeleteMapping(path="order/deleteOrder")
    public String DeleteOrder (@RequestParam(name = "token") String token, @RequestParam(name="id") int id) throws Exception
    {
        if(!AccountController.tokenHashMap.containsKey(token))
        {
            throw new Exception("Not Authorized");
        }
        else if(!orderHashMap.containsKey(id))
        {
            throw new Exception("Order ID Not Found");
        }
        else if(AccountController.tokenHashMap.get(token).isAuthorization() || orderHashMap.get(id).getUsername()==AccountController.tokenHashMap.get(token).getUsername()&&orderHashMap.containsKey(id))
        {
            orderHashMap.remove(id);
            return "Delete Successful";
        }else
        {
            return "You Are Not Authorized";
        }
    }
}
