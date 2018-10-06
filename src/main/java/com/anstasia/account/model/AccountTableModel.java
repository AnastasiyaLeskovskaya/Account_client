package com.anstasia.account.model;

import com.anstasia.account.controller.Controller;
import javax.swing.table.AbstractTableModel;

/**
 * Created by Anastasia on 13.11.2017.
 */
public class AccountTableModel extends AbstractTableModel{// для моей таблицы(счетов)

    private String[] columnNames = {"Счет", "Баланс"};
//    private ObjectA objectA;
//    public AccountTableModel() {
//        this.objectA = objectA;
//        System.out.println("AccountTableModel constructor invoked");
//    }

    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return Controller.getInstance().objectA.getAccounts().size();
    }

    @Override
    public int getColumnCount() {
        //  System.out.println("getColumnCount");
        return 2;
    }

    @Override
    public Object getValueAt(int r, int c) {
        //  System.out.println("getValueAt "+r+":"+c);
        switch (c) {
            case 0:
                return Controller.getInstance().objectA.getAccount(r).getName();
            case 1:
                return  Controller.getInstance().objectA.getAccount(r).getBalance();
            default:
                return "Chupakabra";
        }
    }
}

