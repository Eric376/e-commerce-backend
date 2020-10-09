package bd.psu.edu.team11.finalproj.models;

import bd.psu.edu.team11.finalproj.Controllers.AccountController;
import bd.psu.edu.team11.finalproj.Models.Account;
import bd.psu.edu.team11.finalproj.Models.DTOs.AccountDTO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
    private Account account;

    // Run before each test
    @Before
    public void setUp() throws Exception {
        // 1. orderController = new OrderController();
        account = new Account();
        account.setUsername("user123");
        account.setFirstName("John");
        account.setLastName("Gaylor");
        account.setEmail("johngsth@gmail.com");
        account.setAddress("123 One Lane");
        account.setPhoneNumber("814-765-1512");
        account.setPassword("password");
        account.setAuthorization(true);
    }

    // Indicates a method that needs to be run after each other
    @After
    public void tearDown() throws Exception {
        System.out.println("Test Completed");
    }

    // Any test method will always return void

    @Test
    public void Account(){
        Assert.assertEquals("user123", account.getUsername());
        Assert.assertEquals("John", account.getFirstName());
        Assert.assertEquals("Gaylor", account.getLastName());
        Assert.assertEquals("johngsth@gmail.com", account.getEmail());
        Assert.assertEquals("123 One Lane", account.getAddress());
        Assert.assertEquals("814-765-1512", account.getPhoneNumber());
        Assert.assertEquals("password", account.getPassword());
        Assert.assertTrue(account.isAuthorization());
    }

    @Test
    public void convertToDTO(){
        Account convertedAccount;
        convertedAccount = account.convertToDTO(account);
        Assert.assertEquals("Not Authorized.", convertedAccount.getLastName());
        Assert.assertEquals("Not Authorized.", convertedAccount.getAddress());
        Assert.assertEquals("Not Authorized.", convertedAccount.getPassword());
        Assert.assertFalse(convertedAccount.isAuthorization());
    }

    /**
     * Happy path test to get a username
     */
    @Test
    public void getUserName(){
        Assert.assertTrue(account.getUsername().equals("user123"));
    }

    @Test
    public void setUserName(){
        Assert.assertEquals("user123", account.getUsername());
    }

    @Test
    public void getFirstName(){
        Assert.assertEquals("John", account.getFirstName());
    }

    @Test
    public void setFirstName(){
        Assert.assertEquals("John", account.getFirstName());
    }

    @Test
    public void getLastName(){
        Assert.assertEquals("Gaylor", account.getLastName());
    }

    @Test
    public void setLastName(){
        Assert.assertEquals("Gaylor", account.getLastName());
    }

    @Test
    public void getEmail(){
        Assert.assertEquals("johngsth@gmail.com", account.getEmail());
    }

    @Test
    public void setEmail(){
        Assert.assertEquals("johngsth@gmail.com", account.getEmail());
    }

    @Test
    public void getAddress(){
        Assert.assertEquals("123 One Lane", account.getAddress());
    }

    @Test
    public void setAddress(){
        Assert.assertEquals("123 One Lane", account.getAddress());
    }

    @Test
    public void getPhoneNumber(){
        Assert.assertEquals("814-765-1512", account.getPhoneNumber());
    }

    @Test
    public void setPhoneNumber(){
        Assert.assertEquals("814-765-1512", account.getPhoneNumber());
    }

    @Test
    public void getPassword(){
        Assert.assertEquals("password", account.getPassword());
    }

    @Test
    public void setPassword(){
        Assert.assertEquals("password", account.getPassword());
    }

    @Test
    public void isAuthorization(){
        Assert.assertTrue(account.isAuthorization());
    }

    @Test
    public void setAuthorization(){
        Assert.assertTrue(account.isAuthorization());
    }
}

