/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leeserenaproject2;
import java.util.*;
/**
 *
 * @author szale
 */
public class Bookstore implements BookstoreSpecification{
    //had to make it abstract for some reason
    private ArrayList<Product> inventory = new ArrayList();
    private int nextPurchaseId;
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
        inventory.add(new Book("To Kill A Mockingbird", 9.99, 10, "Harper Lee"));
        incrementNextPurchaseId();
        inventory.add(new Book("Charlotte's Web", 7.99, 10, "E.B. White"));
        incrementNextPurchaseId();
        inventory.add(new CD("Cuz I Love You", 7.99, 10, "Lizzo"));
        incrementNextPurchaseId();
        inventory.add(new DVD("How to Train Your Dragon", 15.99, 10, "Disney"));
        
        incrementNextPurchaseId();
        
        Member member1= new Member("Steven", 5);
        PremiumMember member2 = new PremiumMember("Jessica", 3, true);
        PremiumMember member3 = new PremiumMember("Malik", 100, false);

        membersList.add(member1);
        premiumMembersList.add(member2);
        premiumMembersList.add(member3);
        
    
    }
    
//    public  getCartItem(int id)
//    {
//        return ;//How do I access purchases array?
//    }
    
    public int getNextPurchaseId()
    {
        return nextPurchaseId;
    }
    
    private void incrementNextPurchaseId()
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
    
    
//    public boolean removePurchase(int id) {
//        for (int i = 0; i < inventory.size(); i++)
//        {
//            Product currentOrder = inventory.get(i);
//
//            if (currentOrder.getPurchaseId() == id)
//            {
//                //uhhh idk how im able to stop deleting the inventory LMAOO
//                //i wanna delete what the user inputs but idk how to connect
//                //the inventory and the purchases arraylist so yea... .-.
//                //taken from the burgerorder lab
//                inventory.remove(i);
//                i--;
//                return true;
//            }
//           
//        }
//        return false;
//    }
    
    public void removePurchase(int id){
        int current;
        if (id <= inventory.size()){
            current = (int) inventory.get(id - 1).getStock();
            if (current == 1){
                inventory.remove(id-1);
            } else {
                inventory.get(id - 1).setStock(current - 1);
            }
        }
    }
    
    boolean isExist(int choice){
        for(Product p : inventory)
        {
            if(p.getID() == choice)
            {
                return true;
            }
        }
        return false;
    }
    
    public Product getProductByID(int id)
    {
        for (Product p : inventory)
        {
            if(p.getID() == id)
            {
                return p;
            }
        }
        return null;
    }
   
    @Override
    public void restockProduct(int ID, int quantity){
        Product p = getProductByID(ID);
        if(p == null)
        {
            System.out.println("Wrong product ID is provided");
            return;
        }
        p.setStock((int) (p.getStock() + quantity));
    }
    
    @Override
    public double inventoryValue()
    {
        double grossValue = 0.0;
        for (Product p: inventory){
            grossValue += (p.getPrice() * p.getStock());
        }
        return grossValue;
    }
    
}


