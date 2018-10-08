package com.anstasia.account.view.ui;

import com.anstasia.account.controller.Controller;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class AddAccountDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField nameCountTextField;
    private JTextField startBalansTextField;
   // private ObjectA objectA;

    public AddAccountDialog() {

        this.setContentPane(contentPane);
        this.setModal(true);
        this.setBounds(50, 50, 400, 200);
        this.getRootPane().setDefaultButton(buttonOK);
        setResizable(false);

       // System.out.println(Controller.getInstance().objectA.getAccounts());

        buttonOK.addActionListener(e -> {
            try {
                onOK();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() throws SQLException, ClassNotFoundException {
        // add your code here
        // Controller.getInstance().objectA.addNewAccount(startBalansTextField.getText(), nameCountTextField.getText());

        // Временный коммент из за датапровидера
        Controller.getInstance().getObjectA().addNewAccount(startBalansTextField.getText(), nameCountTextField.getText());
        Controller.getInstance().sc.addNewAccount(startBalansTextField.getText(), nameCountTextField.getText());
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
