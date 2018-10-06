package com.anstasia.account.model;
import com.anstasia.account.connection.DbConnection;
import com.anstasia.account.controller.Controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;



public class ObjectA implements Serializable{

    private ArrayList<Account> accounts;

    public ObjectA(ArrayList<Account> accounts){
        this.accounts = accounts;
        System.out.println(accounts.get(0));
        System.out.println("I am ObjA"+ accounts);
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

    public void deleteAccount(int index) throws SQLException, ClassNotFoundException {//вызываетс в AccountTableModel
        DbConnection.getInstance().deleteAccount( index);
        // accounts.remove(index);
    }

    public  ArrayList  loadAccounts(){
        return accounts;
    }

    public void addAccount(Account  account){
        accounts.add(account);
    }
}

    // код который может пригодиться !!!

//   public String getAccountName(int index){
//       return   accounts.get(index).getName();
//       // System.out.println(accounts.get(index).getName());
//   }
//    public Account  loadAccount (int id){
//        return accounts.get(id);// return null
//    }


    //  метод берет данные из бд и записывает в arrayList
    // public void generateData()throws ClassNotFoundException, SQLException {
    //    Class.forName("com.mysql.jdbc.Driver");
    //    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/account","root","ROOT");
    //   Statement stmt = con.createStatement();
    //  ResultSet rs = stmt.executeQuery("select * from account.objecta");
//        DbHelper db =  new DbHelper();
//        db.getAccounts();

    // while(rs.next()) {
    // System.out.println("fetch sise"+ rs.getFetchSize());
    //   accounts.add(new Account(rs.getInt("id"), rs.getString("balance"),
    //         rs.getString("name")));
    //  System.out.println(rs.getInt("id") +","+ rs.getString("balance") + ", " +
    //      rs.getString("name"));
    //  }
    //  con.close();
    // }

// метод добавляет строку  нового счета в бд И В коллекцию




