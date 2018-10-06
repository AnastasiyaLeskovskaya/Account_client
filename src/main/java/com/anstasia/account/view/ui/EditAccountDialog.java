package com.anstasia.account.view.ui;

import com.anstasia.account.controller.Controller;
import com.anstasia.account.model.Account;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class EditAccountDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox accountsComboBox;
    private JTextField currentBalanceField;
    private JTextField valuetField;
    private JButton button1;
    private JButton button2;
    private JLabel dateField;
    private JLabel valueLable;
    private JLabel categoryField;
    private JLabel currentBalanceLabel;
    private JComboBox categotyCombo;
    private int currentAccountId;

    // операции со счетом
    public EditAccountDialog() throws SQLException, ClassNotFoundException {
        setContentPane(contentPane);
        setModal(true);
        setBounds(100, 100, 600, 400);

        categotyCombo.addItem("добавить категорию");
        categotyCombo.addItem("зарплата");
        categotyCombo.addItem("аванс");
        categotyCombo.addItem("комунальные");
        categotyCombo.addItem("продукты");



//  заполнение сомбо значениями из массива

//        for (Account account : Controller.getInstance().objectA.getAccounts()) {
//            accountsComboBox.addItem(account.getName());
//        }


// !!! заполнение сомбо значениями из бд
        for (Account account : Controller.getInstance().getObjectA().getAccounts()) {
            accountsComboBox.addItem(account.getName());
        }

        currentBalanceLabel.setText(accountsComboBox.getSelectedItem().toString());
       // System.out.println(accountsComboBox.getSelectedItem().toString());
       //

        accountsComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // accountsComboBox.getSelectedItem().
                for (Account account : Controller.getInstance().getObjectA().getAccounts()) {
                   String name =  accountsComboBox.getSelectedItem().toString();
                  if (name.equals(account.getName())){
                      currentBalanceLabel.setText(account.getName()+" Balance "+account.getBalance());
                      System.out.println(account.getName()+account.getBalance());
                      currentAccountId=account.getId();
                  }
                }
            }
        });


        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
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


        categotyCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void onOK() throws SQLException {
        // add your code here
        Controller.getInstance().objectT.addNewTransaction(currentAccountId,Integer.parseInt(valuetField.getText()));
        System.out.println(valuetField.getText());
       // DbConnection.getInstance().addNewTransactionDb(currentAccountId,Integer.parseInt(valuetField.getText()));

        System.out.println("!!!");
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
