package com.anstasia.account.connection;

import com.anstasia.account.controller.Controller;
import com.anstasia.account.model.Account;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketClient implements Serializable {

    protected ObjectOutputStream out;
    protected ObjectInputStream in;
    protected Gson gs;

    public SocketClient() throws IOException {

        int serverPort = 6666; // здесь обязательно нужно указать порт к которому привязывается сервер.
        String address = "127.0.0.1"; // это IP-адрес компьютера, где исполняется наша серверная программа.// Здесь указан адрес того самого компьютера где будет исполняться и клиент.
        InetAddress ipAddress = InetAddress.getByName(address); // создаем объект который отображает вышеописанный IP-адрес.

        Socket socket = new Socket(ipAddress, serverPort);
        System.out.println("Yes! I just got hold of the program.");

        //   Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиентом.
        InputStream sin = socket.getInputStream();
        OutputStream sout = socket.getOutputStream();

        //  Koнвертируем потоки в другой тип, чтоб легче обрабатывать  данные.
        out = new ObjectOutputStream(sout);
        in = new ObjectInputStream(sin);
        gs = new Gson();
    }

    //  download data from server
    public void generateDataObjectA() {
        try {
            out.writeObject("generateDataObjectA"); // отсылаем введенную строку текста серверу.
            out.flush(); // заставляем поток закончить передачу данных.
            Object obj = in.readObject();

            // распарсить стринг Gson  в ArrayList<Account>
            TypeToken<List<Account>> token = new TypeToken<List<Account>>(){};
            List<Account> accounts = gs.fromJson((String) obj, token.getType());
            Controller.getInstance().setObjectA((ArrayList<Account>)accounts);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error connecting with generateDataObjectA() in SocketClient.class ");
        }
    }


    public void addNewAccount(String startBalance, String name){
        try {
            System.out.println(startBalance + name);
            out.writeObject("addNewAccount");
            Account account = new Account(startBalance,name);
            System.out.println(gs.toJson(account));
            out.writeObject(gs.toJson(account)); // отсылаем введенную строку текста серверу.
            out.flush();
            //System.out.println(account);

            // выкачивание свежей таблицы из бд
            generateDataObjectA();
            // отображение обновленных данных на экране
            Controller.getInstance().accountGUI.accountTable.updateUI();

        }catch (IOException e){
            System.out.println("Error connecting with addNewAccount() in SocketClient.class ");
        }
    }

    public void deleteAccountFromDB(int idAccount) throws IOException {
        out.writeObject("deleteAccount");
        out.writeObject(gs.toJson(idAccount)); // отсылаем введенную строку текста серверу.
        out.flush();
    }
}

