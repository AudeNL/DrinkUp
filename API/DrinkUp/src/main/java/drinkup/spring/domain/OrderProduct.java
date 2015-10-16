package drinkup.spring.domain;

import javax.persistence.*;

@Entity
public class OrderProduct   {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProduct;
    private int idOrder;

    private int quantity;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


