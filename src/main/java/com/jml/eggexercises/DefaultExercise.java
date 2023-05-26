
package com.jml.eggexercises;

import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.Document;

/* @author jmlucero */
public class DefaultExercise extends Exercise {

    public DefaultExercise(JTextPane jTextPane1, JTextField jTextField1,Document doc) {
        super(jTextPane1, jTextField1,doc);
    }

    @Override
    protected void action(ActionEvent evt) {
        AddTextToPane(jTextField.getText());
    }

 
 
    

}
