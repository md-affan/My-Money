package com.geektrust.backend.repositories;
import java.util.*;

public class Rebalance{
   
    public static List<Integer> get_rebalance(int e, int d, int g, List<Integer> percent){
        List<Integer> ans = new ArrayList<Integer>();

        int total = e + d + g;
        double idk = percent.get(0)/100.00;

        ans.add((int)(idk*total));

        idk = percent.get(1)/100.00;
        ans.add((int)(idk*total));
        
        idk = percent.get(2)/100.00;
        ans.add((int)(idk*total));

        return ans;
    }
}