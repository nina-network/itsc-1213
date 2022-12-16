/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leeserenaproject1;
import java.util.*;
/**
 *
 * @author szale
 */
public class Bookstore {
    private ArrayList<Product> inventory = new ArrayList();
    private static int nextPurchaseId;
    private ArrayList<Member> membersList = new ArrayList();
    private ArrayList<PremiumMember> premiumMembersList = new ArrayList();
    
 /*
method that adds new members to arraylist
first finds type of member, then adds to whatever member list it belongs to
*/
    public void addNewMember(String name, boolean premium, int numOfItems){
        if (premium){
        if (numOfItems == 0){
                //registrating only
                premiumMembersList.add(new PremiumMember(name, numOfItems, false));
            } else{
                // registering as a member through checkout
                premiumMembersList.add(new PremiumMember(name, numOfItems, true));
            }
        } else{
            membersList.add(new Member(name, numOfItems));

        }   
    }

/*
Constructor which calls helper methods
*/
    public Bookstore(){
        generateInventory();
        generateMembers();
        
    
    }
    
    public int getNextPurchaseId()
    {
        return nextPurchaseId;
    }
    
    private static void incrementNextPurchaseId()
    {
        nextPurchaseId++;
    }
    
/*
    get method for everything
    */
    public ArrayList<Member> getMembersList(){
        return membersList;
    }
    
    public ArrayList<PremiumMember> getPremiumMembersList(){
        return premiumMembersList;
    }
    
    public ArrayList<Product> getInventory(){
        return inventory;
    }


/*
helper method that generates inventory from bookstore so 
program has inputs (basically)
*/
    private void generateInventory(){
        inventory.add(new Product("To Kill A Mockingbird", "Book", "Harper Lee", 9.99, 1));
        incrementNextPurchaseId();
        inventory.add(new Product("Charlotte's Web", "Book", "E.B. White", 7.99, 2));
        incrementNextPurchaseId();
        inventory.add(new Product("Cuz I Love You", "CD", "Lizzo", 7.99, 3));
        incrementNextPurchaseId();
        inventory.add(new Product("How to Train Your Dragon", "Movie", "Disney", 15.99, 4));
        incrementNextPurchaseId();

    }

/*
helper method that generates members of bookstore so program 
has inputs (basically)
*/
    private void generateMembers(){
        Member member1= new Member("Steven", 5);
        PremiumMember member2 = new PremiumMember("Jessica", 3, true);
        PremiumMember member3 = new PremiumMember("Malik", 100, false);

        membersList.add(member1);
        premiumMembersList.add(member2);
        premiumMembersList.add(member3);
    }     

/*
    method used to check and display member profile
*/
    public void displayMemberStatus(int memberId){
        System.out.println("Member details:");
        if (memberId <= membersList.size()){
            Member chosenMember = membersList.get(memberId - 1);
            System.out.println("\tName: " + chosenMember.getName());
            System.out.println("\tNumber of items purchased: " + chosenMember.getNumPurchases());
            System.out.println("\tStatus: Free Tier");
        } else{
            PremiumMember chosenMember = premiumMembersList.get(memberId - membersList.size() -1);
            System.out.println("\tName: " + chosenMember.getName());
            System.out.println("\tNumber of items purchased: " + chosenMember.getNumPurchases());
            System.out.println("\tStatus: Premium");
            System.out.println(
                    "\tMembership due paid: " + chosenMember.getHasPaidDues());
        }
    }
    
    
    public boolean removePurchase(int id) {
        for (int i = 0; i < inventory.size(); i++)
        {
            Product currentOrder = inventory.get(i);

            if (currentOrder.getPurchaseId() == id)
            {
                //uhhh idk how im able to stop deleting the inventory LMAOO
                //i wanna delete what the user inputs but idk how to connect
                //the inventory and the purchases arraylist so yea... .-.
                //taken from the burgerorder lab
                inventory.remove(i);
                i--;
                return true;
            }
            
        }
        return false;
    }
    
   
    
    
}

