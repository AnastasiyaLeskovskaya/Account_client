package com.anstasia.account.connection;
import com.anstasia.account.controller.Controller;

import java.sql.*;

public class DbConnection  {

    // JDBC variables for opening and managing connection
    private  Connection con;
    private  Statement stmt;
    private  ResultSet rs;
    private int idCount;

    // Реализация одиночки
    private static DbConnection Db_Instance = null;

    private DbConnection() {
    }

    public static synchronized DbConnection getInstance() {
        if (Db_Instance == null) {
            Db_Instance = new DbConnection();
        }
        return Db_Instance;
    }

    public void getConnection(String url,String user,String pass) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            stmt = con.createStatement();
            // con.close();
            // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "ROOT");
        } catch (NumberFormatException e) {
            System.out.println(" У вас ошибка!!!! СОЕДИНЕНИЯ");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(" У вас ошибка!!!! СОЕДИНЕНИЯ");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(" У вас ошибка!!!! СОЕДИНЕНИЯ");
        }
    }

    // вызов EditAccountDialog
    public void addNewTransactionDb( int recevierId, int amount) throws SQLException {
        rs = stmt.executeQuery("select count(id) from transactions");
        int  idNext = 0;
        while (rs.next()) {
            idNext = rs.getInt(1);
            // System.out.println("AAA"+idNext);
        }
        String query = "insert into account.transactions(id, receiverId,amount)" + " values( "+(idNext+1)+","+(recevierId) + "," + (amount) + ")";
        stmt.executeUpdate(query);
    }

    public int accountSize()throws ClassNotFoundException, SQLException {
        rs = stmt.executeQuery("select count(id) from objecta");
        while (rs.next()) {
            idCount = rs.getInt(1);
            System.out.println(idCount);
        }
        return idCount;
    }

    // вызов CreatePopupMenu и ObjectA
    public void deleteAccount(int selectRow) throws ClassNotFoundException, SQLException {
        String query = "delete from account.objecta where id=" + (selectRow+1);
        stmt.executeUpdate(query);
        rs = stmt.executeQuery("select *  from objecta");
        Controller.getInstance().accountGUI.accountTable.updateUI();
        rs.getString(3);
//        PreparedStatement pst = con.prepareStatement("delete from objecta where id=" + (selectRow+1));
//        pst.setInt(1, rec.getId());
//        pst.executeUpdate();
    }
}



