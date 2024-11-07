package springmicroservice.snackmachinefiles;

import java.util.ArrayList;
import java.util.List;

public class Snacks {
    private static final List<Snack> snacks;
    
    //STATIC BLOQUE INICIALIZER
    static{
        snacks = new ArrayList<>();
        snacks.add(new Snack("Lys",1.25));
        snacks.add(new Snack("Sprite",1.25));        
        snacks.add(new Snack("Coca Cola",1.25));
        snacks.add(new Snack("Tuna crakers",3.25));
    }
    
    public static void AddSnack(Snack snack){
        snacks.add(snack);
    }
    
    public static void ShowSnacks(){
        var inventory = "";
        for(var snack : snacks){
            inventory += snack.toString();
        }
        System.out.println("Inventory");
        System.out.print(inventory);
    }
    
    public static List<Snack> GetSnack(){
        return snacks;
    }
}
