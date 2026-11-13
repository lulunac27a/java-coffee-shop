import java.util.Scanner;

public class CoffeeShop {
    // Machine inventory and money state
    private int water = 1000;      // in ml
    private int milk = 500;        // in ml
    private int coffeeBeans = 100; // in grams
    private int cups = 10;         // disposable cups
    private double money = 50.00;  // cash register balance

    public static void main(String[] args) {
        CoffeeShop machine = new CoffeeShop();
        machine.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Java Coffee Shop!");

        while (running) {
            System.out.println("\nSelect an option: [buy] [fill] [status] [exit]");
            System.out.print("> ");
            String action = scanner.nextLine().trim().toLowerCase();

            switch (action) {
                case "buy":
                    buyCoffee(scanner);
                    break;
                case "fill":
                    fillSupplies(scanner);
                    break;
                case "status":
                    printStatus();
                    break;
                case "exit":
                    running = false;
                    System.out.println("Shutting down coffee machine. Have a great day!");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
        scanner.close();
    }

    private void buyCoffee(Scanner scanner) {
        System.out.println("\nMenu:");
        System.out.println("1 - Espresso ($2.50)");
        System.out.println("2 - Latte ($3.50)");
        System.out.println("3 - Cappuccino ($3.00)");
        System.out.println("back - Return to main menu");
        System.out.print("> ");

        String choice = scanner.nextLine().trim().toLowerCase();

        switch (choice) {
            case "1":
                makeDrink("Espresso", 250, 0, 16, 2.50);
                break;
            case "2":
                makeDrink("Latte", 350, 75, 20, 3.50);
                break;
            case "3":
                makeDrink("Cappuccino", 200, 100, 12, 3.00);
                break;
            case "back":
                return;
            default:
                System.out.println("Invalid menu selection.");
        }
    }

    private void makeDrink(String name, int reqWater, int reqMilk, int reqBeans, double cost) {
        if (water < reqWater) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < reqMilk) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeBeans < reqBeans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            water -= reqWater;
            milk -= reqMilk;
            coffeeBeans -= reqBeans;
            cups -= 1;
            money += cost;
            System.out.printf("Resources confirmed! Dispensing your %s. Enjoy!%n", name);
        }
    }

    private void fillSupplies(Scanner scanner) {
        try {
            System.out.print("Add water (ml): ");
            water += Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Add milk (ml): ");
            milk += Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Add coffee beans (grams): ");
            coffeeBeans += Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Add disposable cups: ");
            cups += Integer.parseInt(scanner.nextLine().trim());

            System.out.println("Supplies restocked!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter whole numbers only.");
        }
    }

    private void printStatus() {
        System.out.println("\n--- Coffee Machine Inventory ---");
        System.out.println("Water: " + water + " ml");
        System.out.println("Milk: " + milk + " ml");
        System.out.println("Coffee beans: " + coffeeBeans + " g");
        System.out.println("Disposable cups: " + cups);
        System.out.printf("Cash balance: $%.2f%n", money);
    }
}
