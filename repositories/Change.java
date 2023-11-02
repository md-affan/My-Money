package com.geektrust.backend.repositories;
import java.util.*;

public class Change {
    private static int equity_change;
    private static int debt_change;
    private static int gold_change;

    public static void change(int a, int b, int c){
        equity_change = a;
        debt_change = b;
        gold_change = c;
    }

    public static List<Integer> get_change(){
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(equity_change);
        ans.add(debt_change);
        ans.add(gold_change);

        return ans;
    }
}
