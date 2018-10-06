package com.anstasia.account.model;

import java.util.ArrayList;

public class ObjectT {

    private ArrayList<Transaction> transactions;

    public ObjectT(){
        transactions = new ArrayList<>();
        generateData();
        //System.out.println(transactions);
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    public Transaction getTransaction(int index){
        return transactions.get(index);
    }

    public void generateData()  {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/account","root","ROOT");
//        Statement stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery("select * from transactions");
//        while(rs.next()) {
//            // System.out.println("fetch sise"+ rs.getFetchSize());
//            transactions.add(new Transaction.Builder(rs.getInt("id"), rs.getInt("amount"),
//                    rs.getString("comment").build()));
//            //  System.out.println(rs.getInt("id") +","+ rs.getString("balance") + ", " +
//            //      rs.getString("name"));
//        }
//        con.close();

        transactions.add(new Transaction.Builder(1,620).comment("зарплата").build());
        transactions.add(new Transaction.Builder(1,420).comment("аванс").build());
        transactions.add(new Transaction.Builder(2,620).comment("зарплата").build());

    }

    public void addNewTransaction(int receiverId, int amount){//вызывается при нажатии кнопки OK в editBalanceDialog
        try{
            Transaction tr = new Transaction.Builder(receiverId,amount).build();
            transactions.add(tr);
            System.out.println(tr);
            }catch (NumberFormatException e) {
            System.out.println("!!!!! У вас ошибка!!!!Проверьте корректность данных в полях");
        }

    }

    public void addBalance(){// добавляет поступления на счет

    }

    @Override
    public String toString() {
        return "ObjectT{" +
                "transactions=" + transactions +
                '}';
    }


}
