package com.anstasia.account.view.ui;

import com.anstasia.account.controller.Controller;
import com.anstasia.account.model.Account;
import javax.swing.*;
import java.io.IOException;
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
            } catch (IOException e1) {
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
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            accountTable.updateUI();
        });

        menuItemGetAccountName.addActionListener(e -> {
            System.out.println(getCurrentAccountName());
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

    private void removeCurrentRow() throws IOException {
        int selectedRow = accountTable.getSelectedRow();

        // delete account from Db
        int idAccountForDel = Controller.getInstance().getCurrentAccountId(selectedRow);
        Controller.getInstance().sc.deleteAccountFromDB(idAccountForDel);

        // delete account local
        Controller.getInstance().removeRow(selectedRow);

        // System.out.println("Selected row " + selectedRow);
        // System.out.println(selectedRow);
        // System.out.println( "id for del " + Controller.getInstance().getCurrentAccountId(selectedRow));
    }

    private void removeAllRows() throws IOException {
        int rowCount = accountTable.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            Controller.getInstance().removeRow(0);
        }
        Controller.getInstance().sc.deleteAllAccountsFromDB();
    }

    private String getCurrentAccountName() {//получаем имя выделенного счет
        int selectedRow = accountTable.getSelectedRow();
        return Controller.getInstance().getCurrentAccountName(selectedRow);
    }

    private Account getCurrentAccount() {//получаем имя выделенного счет
        int selectedRow = accountTable.getSelectedRow();
        return Controller.getInstance().getCurrentAccount(selectedRow);
    }
}
