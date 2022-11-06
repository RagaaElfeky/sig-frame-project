/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efwd.view;

import efwd.model.InvoiceTable;
import efwd.model.InvoiceTableModel;
import efwd.model.ItemTable;
import efwd.model.ItemTableModel;
import efwd.controller.SigController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author -
 */
public class SigFrame extends javax.swing.JFrame {

    /**
     * Creates new form SIGframe
     */
    public SigFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        invTable = new javax.swing.JTable();
        invTable.getSelectionModel().addListSelectionListener(controller);
        jScrollPane2 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        itemTable.getSelectionModel().addListSelectionListener(controller);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        invNoLbl = new javax.swing.JLabel();
        invDateTxf = new javax.swing.JTextField();
        custNameTxf = new javax.swing.JTextField();
        invTotalLbl = new javax.swing.JLabel();
        newInvoiceBtn = new javax.swing.JButton();
        newInvoiceBtn.addActionListener(controller);
        deletInvoiceBtn = new javax.swing.JButton();
        deletInvoiceBtn.addActionListener(controller);
        saveBtn = new javax.swing.JButton();
        saveBtn.addActionListener(controller);
        cancelBtn = new javax.swing.JButton();
        cancelBtn.addActionListener(controller);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        loadFile = new javax.swing.JMenuItem();
        loadFile.addActionListener(controller);
        saveFile = new javax.swing.JMenuItem();
        saveFile.addActionListener(controller);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Cust Name", "Date ", "InvTotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(invTable);

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                " No", "Item Name", "Price", "Count", "Item Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(itemTable);

        jLabel1.setText("Invoice Number       :");

        jLabel2.setText("Invoice Date      :");

        jLabel3.setText("Customer Name :");

        jLabel4.setText("Invoice Total  : ");

        invNoLbl.setText(".");

        invTotalLbl.setText(".");

        newInvoiceBtn.setText("Creat New Invoice");

        deletInvoiceBtn.setText("Delet Invoice");
        deletInvoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletInvoiceBtnActionPerformed(evt);
            }
        });

        saveBtn.setText("Save");

        cancelBtn.setText("Cancel");

        jMenuFile.setText("File");

        loadFile.setText("Load File");
        loadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFileActionPerformed(evt);
            }
        });
        jMenuFile.add(loadFile);

        saveFile.setText("Save File");
        jMenuFile.add(saveFile);

        jMenuBar1.add(jMenuFile);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(invNoLbl)
                .addGap(186, 186, 186))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(invDateTxf, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel4)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(invTotalLbl)
                                            .addComponent(custNameTxf))))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(newInvoiceBtn)
                        .addGap(30, 30, 30)
                        .addComponent(deletInvoiceBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveBtn)
                        .addGap(63, 63, 63)
                        .addComponent(cancelBtn)
                        .addGap(42, 42, 42))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(invNoLbl))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(invDateTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(custNameTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(invTotalLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newInvoiceBtn)
                    .addComponent(deletInvoiceBtn)
                    .addComponent(saveBtn)
                    .addComponent(cancelBtn))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadFileActionPerformed

    private void deletInvoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletInvoiceBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deletInvoiceBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SigFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SigFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SigFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SigFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              SigFrame gf =  new SigFrame();
              gf.controller.loadFile("InvoiceHeader.csv", "InvoiceLine.csv");
              gf.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField custNameTxf;
    private javax.swing.JButton deletInvoiceBtn;
    private javax.swing.JTextField invDateTxf;
    private javax.swing.JLabel invNoLbl;
    private javax.swing.JTable invTable;
    private javax.swing.JLabel invTotalLbl;
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadFile;
    private javax.swing.JButton newInvoiceBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JMenuItem saveFile;
    // End of variables declaration//GEN-END:variables
public static SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
private InvoiceTableModel invoiceTableModel;
private ItemTableModel itemTableModel;
private ArrayList<InvoiceTable>invoiceis;
    private SigController controller = new SigController(this);

    public InvoiceTableModel getInvoiceTableModel() {
        
         return invoiceTableModel;
    }
     public void setInvoiceTableModel(InvoiceTableModel invoiceTableModel) {
         this.invoiceTableModel = invoiceTableModel;
        getInvTable().setModel(invoiceTableModel);
    }
 public ItemTableModel getItemTableModel() {
        return itemTableModel;
    }
  public void setItemTableModel(ItemTableModel itemTableModel) {
          this.itemTableModel = itemTableModel;
        getItemTable().setModel(itemTableModel);
     }

public ArrayList<InvoiceTable> getInvoiceis() {
     if (invoiceis==null)
         invoiceis=new ArrayList<>();
     return invoiceis;
 }
    public SigController getController() {
        return controller;
    }
    
    public JTable getItemTable() {
        return itemTable;
    }
      

    public JTextField getCustNameTxf() {
        
        return custNameTxf;
    }
     

    public JTextField getInvDateTxf() {
         
        return invDateTxf;
    }
 
   

    public JLabel getInvNoLbl() {
        return invNoLbl;
    }

    public JLabel getInvTotalLbl() {
        return invTotalLbl;
    }

   
     public JTable getInvTable() {
        return invTable ;
    }

    public InvoiceTableModel getInvoices() {
        return invoiceTableModel ; //To change body of generated methods, choose Tools | Templates.
    }

    public InvoiceTable getInvoiceByNo(int no) {
        //InvoiceTable inv =null;
        for(InvoiceTable invo : getInvoiceis())
                {
                    if(invo.getNo()==no) return invo;
                }
        return null;
    }
public int getNextInvoiceNo(){

int no =0;
for(InvoiceTable invo : getInvoiceis()){
    if (invo.getNo()> no)no = invo.getNo();
}
return no + 1;
}
        }
 
     
    

   

   

    

  

