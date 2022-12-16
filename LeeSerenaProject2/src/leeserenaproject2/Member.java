/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leeserenaproject2;

/**
 *
 * @author szale
 */
public class Member {
    private String name;
    public int numPurchases;
    
    /*
    just a constructor
    */
    public Member(String name, int numPurchases){
        this.name = name;
        this.numPurchases = numPurchases;
    }
    
    /*
    getting and setting
    */
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public int getNumPurchases(){
        return numPurchases;
    }
    public void setPurchases(int numPurchases){
        this.numPurchases = numPurchases;
    }
    
    /*
    method that increments # of purchases by a set amount
    Basically, records number of purchases this specific member made like
    stevie bought 5 items
    */
    public void incrementPurchase(int newPurchases){
        this.numPurchases += numPurchases;
    }
    
}
