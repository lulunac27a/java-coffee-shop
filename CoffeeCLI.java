import java.util.Scanner;

public class CoffeeShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalBill = 0.0;
        boolean ordering = true;

        System.out.println("=== Welcome to the Java Coffee Shop ===");

        while (ordering) {
            System.out.println("\nSelect a drink:");
            System.out.println("1. Coffee - $3.25");
            System.out.println("2. Espresso - $4.25");
            System.out.println("3. Tea - $2.75");
            System.out.println("4. Checkout / Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            double itemCost = 0.0;

            switch (choice) {
                case 1:
                    itemCost = 3.25;
                    itemCost += customizeDrink(scanner, true, true); // can add
                                                                     // cream/sugar
                    break;
                case 2:
                    itemCost = 4.25;
                    itemCost += customizeDrink(scanner, false, false); // espresso
                                                                       // custom
                                                                       // options
                    break;
                case 3:
                    itemCost = 2.75;
                    break;
                case 4:
                    ordering = false;
                    continue;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            totalBill += itemCost;
            System.out.printf("Item added! Current total: $%.2f%n", totalBill);
        }

        System.out.printf("\nThank you! Your final total is: $%.2f%n",
                totalBill);
        scanner.close();
    }

    public static double customizeDrink(Scanner scanner, boolean allowCream,
            boolean allowSugar) {
        double extrasCost = 0.0;

        System.out.print("Do you want it iced? (y/n): ");
        char iced = scanner.next().charAt(0); // Iced is no extra charge

        if (allowCream) {
            System.out.print("Add cream for $0.50? (y/n): ");
            char cream = scanner.next().charAt(0);
            if (cream == 'y' || cream == 'Y') {
                extrasCost += 0.50;
            }
        }

        if (allowSugar) {
            System.out.print("Add sugar for $0.50? (y/n): ");
            char sugar = scanner.next().charAt(0);
            if (sugar == 'y' || sugar == 'Y') {
                extrasCost += 0.50;
            }
        }

        return extrasCost;
    }
}
