package oop.example;
/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Kate Ingraham
 */
import java.math.BigDecimal;
import java.util.Scanner;

public class TaxCalc {
    BigDecimal orderAmount;
    String state;
    private final BigDecimal wTaxRate = BigDecimal.valueOf(.055);

    public BigDecimal getOrderAmount(){
        Scanner input = new Scanner(System.in);
        double inputOrderAmount;
        do {

            System.out.println("Enter the order amount: ");
            while (!input.hasNextDouble()) {
                String str1 = input.next();
                System.out.println(str1 + " is not a valid order amount.");
                System.out.println("Enter the order amount: ");
            }
            inputOrderAmount = input.nextDouble();
            if (inputOrderAmount < 0) {
                System.out.println("Order amount cannot be a negative value.");
            }
        } while (inputOrderAmount < 0);
        orderAmount = BigDecimal.valueOf(inputOrderAmount);
        return orderAmount;
    }

    public String getState() {
        Scanner input = new Scanner(System.in);
        int stringLength;
        int numbers = 0;

        do {

            System.out.println("Enter the state abbreviation: ");
            state = input.next();
            char [] stateNumTest = state.toCharArray();

            while (state.isBlank() || state.isEmpty()) {
                System.out.println("Empty entry. Please try again.");
                System.out.println("Enter the state abbreviation: ");
            }

            if (state.length() != 2) {
                System.out.println("State abbreviations must be two letters only.");
            }

            for (char c: stateNumTest){
                if(Character.isDigit(c)){
                    numbers = 1;
                }
            }

            if(numbers == 1){
                System.out.println("State abbreviations cannot contain numbers.");
                state = "n";
                numbers = 0;
            }

                stringLength = state.length();


        } while (stringLength != 2);

        return state;

    }

    public BigDecimal [] getTaxAndTotal(BigDecimal subtotal, String userState) {
        if (userState.equals("WI") || userState.equals("wi") || userState.equals("Wi") || userState.equals("wI")){
            BigDecimal tax = subtotal.multiply(wTaxRate);
            BigDecimal total = tax.add(subtotal);
            return new BigDecimal[]{tax, total};

        }

        return new BigDecimal[]{BigDecimal.valueOf(0),subtotal};

    }

}
