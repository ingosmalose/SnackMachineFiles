package springmicroservice.model;

import java.io.Serializable;
import java.util.Objects;

public class Snack implements Serializable {

    private static int conterSnack = 0;
    private int idSnack;
    private String name;
    private Double price;

    public Snack() {
        this.idSnack = ++Snack.conterSnack;
    }

    public Snack(String name, Double price) {
        this();
        this.name = name;
        this.price = price;
    }

    public int getConterSnack() {
        return conterSnack;
    }

    public int getIdSnack() {
        return idSnack;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setName(String nameSnack) {
        this.name = nameSnack;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nSnack {"
                + "Id : [" + idSnack
                + "], Name = " + name
                + ", Price $ " + price
                + "}";
    }
    
    public String escribirSnack() {
        return idSnack + "," + name + "," + price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSnack, name, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Snack other = (Snack) obj;
        if (this.idSnack != other.idSnack) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.price, other.price);
    }

}
