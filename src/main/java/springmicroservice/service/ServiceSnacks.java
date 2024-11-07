package springmicroservice.service;

import java.util.ArrayList;
import java.util.List;
import springmicroservice.model.Snack;

public class ServiceSnacks implements IServiceSnack {

    private static final List<Snack> snacks;

    //STATIC BLOQUE INICIALIZER
    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Lys", 1.25));
        snacks.add(new Snack("Sprite", 1.25));
        snacks.add(new Snack("Coca Cola", 1.25));
        snacks.add(new Snack("Tuna crakers", 3.25));
    }
    
    @Override
    public void AddSnack(Snack snack) {
        snacks.add(snack);
    }

    @Override
    public void ShowSnacks() {
        var inventory = "";
        for (var snack : snacks) {
            inventory += snack.toString();
        }
        System.out.println("Inventory");
        System.out.print(inventory);
    }

    @Override
    public List<Snack> GetSnack() {
        return snacks;
    }
}
