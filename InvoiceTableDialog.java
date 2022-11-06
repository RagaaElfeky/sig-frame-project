/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efwd.view;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author -
 */
public class InvoiceTableDialog extends JDialog {
     private JTextField custNameField;
    private JTextField dateField;
    private JLabel custNameLbl;
    private JLabel dateLbl;
    private JButton okBtn;
    private JButton cancelBtn;

    public InvoiceTableDialog(SigFrame Frame) {
        custNameLbl = new JLabel("Customer Name:");
        custNameField = new JTextField(20);
        dateLbl = new JLabel("Invoice Date:");
        dateField = new JTextField(20);
        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");
        
        okBtn.setActionCommand("newInvoiceOK");
        cancelBtn.setActionCommand("newInvoiceCancel");
        
        okBtn.addActionListener(Frame.getController());
        cancelBtn.addActionListener(Frame.getController());
        setLayout(new GridLayout(5, 3));
        
        add(dateLbl);
        add(dateField);
        add(custNameLbl);
        add(custNameField);
        add(okBtn);
        add(cancelBtn);
        setModal(true);
        pack();
        
    }

    public JTextField getCustNameField() {
        return custNameField;
    }

    public JTextField getDateField() {
        return dateField;
    }
    
    
    
}
