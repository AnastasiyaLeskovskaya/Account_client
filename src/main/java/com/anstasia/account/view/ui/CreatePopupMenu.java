package com.anstasia.account.view.ui;

import com.anstasia.account.connection.DbConnection;
import com.anstasia.account.controller.Controller;
import com.anstasia.account.model.Account;
import javax.swing.*;
import java.sql.SQLException;

public class CreatePopupMenu {
    private JTable accountTable;


    public CreatePopupMenu(JTable accountTable) {
        this.accountTable = accountTable;

        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem menuItemAddBalance = new JMenuItem("Пополнить баланс");
        JMenuItem menuItemRemove = new JMenuItem("Удалить текущий счет");
        JMenuItem menuItemRemoveAll = new JMenuItem("Удалить все счета");
        JMenuItem menuItemGetAccountName = new JMenuItem("Имя счета");

        popupMenu.add(menuItemAddBalance);
        popupMenu.add(menuItemRemove);
        popupMenu.add(menuItemRemoveAll);
        popupMenu.add(menuItemGetAccountName);

        menuItemRemove.addActionListener(e -> {
            try {
                removeCurrentRow();
            } catch (SQLException | ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            accountTable.updateUI();
        });

        menuItemAddBalance.addActionListener(e -> {// создаем фрейм передаем имя счета
            // getCurrentAccount();
            openEditBalanceDialog(getCurrentAccount());
        });

        menuItemRemoveAll.addActionListener(e -> {
            try {
                removeAllRows();
            } catch (SQLException | ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            accountTable.updateUI();
        });
        menuItemGetAccountName.addActionListener(e -> {
            System.out.println(getCurrentAccount());
            accountTable.updateUI();
        });
        accountTable.setComponentPopupMenu(popupMenu);
        accountTable.addMouseListener(new TableMouseListener(accountTable));
    }   // закрывающая конструктор

    // пополнить баланс
    private void openEditBalanceDialog(Account currentAccount) {// открывает фрейм для добавления баланса
        EditBalanceDialog editBalanceDialog = new EditBalanceDialog(currentAccount);// фрейм для добавления баланса
        editBalanceDialog.setVisible(true);
    }

    private void removeCurrentRow() throws SQLException, ClassNotFoundException {
        int selectedRow = accountTable.getSelectedRow();
        // Controller.getInstance().removeRow(selectedRow);
        DbConnection.getInstance().deleteAccount( selectedRow);
        // accountTableModel.removeRow(selectedRow);
    }

    private void removeAllRows() throws SQLException, ClassNotFoundException {
        int rowCount = accountTable.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            Controller.getInstance().removeRow(0);
        }
    }

    private Account getCurrentAccount() {//получаем имя выделенного счет
        int selectedRow = accountTable.getSelectedRow();
        return Controller.getInstance().getCurrentAccount(selectedRow);
    }
}
