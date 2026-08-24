package org.practice.bankledger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransactionLedger {
    HashMap<Integer, Integer> balance = new HashMap<>();
    HashMap<Integer, List<String>> transactions = new HashMap<>();

    public void withdraw(int id,int amount){
        if(balance.getOrDefault(id,0)>amount) {
            balance.put(id, balance.get(id) - amount);
            transactions.putIfAbsent(id, new ArrayList<>());
            transactions.get(id).add("Withdraw amount" + amount + " ");
        } else{
            transactions.get(id).add("Insufficient Balance for withdrawal amount" + amount + " ");
        }
    }

    public void add(int id,int amount){
        balance.put(id,balance.getOrDefault
                (id,0)+amount);
        transactions.putIfAbsent(id,new ArrayList<>());
        transactions.get(id).add("Deposit amount" + amount +" ");
    }

    public boolean transfer(int id,int amount,int to){
        if(balance.getOrDefault(id,0)>amount){
            balance.put(id,balance.get(id)-amount);
            balance.put(to,balance.get(to)+amount);
            transactions.putIfAbsent(id,new ArrayList<>());
            transactions.get(id).add("Transfer amount" + amount +" to " + to);
            return true;
        }
            return false;
    }

    public List<String> getTransactions(int id){
        return transactions.getOrDefault(id,new ArrayList<>());
    }


    public int getBalance(int id){
        return balance.get(id);
    }

    public static void main(String[] args) {
        TransactionLedger tl = new TransactionLedger();
        tl.add(1,100);
        tl.withdraw(1,50);
        tl.transfer(1,50,2);
        System.out.println(tl.getTransactions(1));
        System.out.println(tl.getBalance(1));
    }

}
