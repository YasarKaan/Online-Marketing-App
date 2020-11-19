package Helper;


import User.Address;
import User.Customer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TakeInput {

    public int getInput() {
        try {
            System.out.print( "Enter:" );
            int amount;
            Scanner scanner = new Scanner( System.in );
                amount = scanner.nextInt();

            return amount;
        } catch (InputMismatchException e) {
            System.out.println( "Please write a number" );
            return getInput();
        }
    }
    public String getProductName() {
        try {
            String input;
            System.out.println( "Enter Product: " );
            Scanner scanner1 = new Scanner( System.in );
                input = scanner1.nextLine();

            return input;
        } catch (InputMismatchException e) {
            System.out.println( "Please write an Product name" );
            return takeNewUser( );
        }
    }


    public String takeNewUser() {
        try {
            String input;
            System.out.println( "Enter name: " );
            Scanner scanner = new Scanner( System.in );
                input = scanner.next();
            return input;
        } catch (InputMismatchException e) {
            System.out.println( "Please write an username" );
            return takeNewUser( );
        }
    }
    public String setPassword() {
        try {
            String input;
            System.out.println( "Enter Password: " );
            Scanner scanner = new Scanner( System.in );
                input = scanner.next();
            return input;
        } catch (InputMismatchException e) {
            System.out.println( "Please write a Password" );
            return setPassword();
        }
    }
    public String takeTelephoneNumber() {
        try {
            String input;
            System.out.println( "Enter Telephone Number: " );
            Scanner scanner = new Scanner( System.in );
                input = scanner.next();

            return input;
        } catch (InputMismatchException e) {
            System.out.println( "Please write a Telephone Number" );
            return takeTelephoneNumber();
        }
    }
    public String takeEmail() {
        try {
            String input;
            System.out.println( "Enter Email: " );
            Scanner scanner = new Scanner( System.in );
            while (true) {
                input = scanner.next();
                break;
            }
            return input;
        } catch (InputMismatchException e) {
            System.out.println( "Please write an Email " );
            return takeEmail();
        }
    }



    public String takePassword() {
        try {
            String input;
            System.out.println( "Enter Password: " );
            Scanner scanner = new Scanner( System.in );
                input = scanner.next();
            return input;
        } catch (InputMismatchException e) {
            System.out.println( "Please write a Password " );
            return takePassword();
        }
    }

    public String takeActualBalance() {
        try {
            String input;
            System.out.println( "Enter Actual Balance: " );
            Scanner scanner = new Scanner( System.in );
                input = scanner.next();
            return input;
        } catch (InputMismatchException e) {
            System.out.println( "Please write an Actual Balance " );
            return takeActualBalance();
        }
    }
    public Address takeAddress(Customer customer) {
        try {
            System.out.println( "Enter address title: " );
            Scanner scanner = new Scanner( System.in );
            String title = scanner.next();
            System.out.println( "Enter address country: " );
            String country = scanner.next();
            System.out.println( "Enter address city: " );
            String city = scanner.next();
            System.out.println( "Enter address district: " );
            String district = scanner.next();
            System.out.println( "Enter address street: " );
            String street = scanner.next();
            System.out.println( "Enter address door number: " );
            String doornumber = scanner.next();
            return customer.addAddress(title,country,city,district,street,doornumber);
        } catch (InputMismatchException e) {
            System.out.println( "Please write an address ");
            return takeAddress(customer);
        }
    }



}
