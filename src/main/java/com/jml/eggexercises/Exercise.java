package com.jml.eggexercises;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;

/* @author jmlucero */
public abstract class Exercise {

    public JTextPane jTextPane;
    public JTextField jTextField;
    public Document doc;
    public java.awt.event.ActionListener myListener;

    public Exercise(JTextPane jTextPane, JTextField jTextField, Document doc) {
        this.jTextPane = jTextPane;
        this.jTextField = jTextField;
        this.doc = doc;
        myListener = new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                action(evt);
            }
        };
        jTextField.addActionListener(myListener);

    }

    protected void action(ActionEvent evt) {

    }

    protected void removeListener() {
        jTextField.removeActionListener(myListener);
    }

    protected void AddTextToPane(String args, SimpleAttributeSet set) {
        try {
            doc.insertString(doc.getLength(), args + "\n", set);
        } catch (BadLocationException ex) {
            Logger.getLogger(Exercise.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected void AddTextToPane(String args) {
        SimpleAttributeSet set = new SimpleAttributeSet();
        try {
            doc.insertString(doc.getLength(), args + "\n", set);
        } catch (BadLocationException ex) {
            Logger.getLogger(Exercise.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected void buttonAction() {
    }
;

}
