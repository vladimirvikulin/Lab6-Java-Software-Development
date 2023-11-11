/**
 * The `App` class represents the main application to manage and display a gift of sweets.
 */
import sweets.*;
import gift.Gift;
import java.util.List;
import java.util.Scanner;

public class App {
    /**
     * The main method that runs the application.
     *
     * @param args The command-line arguments (not used in this application).
     * @throws Exception An exception that can occur during program execution.
     */
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in);){
            int studentBook = 1106;
            int C13 = studentBook % 13;
            System.out.println("C13:" + C13);
            Gift gift = new Gift();

            Waffle waffleArtek = new Waffle("Artek", 100, 3, 50, "Banana", 20, "American ");
            Candy candyToffee = new Candy("Toffee", 50, 1, 25, "Caramel", 10, true);
            Candy candyMars = new Candy("Mars", 100, 1, 75, "Original", 50, true);
            Lollipop lollipopChupaChups = new Lollipop("Chupa Chups", 25, 0, 75, "Strawberry", 0, "Ball");

            gift.addSweet(waffleArtek);
            gift.addSweet(candyToffee);
            gift.addSweet(candyMars);
            gift.addSweet(lollipopChupaChups);

            System.out.println("Total Weight of the Gift: " + gift.getTotalWeight());

            System.out.println("Sweets in the Gift:");
            gift.displaySweets();

            gift.sortSweetsByPrice();
            System.out.println("Sweets in the Gift (sorted by price):");
            gift.displaySweets();

            System.out.println("Write min chocolate content to find:");
            double minChocolateContent = scanner.nextDouble();
            System.out.println("Write max chocolate content to find:");
            double maxChocolateContent = scanner.nextDouble();
            if (minChocolateContent < 0 || maxChocolateContent < 0) {
                System.out.println("Please enter non-negative values for chocolate content");
            } else {
                List<Sweet> selectedSweets = gift.findSweetsByChocolateContentRange(minChocolateContent, maxChocolateContent);
                if (selectedSweets.isEmpty()) {
                    System.out.println("No sweets were found");
                } else {
                    System.out.println("Sweets with Cocoa Content between " + minChocolateContent + "% and " + maxChocolateContent + "%:");
                    for (Sweet sweet : selectedSweets) {
                        System.out.println(sweet.getDescription());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
