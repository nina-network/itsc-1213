/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leeserenaproject2;

/**
 *
 * @author szale
 */
public abstract class Product implements Comparable{
    private static int counter = 1;
    
    private String name;
    //private String type;
    //private String creator;
    private double price;
    private int stock;
    private int id;
    
    /*
    Product constructor 
    */
    public Product(String name, double price, int stock)
    {
        this.name = name;
        // this.type = type;
        // this.creator = creator;
        this.price = price;
        this.stock = stock;
        this.id = Product.counter++;
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
    
//    public String getCreator(){
//        return creator;
//    }
//    public void setCreator(String creator){
//        this.creator = creator;
//    }
   
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    
    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
    
    public int getID(){
        return id;
    }
//    
    public void setID(int id){
        this.id = id;
    }
    
    public int compareTo(Product p)
    {
        if (this.getPrice() == p.getPrice())
            return 0;
        else
            return (int)(this.getPrice() - p.getPrice());
    }
    //    public String getType(){
//        return type;
//    }
//    public void setType(String type){
//        this.type = type;
//    }
}
