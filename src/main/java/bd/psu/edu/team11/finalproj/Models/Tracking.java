package bd.psu.edu.team11.finalproj.Models;

public class Tracking {
    int id;
    String status;
    Order order;

    public Tracking() {
        this.id  = 123;
        this.status = "Baking";
        this.order = new Order();
    }

    public Tracking(int id, String status, Order order) {
        this.id = id;
        this.status = status;
        this.order = order;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
