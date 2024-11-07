package springmicroservice.snackmachinefiles;

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
    
    public int getConterSnack(){
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
//        return "\nSnack {"
//                + "\nId Snack : " + idSnack
//                + "\nName Snack : " + name
//                + "\nPrice Snack : " + price
//                + "\n}";

return "\nSnack {"
                + "Id : [" + idSnack
                + "] Name = " + name
                + ". Price $ " + price
                + "}";
    }
    
    //  equals() -> Boolean
    //  hashCode() -> Int

    @Override
    public int hashCode() {
        return Objects.hash(idSnack, name, price);
        /*
        int hash = 3;
        hash = 17 * hash + this.idSnack;
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + Objects.hashCode(this.price);
        return hash;
        //*/
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
