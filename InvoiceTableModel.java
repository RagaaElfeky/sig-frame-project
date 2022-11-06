/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efwd.model;
import efwd.view.SigFrame;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author -
 */
public class InvoiceTableModel extends AbstractTableModel {
private ArrayList<InvoiceTable>invoice;
private String[] columns ={"No","custName","Date","Total"};
public InvoiceTableModel(ArrayList<InvoiceTable>invoice) {
 this.invoice = invoice;
}
    @Override
    public int getRowCount() {
       return invoice.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return columns.length; 
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
          InvoiceTable inv = invoice.get(rowIndex);
        switch (columnIndex) {
            case 0: return inv.getNo();
            case 1: return inv.getCustName();
            case 2: return SigFrame.date.format(inv.getDate());
            case 3: return inv.getInvTotal();
        }
        return "";
        
    }
      @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public InvoiceTable get(int selectedRow) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
        
     
 }
