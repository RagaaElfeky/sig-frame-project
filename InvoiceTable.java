/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efwd.model;
import efwd.view.SigFrame;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author -
 */
public class InvoiceTable {
  private   int no;
  private  String custName;
  private   Date date;
  private  double invTotal;
  private ArrayList<ItemTable>Items;

    public InvoiceTable(int no, String custName, Date date, double invTotal) {
        this.no = no;
        this.custName = custName;
        this.date = date;
        this.invTotal = invTotal;
    }
    public InvoiceTable(int no,Date date, String custName) {
        this.no = no;
        this.custName = custName;
        this.date = date;
        
    }

    public int getNo() {
        return no;
    }
   

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }
    
    

    public double getInvTotal() {
         double total = 0.0;
        
        for (ItemTable item : getItems()) {
            total += item.getItemTotal();
        }
        
        
        return invTotal=total;
    }
 public ArrayList<ItemTable> getItems() {
       if (Items == null) {
            Items = new ArrayList<>();
        }
        return Items;
    }
  public String getHeaderCSV() {
        return no+","+SigFrame.date.format(date)+","+custName;
    }
    

   
  

    public  Date getDate() {
        return date;
         //To change body of generated methods, choose Tools | Templates.
    }

    

    public void setDate(Date date) {
        this.date = date;
    }
    

    @Override
    public String toString() {
        return "InvoiceTable{" + "no=" + no + ", custName=" + custName + ", date=" + date + ", invTotal=" + invTotal + '}';
    }

    

  
   
    
}
