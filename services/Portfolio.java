package com.geektrust.backend.services;

import java.util.*;
import com.geektrust.backend.repositories.Change;
import com.geektrust.backend.repositories.Debt;
import com.geektrust.backend.repositories.Equity;
import com.geektrust.backend.repositories.Gold;
import com.geektrust.backend.repositories.Rebalance;
import com.geektrust.backend.repositories.Sip;

public class Portfolio {
    private static Change change = new Change();
    private static Rebalance rebalance = new Rebalance();
    private static Debt debt = new Debt();
    private static Equity equity = new Equity();
    private static Gold gold = new Gold();
    private static Sip sip = new Sip();
    private static HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    private static List<Integer> initial = new ArrayList<>();
    
    public static void allocate(int eq_amount, int dbt_amount, int gld_amount){
        equity.equity(eq_amount, 0);
        debt.debt(dbt_amount, 0);
        gold.gold(gld_amount, 0);

        double ratio = Double.valueOf(eq_amount)/(eq_amount+dbt_amount+gld_amount);
        initial.add((int)(ratio*100));

        ratio = Double.valueOf(dbt_amount)/(eq_amount+dbt_amount+gld_amount);
        initial.add((int)(ratio*100));

        ratio = Double.valueOf(gld_amount)/(eq_amount+dbt_amount+gld_amount);
        initial.add((int)(ratio*100));
    }

    public static void set_Sip(int eq_sip, int dbt_sip, int gld_sip){
        sip.sip(eq_sip, dbt_sip, gld_sip);
    }

    public static void calculate(double eq_chng, double dbt_chng, double gld_chng, String month){
        int equity_amount = equity.get_amount();
        int debt_amount = debt.get_amount();
        int gold_amount = gold.get_amount();

        if(month.equals("JANUARY")){
            equity.equity(equity_amount, eq_chng);
            debt.debt(debt_amount, dbt_chng);
            gold.gold(gold_amount, gld_chng);
            List<Integer> ll = new ArrayList<Integer>();
            ll.add(equity.get_amount());
            ll.add(debt.get_amount());
            ll.add(gold.get_amount());
            map.put(month, ll);
        }
        else{
            List<Integer> s = sip.get_sip();
            equity_amount += s.get(0);
            debt_amount += s.get(1);
            gold_amount += s.get(2);
            equity.equity(equity_amount, eq_chng);
            debt.debt(debt_amount, dbt_chng);
            gold.gold(gold_amount, gld_chng);
            List<Integer> ll = new ArrayList<Integer>();
            ll.add(equity.get_amount());
            ll.add(debt.get_amount());
            ll.add(gold.get_amount());
            map.put(month, ll);
        }

        if(month.equals("JUNE") || month.equals("DECEMBER")){
            List<Integer> rb = rebalance.get_rebalance(equity.get_amount(),debt.get_amount(),gold.get_amount(),initial);
            map.put("REBALANCE", rb);
            equity.equity(rb.get(0), 0);
            debt.debt(rb.get(1), 0);
            gold.gold(rb.get(2), 0);
        }
        
    }

    public static List<Integer> balance(String get_output){
        if(get_output.equals("REBALANCE") && !map.containsKey("REBALANCE")){
            return null;
        }
        else return map.get(get_output);
    } 

}
