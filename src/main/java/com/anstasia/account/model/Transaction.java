package com.anstasia.account.model;

import java.util.Date;

public class Transaction {
    private final int receiverId;// получатель
    private final Account senderId;
    private final int amount; // количество
    private final String comment;// категория
    private final Date date;

    public static class Builder {
        // Обязательные параметры
        private final int receiverId;
        private final int amount;

        // Необязательные параметры с значениями по умолчанию
        private Account senderId = null;
        private String comment = null;
        private Date date = null;


        public Builder(int receiverId, int amount) {
            this.receiverId = receiverId;
            this.amount = amount;
        }

        public Builder senderId(Account val) {
            senderId = val;
            return this;
        }

        public Builder comment(String val) {
            comment = val;
            return this;
        }

        public Builder date(Date val) {
            date = val;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }

    private Transaction(Builder builder) {
        receiverId = builder.receiverId;
        senderId = builder.senderId;
        comment = builder.comment;
        amount = builder.amount;
        date = builder.date;

    }

    @Override
    public String toString() {
        return "Transaction{" +
                "receiverId=" + receiverId +
                ", senderId=" + senderId +
                ", amount=" + amount +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }
}



