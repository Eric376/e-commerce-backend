package bd.psu.edu.team11.finalproj.Models;

public class Account
{
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;
    private String password;
    private boolean authorization;

    public Account()
    {
        this.username = "DummyUser";
        this.firstName = "Test";
        this.lastName = "Test";
        this.email = "Test";
        this.address = "Test";
        this.phoneNumber = "Test";
        this.password = "password";
        this.authorization = false;
    }

    public Account(String username, int id, String firstName, String lastName, String email, String address, String phoneNumber, String password, boolean authorization) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.authorization = authorization;
    }

    public Account convertToDTO(Account accountIn)
    {
        Account accountOut = new Account();
        accountOut.setUsername(accountIn.username);
        accountOut.setFirstName(accountIn.firstName);
        accountOut.setLastName("Not Authorized.");
        accountOut.setEmail(accountIn.email);
        accountOut.setAddress("Not Authorized.");
        accountOut.setPhoneNumber(accountIn.phoneNumber);
        accountOut.setPassword("Not Authorized.");
        accountOut.setAuthorization(false);
        return accountOut;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAuthorization() {
        return authorization;
    }

    public void setAuthorization(boolean authorization) {
        this.authorization = authorization;
    }
}


