package com.anstasia.account.main;


import com.anstasia.account.connection.DbConnection;
import com.anstasia.account.connection.SocketClient;
import com.anstasia.account.controller.Controller;
import com.anstasia.account.view.ui.AccountGUI;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("hello Anastasiya!");
        // Соединились с бд
        //DbConnection.getInstance().getConnection(args[0], args[1], args[2]);
        // создаем соединение с сервером

        SocketClient sc;
        try {
            sc = new SocketClient();
            sc.generateDataObjectA();
           // DataProvider dataProvider = new DataProvider();
           // dataProvider.generateDataObjectA();
            Controller.getInstance().setSc(sc);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AccountGUI accountGUI = new AccountGUI(Controller.getInstance().getObjectA());
        Controller.getInstance().setAccountGUI(accountGUI);
//        Controller.getInstance().setSc(sc);
//         ObjectA objectA = new ObjectA();
//         ObjectT objectT = new ObjectT();
        // controller.setObjectA(objectA);
        // controller.setObjectT(objectT);
        // controller.setAccountGUI(accountGUI);

        // DbConnection.getInstance().getAccount();
        // DbConnection.getInstance().accountSize();
        // DbConnection.getInstance().addNewAccountDb("234","gfgf");

//         Controller.getInstance().objectT.addNewTransaction(1,12);
//         System.out.println(Controller.getInstance().objectT.getTransactions());
//
//
//         System.out.println( Controller.getInstance().objectA.getAccounts());
    }
}

