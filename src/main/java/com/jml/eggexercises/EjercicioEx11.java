
package com.jml.eggexercises;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/* @author jmlucero */
public class EjercicioEx11 extends Exercise {

    public EjercicioEx11(JTextPane jTextPane, JTextField jTextField, Document doc) {
        super(jTextPane, jTextField, doc);
    }

    @Override
    protected void action(ActionEvent evt) {
         
        AddTextToPane(jTextField.getText());
    }

    @Override
    protected void buttonAction() {
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setForeground(set, Color.blue);
        
        AddTextToPane("No hay accion especial implementada en esta caso.",set);
    }

}
