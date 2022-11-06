/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efwd.model;

/**
 *
 * @author -
 */
public class ItemTable {
   
     private String itemName;
     private int  price;
     private int count;
     private double itemTotal;
     private InvoiceTable invoice;

   
 public ItemTable(String itemName, int price, int count, InvoiceTable invoice){
       this.itemName = itemName;
        this.price = price;
        this.count = count;
        this.invoice= invoice;
                
        this.invoice.getItems().add(this);
 }

   
 

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public double getItemTotal() {
         itemTotal = Math.multiplyExact(price, count);
        return itemTotal ;
    }

    public void setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
    }

   

    public InvoiceTable getInvoice() {
        return invoice;
    }

    @Override
    public String toString() {
        return "ItemTable{" + ", itemName=" + itemName + ", price=" + price + ", count=" + count + ", itemTotal=" + itemTotal + '}';
    }
    
      public String getLineCSV() {
        return getInvoice().getNo()+","+getItemName()+","+price+","+count;
    }
    
}
