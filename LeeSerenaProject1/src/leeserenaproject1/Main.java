/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package leeserenaproject1;

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
        
        ArrayList<Integer> purchases = new ArrayList<>();
        
        
        while (run) {
            System.out.println("\nWelcome to the automated BookStore System!");
            System.out.println("Select from one of the following options:");
            System.out.println("\t1. Make a purchase");
            System.out.println("\t2. Cancel a purchase");
            System.out.println("\t3. Checkout");
            System.out.println("\t4. Register as a new memeber.");
            System.out.println("\t5. Check membership status.");
            System.out.println("\t6. Exit");
            
            int choice = keyboard.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("-----------------------------------------");
                    purchase(bookstore, keyboard, purchases);
                    break;
                case 2:
                    System.out.println("-----------------------------------------");
                    System.out.println("Enter purchase ID you want to cancel: ");
                int cancelpurchase = keyboard.nextInt();
                boolean cancelResult = bookstore.removePurchase(cancelpurchase);
                if (cancelResult == true) {
                    System.out.println("Your order has been successfuly cancelled");
                }
                else
                {
                    System.out.println("Sorry, we can't find your order number in the system");
                }
                break;
                case 3:
                    System.out.println("-----------------------------------------");
                    purchase(bookstore, keyboard, purchases);
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
        public static void purchase(Bookstore bookstore, Scanner keyboard, ArrayList<Integer> purchases){
                System.out.print("Which of the following would you like to purchase? ");
                ArrayList<Product> inventory = bookstore.getInventory();
                
                int itemNum = 1;
                // displays inventory item
                for (Product item : inventory){
                    System.out.println("\n\t" + itemNum + " " + item.getName()); 
                    System.out.println(" by " + item.getCreator()+ 
                            " - $" + item.getPrice());
                    System.out.println("");
                    itemNum++;
                }
                
            //Wonky or Unneeded Code
                /*
                for (DVD item : dvdInventory){
                    System.out.println("\t" + itemNum + " " + item.getName());
                    System.out.println(" by " + ((DVD) item).getCategory()+ 
                            " - $" + item.getPrice() + " (DVD)");
                    System.out.println("");
                    itemNum++;
                }
                */
                int choice = keyboard.nextInt();
                //double total = 0;
                /*
                In this uncompleted method i was trying to create a user arraylist that records
                that specific user's purchases where you could delete their purchases
                ArrayList<Member> user = new ArrayList<>();
                for (int i = 0; i < purchases.size(); i++)
                {
                   purchases.add(user);
                }
 
                
                for (int i = 0; i < user.size(); i++)
                {
                    if ()
                }
                */
                
                /*
                honestly do we even need a remove thing? what happened to capitalism
                */
                
            /*    
            for (int i = 0; i < purchases.size(); i++)
            {
                int currentOrder = purchases.get(i);
                //HOW DO U DEREFERNCE??????
                if (currentOrder.getPurchaseId() == choice)
                {
                    //uhhh idk how im able to stop deleting the inventory LMAOO
                    //i wanna delete what the user inputs but idk how to connect
                    //the inventory and the purchases arraylist so yea... .-.
                    //taken from the burgerorder lab
                    inventory.remove(i);
                    i--;
                }
            }
            */
            
            //idk how to make an actual purchase and put it into the arraylist
                
                if (choice < itemNum){
                    purchases.add(choice);
                    //pudate incentory for item choice
                    
                    System.out.println("You have " + purchases.size() + 
                            " items in your cart.");
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
                    System.out.println("INVALID CHOICE");
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
                    System.out.println("INVALID CHOICE");
                    return;
                }
                
                //valid choice
                bookstore.displayMemberStatus(choice);
            }
}
                
     


    

