package com.anstasia.account.main;


import com.anstasia.account.connection.SocketClient;
import com.anstasia.account.controller.Controller;
import com.anstasia.account.view.ui.AccountGUI;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("hello Anastasiya!");

        SocketClient sc;
        try {
            sc = new SocketClient();
            sc.generateDataObjectA();
            Controller.getInstance().setSc(sc);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AccountGUI accountGUI = new AccountGUI(Controller.getInstance().getObjectA());
        Controller.getInstance().setAccountGUI(accountGUI);
    }
}

