package drinkup.spring.domain;

import javax.persistence.*;

@Entity
public class Comment   {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCustomer;
    private int idProduct;

    private String comment;

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
