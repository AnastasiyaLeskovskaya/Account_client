package com.anstasia.account.controller;

import com.anstasia.account.connection.SocketClient;
import com.anstasia.account.model.Account;
import com.anstasia.account.model.ObjectA;
import com.anstasia.account.model.ObjectT;
import com.anstasia.account.view.ui.AccountGUI;
import java.io.Serializable;
import java.util.ArrayList;

public class Controller implements Serializable {

    public AccountGUI accountGUI;
    public ObjectA objectA;
    public ObjectT objectT;
    public SocketClient sc;
    // public EditAccountDialog editAccount;

    // реализуем Singleton
    private Controller(){}

    private static class ControllerHolder {
        private static final Controller instance = new Controller();
    }

    public static Controller getInstance() {
        return Controller.ControllerHolder.instance;
    }

    private Object readResolve() {  // чтобы не б
        return Controller.ControllerHolder.instance;
    }

    // Забрали списов в сокете и инициализировали данные
    public void setObjectA(ArrayList<Account> accountsFromDb) {
        this.objectA = new ObjectA(accountsFromDb);
    }

    public SocketClient getSc() {
        return sc;
    }

    public void setSc(SocketClient sc) {
        this.sc = sc;
    }

    public void setObjectT(ObjectT objectT) {
        this.objectT = objectT;
    }

    public void setAccountGUI(AccountGUI accountGUI) {
        this.accountGUI = accountGUI;
    }

    public ObjectA getObjectA() {
        System.out.println("I am getObjectA");
        return objectA;
    }

    // методы вызываемые в CreatePopupMenu
    public void removeRow(int selectedRow)  {// вызывается в пCreatePopupMenu
        objectA.deleteAccount (selectedRow);
    }

    public int getCurrentAccountId(int selectedRow) {//  вызывается в пCreatePopupMenu  получение выделенного в попапиеню Имени счета
        return  objectA.getAccount(selectedRow).getId();
    }

    public String getCurrentAccountName(int selectedRow) {//  вызывается в пCreatePopupMenu  получение выделенного в попапиеню Имени счета
        return  objectA.getAccount(selectedRow).getName();
    }

    public Account getCurrentAccount(int selectedRow) {//  вызывается в пCreatePopupMenu  получение выделенного в попапиеню Имени счета
        return  objectA.getAccount(selectedRow);
    }
    public void addBalance() {// добавляет поступления на счет

    }

    public void getAllIncome() {// метод который посчитает все поступления у одного счета
    }
}
