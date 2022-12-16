/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leeserenaproject2;

/**
 *
 * @author szale
 */
public class DVD extends Product {
    private String director;
    
    public DVD(String name, double price, int stock, String director)
    {
        super(name, price, stock);
        this.director = director;
    }
    
    public String getDirector()
    {
        return director;
    }
    public void setDirector(String director)
    {
        this.director = director;
    }
    
    public int compareTo(Product p)
    {
        if (this.getPrice() == p.getPrice())
            return 0;
        else
            return (int)(this.getPrice() - p.getPrice());
    }
}
