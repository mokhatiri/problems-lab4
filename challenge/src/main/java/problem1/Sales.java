package problem1;

import java.util.Scanner;

public class Sales
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many salespeople are there: ");
        int salesCount = scanner.nextInt();
        if (salesCount <= 0) {
            System.out.println("Number of salespeople must be positive.");
            scanner.close();
            return;
        }
        int[] salesAmounts = new int[salesCount];

        // Initialize stats
        int totalSalesAmount = 0;
        int highestSaleAmount = Integer.MIN_VALUE;
        int topSalespersonId = 0;
        int lowestSaleAmount = Integer.MAX_VALUE;
        int bottomSalespersonId = 0;

        // Read sales, display each line, and compute stats in one loop
        System.out.println("\nSalesperson Sales");
        System.out.println("--------------------");

        for (int i = 0; i < salesCount; i++) {
            System.out.print("Enter sales for salesperson " + (i + 1) + ": ");
            salesAmounts[i] = scanner.nextInt();

            // display
            System.out.printf("%11d | %d%n", (i + 1), salesAmounts[i]);

            // stats
            totalSalesAmount += salesAmounts[i];
            if (salesAmounts[i] > highestSaleAmount) {
                highestSaleAmount = salesAmounts[i];
                topSalespersonId = i;
            }
            if (salesAmounts[i] < lowestSaleAmount) {
                lowestSaleAmount = salesAmounts[i];
                bottomSalespersonId = i;
            }
        }

        // Summary
        double averageSalesAmount = (double) totalSalesAmount / salesCount;
        System.out.println("\nTotal sales: " + totalSalesAmount);
        System.out.printf("Average sales: %.2f%n", averageSalesAmount);
        System.out.println("Highest sale: Salesperson " + (topSalespersonId + 1) + " with $" + highestSaleAmount);
        System.out.println("Lowest sale:  Salesperson " + (bottomSalespersonId + 1) + " with $" + lowestSaleAmount);

        // Amount comparison
        System.out.print("\nEnter an amount: ");
        int thresholdAmount = scanner.nextInt();

        System.out.println("\nSalespeople who exceeded that amount:");
        int exceededCount = 0;

        for (int i = 0; i < salesCount; i++) {
            if (salesAmounts[i] > thresholdAmount) {
                System.out.println("* Salesperson " + (i + 1) + " with a sale of $" + salesAmounts[i]);
                exceededCount++;
            }
        }

        System.out.println("Number of salespeople who exceeded that amount: " + exceededCount);
        scanner.close();
    }
}