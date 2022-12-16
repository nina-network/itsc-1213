/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leeserenaproject2;

/**
 *
 * @author szale
 */
interface BookstoreSpecification {
    public abstract void restockProduct(int ID, int quantity);
    public abstract double inventoryValue();
}
