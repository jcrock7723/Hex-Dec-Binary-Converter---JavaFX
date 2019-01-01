package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hex Dec Bin Converter");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /*//Testing Decimal to Binary
        System.out.print("Enter the integer value you would like to be converted to Binary: ");
        int value = input.nextInt();
        System.out.println(dec2Bin(value));*/

        /*//Testing Decimal to hex
        System.out.print("Enter the integer value you would like to be converted to Hex: ");
        int value = input.nextInt();
        System.out.println(dec2Hex(value));*/

        /*//Testing Binary to decimal
        System.out.print("Enter the Binary value you would like to be converted to a Decimal: ");
        String value = input.next();
        System.out.println(bin2Dec(value));*/

        /*//Testing Hex to Decimal
        System.out.print("Enter the Hex value you would like to be converted to a Decimal: ");
        String value = input.next();
        System.out.println(hex2Dec(value));*/

        //System.exit(0);

        launch(args);
    }


    // All Below For Testing and building methods
/*
    *//**
     * How to Convert from Decimal to Binary
     * Conversion steps:
     *
     *     Divide the number by 2.
     *     Get the integer quotient for the next iteration.
     *     Get the remainder for the binary digit.
     *     Repeat the steps until the quotient is equal to 0.
     *//*
    public static String dec2Bin(int value){

        // when the quotient is zero return the stop
        if(value <= 0)
        {
            return "";
        }
        else
        {
            if  (value%2 != 0) //see if the remainder is odd or even ie. 1 or 0
            {
                return dec2Bin(value/2) + '1'; // if the remainder is 1 then send back through and add 1 to the String
            }
            else
            {
                return  dec2Bin(value/2) + '0'; // if the remainder is 0 append a zero to the String
            }
        }
    }

    *//**
     * How to convert from decimal to hex
     * Conversion steps:
     *
     *     Divide the number by 16.
     *     Get the integer quotient for the next iteration.
     *     Get the remainder for the hex digit.
     *     Repeat the steps until the quotient is equal to 0.
     *//*
    public static String dec2Hex(int value) {

        int remainder = value%16;

        // when the quotient is zero return the stop
        if(value <= 0)
        {
            return "";
        }

        else
        {
            if  (remainder >= 10) //if remainder is greater than 10 return the corresponding letter
            {
                String hexLetter = "Z";
                switch (remainder) {
                    case 10: hexLetter = "A"; break;
                    case 11: hexLetter = "B"; break;
                    case 12: hexLetter = "C"; break;
                    case 13: hexLetter = "D"; break;
                    case 14: hexLetter = "E"; break;
                    case 15: hexLetter = "F"; break;
                }
                return dec2Hex(value/16) + hexLetter;
            }
            else
            {
                return  dec2Hex(value/16) + Integer.toString(remainder);
            }
        }
    }

    *//**
     * How to convert binary to decimal
     * Conversion steps:
     *     Determine the number of digits
     *     Parse the first binary digit.
     *     Use pow to process the number 2 to the power of length-1
     *     Get the remaining binary digits for the next recursion
     *     Repeat the steps until the number of binary digits is equal to 1 then add and finish.
     *//*
    public static int bin2Dec(String binaryValue){

        // find the length of the binary number
        int numberDigits = binaryValue.length();

        // remove the first digit for processing
        String leadDigit = binaryValue.substring(0,1);

        // remove remainder digits for recursion
        String remDigits = binaryValue.substring(1);

        // Base Case to stop
        if (numberDigits == 1) {
            return Integer.parseInt(leadDigit); // return the lead digit either 0 or 1
        }

        else
        {
            // Convert first digit to decimal value based on its position and send the remaining digits back through
            return Integer.parseInt(leadDigit) * (int)Math.pow(2, numberDigits-1) + bin2Dec(remDigits);
        }
    }

    *//**
     * How to convert hex to decimal
     * Conversion steps:
     *     Determine the number of digits
     *     Parse the first binary digit.
     *     Use pow to process the number 2 to the power of length-1
     *     Get the remaining binary digits for the next recursion
     *     Repeat the steps until the number of binary digits is equal to 1 then add and finish.
     *//*
    public static int hex2Dec(String hexValue) {

        // find the length of the binary number
        int numberDigits = hexValue.length();

        // Base Case to stop
        if (numberDigits == 0) {
            return 0;
        }

        // remove the first digit for processing
        String leadDigit = hexValue.substring(0,1);

        // remove remainder digits for recursion
        String remDigits = hexValue.substring(1);

        // Use a try catch to decide how to process
        // If an exception is thrown it is a letter
        // If not proceed as a digit conversion
        try {
            Integer.parseInt(leadDigit);
        } catch (NumberFormatException e) { // if an exception is caught convert hex letter to dec value
            int hexLetterValue = 0;
            switch (leadDigit) {
                case "A": hexLetterValue = 10; break;
                case "B": hexLetterValue = 11; break;
                case "C": hexLetterValue = 12; break;
                case "D": hexLetterValue = 13; break;
                case "E": hexLetterValue = 14; break;
                case "F": hexLetterValue = 15; break;
            }
            return hex2Dec(remDigits) + hexLetterValue * (int)Math.pow(16, numberDigits-1);
        }
        // if no exception is caught convert hex digit to decimal
        return Integer.parseInt(leadDigit) * (int)Math.pow(16, numberDigits-1) + hex2Dec(remDigits);
    }*/


}


