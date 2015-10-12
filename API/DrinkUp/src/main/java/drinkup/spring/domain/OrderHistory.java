package drinkup.spring.domain;

import javax.persistence.*;

@Entity
public class OrderHistory   {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idOrderHistory;
    private String idENterprise;
    private int idCustomer;
    private String orderDate;

    private float price;
    private int status;

    public int getIdOrderHistory() {
        return idOrderHistory;
    }

    public void setIdOrderHistory(int idOrderHistory) {
        this.idOrderHistory = idOrderHistory;
    }

    public String getIdENterprise() {
        return idENterprise;
    }

    public void setIdENterprise(String idENterprise) {
        this.idENterprise = idENterprise;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}


