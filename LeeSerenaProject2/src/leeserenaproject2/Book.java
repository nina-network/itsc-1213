/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leeserenaproject2;

/**
 *
 * @author szale
 */
class Book extends Product {
    //just write the compareTo method in class and ull be good
    private String author;
    
    public Book(String name, double price, int stock, String author)
    {
        super(name, price, stock);
        this.author = author;
    }
    
    
    public String getAuthor()
    {
        return author;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }
    
    public int compareTo(Product p)
    {
        if (this.getPrice() == p.getPrice())
            return 0;
        else
            return (int)(this.getPrice() - p.getPrice());
    }
    
}
