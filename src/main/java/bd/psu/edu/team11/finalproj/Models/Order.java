package bd.psu.edu.team11.finalproj.Models;

public class Order
{
    private String cardNumber, expDate;
    private int CVV, chickenSandwich, beefSandwich, turkeySandwich, veggieSandwich, roastPork, pizza, fries, iceCream, drink, noodle;
    private String username;
    public Order() {
    }

    public Order(String username, String cardNumber, String expDate, int CVV, int chickenSandwich, int beefSandwich, int turkeySandwich, int veggieSandwich, int roastPork, int pizza, int fries, int iceCream, int drink, int noodle)
    {
        this.chickenSandwich = chickenSandwich;
        this.beefSandwich = beefSandwich;
        this.turkeySandwich = turkeySandwich;
        this.veggieSandwich = veggieSandwich;
        this.roastPork = roastPork;
        this.pizza = pizza;
        this.fries = fries;
        this.iceCream = iceCream;
        this.drink = drink;
        this.noodle = noodle;
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.CVV = CVV;
        this.username = username;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public int getChickenSandwich() {
        return chickenSandwich;
    }

    public void setChickenSandwich(int chickenSandwich) {
        this.chickenSandwich = chickenSandwich;
    }

    public int getBeefSandwich() {
        return beefSandwich;
    }

    public void setBeefSandwich(int beefSandwich) {
        this.beefSandwich = beefSandwich;
    }

    public int getTurkeySandwich() {
        return turkeySandwich;
    }

    public void setTurkeySandwich(int turkeySandwich) {
        this.turkeySandwich = turkeySandwich;
    }

    public int getVeggieSandwich() {
        return veggieSandwich;
    }

    public void setVeggieSandwich(int veggieSandwich) {
        this.veggieSandwich = veggieSandwich;
    }

    public int getRoastPork() {
        return roastPork;
    }

    public void setRoastPork(int roastPork) {
        this.roastPork = roastPork;
    }

    public int getPizza() {
        return pizza;
    }

    public void setPizza(int pizza) {
        this.pizza = pizza;
    }

    public int getFries() {
        return fries;
    }

    public void setFries(int fries) {
        this.fries = fries;
    }

    public int getIceCream() {
        return iceCream;
    }

    public void setIceCream(int iceCream) {
        this.iceCream = iceCream;
    }

    public int getDrink() {
        return drink;
    }

    public void setDrink(int drink) {
        this.drink = drink;
    }

    public int getNoodle() {
        return noodle;
    }

    public void setNoodle(int noodle) {
        this.noodle = noodle;
    }


}
