package com.geektrust.backend.repositories;
import java.util.*;

public class Sip {
    public static int equity_sip;
    public static int debt_sip;
    public static int gold_sip;

    public static void sip(int a, int b, int c){
        equity_sip = a;
        debt_sip = b;
        gold_sip = c;
    }

    public static List<Integer> get_sip(){
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(equity_sip);
        ans.add(debt_sip);
        ans.add(gold_sip);

        return ans;
    }
}
