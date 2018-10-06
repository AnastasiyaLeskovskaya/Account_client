package com.anstasia.account.model;

import com.anstasia.account.controller.Controller;
import java.io.Serializable;
import java.util.ArrayList;



public class ObjectA implements Serializable{

    private ArrayList<Account> accounts;

    public ObjectA(ArrayList<Account> accounts){
        this.accounts = accounts;
        //System.out.println("I am ObjA"+ accounts);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addNewAccount(String startBalance, String name) {//вызывается при нажатии кнопки OK в addAccountDialog
        //   для пополнения в массив
        accounts.add( new Account(startBalance, name));
        Controller.getInstance().accountGUI.accountTable.updateUI();
    }

    public Account getAccount(int index){
        return accounts.get(index);
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void deleteAccount(int index) {//вызываетс в AccountTableModel
        accounts.remove(index);
    }

    public  ArrayList  loadAccounts(){
        return accounts;
    }

    public void addAccount(Account  account){
        accounts.add(account);
    }
}





