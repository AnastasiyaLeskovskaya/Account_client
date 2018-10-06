package com.anstasia.account.view.ui;

import com.anstasia.account.model.AccountTableModel;
import com.anstasia.account.model.ObjectA;
import com.anstasia.account.view.MyWindowAdapter;

import javax.swing.*;
import java.sql.SQLException;

public class AccountGUI extends JFrame {

    private JButton addAccountButton;
    private JPanel panel;
    private JTabbedPane tabbedPane1;
    public JTable accountTable;
    private JButton editAccountButton;
    //private ObjectA objectA;
    private AccountTableModel accountTableModel;

    public AccountGUI(ObjectA objectA) {
        super("Main");
        System.out.println("AccountGUI constructor invoked");
        setVisible(true);//
        setBounds(100, 100, 600, 400);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setContentPane(panel);
        accountTableModel = new AccountTableModel();
        accountTable.setModel(accountTableModel);
        addWindowListener(new MyWindowAdapter());

        new CreatePopupMenu(accountTable);

        addAccountButton.addActionListener(e -> openAddAccountFrame());
        editAccountButton.addActionListener(e -> {
            try {
                openEditAccountFrame();
            } catch (SQLException | ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    //openAddAccountFrame
    private void openAddAccountFrame(){// открывает фрейм для добавления счета
        AddAccountDialog addAccountDialog = new AddAccountDialog();// фрейм для добавления счета
        addAccountDialog.setVisible(true);
    }

    private void openEditAccountFrame() throws SQLException, ClassNotFoundException {// открывает фрейм для добавления счета
        EditAccountDialog editAccountDialog = new EditAccountDialog();// фрейм для добавления счета
        editAccountDialog.setVisible(true);
    }
}

