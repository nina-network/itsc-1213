/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package leeserenaproject2;

import java.util.*;

/**
 *
 * @author szale
 */
public class Main {

    public static void main(String[] args)
    {
        /*
        This is the main method which executes the Bookstore class
        */
        Bookstore bookstore = new Bookstore();
        
        Scanner keyboard = new Scanner(System.in);
        
        
        boolean run = true;
        
        ArrayList<Integer> purchasedIDs = new ArrayList<>();
        
        
        while (run) {
            System.out.println("\nWelcome to the automated BookStore System!");
            System.out.println("Select from one of the following options:");
            System.out.println("\t1. Make a purchase");
            System.out.println("\t2. Cancel a purchase");
            System.out.println("\t3. Checkout");
            System.out.println("\t4. Register as a new memeber");
            System.out.println("\t5. Check membership status");
            System.out.println("\t6. Restock inventory");
            System.out.println("\t7. Get inventory total value");
            System.out.println("\t8. Exit");
            
            int choice = keyboard.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("-----------------------------------------");
                    purchase(bookstore, keyboard, purchasedIDs);
                    break;
                case 2:
                    System.out.println("-----------------------------------------");
                    System.out.println("Enter purchase ID you want to cancel: ");
                int cancelpurchase = keyboard.nextInt();
                // cancelResult = bookstore.removePurchase(cancelpurchase);
                bookstore.removePurchase(cancelpurchase); 
                
//                    System.out.println("Sorry, we can't find your order number in the system");
//                }
//                //else
//                {
//                    System.out.println("Your order has been successfuly cancelled");
//                }
  
                break;

                case 3:
                    System.out.println("-----------------------------------------");
                    checkout(bookstore, keyboard, purchasedIDs);
                    break;   
                case 4:
                    System.out.println("-----------------------------------------");
                    registerNewMember(bookstore, keyboard, 0);
                    break;
                case 5:
                    System.out.println("-----------------------------------------");
                    checkMemberStatus(bookstore, keyboard);
                    break;
                case 6:
                    System.out.println("-----------------------------------------");
                    restock(bookstore, keyboard, purchasedIDs);
                    break;
                case 7:
                    System.out.println("-----------------------------------------");
                    getInventoryValue(bookstore, keyboard, purchasedIDs);
                    break;
                case 8:
                    System.out.println("-----------------------------------------");
                    System.out.println("Thank you for coming! ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Sorry, but you need to enter a valid choice. \\(^ヮ^)/");
                    
            
            }
        }
    }

            /*
            method to make a purchase
            */
        public static void purchase(Bookstore bookstore, Scanner keyboard, ArrayList<Integer> purchasedIDs){
                System.out.print("Which of the following would you like to purchase? ");
                ArrayList<Product> inventory = bookstore.getInventory();
                
                int itemNum = 1;
                // displays inventory item
                for (Product item : inventory){
                    //put type thingy
                    System.out.println("\n\t" + item.getID() + " " + item.getName());
                    if (item instanceof Book)
                        System.out.print(" by " + ((Book) item).getAuthor() + " - $" + item.getPrice() + " (Book)");
                    else if (item instanceof CD)
                        System.out.print(" by " + ((CD) item).getArtist() + " -$" + item.getPrice() + " (CD)");
                    else
                        System.out.print(" - $" + item.getPrice() + " (DVD)");
                    System.out.println("");
                
                }
                
                System.out.println("");
                
                int choice = keyboard.nextInt();
                
                if (choice < itemNum){
                    purchasedIDs.add(choice);
                    //pudate incentory for item choice
                    // bookstore.removePurchase(choice);
                    
                    System.out.println("You have " + purchasedIDs.size() + 
                            " items in your cart.");
                }
                }
                // from here add checkout and remove purchase
                
                
           private static double getTotalPurchase(Bookstore bookstore, ArrayList<Integer> purchasedIDs)
            {
                double total = 0;
               
                for(int id : purchasedIDs){
                      
                   
                    Product product = bookstore.getProductByID(id);
                      if (product != null)
                    
                        total += product.getPrice();
                }
                return total;
            }
            
            public static void checkout(Bookstore bookstore, Scanner keyboard, ArrayList<Integer> purchasedIDs)
            {
                double total = getTotalPurchase(bookstore, purchasedIDs);
                
                // writing a response/prompt for checkout method
                //gonna have yes, no, and then for gettotalpurchaschase or for loop
                System.out.println("Would you checkout your items?");
                System.out.println("\t1. Yes");
                System.out.println("\t2. No");
                
                int choice = keyboard.nextInt();
                
                int itemNum= 1;
                
                if (choice> 2 || choice < 1){
                    System.out.println("Sorry, but you need to enter a valid choice. \\(^ヮ^)/");
                    checkout(bookstore, keyboard, purchasedIDs); //inputting valid choice
                    
                } else if (choice == 1){ 
                    System.out.println("Your total purchase is " + total);
                } else{
                    System.out.println("No problem \\(. v .)/ \nTaking you back to homepage . . .");
                }
                }
         
        
            /*
            method to make a new member
            */
            private static boolean registerNewMember(Bookstore bookstore, Scanner keyboard, int numOfItems){
                System.out.println("Let's get you registered as a new Member!");
                System.out.println("Would you like to register as a free-tier or premium member?");
                System.out.println("\t1. Free-tier");
                System.out.println("\t2. Premium");
                
                int choice1 = keyboard.nextInt();
                if (choice1> 2 || choice1 < 1){
                    System.out.println("Sorry, but you need to enter a valid choice. \\(^ヮ^)/");
                    return registerNewMember(bookstore, keyboard, numOfItems); //inputting valid choice
                    
                } else {
                    System.out.println("Please enter your name:");
                    keyboard.nextLine();
                    String name = keyboard.nextLine();
                    if (choice1 == 1){
                        bookstore.addNewMember(name, false, numOfItems);
                        return false;
                    } else{ //when user wants to enter as a premium member
                        bookstore.addNewMember(name, true, numOfItems);
                        return true;
                    }
                }
            }
            
            /*
            method that checks member status
            */
            private static void checkMemberStatus(Bookstore bookstore, Scanner keyboard){
                System.out.println("Please select your member ID");
                int num = 1;
                for (Member member : bookstore.getMembersList()){
                    System.out.println("\t" + num +". " + member.getName());
                    num++;
                }
                for (PremiumMember member : bookstore.getPremiumMembersList()){
                    System.out.println("\t" + num + ". " + member.getName());
                    num++;
                }
                int choice = keyboard.nextInt();
                if (choice < 1 || choice > bookstore.getMembersList().size() + bookstore.getPremiumMembersList().size())
                {
                    System.out.println("Sorry, but you need to enter a valid choice. \\(^ヮ^)/");
                    return;
                }
                
                //valid choice
                bookstore.displayMemberStatus(choice);
            }
            
            private static void restock(Bookstore bookstore, Scanner keyboard, ArrayList<Integer> purchasedIDs)
            {
                ArrayList<Product> inventory = bookstore.getInventory();
                
                System.out.println("Would you like to restock the inventory?");
                System.out.println("\t1. Yes");
                System.out.println("\t2. No");
                
                int choice = keyboard.nextInt();
                
                if (choice < 1 || choice > bookstore.getMembersList().size() + bookstore.getPremiumMembersList().size())
                {
                    System.out.println("Sorry, but you need to enter a valid choice. \\(^ヮ^)/");
                    restock(bookstore, keyboard, purchasedIDs);
                } else if (choice == 1)
                {
                    System.out.println("Choose which product to restock:");
                    for (Product item : inventory){
                    //put type thingy
                    System.out.print("\n\t" + item.getID() + " " + item.getName());
                    if (item instanceof Book){
                        System.out.print(" by " + ((Book) item).getAuthor() + " - $" + item.getPrice() + " (Book)");
                        System.out.println("\n\tNumber of copies: " + item.getStock());
                    }
                    if (item instanceof CD){
                        System.out.print(" by " + ((CD) item).getArtist() + " -$" + item.getPrice() + " (CD)");
                        System.out.println("\n\tNumber of copies: " + item.getStock());
                        }
                    if (item instanceof DVD){
                        System.out.print(" - $" + item.getPrice() + " (DVD)");
                        System.out.println("\n\tNumber of copies: " + item.getStock());
                    }
                    System.out.println("");
                
                }

                    int itemChoice = keyboard.nextInt();
                    
                    if (itemChoice == 1)
                    {
                        
                        System.out.println("How many copies will be inputted? ");
                        int inventoryNum = keyboard.nextInt();
                        bookstore.restockProduct(itemChoice, inventoryNum);
                        for (Product item : inventory)
                        {
                            if (item.getID() == itemChoice)
                            {
                                System.out.println("\nThere is now " + item.getStock() + " items.");
                            }
                        }
                    }
                    if (itemChoice == 2)
                    {
                        System.out.println("How many copies will be inputted? ");
                        int inventoryNum = keyboard.nextInt();
                        bookstore.restockProduct(itemChoice, inventoryNum);
                        for (Product item : inventory)
                        {
                            if (item.getID() == itemChoice)
                            {
                                System.out.println("\nThere is now " + item.getStock() + " items.");
                            }
                        }
                    }
                    if (itemChoice == 3)
                    {
                        System.out.print("How many copies will be inputted? ");
                        int inventoryNum = keyboard.nextInt();
                        bookstore.restockProduct(itemChoice, inventoryNum);
                        for (Product item : inventory)
                        {
                            if (item.getID() == itemChoice)
                            {
                                System.out.println("\nThere is now " + item.getStock() + " items.");
                            }
                        }
                    }
                    if (itemChoice == 4)
                    {
                        System.out.println("How many copies will be inputted? ");
                        int inventoryNum = keyboard.nextInt();
                        bookstore.restockProduct(itemChoice, inventoryNum);
                        for (Product item : inventory)
                        {
                            if (item.getID() == itemChoice)
                            {
                                System.out.println("\nThere is now " + item.getStock() + " items.");
                            }
                        }
                    }
                    }
                else {
                    System.out.println("No problem \\(. v .)/ \nTaking you back to homepage . . .");
                }
                    
                
                 
            }
            
            private static void getInventoryValue(Bookstore bookstore, Scanner keyboard, ArrayList<Integer> purchasedIDs)
            {
                
                
                System.out.println("Would see how many products there are?");
                System.out.println("\t1. Yes");
                System.out.println("\t2. No");
                
                int choice = keyboard.nextInt();
                
                if (choice> 2 || choice < 1){
                    System.out.println("Sorry, but you need to enter a valid choice. \\(^ヮ^)/");
                    getInventoryValue(bookstore, keyboard, purchasedIDs);
                } else if (choice == 1){
                    System.out.println("The inventory value is " + bookstore.inventoryValue());
                } else {
                    System.out.println("No problem \\(. v .)/ \nTaking you back to homepage . . .");
                    
                }
            }
}
                
     


    

