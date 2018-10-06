///** Class for work with data from DB */
//
//package com.anstasia.account.connection;
//
//import com.anstasia.account.controller.Controller;
//import com.anstasia.account.model.Account;
//import com.google.gson.reflect.TypeToken;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DataProvider extends  SocketClient{
//
//    public DataProvider() throws IOException {
//    }
//
//    public void generateDataObjectA() throws IOException, ClassNotFoundException {
//
//            out.writeObject("generateDataObjectA"); // отсылаем введенную строку текста серверу.
//            // System.out.println("отослали строку на сервер ");
//            out.flush(); // заставляем поток закончить передачу данных.
//            Object obj = in.readObject();
//            // System.out.println("Gson ===" + obj);
//
//            // распарсить стринг Gson  в ArrayList<Account>
//            TypeToken<List<Account>> token = new TypeToken<List<Account>>(){};
//            List<Account> accounts = gs.fromJson((String) obj, token.getType());
//            Controller.getInstance().setObjectA((ArrayList<Account>)accounts);
//
//            }
//    public void addNewAccount(String startBalance, String name) throws ClassNotFoundException {
//        try {
//            out.writeObject("addNewAccount");
//            Account account = new Account(startBalance,name);
//            out.writeObject(account); // отсылаем введенную строку текста серверу.
//            out.flush();
//            System.out.println(account);
//            generateDataObjectA();
//        }catch (IOException e){}
//    }
//
//}
