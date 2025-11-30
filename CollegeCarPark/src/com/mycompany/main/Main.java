/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

// All imports

package com.mycompany.main;
import java.util.Scanner;

import static java.lang.System.exit;


/**
 *
 * @author st20287200
 */
public class Main {
    public static String filePath = "\\CollegeCarPark\\new vrn.csv"; //File path to csv file

    public static void main(String[] args) {
        menu(); //Call the main menu method
    }

    public static void printMenu(String[] options){

        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }
    public static void menu() {
        String[] options = {
                "[1] Admin Mode:",
                "[2] Record Mode:",
                "[3] Exit",
        };
        Scanner scanner = new Scanner(System.in); //Get user input for main menu
        int option = 1;
        while (option!=3){
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option){  //Based off user selection will either trigger admin menu or record menu
                    case 1: adminMenu(); break;
                    case 2: recordMenu(); break;
                    case 3: exit(0);
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            }
        }
    }

    public static void recordMenu() {
        Scanner userInput = new Scanner(System.in); // Create new scanner object
        System.out.println("Please enter your VRN: "); //Prompt user to enter their VRN
        String selection = userInput.nextLine();

        CarParkRecord myCarParkRecord = new CarParkRecord(filePath);
        myCarParkRecord.parseRecord(selection);

    }
    public static void adminMenu() {
        Scanner userInput = new Scanner(System.in); //Get user input for the admin menu
        System.out.println("Please select an option: ");
        System.out.println("[1]Show all vehicles: ");
        System.out.println("[2]Search for VRN: ");
        System.out.println("[3]Amend data: ");
        System.out.println("[4]Delete data");
        String selection = userInput.nextLine();
        
        switch(selection) {
            case "1":
                CarParkAdmin.displayData(filePath); //Run displayData method
                break;
            case "2":
                CarParkAdmin.searchVRN(filePath); //Run searchVRN method
                break;
           case "3":
                CarParkAdmin.amendLine(filePath);// Run amend method
               break;
            case "4":
                CarParkAdmin.deleteLine(filePath); // Run delete method

        }
    }
}
