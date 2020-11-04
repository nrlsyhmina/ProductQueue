import javax.swing.*;

public class TestProduct
{
    public static void main(String[] args)
    {
        Queue prodQueue = new Queue();
        String type, color, size;
        double price;
        char c;
        
        //a) store 10 products into queue, prodQueue
        for(int i=0; i<2 ; i++)
        {
            type = JOptionPane.showInputDialog("Enter Type: ");
            color = JOptionPane.showInputDialog("Enter Color: ");
            size = JOptionPane.showInputDialog("Enter Size: ");
            c = size.charAt(0);
            price = Double.parseDouble(type = JOptionPane.showInputDialog("Enter Price: "));
            Product pro = new Product();
            pro.setData(type, color, c , price);
            prodQueue.enqueue(pro);
        }
        
        //b)Remove all the products from the prodStack and store them into
        //THREE different stacks (shortSleeve, shortPants, and booties). 
        //All products in the prodStack must remain in the original order.
        
        Queue shortsleeve = new Queue();
        Queue shortPants = new Queue();
        Queue booties = new Queue();
        Queue tempQueue = new Queue();
        
        Object obj;
        Product temp;
        
        while(!prodQueue.isEmpty())
        {
            obj = prodQueue.dequeue();
            temp = (Product) obj;
            tempQueue.enqueue(temp);
            
            if(temp.getType().equalsIgnoreCase("short sleeve"))
            {
                shortsleeve.enqueue(obj);
            }
            
            else if(temp.getType().equalsIgnoreCase("short pant"))
            {
                shortPants.enqueue(obj);
            }
            else
            {
                booties.enqueue(obj);
            }
        }
        
        Object obj1;
        while(!tempQueue.isEmpty()) {
            obj1 = tempQueue.dequeue();
            prodQueue.enqueue(obj1);
        }
        
        //c)Calculate and display the tota
        Object ob;
        Product po;
        double total = 0.00, total1=0.00, total2=0.0;
        
        while(!shortsleeve.isEmpty())
        {
            ob = shortsleeve.dequeue();
            po = (Product)ob;
            total += po.getPrice();
            tempQueue.enqueue(po);
        }
        
        while(!tempQueue.isEmpty())
        {
            obj1 = tempQueue.dequeue();
            shortsleeve.enqueue(obj1);
        }
        
        System.out.println("Total price for short sleeve is :RM " + total);
        
        while(!shortPants.isEmpty())
        {
            ob = shortPants.dequeue();
            po = (Product) ob;
            total1+=po.getPrice();
        }
        System.out.println("Total price for short pants is :RM " + total1);
        
        while(!booties.isEmpty())
        {
            ob = booties.dequeue();
            po = (Product) ob;
            total2+=po.getPrice();
        }
        System.out.println("Total price for booties is :RM " + total2);
        
        //d)Display all the types and prices pf the products size M and blue
        String a = "", b = "", g = "", d = "", e = "", f = "";
        while(!prodQueue.isEmpty())
        {
            ob = prodQueue.dequeue();
            po = (Product)ob;
            if(po.getSize()=='m' || po.getSize()=='M' && po.getColor().equalsIgnoreCase("blue"))
            {
                a+=po.getType() + "\t" + po.getPrice() + "\n";
            }
        }
        System.out.println("Display: \n" + a);
    }
}