package drinkup.spring.domain;

import javax.persistence.*;

@Entity
public class ProductIngredient   {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCustomer;
    private int idIngredient;

    public int getIdCustomer() {
        return idCustomer;
    }
    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdIngredient() {
        return idIngredient;
    }
    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }


}
