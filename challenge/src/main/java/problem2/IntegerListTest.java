package problem2;

import java.util.Scanner;
public class IntegerListTest
{
    static IntegerList integerList = new IntegerList(10);
    static Scanner userInput = new Scanner(System.in);
    //-------------------------------------------------------
// Create a list, then repeatedly print the menu and do what the
// user asks until they quit
//-------------------------------------------------------
    public static void main(String[] args)
    {
        printMenu();
        int userChoice = userInput.nextInt();
        
        while (userChoice != 0)
        {
            handleUserChoice(userChoice);
            printMenu();
            userChoice = userInput.nextInt();
        }
    }
    //--------------------------------------
// Do what the menu item calls for
//--------------------------------------
    public static void handleUserChoice(int userChoice)
    {
        // int loc;
        switch(userChoice)
        {
            case 0:
                System.out.println("Bye!");
                break;
                
            case 1:
                System.out.println("How big should the list be?");
                int newSize = userInput.nextInt();
                integerList = new IntegerList(newSize);
                // list.randomize();
                break;
                
            case 2:
                integerList.print();
                break;
                
            case 3:
                System.err.println("Enter the integer you want to add : ");
                int newElement = userInput.nextInt();
                integerList.addElement(newElement);
                break;
                
            case 4:
                System.err.println("Enter the integer you want to remove : ");
                int elementToRemove = userInput.nextInt();
                integerList.removeFirst(elementToRemove);
                break;
                
            case 5:
                System.err.println("Enter the integer you want to remove entirely: ");
                int elementToRemoveAll = userInput.nextInt();
                integerList.removeAll(elementToRemoveAll);
                break;
                
            default:
                System.out.println("Sorry, invalid choice");
        }
    }
    //----------------------------
// Print the user's choices
//----------------------------
    public static void printMenu()
    {
        System.out.println("\n Menu ");
        System.out.println(" ====");
        System.out.println("0: Quit");
        System.out.println("1: Create a new list (the list will be empty at first)");
        System.out.println("2: Print the list");
        System.out.println("3: Add an integer to the list");
        System.out.println("4: Remove the first occurence of an Integer");
        System.out.println("5: Remove the integer you want to remove from the list");
        System.out.print("\nEnter your choice: ");
    }
}