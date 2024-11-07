package springmicroservice.snackmachinefiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import springmicroservice.model.Snack;
import springmicroservice.service.IServiceSnack;
import springmicroservice.service.ServiceSnackFiles;

public class SnackMachine {

    public static void main(String[] args) {
        Machine();
    }

    public static void Machine() {
        var exit = false;
        var read = new Scanner(System.in);
        List<Snack> products = new ArrayList<>();
        System.out.println("Developed by Oscar Lopez");
        //IServiceSnack serviceSnacks = new ServiceSnacks();
        IServiceSnack serviceSnacks = new ServiceSnackFiles();
        

        serviceSnacks.ShowSnacks();
        while (!exit) {
            try {
                var option = showMenu(read);
                exit = executeOption(option, read, products, serviceSnacks);
            } catch (Exception e) {
                System.out.println("ERROR : " + e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }

    private static int showMenu(Scanner console) {
        System.out.println("""
                           Menu : \n
                           [1] Buy snack
                           [2] Show ticket
                           [3] Add new snack
                           [4] Exit
                           Select an option:\s""");
        return Integer.parseInt(console.nextLine());
    }

    private static boolean executeOption(int option, Scanner read, List<Snack> products, IServiceSnack serviceSnacks) {
        var exit = false;
        switch (option) {
            case 1 ->
                BuySnack(read, products, serviceSnacks);
            case 2 ->
                ShowTicket(products);
            case 3 ->
                AddSnack(read, serviceSnacks);
            case 4 ->
                exit = exit();
            //break;
        }
        return exit;
    }

    private static void BuySnack(Scanner read, List<Snack> products, IServiceSnack serviceSnacks) {
        System.out.println("What snack would you like to buy, tipe [id]?");
        var idSnack = Integer.parseInt(read.nextLine());
        var snackFind = false;
        for (var snack : serviceSnacks.GetSnack()) {
            if (idSnack == snack.getIdSnack()) {
                products.add(snack);
                System.out.println("Snack added");
                snackFind = true;
                break;
            }
        }
        if (!snackFind) {
            System.out.println("Id snack selected is not in our information. ID TYPED : " + idSnack);
        }
    }

    private static void AddSnack(Scanner console, IServiceSnack serviceSnacks) {
        System.out.print("Name snack : ");
        var name = console.nextLine();
        System.out.print("Price snack $ ");
        var price = Double.parseDouble(console.nextLine());
        serviceSnacks.AddSnack(new Snack(name, price));
        System.out.println("Snack created succesfully.\n");
        serviceSnacks.ShowSnacks();

    }

    private static boolean exit() {
        System.out.println("Have a wonderful day.\n");
        return true;
    }

    private static void ShowTicket(List<Snack> products) {
        var ticket = "***   Ticket sold ***";
        var total = 0.0;
        for (var product : products) {
            ticket += "\n\t" + product.getName() + " - $" + product.getPrice();
            total += product.getPrice();
        }
        ticket += "\n\t Total $ " + total;
        System.out.println(ticket);
    }

}
