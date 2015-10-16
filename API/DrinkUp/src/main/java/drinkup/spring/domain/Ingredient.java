package drinkup.spring.domain;

import javax.persistence.*;

@Entity
public class Ingredient   {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idIngredient;

    private String nameIngredient;

    public int getIdIngredient() {
        return idIngredient;
    }
    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getNameIngredient() {
        return nameIngredient;
    }
    public void setNameIngredient(String idIngredient) {
        this.nameIngredient = nameIngredient;
    }


}
