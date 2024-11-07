package springmicroservice.service;

import springmicroservice.model.Snack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ServiceSnackFiles implements IServiceSnack {

    private final String NAME_FILE = "inventory_snacks.txt";
    private List<Snack> snacks = new ArrayList<>();

    public ServiceSnackFiles() {
        var file = new File(NAME_FILE);
        var exist = false;
        try {
            exist = file.exists();
            if (exist) {
                this.snacks = loadSnack();
                //this.snacks = loadSnackDefault();
            } else {
                var exit = new PrintWriter(new FileWriter(file));
                exit.close();
                System.out.println("File created succesfully.");
            }
        } catch (Exception e) {
            System.out.println("Error CREATING FILE : " + e.getMessage());
            loadSnackDefault();
        }
        if (!exist) {
            loadSnackDefault();
        }
    }

    private void loadSnackDefault() {
        this.AddSnack(new Snack("Lys", 1.25));
        this.AddSnack(new Snack("Sprite", 1.25));
        this.AddSnack(new Snack("Coca Cola", 1.25));
        this.AddSnack(new Snack("Tuna crakers", 3.25));
    }

    @Override
    public void AddSnack(Snack snack) {
        //  Add to list on memory
        this.snacks.add(snack);
        //  Save in file
        this.addSnackFile(snack);
    }

    @Override
    public void ShowSnacks() {
        System.out.println("--- Snacks en el Inventario ---");
        var inventorySnack = "";
        for (var snack : this.snacks) {
            inventorySnack += snack.toString() + "\n";
        }
        System.out.println(inventorySnack);
    }

    @Override
    public List<Snack> GetSnack() {
        return this.snacks;
    }

    private List<Snack> loadSnack() throws IOException {
        var snacks = new ArrayList<Snack>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(NAME_FILE));
            for (String line : lines) {
                String[] lineSnack = line.split(",");
                var idSnack = lineSnack[0];
                var name = lineSnack[1];
                var price = Double.parseDouble(lineSnack[2]);
                var snack = new Snack(name, price);
                snacks.add(snack);
            }
        } catch (Exception e) {
            System.out.println("Error Load Snack : " + e.getMessage());
            e.printStackTrace();
        }
        return snacks;
    }

    private void addSnackFile(Snack snack) {
        boolean add = false;
        var file = new File(NAME_FILE);
        try {
            add = file.exists();
            var exit = new PrintWriter(new FileWriter(file, add));
            exit.println(snack.toString());
            exit.close();
        } catch (Exception e) {
            System.out.println("Error Adding file : " + e.getMessage());
        }
    }

}
