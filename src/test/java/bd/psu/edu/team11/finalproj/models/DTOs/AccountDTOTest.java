package bd.psu.edu.team11.finalproj.models.DTOs;

import bd.psu.edu.team11.finalproj.Models.DTOs.AccountDTO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountDTOTest {
    private AccountDTO accountDTO;

    @Before
    public void setUp(){
        accountDTO = new AccountDTO();
        accountDTO.setAddress("here");
        accountDTO.setEmail("email");
        accountDTO.setFirstName("john");
        accountDTO.setLastName("gaylor");
        accountDTO.setPhoneNumber("1234567");
    }

    @After
    public void tearDown(){

    }

    @Test
    public void AccountDTO(){
        Assert.assertEquals("here", accountDTO.getAddress());
        Assert.assertEquals("email", accountDTO.getEmail());
        Assert.assertEquals("john", accountDTO.getFirstName());
        Assert.assertEquals("gaylor", accountDTO.getLastName());
        Assert.assertEquals("1234567", accountDTO.getPhoneNumber());
    }
}
