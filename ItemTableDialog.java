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
public class ItemTableDialog extends JDialog{
    private JTextField iNameField;
    private JTextField iCountField;
    private JTextField iPriceField;
    private JLabel iNameLbl;
    private JLabel iCountLbl;
    private JLabel iPriceLbl;
    private JButton okBtn;
    private JButton cancelBtn;
    
    public ItemTableDialog(SigFrame miniFrame) {
        iNameField = new JTextField(20);
        iNameLbl = new JLabel("Item Name");
        
           iPriceField = new JTextField(20);
        iPriceLbl = new JLabel("Item Price");
        
        iCountField = new JTextField(20);
        iCountLbl = new JLabel("Item Count");
        
     
        
        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");
        
        okBtn.setActionCommand("newItemOK");
        cancelBtn.setActionCommand("newItemCancel");
        
        okBtn.addActionListener(miniFrame.getController());
        cancelBtn.addActionListener(miniFrame.getController());
        setLayout(new GridLayout(6, 2));
        
        add(iNameLbl);
        add(iNameField);
          add(iPriceLbl);
        add(iPriceField);
        add(iCountLbl);
        add(iCountField);
        add(okBtn);
        add(cancelBtn);
        setModal(true);
        pack();
    }

    public JTextField getINameField() {
        return iNameField;
    }
    
     public JTextField getIPriceField() {
        return iPriceField;
    }

    public JTextField getICountField() {
        return iCountField;
    }

   
}


