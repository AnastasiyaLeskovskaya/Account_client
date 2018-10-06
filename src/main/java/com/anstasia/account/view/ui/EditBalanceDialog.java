package com.anstasia.account.view.ui;

import com.anstasia.account.controller.Controller;
import com.anstasia.account.model.Account;
import com.anstasia.account.model.ObjectA;

import javax.swing.*;
import java.awt.event.*;
// создается в попап меню

public class EditBalanceDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField getBalanceTextField;
    private JLabel accountNameLabel;
    private JComboBox categoryIncomCombo;
    private  Account account;


    public EditBalanceDialog(Account currentAccount) { // передается только нужный аккаунт
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setBounds(100, 100, 600, 200);
        this.account = currentAccount;
        //System.out.println(currentAccount);
        accountNameLabel.setText(account.getName());

        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());

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

    private void onOK() {
        // add your code here
        System.out.println(Integer.parseInt(getBalanceTextField.getText()));
        account.addBalance(Integer.parseInt(getBalanceTextField.getText()));
        System.out.println(account.getBalance());

        Controller.getInstance().objectT.addNewTransaction(account.getId(),Integer.parseInt(getBalanceTextField.getText()));
        //System.out.println( Controller.getInstance().objectT.getTransaction(account.getId()));


        // Controller.getInstance().objectA.getAccount()
        //System.out.println(Controller.getInstance().objectA.getAccounts());

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
