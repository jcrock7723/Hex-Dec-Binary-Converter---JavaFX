package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //Radio Buttons and Group
    @FXML private RadioButton dec2Bin;
    @FXML private RadioButton dec2Hex;
    @FXML private RadioButton bin2Dec;
    @FXML private RadioButton hex2Dec;
    @FXML private ToggleGroup radioGroup;

    // Output Field
    @FXML private TextField outputField;

    // Calculate Button
    @FXML private Button calculateButton;

    // Clear all Button
    @FXML private Button clearButton;

    // TextField Button
    @FXML private TextField numberField;




    //Method to determine which operation is selected **Run on Calculate Pressed**
    public void radioButtonSelection() {

        if (this.radioGroup.getSelectedToggle().equals(this.dec2Bin))
            outputField.setText(" ");
            numberField.clear();
            //outputField.setText("dec2Bin Output");

        if (this.radioGroup.getSelectedToggle().equals(this.dec2Hex))
            outputField.setText(" ");
            numberField.clear();
            //outputField.setText("dec2Hex Output");

        if (this.radioGroup.getSelectedToggle().equals(this.bin2Dec))
            outputField.setText(" ");
            numberField.clear();
            //outputField.setText("bin2Dec Output");

        if (this.radioGroup.getSelectedToggle().equals(this.hex2Dec))
            outputField.setText(" ");
            numberField.clear();
            //outputField.setText("hex2Dec Output");

    }

    //Method to clear all and reset toggles **run also when different toggle selected
    public void clearAllButtonClick() {
        radioGroup.selectToggle(null);
        outputField.setText(" ");
        numberField.clear();
    }

    // handle the Enter button clicked
    @FXML
    public void handleEnterPressed(KeyEvent event) {
    if (event.getCode() == KeyCode.ENTER) {
        outputField.setText("Worth a try - Hit \"Convert\" ");
        // calculateConversion();
    } }


    // Method to calculate the conversion
    public void calculateConversion() {

        // Get the input from the text field - convert to an integer - process - send to output field
        if (this.radioGroup.getSelectedToggle().equals(this.dec2Bin))
            outputField.setText(dec2Bin(Integer.parseInt(numberField.getText()))); // 120 Should output 1111000

        // Get the input from the text field - convert to an integer - process - send to output field
        if (this.radioGroup.getSelectedToggle().equals(this.dec2Hex))
            outputField.setText(dec2Hex(Integer.parseInt(numberField.getText()))); // 59305 should output E7A9

        // Get the input from the text field - convert to an integer - process - send to output field
        if (this.radioGroup.getSelectedToggle().equals(this.bin2Dec))
            outputField.setText(String.valueOf(bin2Dec(numberField.getText()))); //should output 120

        // Get the input from the text field - convert to an integer - process - send to output field
        if (this.radioGroup.getSelectedToggle().equals(this.hex2Dec))
            outputField.setText(String.valueOf(hex2Dec(numberField.getText()))); //should output 59305

    }

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
    }



    // Initialize Method
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    // Initialize Toggle Group and add the radio buttons
    radioGroup = new ToggleGroup();
    this.dec2Bin.setToggleGroup(radioGroup);
    this.dec2Hex.setToggleGroup(radioGroup);
    this.bin2Dec.setToggleGroup(radioGroup);
    this.hex2Dec.setToggleGroup(radioGroup);



    }


}
