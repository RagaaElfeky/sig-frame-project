/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efwd.controller;

import efwd.model.InvoiceTable;
import efwd.model.InvoiceTableModel;
import efwd.model.ItemTable;
import efwd.model.ItemTableModel;
import efwd.view.ItemTableDialog;
import efwd.view.InvoiceTableDialog;
import efwd.view.SigFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author -
 */
public class SigController implements ActionListener, ListSelectionListener{
 private SigFrame Frame;
private  ItemTableDialog itemDialog;
private  InvoiceTableDialog invoiceDialog;
    public SigController(SigFrame Frame) {
        this.Frame = Frame;
    }
         @Override
    public void valueChanged(ListSelectionEvent e) {
         System.out.println("Row Selected");
        int selectedRow = Frame.getInvTable().getSelectedRow();
        if (selectedRow == -1) {
            Frame.getCustNameTxf().setText("");
            Frame.getInvNoLbl().setText("");
            Frame.getInvTotalLbl().setText("");
            Frame.getInvDateTxf().setText("");
            Frame.setItemTableModel(new ItemTableModel());
        } else {
            InvoiceTable selectedInvoice = Frame.getInvoiceis().get(selectedRow);
            Frame.getCustNameTxf().setText(selectedInvoice.getCustName());
            Frame.getInvNoLbl().setText("" + selectedInvoice.getNo());
            Frame.getInvTotalLbl().setText("" + selectedInvoice.getInvTotal());
            Frame.getInvDateTxf().setText(Frame.date.format(selectedInvoice.getDate()));
            Frame.setItemTableModel(new ItemTableModel(selectedInvoice.getItems()));
        } 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buton=e.getActionCommand();
        switch(buton){
             case "Creat New Invoice":
               CreatnewInvoice();
                break;
             case "Delet Invoice":
                 deletInvoice();
                 break;
             case "Save":
                 newItem();
                 break;
             case "Cancel":
                 cancelItem();
                 break;
             case "Load File" :
                 loadFile(null,null);
                 break;
             case "Save File" :
                 saveFile();
                 break;
             case"newInvoiceOK" :
                  newInvoiceOK();
                break;
             case"newInvoiceCancel" :
                  newInvoiceCancel();
                break;
             case"newItemOK" :
                  newItemOK();
                break;   
            case"newItemCancel" :
                  newItemCancel();
                break;    
        }
    }
     private void CreatnewInvoice() {
         invoiceDialog=new InvoiceTableDialog(Frame);
        invoiceDialog.setVisible(true);
     }
     

     private void newInvoiceOK() {
         try{
        String invDate = invoiceDialog.getDateField().getText();
        String custName = invoiceDialog.getCustNameField().getText();
        Date date = Frame.date.parse(invDate);
        String[] dateIngredients = invDate.split("-");
        if(Integer.parseInt(dateIngredients[1])>12){
            throw new  ParseException("The month is not allowed to be > 12", 0);
        }
        if(Integer.parseInt(dateIngredients[0])>31){
             throw new  ParseException("the day is not allowed to be >31,",0);
        }
        int no = Frame.getNextInvoiceNo();
        InvoiceTable invo =new InvoiceTable(no,date,custName);
        Frame.getInvoiceis().add(invo);
        Frame.getInvoiceTableModel().fireTableDataChanged();
        newInvoiceCancel();
     }catch (ParseException ex){
    JOptionPane.showMessageDialog(Frame, "Date formate is incorrect :"+ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
     }
    private void newInvoiceCancel() {
        invoiceDialog.setVisible(false);
        invoiceDialog.dispose();
        invoiceDialog = null;
        
    }
    
    
      private void deletInvoice() {
       int selectedRow = Frame.getInvTable().getSelectedRow();
       if(selectedRow != -1){
           Frame.getInvoiceis().remove(selectedRow);
           Frame.getInvoiceTableModel().fireTableDataChanged();
       }
      }
  private void newItem() {
      int selectedInvoice = Frame.getInvTable().getSelectedRow();
      if(selectedInvoice==-1){
   JOptionPane.showMessageDialog(Frame, "pleas,Select Invoice to add item", "ERROR", JOptionPane.ERROR_MESSAGE);
      } else{
          itemDialog=new ItemTableDialog(Frame);
          itemDialog.setVisible(true);
      }
  }
  
  
    private void newItemOK() {
      String itemName =itemDialog.getINameField().getText();
      int count =Integer.parseInt(itemDialog.getICountField().getText());
      int price = Integer.parseInt(itemDialog.getIPriceField().getText());
      int selectedInvoIndex = Frame.getInvTable().getSelectedRow();
      InvoiceTable invo = Frame.getInvoiceis().get(selectedInvoIndex);
      new ItemTable(itemName,price,count,invo);
      Frame.getInvoiceTableModel().fireTableDataChanged();
      Frame.getInvTable().setRowSelectionInterval(selectedInvoIndex, selectedInvoIndex);
      newItemCancel();
    }

    private void newItemCancel() {
        itemDialog.setVisible(false);
        itemDialog.dispose();
         itemDialog = null;
    }

    
    
    private void cancelItem() {
      int selectedInvoice = Frame.getInvTable().getSelectedRow();
         int selectedItem = Frame.getItemTable().getSelectedRow();
         if (selectedInvoice !=-1 && selectedItem !=-1){
             InvoiceTable invoice = Frame.getInvoiceis().get(selectedInvoice);
             invoice.getItems().remove(selectedItem);
             Frame.getItemTableModel().fireTableDataChanged();
             Frame.getInvoiceTableModel().fireTableDataChanged();
             Frame.getInvTable().setRowSelectionInterval(selectedInvoice, selectedInvoice);
         }
    }


   


    

 
    private void saveFile(){
        JFileChooser choos=new JFileChooser();
        File invoiceFile=null;
        File itemFile=null;
        JOptionPane.showMessageDialog(Frame, "Select invoice File", "Invoice File", JOptionPane.QUESTION_MESSAGE);
        int target = choos.showSaveDialog(Frame);
        if(target==JFileChooser.APPROVE_OPTION){
            invoiceFile = choos.getSelectedFile();
            JOptionPane.showMessageDialog(Frame, "select item File", "Item file",  JOptionPane.QUESTION_MESSAGE);
            target=choos.showSaveDialog(Frame);
            if(target==JFileChooser.APPROVE_OPTION){
                itemFile = choos.getSelectedFile();
            }
        }
        if(invoiceFile != null&&itemFile != null){
        String invoiceData = "";
        String itemData = "";
        for(InvoiceTable invo : Frame.getInvoiceis()){
                invoiceData += invo.getHeaderCSV();
                itemData += "\n";
                
                for (ItemTable item : invo.getItems()) {
                    itemData += item.getLineCSV();
                    itemData += "\n";
                }
            }
         System.out.println("Check Result");
          try {
                FileWriter invoicefw = new FileWriter(invoiceFile);
                FileWriter itemfw = new FileWriter(itemFile);
                invoicefw.write(invoiceData);
                itemfw.write(itemData);
                invoicefw.flush();
                itemfw.flush();
                invoicefw.close();
                itemfw.close();  
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(Frame, "Error while writing files: \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }}
        public void loadFile(String invoicePath ,String itemPath) {
     System.out.println("loading Files");
      File invoiceFile = null;
        File itemFile = null;
      if (invoicePath == null && itemPath == null) {
            JFileChooser choos = new JFileChooser();
            JOptionPane.showMessageDialog(Frame, "Please, select Invoice File!", "Invoice", JOptionPane.WARNING_MESSAGE);
            int target = choos.showOpenDialog(Frame);
            if (target == JFileChooser.APPROVE_OPTION) {
                invoiceFile = choos.getSelectedFile();
                JOptionPane.showMessageDialog(Frame, "Please, select Item file!", "Item", JOptionPane.WARNING_MESSAGE);
                target = choos.showOpenDialog(Frame);
                if (target == JFileChooser.APPROVE_OPTION) {
                    itemFile = choos.getSelectedFile();
                      } else {
            invoiceFile = new File(invoicePath);
            itemFile = new File(itemPath);
        }

        if (invoiceFile != null && itemFile != null) {
            try {
                List<String> invoiceData = readFile(invoiceFile);
                /*
                [
                  "1,22-11-2020,Ali"
                  "2,13-10-2021,Saleh"
                ]
                 */
                List<String> itemData = readFile(itemFile);
                /*
                [
                   "1,Mobile,3200,1"
                   "1,Cover,20,2"
                   "1,Headphone,130,1"
                   "2,Laptop,4000,1"
                   "2,Mouse,35,1"
                ]
                 */
                System.out.println("point");
                Frame.getInvoiceis().clear();
             for (String invoice : invoiceData) {
                    /*
                    invoice = "1,12-11-2020,Ali"
                     */
                    String[] segm = invoice.split(",");
                    /*
                    segments = ["1", "12-11-2020", "Ali"]
                     */
                    int no = Integer.parseInt(segm[0]);
                    Date date = new Date();
                    try {
                        date = Frame.date.parse(segm[1]);
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(Frame, "Error while parsing date: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    String custName = segm[2];
                    InvoiceTable invoicef = new InvoiceTable(no, date, custName);
                  Frame.getInvoiceis().add(invoicef);
                }
                Frame.setInvoiceTableModel(new InvoiceTableModel(Frame.getInvoiceis()));

                for (String item : itemData) {
                    /*
                        lLine = "1,Mobile,3200,1"
                     */
                    String[] segm = item.split(",");
                    if (segm.length < 4) {
                        JOptionPane.showMessageDialog(Frame, "Error in items format: " + itemData, "Error", JOptionPane.ERROR_MESSAGE);
                        
                        continue;
                    }
                    /*
                        parts = ["1", "Mobile", "3200", "1"]
                     */
                    int no = Integer.parseInt(segm[0]);
                    String itemname = segm[1];
                    int price = Integer.parseInt(segm[2]);
                    int count = Integer.parseInt(segm[3]);
                    InvoiceTable invoice = Frame.getInvoiceByNo(no);
                    if (invoice != null) {
                        ItemTable item1 = new ItemTable(itemname, price, count, invoice);
                    }
                }
                System.out.println("Check result");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(Frame, "Error while loading files: \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
 }
      }
        
    }
     /*  private List<String> writeFile(File fi) throws IOException {
        List<String> Items = new ArrayList<>();

        FileWriter fir = new FileWriter(fi);
        BufferedWriter bar = new BufferedWriter(fir);
        String item = null;
        while ((item = bar.write(item) != null) {
            Items.add(item);
        }

        return Items;
        
    }  
**/

    private List<String> readFile(File fi) throws IOException {
        List<String> Items = new ArrayList<>();

        FileReader fir = new FileReader(fi);
        BufferedReader bar = new BufferedReader(fir);
        String item = null;
        while ((item = bar.readLine()) != null) {
            Items.add(item);
        }

        return Items;
        
    }

   

}



   


    

