package drinkup.spring.domain;

import javax.persistence.*;

@Entity
public class Pub   {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idEnterprise;

    private String namePub;
    private String adress;
    private String zipCode;
    private String city;
    private int xVal;
    private int yVal;
    private int zVal;
    private int idType;

    public String getIdEnterprise() {
        return idEnterprise;
    }

    public void setIdEnterprise(String idEnterprise) {
        this.idEnterprise = idEnterprise;
    }

    public String getNamePub() {
        return namePub;
    }

    public void setNamePub(String namePub) {
        this.namePub = namePub;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getxVal() {
        return xVal;
    }

    public void setxVal(int xVal) {
        this.xVal = xVal;
    }

    public int getyVal() {
        return yVal;
    }

    public void setyVal(int yVal) {
        this.yVal = yVal;
    }

    public int getzVal() {
        return zVal;
    }

    public void setzVal(int zVal) {
        this.zVal = zVal;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }
}
