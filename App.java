package com.geektrust.backend;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import com.geektrust.backend.services.Portfolio;

public class App {

	public static void main(String[] args) {

        Portfolio r = new Portfolio();

        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {

            while (true) {
                String line = reader.readLine();
                if (line == null){
                    break;
                }
                List<String> tokens = Arrays.asList(line.split(" "));

                switch(tokens.get(0)){
                    
                    case "ALLOCATE":
                    {
			r.allocate(Integer.parseInt(tokens.get(1)), Integer.parseInt(tokens.get(2)), Integer.parseInt(tokens.get(3)));
                    }
                    break;

                    case "SIP":
                    {
			r.set_Sip(Integer.parseInt(tokens.get(1)), Integer.parseInt(tokens.get(2)), Integer.parseInt(tokens.get(3)));
                    }
                    break;

                    case "CHANGE":
                    {
                        StringBuilder s1 = new StringBuilder(tokens.get(1));
                        s1.deleteCharAt(s1.length() - 1);

                        StringBuilder s2 = new StringBuilder(tokens.get(2));
                        s2.deleteCharAt(s2.length() - 1);

                        StringBuilder s3 = new StringBuilder(tokens.get(3));
                        s3.deleteCharAt(s3.length() - 1);

                        r.calculate(Double.parseDouble(s1.toString()), Double.parseDouble(s2.toString()), Double.parseDouble(s3.toString()), tokens.get(4));
                    }
                    break;

                    case "BALANCE":
                    {
                        List<Integer> out = r.balance(tokens.get(1));

                        for(int i : out) {
                            System.out.print(i);
                            System.out.print(" ");
                        }
                        System.out.println();
                    }
                    break;

                    case "REBALANCE":
                    {

                        if(r.balance(tokens.get(0)) == null) {
                            System.out.print("CANNOT_REBALANCE");
                            break;}

                        List<Integer> out = r.balance(tokens.get(0));
                        for(int i : out) {
                            System.out.print(i);
                            System.out.print(" ");
                        }
                        System.out.println();
                    }
                    break;

                    default :
                        throw new RuntimeException("Invalid Command");
                }
            }
            reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
    }
}
