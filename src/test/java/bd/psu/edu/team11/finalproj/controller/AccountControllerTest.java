package bd.psu.edu.team11.finalproj.controller;

import bd.psu.edu.team11.finalproj.Controllers.AccountController;
import bd.psu.edu.team11.finalproj.Models.Account;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.hamcrest.CoreMatchers.is;

public class AccountControllerTest {

    private AccountController accountController;
    private Account account;

    @Before
    public void setUp(){
        accountController = new AccountController();
        account = new Account();
    }

    @After
    public void tearDown(){

    }

    /**
     * Happy Path Test for Login
     * @throws Exception
     */
    @Test
    public void loginHappy() throws Exception
    {
        int accountId = accountController.createAccount(account);
        String token = accountController.Login(accountId, account.getPassword());
        Assert.assertTrue(token.length() == 13);
    }

    /**
     * Sad Path Test for Login
     * @throws Exception
     */
    @Test(expected = Exception.class)
    public void loginSad() throws Exception
    {
        int accountId = accountController.createAccount(account);
        String token = accountController.Login(1, "wrong password");
    }

    /**
     * Happy Path Test for getAccount
     * @throws Exception
     */
    @Test
    public void getAccountHappy()throws Exception
    {
        account = new Account();
        int accountID = accountController.createAccount(account);
        String token = accountController.Login(accountID, "password");
        Account testAccount = accountController.getAccount(token, accountID);
        Assert.assertTrue(testAccount.getUsername() == account.getUsername());
    }

    /**
     * Sad Path Test for getAccount
     * @throws Exception
     */
    @Test(expected = Exception.class)
    public void getAccountSad()throws Exception
    {
        account = new Account();
        int accountID = accountController.createAccount(account);
        String token = accountController.Login(accountID, "password");
        accountID++;
        accountController.getAccount(token, accountID);
    }

    /**
     * Happy Path Test for getDummyAccount
     */
    @Test
    public void getDummyAccountHappy()
    {
        account = accountController.getDummyAccount();
        Assert.assertTrue(account.getUsername() == "DummyUser");
    }

    /**
     * Sad Path Test for getDummyAccount
     */
    @Test
    public void createAccountHappy()
    {
        account = new Account();
        int accountID = accountController.createAccount(account);
        Assert.assertNotNull(accountID);
        Assert.assertTrue(accountID == 1);
    }

    /**
     * Happy Path Test for updateAccount
     * @throws Exception
     */
    @Test
    public void updateAccountHappy()throws Exception
    {
        account = new Account();
        account.setAuthorization(true);
        int accountID = accountController.createAccount(account);
        String token = accountController.Login(accountID, "password");
        Account account1 = new Account();
        account1.setUsername("Test Username");
        accountController.updateAccount(token, accountID, account1);
        Assert.assertTrue(accountController.getAccount(token, accountID).getUsername() == "Test Username");
    }

    /**
     * Sad Path Test for updateAccount
     * @throws Exception
     */
    @Test(expected = Exception.class)
    public void updateAccountSad()throws Exception
    {
        account = new Account();
        account.setAuthorization(false);
        int accountID = accountController.createAccount(account);
        String token = accountController.Login(accountID, "password");
        account.setUsername("Test Username");
        accountID++;
        accountController.updateAccount(token, accountID, account);
    }

    /**
     * Happy Path Test for deleteAccount
     * @throws Exception
     */
    @Test(expected = Exception.class)
    public void deleteAccountHappy()throws Exception
    {
        account = new Account();
        int accountID = accountController.createAccount(account);
        String token = accountController.Login(accountID, "password");
        accountController.deleteAccount(token, accountID);
        accountController.getAccount(token, accountID);
    }

    /**
     * Sad Path Test for deleteAccount
     * @throws Exception
     */
    @Test(expected = Exception.class)
    public void deleteAccountSad()throws Exception
    {
        account = new Account();
        account.setAuthorization(false);
        int accountID = accountController.createAccount(account);
        int accountTwoID = accountController.createAccount(account);
        String token = accountController.Login(accountID, "password");
        accountController.deleteAccount(token, accountTwoID);

    }


}

