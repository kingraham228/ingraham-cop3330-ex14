package oop.example;
/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Kate Ingraham
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class App
{


    public static void main( String[] args )
    {
        TaxCalc userInput = new TaxCalc();
        //Inputs
        BigDecimal subtotal = userInput.getOrderAmount();
        String userState = userInput.getState();
        BigDecimal[] userTotal = userInput.getTaxAndTotal(subtotal,userState);
        BigDecimal tax = userTotal[0];
        BigDecimal total = userTotal[1];

        //Big decimal formatting
        subtotal = subtotal.setScale(2,RoundingMode.UP);
        total = total.setScale(2,RoundingMode.UP);

        //State tax selection
        String taxAdd = "";
        if (!tax.equals(BigDecimal.valueOf(0))){
            tax = tax.setScale(2, RoundingMode.UP);
            taxAdd = "The tax is "+NumberFormat.getCurrencyInstance().format(tax)+".\n";
        }

       //Output
        System.out.println("The order amount is: "+ NumberFormat.getCurrencyInstance().format(subtotal)+
                "\nThe state is: "+userState+".\n"+
                "The subtotal is: "+ NumberFormat.getCurrencyInstance().format(subtotal)+".\n"+taxAdd+
                "The total is "+NumberFormat.getCurrencyInstance().format(total));




    }




}
