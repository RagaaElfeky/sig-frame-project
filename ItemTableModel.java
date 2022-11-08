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
public class ItemTableModel extends AbstractTableModel {
     private ArrayList<ItemTable>items;
     private String []columns={"Item Name","Price","Count","Item Total"};
     
     
    public ItemTableModel() {
         this(new ArrayList<ItemTable>());
    }
    

    public ItemTableModel(ArrayList<ItemTable>items) {
        this.items=items;
    }

    @Override
    public int getRowCount() {
         return items.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         ItemTable item = items.get(rowIndex);
        switch (columnIndex) {
            case 0: return item.getItemName();
            case 1: return item.getPrice();
            case 2: return item.getCount();
            case 3: return item.getItemTotal();
        }
        return "";
    }
      @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
}
