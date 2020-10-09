package bd.psu.edu.team11.finalproj.Controllers;

import bd.psu.edu.team11.finalproj.Models.Order;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import bd.psu.edu.team11.finalproj.Models.Tracking;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class TrackingController {

    private HashMap<Integer,Tracking> trackingHashMap;

    public TrackingController()
    {
        this.trackingHashMap = new HashMap<>();
    }

    @GetMapping(path = "tracking/getDummy")
    public Tracking getTestTrack()
    {
        return new Tracking();
    }

    /**
    Check if user has admin status, then update order status accordingly
     */
    @PutMapping("tracking/updateOrder")
    public String updateOrderTracking(@RequestParam(name = "token")String token, @RequestParam(name = "orderID") Integer orderID, @RequestBody Tracking t) throws Exception
    {
        if(!AccountController.tokenHashMap.containsKey(token))
        {
            throw new Exception("Not Authorized");
        }
        else if(!OrderController.orderHashMap.containsKey(orderID))
        {
            throw new Exception("Order Not Found");
        }
        else if(!AccountController.tokenHashMap.get(token).isAuthorization()){
            throw new Exception("Not Authorized");
        }
        else
        {
            trackingHashMap.put(orderID, t);
            return "Order Status Updated";
        }
    }

    /**
     Check if user has admin status, then create new order and return success string
     */
    @PostMapping("tracking/createOrder")
    public String createOrderTracking(@RequestParam(name = "token")String token, @RequestParam(name = "orderID")Integer orderID, @RequestBody Tracking t) throws Exception
    {
        if(!AccountController.tokenHashMap.containsKey(token))
        {
            throw new Exception("Not Authorized");
        }
        else if(!AccountController.tokenHashMap.get(token).isAuthorization())
        {
            throw new Exception("Not Authorized");
        }
        else if(!OrderController.orderHashMap.containsKey(orderID))
        {
            throw new Exception("Order Not Found");
        }
        else
        {
            int id = trackingHashMap.size() + 1;
         	t.setOrder(OrderController.orderHashMap.get(orderID));
            trackingHashMap.put(id, t);
            return "Tracking Created!";
        }

    }

    /**
     Check if the user associated with the order is the same user trying to view this order
     If not also check if an admin is trying to view the order
     if either are true get the requested order
     */
    @GetMapping("tracking/getOrder")
    public Tracking getOrderTracking(@RequestParam(name = "token")String token, @RequestParam(name = "orderID")Integer orderID) throws Exception
    {
        if(!AccountController.tokenHashMap.containsKey(token))
        {
            throw new Exception("Not Authorized");
        }
        else if(!OrderController.orderHashMap.containsKey(orderID))
        {
            throw new Exception("Order Not Found");
        }
        else if(OrderController.orderHashMap.get(orderID).getUsername() != AccountController.tokenHashMap.get(token).getUsername() && !AccountController.tokenHashMap.get(token).isAuthorization())
        {
        throw new Exception("Access Denied: Can only view your order.");
        }
        else if(AccountController.tokenHashMap.get(token).isAuthorization()){
            return trackingHashMap.get(orderID);
        }
        else
        {
            return trackingHashMap.get(orderID);
        }
    }

    /**
     Check if user has admin status, then delete the order associated with the id
     */
    @DeleteMapping("tracking/deleteOrderTracking")
    public String deleteOrderTracking(@RequestParam(name = "token")String token, @RequestParam(name = "orderID")Integer orderID) throws Exception
    {
        if(!AccountController.tokenHashMap.containsKey(token))
        {
            throw new Exception("Not Authorized");
        }
        else if(!OrderController.orderHashMap.containsKey(orderID))
        {
            throw new Exception("Order Not Found");
        }
        else if(!AccountController.tokenHashMap.get(token).isAuthorization()){
            throw new Exception("Not Authorized");
        }
        else
        {
            trackingHashMap.remove(orderID);
            return "Order Removed Successfully!";
        }

    }



}
