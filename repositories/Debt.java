package com.geektrust.backend.repositories;

public class Debt {
    private static int amount;
    private static double rate;

    public static void debt(int a, double r){
        amount = a;
        rate = r;
        calculate();
    }

    public static void calculate(){
        double a = (100+rate)/100 * amount;
        amount = (int)a;
    }

    public static int get_amount(){
        return amount;
    } 
}
