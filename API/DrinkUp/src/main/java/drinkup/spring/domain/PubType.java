package drinkup.spring.domain;

import javax.persistence.*;

@Entity
public class PubType   {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idType;

    private String nameType;

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
}
