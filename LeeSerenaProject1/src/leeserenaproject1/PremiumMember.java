/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leeserenaproject1;

/**
 *
 * @author szale
 */
public class PremiumMember {
    private String name;
    private int numPurchases;
    private boolean hasPaidDues;
    
    /*
    just a constructor
    */
    public PremiumMember(String name, int numPurchases, boolean hasPaidDues){
        this.name = name;
        this.numPurchases = numPurchases;
        this.hasPaidDues = hasPaidDues;
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
    
    public boolean getHasPaidDues(){
        return hasPaidDues;
    }
    public void setHasPaidDues(boolean hasPaidDues){
        this.hasPaidDues = hasPaidDues;
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
