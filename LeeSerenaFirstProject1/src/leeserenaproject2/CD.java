/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leeserenaproject2;

/**
 *
 * @author szale
 */
public class CD extends Product {
    private String artist;
    
    public CD(String name, double price, int stock, String artist)
    {
        super(name, price, stock);
        this.artist = artist;
    }
    
    public String getArtist()
    {
        return artist;
    }
    public void setArtist(String artist)
    {
        this.artist = artist;
    }
    
    public int compareTo(Product p)
    {
        if (this.getPrice() == p.getPrice())
            return 0;
        else
            return (int)(this.getPrice() - p.getPrice());
    }
}
