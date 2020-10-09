package bd.psu.edu.team11.finalproj.Controllers;

import bd.psu.edu.team11.finalproj.Models.Account;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Random;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class AccountController
{
    private HashMap<Integer, Account> accountHashMap;
    public static HashMap<String, Account> tokenHashMap;

    public AccountController()
    {
        this.accountHashMap = new HashMap<>();
        AccountController.tokenHashMap = new HashMap<>();
    }

    /**
     * Get request to login into an existing account in the hashmap. Takes AccountHashMap ID as Param and Password for Body.
     * Outputs a 6Number-6Letter token.
     */
    @GetMapping(path = "account/login")
    public String Login(@RequestParam(name = "id")int accountID, @RequestParam(name = "password") String password) throws Exception
    {
        if(!accountHashMap.containsKey(accountID))
        {
            throw new Exception("Account ID Not Found");
        }
        else
        {
            if (!password.equals(accountHashMap.get(accountID).getPassword()))
            {
                throw new Exception("Incorrect Password");
            }
            else
            {
               return generateToken(accountHashMap.get(accountID));
            }
        }
    }

    /**
     * Gets a dummy account with pre-filled test fields.
     */
    @GetMapping(path = "account/getDummy")
    public Account getDummyAccount()
    {
        return new Account();
    }

    /**
     * Gets an account by searching Account ID associated with the HashMap
     */
    @GetMapping(path = "account/get")
    public Account getAccount(@RequestParam(name = "token")String token, @RequestParam(name = "id")int id) throws Exception
    {
        Account acc = new Account();
        if(!tokenHashMap.containsKey(token))
        {
            throw new Exception("Invalid Token");
        }
        else if(!accountHashMap.containsKey(id))
        {
            throw new Exception("Invalid Account ID");
        }
        else if(tokenHashMap.get(token).isAuthorization())
        {
            acc = this.accountHashMap.get(id);
        }
        else
        {
            acc = acc.convertToDTO(this.accountHashMap.get(id));
        }
        return acc;
    }

    /**
     * Creates a new account and puts it into the Account HashMap. Returns account ID
     * number that is auto-generated.
     */
    @PostMapping(path = "account/create")
    public int createAccount(@RequestBody Account newAccount)
    {
        int id = this.accountHashMap.size() + 1;
        this.accountHashMap.put(id, newAccount);
        return id;
    }

    /**
     * Updates an existing account by searching by Account ID associated with the account in the HashMap
     */
    @PutMapping(path = "account/update")
    public String updateAccount(@RequestParam(name = "token")String token, @RequestParam(name = "id") int id, @RequestBody Account updatedAccount) throws Exception
    {
        if(!tokenHashMap.containsKey(token))
        {
            throw new Exception("Invalid Token");
        }
        else if(!accountHashMap.containsKey(id))
        {
            throw new Exception("Account Not Found");
        }
        else if(!tokenHashMap.get(token).isAuthorization() || !tokenHashMap.get(token).getUsername().equals(accountHashMap.get(id).getUsername()))
        {
            throw new Exception("Not Authorized to Edit Account");
        }
        else if(tokenHashMap.get(token).isAuthorization() && tokenHashMap.get(token).getUsername().equals(accountHashMap.get(id).getUsername()))
        {
            this.accountHashMap.put(id, updatedAccount);
        }
        else
        {
            this.accountHashMap.put(id, updatedAccount);
            AccountController.tokenHashMap.put(token, updatedAccount);

        }
        return "Update Successful";
    }

    /**
     * Deletes an existing account by searching by Account ID associated with the account in the HashMap
     */
    @DeleteMapping(path = "account/delete")
    public String deleteAccount(@RequestParam(name = "token")String token, @RequestParam(name = "id") int id) throws Exception
    {
        if(!tokenHashMap.containsKey(token))
        {
            throw new Exception("Invalid Token");
        }
        else if(!accountHashMap.containsKey(id))
        {
            throw new Exception("Account Not Found");
        }
        else if(!tokenHashMap.get(token).isAuthorization() || !tokenHashMap.get(token).getUsername().equals(accountHashMap.get(id).getUsername()))
        {
            throw new Exception("Not Authorized to Edit Account");
        }
        else if(tokenHashMap.get(token).isAuthorization() && tokenHashMap.get(token).getUsername().equals(accountHashMap.get(id).getUsername()))
        {
            this.accountHashMap.remove(id);
        }
        else
        {
            this.accountHashMap.remove(id);
            AccountController.tokenHashMap.remove(token);
        }
        return "Delete Successful";
    }

    /**
     * Generates a 6Digit-6Letter token, add it to hashmap, and outputs it as a string
     */
    private String generateToken(Account account)
    {
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder((100000 + rnd.nextInt(900000)) + "-");
        for (int i = 0; i < 6; i++)
        {
            sb.append(chars[rnd.nextInt(chars.length)]);
        }
        String output = sb.toString();
        tokenHashMap.put(output, account);
        return output;
    }
}
