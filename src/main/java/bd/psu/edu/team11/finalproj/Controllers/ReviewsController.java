package bd.psu.edu.team11.finalproj.Controllers;

import bd.psu.edu.team11.finalproj.Models.Review;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Vector;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class ReviewsController
{
    private HashMap<String, HashMap<Integer, Review>> reviewHashMap;
    private HashMap<Integer, Review> emptyHashMap = new HashMap<>();//only used for instantiation
    public ReviewsController()
    {
        this.reviewHashMap = new HashMap<>();
        reviewHashMap.put("chickensandwich", emptyHashMap);
        reviewHashMap.put("beefsandwich", emptyHashMap);
        reviewHashMap.put("turkeysandwich", emptyHashMap);
        reviewHashMap.put("veggiesandwich", emptyHashMap);
        reviewHashMap.put("roastpork", emptyHashMap);
        reviewHashMap.put("pizza", emptyHashMap);
        reviewHashMap.put("fries", emptyHashMap);
        reviewHashMap.put("icecream", emptyHashMap);
        reviewHashMap.put("drink", emptyHashMap);
        reviewHashMap.put("noodle", emptyHashMap);
    }

    /**
     * Gets a dummy review with pre-filled test fields.
     */
    @GetMapping(path = "review/getDummy")
    public Review getDummyReview()
    {
        return new Review();
    }

    /**
     * Gets a list of all reviews under the specific food ID that is searched
     */
    @GetMapping(path = "review/getList")
    public Vector getReviewList(@RequestParam(name = "token")String token, @RequestParam(name = "food")String foodName) throws Exception
    {
        if(!AccountController.tokenHashMap.containsKey(token))
        {
            throw new Exception("Not Authorized");
        }
        else if(!reviewHashMap.containsKey(foodName))
        {
            throw new Exception("Food Not Found");
        }
        else
        {
            Vector<Review> reviewList = new Vector<>();
            for(int i = 0; i < reviewHashMap.get(foodName).size(); i++)
            {
                reviewList.add(reviewHashMap.get(foodName).get(i));
            }
            return  reviewList;
        }
    }

    /**
     * Creates a new review and adds it to the inner hmap of reviews for that specific food that was searched
     */
    @PostMapping(path = "review/create")
    public int createReview(@RequestParam(name = "token")String token, @RequestParam(name = "food") String foodName, @RequestBody Review newReview) throws Exception
    {
        if(!AccountController.tokenHashMap.containsKey(token))
        {
            throw new Exception("Not Authorized");
        }
        else
        {
            HashMap<Integer, Review> reviewInnerHMap;
            if(!reviewHashMap.containsKey(foodName))
            {
                throw new Exception("Food Not Found");
            }
            else
            {
                reviewInnerHMap = reviewHashMap.get(foodName);
                int reviewID = reviewInnerHMap.size()+1;
                newReview.setUsername(AccountController.tokenHashMap.get(token).getUsername());
                reviewInnerHMap.put(reviewID, newReview);
                reviewHashMap.put(foodName, reviewInnerHMap);
                return reviewID;
            }
        }
    }

    /**
     * Updates an existing review by searching by food name and then review ID
     */
    @PutMapping(path = "review/update")
    public String updateReview(@RequestParam(name = "token")String token, @RequestParam(name = "food") String foodName, @RequestParam(name = "reviewID") Integer reviewID, @RequestBody Review updatedReview) throws Exception
    {
        HashMap<Integer, Review> reviewInnerHMap;
        if(!AccountController.tokenHashMap.containsKey(token))
        {
            throw new Exception("Token Not found");
        }
        else if(!AccountController.tokenHashMap.get(token).isAuthorization() || !AccountController.tokenHashMap.get(token).getUsername().equals(reviewHashMap.get(foodName).get(reviewID).getUsername()))
        {
            throw new Exception("Not Authorized");
        }
        else if(AccountController.tokenHashMap.get(token).isAuthorization() || AccountController.tokenHashMap.get(token).getUsername().equals(reviewHashMap.get(foodName).get(reviewID).getUsername())
                && reviewHashMap.containsKey(foodName))
        {
            reviewInnerHMap = reviewHashMap.get(foodName);
            reviewInnerHMap.put(reviewID, updatedReview);
            reviewHashMap.put(foodName, reviewInnerHMap);
            return "Review Updated";
        }
        else
        {
            return "Food/Review ID Not Found.";
        }
    }

    /**
     * Deletes an existing review by searching by food name and review ID
     */
    @DeleteMapping(path = "review/delete")
    public String deleteReview(@RequestParam(name = "token")String token, @RequestParam(name = "food") String foodName, @RequestParam(name = "reviewID") Integer reviewID) throws Exception
    {
        HashMap<Integer, Review> reviewInnerHMap;
        if(!AccountController.tokenHashMap.containsKey(token))
        {
            throw new Exception("Token Not found");
        }
        else if(!AccountController.tokenHashMap.get(token).isAuthorization() || !AccountController.tokenHashMap.get(token).getUsername().equals(reviewHashMap.get(foodName).get(reviewID).getUsername()))
        {
            throw new Exception("Not Authorized");
        }
        else
        {
            if(!reviewHashMap.containsKey(foodName))
            {
                throw new Exception("Food Not Found");
            }
            else
            {
                reviewInnerHMap = reviewHashMap.get(foodName);
                reviewInnerHMap.remove(reviewID);
                reviewHashMap.put(foodName, reviewInnerHMap);
                return "Review Deleted";
            }
        }
    }



}
