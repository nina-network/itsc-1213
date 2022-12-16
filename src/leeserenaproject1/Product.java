/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leeserenaproject1;

/**
 *
 * @author szale
 */
public class Product {
    private String name;
    private String type;
    private String creator;
    private double price;
    private int purchaseId;
    
    /*
    Product constructor 
    */
    public Product(String name, String type, String creator, double price, int purchaseId)
    {
        this.name = name;
        this.type = type;
        this.creator = creator;
        this.price = price;
        this.purchaseId = purchaseId;
    }
    
    /*
    get and set methods for all fields
    */
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    
    public String getCreator(){
        return creator;
    }
    public void setCreator(String creator){
        this.creator = creator;
    }
    
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    
    public int getPurchaseId(){
        return purchaseId;
    }
    
    public void setPurchaseId(int purchaseId){
        this.purchaseId = purchaseId;
    }
}
