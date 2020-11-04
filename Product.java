public class Product 
{
    private String type;
    private String color;
    private char size;
    private double price;
    
    public Product() 
    {
        type = "";
        color = "";
        size = ' ';
        price = 0.00;
    }
    
    public void setData (String a, String b, char c, double d) 
    {
        type = a;
        color = b;
        size = c;
        price = d;
    }
    
    public String getType() { //shortSleeve, shortpants, booties
        return type;
    }
    public String getColor() { // blue, pink
        return color;
    }
    public char getSize() { // S, M, L
        return size;
    }
    public double getPrice() {
        return price;
    }
}