package problem1;

import java.util.Scanner;

public class Sales
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many salespeople are there: ");
        int numberOfSalespeople = scanner.nextInt();
        int[] salesData = new int[numberOfSalespeople];

        // Collect sales data
        for (int i = 0; i < numberOfSalespeople; i++) {
            System.out.print("Enter sales for salesperson " + (i + 1) + ": ");
            salesData[i] = scanner.nextInt();
        }

        // Initialize stats
        int totalSalesAmount = 0;
        int highestSaleAmount = salesData[0];
        int topSalespersonId = 0;
        int lowestSaleAmount = salesData[0];
        int bottomSalespersonId = 0;

        // Display sales data and compute stats
        System.out.println("\nSalesperson | Sales");
        System.out.println("--------------------");

        for (int i = 0; i < numberOfSalespeople; i++) {
            System.out.printf("%11d | %d%n", (i + 1), salesData[i]);
            totalSalesAmount += salesData[i];

            if (salesData[i] > highestSaleAmount) {
                highestSaleAmount = salesData[i];
                topSalespersonId = i;
            }
            if (salesData[i] < lowestSaleAmount) {
                lowestSaleAmount = salesData[i];
                bottomSalespersonId = i;
            }
        }

        // Summary
        double averageSalesAmount = (double) totalSalesAmount / numberOfSalespeople;
        System.out.println("\nTotal sales: " + totalSalesAmount);
        System.out.printf("Average sales: %.2f%n", averageSalesAmount);
        System.out.println("Highest sale: Salesperson " + (topSalespersonId + 1) + " with $" + highestSaleAmount);
        System.out.println("Lowest sale:  Salesperson " + (bottomSalespersonId + 1) + " with $" + lowestSaleAmount);

        // Amount comparison
        System.out.print("\nEnter an amount: ");
        int thresholdAmount = scanner.nextInt();

        System.out.println("\nSalespeople who exceeded that amount:");
        int exceededCount = 0;

        for (int salespersonIndex = 0; salespersonIndex < numberOfSalespeople; salespersonIndex++) {
            if (salesData[salespersonIndex] >= thresholdAmount) {
                System.out.println("* Salesperson " + (salespersonIndex + 1) + " with a sale of $" + salesData[salespersonIndex]);
                exceededCount++;
            }
        }

        System.out.println("Number of salespeople who exceeded that amount: " + exceededCount);
        scanner.close();
    }
}
