import persons.clients.Cart;

import persons.clients.Client;
import persons.clients.Order;
import persons.employees.Employee;
import persons.employees.typeEmployeeArea;
import products.Product;
import products.drinks.*;
import products.food.Food;
import products.food.WithMeat;
import products.food.WithoutMeat;
import products.food.typeMeat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //TakeAway Declaration
        TakeAway elCirculo = new TakeAway();

        //region TESTS!

        //PREMIUM Client test
        /*
        Client premiumTest = new Client("Matias Mercado", "321", "matii@gmail.com", "Alberdi 7777");
        premiumTest.setOrdersAmount(9);
        elCirculo.addPersonToStore(premiumTest);
         */

        //

        //Test date for tests
        LocalDate testDate = LocalDate.parse("20/03/2001", DateTimeFormatter.ofPattern("d/MM/yyyy"));

        //region Hardcode-Added new Products to the TakeAway
        /*
        elCirculo.addDrinkToStore(new Alcoholic("Brahma", 2, 90f, 1.5f, "Bottle", true, "Beer", typeAlcoholic.Beer, 4.5f));
        elCirculo.addDrinkToStore(new NonAlcoholic("Pepsi", 4, 70f, 1.5f, "Bottle", true, "Cola", typeNonAlcoholic.Soda));
        elCirculo.addFoodtoStore(new WithMeat("Cheeseburger", 640f, "A burger with cheddar cheese", 2, typeMeat.Beef));
        elCirculo.addFoodtoStore(new WithoutMeat("Fried Noodles", 400f, "Fried noodles with vegetables", 1, "Rice Noodles"));
        */
        //endregion

        //region Hardcode-Added new Persons the TakeAway

        /*
        //Hardcoded Clients
        elCirculo.addPersonToStore(new Client("Matias Mercado", "123", "mati@gmail.com", "Alberdi 7777"));
        elCirculo.addPersonToStore(new Client("Tobias Lima", "2231111111", "tobu@gmail.com", "Alberdi 7777"));
        elCirculo.addPersonToStore(new Client("Olaf Gonzales", "2233333333", "olaf@gmail.com", "Medano 0"));

        //Hardcoded Employees
        elCirculo.addPersonToStore(new Employee("Gabriel Seballos", "2236666666", "gabriel@gmail.com", "San Martin 1412", typeEmployeeArea.Delivery));
        elCirculo.addPersonToStore(new Employee("Cris Hernandez", "2234444444", "cris@gmail.com", "Uruguay 2567", typeEmployeeArea.Kitchen));
        elCirculo.addPersonToStore(new Employee("Ulices Lopez", "2237777777", "ulices@outlook.com", "Yrigoyen 5672", typeEmployeeArea.Inventory));
        elCirculo.addPersonToStore(new Employee("Martin Vasquez", "2239999999", "martin@hotmail.com", "Mitre 3421", typeEmployeeArea.Manager));
        elCirculo.addPersonToStore(new Employee("Marco Martinez", "2235555555", "marco@gmail.com", "Jujuy 2098", typeEmployeeArea.Call_operator));
        */
        //endregion

        //region WORKING! Make Methods

        //region (WORKING!) Adding Person/s to the TakeAway using "Make" Methods
        /*
        elCirculo.makeClient();
        elCirculo.makeEmployee();

        elCirculo.displayAllClients();
        elCirculo.displayAllEmployees();
        */
        //endregion

        //region (WORKING!) Adding Food/s to the TakeAway using "Make" Methods
        /*
        elCirculo.makeFoodWithMeat();
        elCirculo.makeFoodWithoutMeat();

        elCirculo.displayAllFood();
        */
        //endregion

        //region (WORKING!) Adding Drink/s to the TakeAway using "Make" Methods
        /*
        elCirculo.makeNonAlcoholic();
        elCirculo.makeAlcoholic();

        elCirculo.displayAllDrinks();
        */
        //endregion

        //region (WORKING!) Add Order to the TakeAway using "Make" Methods
        /*
        elCirculo.makeOrder();

        elCirculo.displayAllOrders();
        */
        //endregion

        //endregion

        //region Files management
        /*
        //Products files
        elCirculo.saveProductsData();
        elCirculo.loadProductsData();

        elCirculo.displayAllFood();
        elCirculo.displayAllDrinks();

        //Persons files
        elCirculo.savePersonsData();
        elCirculo.loadPersonsData();

        elCirculo.displayAllClients();
        elCirculo.displayAllEmployees();

        //Orders files
        elCirculo.saveOrdersData();
        elCirculo.loadOrdersData();

        elCirculo.displayAllOrders();
        */
        //endregion

        //endregion

        //region MAIN PROGRAM MENU

        //Load data from disk
        System.out.println("\033[1;92m"); //Green text
        elCirculo.loadProductsData();
        elCirculo.loadPersonsData();
        elCirculo.loadOrdersData();

        System.out.println("---------------------------------------------------------------------------\n" + "\033[40m\u001B[35m" );

        Scanner option = new Scanner(System.in);
        int op = 0;
        int subOp = 0;
                                  //region MAIN MENU
        while(op != 9) {
            op = 0;
            menu();

                try {
                    option.reset();
                    op = option.nextInt();
                    option.reset();
                }
                catch(InputMismatchException e){
                    cls();
                    System.out.println("You must enter a valid option number!");
                    pressEnterKeyToContinue();
                    option.reset();  option.nextLine();
                }

            switch (op) {
                case 1:                   //region CLIENTS SUBMENU
                    subOp = 0;

                    while (subOp != 9){
                        subOp = 0;
                        clientSubMenu();

                        try {
                            option.reset();
                            subOp = option.nextInt();
                            option.reset();
                        }
                        catch(InputMismatchException e){
                            cls();
                            System.out.println("You must enter a valid option number!");
                            pressEnterKeyToContinue();
                            option.reset();
                        }

                        cls();
                        switch (subOp) {
                            case 1:                    //region New Client
                                elCirculo.makeClient();
                                option.reset();
                                break;
                                //endregion
                            case 2:                    //region Search Client
                                System.out.println("Input the Client´s phone to search for it: ");
                                Client aux = elCirculo.searchClientByPhone(option.next());
                                if(aux != null){
                                    System.out.println(aux);
                                }
                                pressEnterKeyToContinue();
                                option.reset(); option.nextLine();
                                break;
                                //endregion
                            case 3:                    //region Display all clients
                                elCirculo.displayAllClients();
                                pressEnterKeyToContinue();
                                break;
                                //endregion
                            case 4:                    //region Edit Client
                                elCirculo.displayAllClients();
                                System.out.println("\nInput the Client´s phone to edit it: ");
                                Client auxC = elCirculo.searchClientByPhone(option.next());

                                if(auxC != null){
                                    cls();
                                    System.out.println(auxC);
                                    elCirculo.editClient(auxC);
                                    System.out.println(auxC);
                                }
                                pressEnterKeyToContinue();
                                option.reset();
                                break;
                                //endregion
                            case 5:                    //region Change Active status
                                String stringOption;
                                elCirculo.displayAllClients();
                                System.out.println("\nInput Client phone to edit status: ");
                                stringOption = option.next();
                                option.reset();

                                Client auxCl = elCirculo.searchClientByPhone(stringOption);

                                if(auxCl != null){
                                    System.out.println("\nActive status: " + auxCl.isActive() + "\nSet status to 1:active | 2:inactive  | Other:keep original");

                                    try {
                                        option.reset();
                                        subOp = option.nextInt();
                                        option.reset();
                                    }
                                    catch(InputMismatchException e){
                                        cls();
                                        System.out.println("You must enter a valid option number!");
                                        option.reset();
                                    }

                                    if(subOp == 1){
                                        auxCl.setActive(true);
                                        System.out.println("\nThe client is now Active!");
                                    }
                                    if(subOp == 2){
                                        auxCl.setActive(false);
                                        System.out.println("\nThe client is now Inactive");
                                    }

                                }
                                pressEnterKeyToContinue();
                                break;
                                //endregion
                        }
                        option.reset(); option.nextLine();
                        cls();
                    }
                    break;
                    //endregion
                case 2:                   //region EMPLOYEES SUBMENU
                    subOp = 0;

                    while (subOp != 9){
                        subOp = 0;
                        employeeSubMenu();

                        try {
                            option.reset();
                            subOp = option.nextInt();
                            option.reset();
                        }
                        catch(InputMismatchException e){
                            cls();
                            System.out.println("You must enter a valid option number!");
                            pressEnterKeyToContinue();
                            option.reset();
                        }
                        cls();
                        switch (subOp) {
                            case 1:                   //region New Employee
                                elCirculo.makeEmployee();
                                break;
                                //endregion
                            case 2:                   //region Search Employee
                                System.out.println("Input the Employee´s phone to search for it: ");
                                Employee aux = elCirculo.searchEmployeeByPhone(option.next());
                                if(aux != null){
                                    System.out.println(aux);
                                }
                                pressEnterKeyToContinue();
                                break;
                                //endregion
                            case 3:                   //region Display all Employees
                                elCirculo.displayAllEmployees();
                                pressEnterKeyToContinue();
                                break;
                                //endregion
                            case 4:                   //region Edit Employee
                                elCirculo.displayAllEmployees();
                                System.out.println("Input the Employee´s phone to edit it: ");
                                Employee auxEm = elCirculo.searchEmployeeByPhone(option.next());

                                if(auxEm != null){
                                    cls();
                                    System.out.println(auxEm);
                                    elCirculo.editEmployee(auxEm);
                                }
                                pressEnterKeyToContinue();
                                option.reset();
                                break;
                                //endregion
                            case 5:                   //region Edit Employee Status
                                String stringOption;
                                elCirculo.displayAllEmployees();
                                System.out.println("\nInput Employee phone to edit status: ");
                                stringOption = option.next();
                                option.reset();

                                Employee auxE = elCirculo.searchEmployeeByPhone(stringOption);

                                if(auxE != null){
                                    System.out.println("\nActive status: " + auxE.isActive() + "\nSet status to 1:active | 2:inactive  | Other:keep original");

                                    try {
                                        option.reset();
                                        subOp = option.nextInt();
                                        option.reset();
                                    }
                                    catch(InputMismatchException e){
                                        cls();
                                        System.out.println("You must enter a valid option number!");
                                        pressEnterKeyToContinue();
                                        option.reset();
                                    }

                                    if(subOp == 1){
                                        auxE.setActive(true);
                                        System.out.println("\nThe Employee is now Active!");
                                    }
                                    if(subOp == 2){
                                        auxE.setActive(false);
                                        System.out.println("\nThe Employee is now Inactive");
                                    }

                                }
                                pressEnterKeyToContinue();
                                break;
                                //endregion
                        }
                        option.reset(); option.nextLine();
                        cls();
                    }
                    break;
                    //endregion
                case 3:                   //region PRODUCTS SUBMENU
                    subOp = 0;

                    while (subOp != 9){
                        subOp = 0;
                        productsSubMenu();

                        try {
                            option.reset();
                            subOp = option.nextInt();
                            option.reset();
                        }
                        catch(InputMismatchException e){
                            cls();
                            System.out.println("You must enter a valid option number!");
                            pressEnterKeyToContinue();
                            option.reset();
                        }

                        cls();
                        switch (subOp) {
                            case 1:     //region Drinks SUBMENU
                                subOp = 0;

                                while (subOp != 9){
                                    subOp = 0;
                                    drinksSubMenu();

                                    try {
                                        option.reset();
                                        subOp = option.nextInt();
                                        option.reset();
                                    }
                                    catch(InputMismatchException e){
                                        cls();
                                        System.out.println("You must enter a valid option number!");
                                        pressEnterKeyToContinue();
                                        option.reset();
                                    }

                                    cls();
                                    switch (subOp) {
                                        case 1:            //region New Drink
                                            System.out.println("1: Alcoholic | 2: Non Alcohol | Other: Cancel");
                                            subOp = option.nextInt();
                                            option.reset();
                                            cls();

                                            if(subOp == 1){
                                                elCirculo.makeAlcoholic();
                                            }
                                            if(subOp == 2){
                                                elCirculo.makeNonAlcoholic();
                                            }
                                            option.reset();
                                            break;
                                            //endregion
                                        case 2:            //region Search Drink
                                            System.out.println("Input the ID to search the Drink: ");

                                            try {
                                                option.reset();
                                                subOp = option.nextInt();
                                                option.reset();

                                                if(elCirculo.searchDrinkbyID(subOp) != null){
                                                    System.out.println(elCirculo.searchDrinkbyID(subOp));
                                                }
                                            }
                                            catch(InputMismatchException e){
                                                cls();
                                                System.out.println("You must enter a number!");
                                                option.reset();
                                            }

                                            option.nextLine();
                                            pressEnterKeyToContinue();
                                            break;
                                            //endregion
                                        case 3:            //region Display all Drinks
                                            elCirculo.displayAllDrinks();
                                            pressEnterKeyToContinue();
                                            break;
                                            //endregion
                                        case 4:            //region Edit Drink Price
                                            elCirculo.displayAllDrinks();
                                            System.out.println("\nInput the ID to search the Drink: ");
                                            Drink auxD=null;

                                            try {
                                                option.reset();
                                                subOp = option.nextInt();
                                                option.reset();
                                                auxD = elCirculo.searchDrinkbyID(subOp);
                                            }
                                            catch(InputMismatchException e){
                                                cls();
                                                System.out.println("You must enter a valid option number!");
                                                option.reset(); option.nextLine();
                                                subOp = 0;
                                            }

                                            if(auxD != null){
                                                cls();
                                                elCirculo.editProductPrice(auxD);
                                                System.out.println("$"+auxD.getPrice());
                                            }
                                            option.nextLine();
                                            pressEnterKeyToContinue();
                                            break;
                                        //endregion
                                        case 5:            //region Add stock to a Drink
                                            elCirculo.displayAllDrinks();
                                            System.out.println("\nInput Drink ID to add Stock: ");

                                            try {
                                                option.reset();
                                                subOp = option.nextInt();
                                                option.reset();
                                            }
                                            catch(InputMismatchException e){
                                                cls();
                                                System.out.println("You must enter a valid option number!");
                                                pressEnterKeyToContinue();
                                                option.reset();
                                            }

                                            Drink auxC = elCirculo.searchDrinkbyID(subOp);

                                            if(auxC != null){
                                                System.out.println("\nIn Stock: " + auxC.getStock() + "\nHow many units you want to add to this Drink?");

                                                try {
                                                    option.reset();
                                                    subOp = option.nextInt();
                                                    option.reset();

                                                    auxC.setStock(auxC.getStock() + subOp);
                                                    System.out.println("\nStock Added!\nIn Stock: " + auxC.getStock());
                                                }
                                                catch(InputMismatchException e){
                                                    cls();
                                                    System.out.println("You must enter a valid option number!");
                                                    pressEnterKeyToContinue();
                                                    option.reset();
                                                }


                                            }
                                            pressEnterKeyToContinue();
                                            break;
                                            //endregion
                                    }
                                    option.reset(); option.nextLine();
                                    cls();
                                }
                                break;
                                //endregion
                            case 2:     //region Food SUBMENU
                                subOp = 0;

                                while (subOp != 9){
                                    subOp = 0;
                                    foodSubMenu();

                                    try {
                                        option.reset();
                                        subOp = option.nextInt();
                                        option.reset();
                                    }
                                    catch(InputMismatchException e){
                                        cls();
                                        System.out.println("You must enter a valid option number!");
                                        pressEnterKeyToContinue();
                                        option.reset();
                                    }

                                    cls();
                                    switch (subOp) {
                                        case 1:           //region New Food
                                            System.out.println("1: With Meat | 2: Without Meat | Other: Cancel");

                                            try {
                                                option.reset();
                                                subOp = option.nextInt();
                                                option.reset();

                                                if(subOp == 1){
                                                    elCirculo.makeFoodWithMeat();
                                                }
                                                if(subOp == 2){
                                                    elCirculo.makeFoodWithoutMeat();
                                                }
                                            }
                                            catch(InputMismatchException e){
                                                cls();
                                                System.out.println("You must enter a valid option number!");
                                                pressEnterKeyToContinue();
                                                option.reset();
                                            }

                                            cls();

                                            option.reset();
                                            break;
                                            //endregion
                                        case 2:           //region Search Food
                                            System.out.println("Input the ID to search the Food: ");

                                            try {
                                                option.reset();
                                                subOp = option.nextInt();
                                                option.reset();

                                                Food aux = elCirculo.searchFoodbyID(subOp);

                                                if(aux != null){
                                                    System.out.println(aux);
                                                }
                                            }
                                            catch(InputMismatchException e){
                                                cls();
                                                System.out.println("You must enter a valid option number!");
                                                option.reset();
                                                subOp = 0;
                                            }
                                            option.nextLine();

                                            pressEnterKeyToContinue();
                                            break;
                                            //endregion
                                        case 3:           //region Display all Food

                                            System.out.println("\nDisplay: 1.All food | 2.Available Food | 3.Not available food | 4.Cancel");

                                            try {
                                                option.reset();
                                                subOp = option.nextInt();
                                                option.reset();
                                            }
                                            catch(InputMismatchException e){
                                                cls();
                                                System.out.println("You must enter a valid option number!");
                                                option.reset();
                                                subOp = 0;
                                            }

                                            switch (subOp){
                                                case 1:
                                                    elCirculo.displayAllFood();
                                                    break;
                                                case 2:
                                                    elCirculo.displayAllFood(true);
                                                    break;
                                                case 3:
                                                    elCirculo.displayAllFood(false);
                                                    break;
                                            }
                                            option.reset(); option.nextLine();
                                            pressEnterKeyToContinue();
                                            break;
                                            //endregion
                                        case 4:           //region Edit Food Price
                                            elCirculo.displayAllFood();
                                            System.out.println("\nInput the ID to search the Food: ");
                                            Food auxF=null;
                                            try {
                                                option.reset();
                                                subOp = option.nextInt();
                                                option.reset();
                                                auxF = elCirculo.searchFoodbyID(subOp);
                                            }
                                            catch(InputMismatchException e){
                                                cls();
                                                System.out.println("You must enter a valid option number!");
                                                option.reset(); option.nextLine();
                                            }

                                            if(auxF != null){
                                                cls();
                                                elCirculo.editProductPrice(auxF);
                                                System.out.println("$"+auxF.getPrice());
                                            }
                                            option.reset();
                                            pressEnterKeyToContinue();
                                            break;
                                        //endregion
                                        case 5:           //region Edit Food Availability
                                            elCirculo.displayAllFood();
                                            System.out.println("\nInput the ID to search the Food: ");
                                            Food auxFo = null;

                                            try {
                                                option.reset();
                                                subOp = option.nextInt();
                                                option.reset();
                                                auxFo = elCirculo.searchFoodbyID(subOp);
                                            }
                                            catch(InputMismatchException e){
                                                cls();
                                                System.out.println("You must enter a valid option number!");
                                                option.reset(); option.nextLine();
                                            }

                                            if(auxFo != null){
                                                cls();
                                                System.out.println(auxFo);
                                                System.out.println("\nSet to: 1.Available | 2.Unavailable | Other.Cancel");

                                                try {
                                                    option.reset();
                                                    subOp = option.nextInt();
                                                    option.reset();
                                                }
                                                catch(InputMismatchException e){
                                                    cls();
                                                    System.out.println("You must enter a valid option number!");
                                                    option.reset(); option.nextLine();
                                                }

                                                if(subOp == 1){
                                                    auxFo.setActive(true);
                                                }
                                                if(subOp == 2){
                                                    auxFo.setActive(false);
                                                }
                                                System.out.println(auxFo.isActive());
                                            }
                                            option.reset();
                                            pressEnterKeyToContinue();
                                            break;
                                        //endregion
                                    }
                                    option.reset();option.nextLine();
                                    cls();
                                }
                                break;
                                //endregion
                            case 3:     //region Premium Prices Menu
                                subOp = 0;
                                System.out.println("Drink menu!: ");
                                for (Drink eachDrink: elCirculo.getDrinks()) {
                                    if(eachDrink instanceof NonAlcoholic){
                                        System.out.println(eachDrink);
                                        System.out.println("----------------------\nPrice with Premium Discount!: $" + ((NonAlcoholic) eachDrink).priceWithDiscount());
                                    }
                                }
                                System.out.println("\nFood menu!: ");
                                for (Food eachFood: elCirculo.getFoods()) {
                                    if(eachFood instanceof WithoutMeat){
                                        System.out.println(eachFood);
                                        System.out.println("\n----------------------\nPrice with Premium Discount!: $" + ((WithoutMeat) eachFood).priceWithDiscount());
                                    }
                                }

                                pressEnterKeyToContinue();
                                option.reset(); option.nextLine();
                                cls();
                                break;
                                //endregion

                        }
                        option.reset();
                    }
                    break;
                    //endregion
                case 4:                   //region ORDERS SUBMENU
                    subOp = 0;

                    while (subOp != 9){
                        subOp = 0;
                        ordersSubMenu();

                        try {
                            option.reset();
                            subOp = option.nextInt();
                            option.reset();
                        }
                        catch(InputMismatchException e){
                            cls();
                            System.out.println("You must enter a valid option number!");
                            pressEnterKeyToContinue();
                            option.reset();
                        }

                        cls();
                        switch (subOp) {
                            case 1:                //region New Order
                                elCirculo.makeOrder();
                                option.reset();
                                pressEnterKeyToContinue();
                                break;
                                //endregion
                            case 2:                //region Search Order
                                System.out.println("Input the Order ID to search for it: ");

                                try{
                                    Order aux = elCirculo.searchOrderbyOrderID(option.nextInt());

                                    if(aux != null){
                                        System.out.println(aux);
                                    }
                                } catch(InputMismatchException e){
                                    cls();
                                    System.out.println("You must enter a valid option number!");
                                    option.reset();
                                }

                                pressEnterKeyToContinue();
                                option.reset(); option.nextLine();
                                break;
                            //endregion
                            case 3:                //region Display Orders
                                subOp = 0;

                                while (subOp != 9){
                                    subOp = 0;
                                    displayOrdersSubMenu();

                                    try {
                                        option.reset();
                                        subOp = option.nextInt();
                                        option.reset();
                                    }
                                    catch(InputMismatchException e){
                                        cls();
                                        System.out.println("You must enter a valid option number!");
                                        pressEnterKeyToContinue();
                                        option.reset();
                                    }

                                    cls();
                                    switch (subOp) {
                                        case 1:            //region Display all Orders
                                            elCirculo.displayAllOrders();
                                            pressEnterKeyToContinue();
                                            break;
                                        //endregion
                                        case 2:            //region Display Orders by Client
                                            elCirculo.displayAllClients();
                                            System.out.println("\nInput the Client´s phone to search for it: ");
                                            Client auxC = elCirculo.searchClientByPhone(option.next());
                                            option.reset();

                                            if(auxC != null){
                                                elCirculo.displayAllOrders(auxC);
                                            }

                                            pressEnterKeyToContinue();
                                            break;
                                        //endregion
                                        case 3:            //region Display Orders by Date
                                            System.out.println("\nInput the Date to filter (d/MM/yyyy): ");

                                            try {
                                                elCirculo.displayAllOrders(option.next());
                                                option.reset();
                                            }
                                            catch(DateTimeParseException e){
                                                System.out.println("Wrong Format!");
                                            }

                                            pressEnterKeyToContinue();
                                            break;
                                        //endregion
                                        case 4:            //region Display today Orders
                                            elCirculo.displayTodayOrders();
                                            pressEnterKeyToContinue();
                                            break;
                                        //endregion
                                    }
                                    option.reset();
                                    cls();
                                }
                                break;
                            //endregion
                        }
                        option.reset();option.nextLine();
                        cls();
                    }
                    break;
                    //endregion
            }
            option.reset();
            cls();
        }
        //Save data to file
        System.out.println("\033[1;92m");
        elCirculo.saveProductsData();
        elCirculo.savePersonsData();
        elCirculo.saveOrdersData();

        System.out.println("\n\n\n\t\t\t\t< -- See you later! :) -- >\n\n\n" +
                           "----------------------------------------------------------------------------------");
        //endregion
    }

    //region Menu
    public static void menu(){
        System.out.println("\nWelcome to the TakeAway System!" +
                "\n\n1_ Clients management" +
                "\n2_ Employees management" +
                "\n3_ Products management" +
                "\n4_ Orders management" +
                "\n\n9_ Exit Program");
    }

    public static void clientSubMenu(){
        cls();
        System.out.println(
                "\nClients management" +
                "\n\n1_ New Client" +
                "\n2_ Search Client" +
                "\n3_ Display Clients" +
                "\n4_ Edit Client Data" +
                "\n5_ Edit Client Status" +
                "\n\n9_ Go Back");

    }

    public static void employeeSubMenu(){
        cls();
        System.out.println(
                "\nEmployees management" +
                        "\n\n1_ New Employee" +
                        "\n2_ Search Employee" +
                        "\n3_ Display Employee" +
                        "\n4_ Edit Employee Data" +
                        "\n5_ Edit Employee Status" +
                        "\n\n9_ Go Back");

    }

    public static void productsSubMenu(){
        cls();
        System.out.println(
                "\nProducts management" +
                        "\n\n1_ Drinks" +
                        "\n2_ Food" +
                        "\n3_ Premium Prices Menu" +
                        "\n\n9_ Go Back");

    }

    public static void drinksSubMenu(){
        cls();
        System.out.println(
                "\nDrinks" +
                        "\n\n1_ New Drink" +
                        "\n2_ Search Drink" +
                        "\n3_ Display Drinks" +
                        "\n4_ Edit Drink Price" +
                        "\n5_ Add more stock" +
                        "\n\n9_ Go Back");
    }

    public static void foodSubMenu(){
        cls();
        System.out.println(
                "\nFood" +
                        "\n\n1_ New Food" +
                        "\n2_ Search Food" +
                        "\n3_ Display Food" +
                        "\n4_ Edit Food Price" +
                        "\n5_ Edit Food Availability" +
                        "\n\n9_ Go Back");
    }

    public static void ordersSubMenu(){
        cls();
        System.out.println(
                "\nOrders" +
                        "\n\n1_ New Order" +
                        "\n2_ Search Order" +
                        "\n3_ Display Orders" +
                        "\n\n9_ Go Back");
    }

    public static void displayOrdersSubMenu(){
        cls();
        System.out.println(
                "\nDisplay Orders" +
                        "\n\n1_ Display All" +
                        "\n2_ Display by Client" +
                        "\n3_ Display by Date" +
                        "\n4_ Display today Orders" +
                        "\n\n9_ Go Back");
    }

    //endregion

    private static void pressEnterKeyToContinue(){
        System.out.println("\nPress Enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

    public static void cls()
    {
        for (int i = 0; i < 50; ++i) System.out.println();
    }

}
