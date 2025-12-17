import com.google.gson.Gson;
import persons.Person;
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

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TakeAway {
    static Scanner scanner = new Scanner(System.in);
    private List<Person> persons = new ArrayList<>();
    private List<Food> foods = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public TakeAway() {
    }

    public TakeAway(List<Person> persons, List<Food> foods, List<Drink> drinks, List<Order> orders) {
        this.persons = persons;
        this.foods = foods;
        this.drinks = drinks;
        this.orders = orders;
    }

    //region GET/SET
    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    //endregion+

    //region "Make" Methods so the instances have a control before made

    public Client makeClient() {
        System.out.println("Making a Client!\n");

        Client aux = new Client();

        try{
        scanner.reset();
        System.out.println("Name: ");
        aux.setName(scanner.nextLine());
        scanner.reset();

        System.out.println("Phone: ");
        aux.setPhone(scanner.next());
        scanner.nextLine();
        scanner.reset();

        System.out.println("Email: ");
        aux.setEmail(scanner.nextLine());
        scanner.reset();

        System.out.println("Address: ");
        aux.setAddress(scanner.next());
        scanner.reset();
        scanner.nextLine();

        for (Person eachClient : persons) {
            if (eachClient.equals(aux)) {
                System.out.println("\nThat client is already signed!");
                aux = null;
            }
        }

        addPersonToStore(aux);
        }
        catch(InputMismatchException e){
            cls();
            System.out.println("You must enter a valid option number!");
            scanner.reset();  scanner.nextLine();
        }

        return aux;
    }

    public Employee makeEmployee() {
        System.out.println("Making an Employee!\n");

        Employee aux = new Employee();

        try{
        scanner.reset();
        System.out.println("Name: ");
        aux.setName(scanner.nextLine());
        scanner.reset();

        System.out.println("Phone: ");
        aux.setPhone(scanner.next());
        scanner.nextLine();
        scanner.reset();

        System.out.println("Email: ");
        aux.setEmail(scanner.nextLine());
        scanner.reset();

        System.out.println("Address: ");
        aux.setAddress(scanner.nextLine());
        scanner.reset();

        System.out.println("Input employee area: \n1.Delivery\n2.Inventory\n3.Kitchen\n4.Manager\n5.Call Operator");
        scanner.reset();
        int a;
        do {
            a = scanner.nextInt();
            switch (a) {
                case 1:
                    aux.setArea(typeEmployeeArea.Delivery);
                    break;
                case 2:
                    aux.setArea(typeEmployeeArea.Inventory);
                    break;
                case 3:
                    aux.setArea(typeEmployeeArea.Kitchen);
                    break;
                case 4:
                    aux.setArea(typeEmployeeArea.Manager);
                    break;
                case 5:
                    aux.setArea(typeEmployeeArea.Call_operator);
                    break;
                default:
                    System.out.println("Invalid input. Insert a correct input.");
                    break;
            }
        } while (a < 1 || a > 5);


        for (Person eachEmployee : persons) {
            if (eachEmployee.equals(aux)) {
                System.out.println("\nThat employee is already signed!");
                aux = null;
            }
        }

        addPersonToStore(aux);
        }
        catch(InputMismatchException e){
            cls();
            System.out.println("You must enter a valid option number!");
            scanner.reset();  scanner.nextLine();
        }

        return aux;
    }

    public WithMeat makeFoodWithMeat() {
        System.out.println("Making a Food with meat!\n");

        WithMeat aux = new WithMeat();

        try{
            scanner.reset();
            System.out.println("Name: ");
            aux.setName(scanner.nextLine());
            scanner.reset();

            System.out.println("Price: ");
            aux.setPrice(scanner.nextFloat());
            scanner.nextLine();
            scanner.reset();

            System.out.println("Description: ");
            aux.setDescription(scanner.nextLine());
            scanner.reset();

            System.out.println("Number of people recommended per dish: ");
            aux.setNumberPeopleRecommended(scanner.nextInt());
            scanner.nextLine();
            scanner.reset();

            System.out.println("Type of meat: \n1.Beef\n2.Fish\n3.Pork\n4.Chicken\n5.Other");
            scanner.reset();
            int a;
            do {
                a = scanner.nextInt();
                switch (a) {
                    case 1:
                        aux.setMeatType(typeMeat.Beef);
                        break;
                    case 2:
                        aux.setMeatType(typeMeat.Fish);
                        break;
                    case 3:
                        aux.setMeatType(typeMeat.Pork);
                        break;
                    case 4:
                        aux.setMeatType(typeMeat.Chicken);
                        break;
                    case 5:
                        aux.setMeatType(typeMeat.Other);
                        break;
                    default:
                        System.out.println("Invalid input. Insert a correct input.");
                        break;
                }
            } while (a < 1 || a > 6);
            scanner.reset();
            scanner.nextLine();

        addFoodtoStore(aux);
        }
        catch(InputMismatchException e){
            cls();
            System.out.println("You must enter a valid option number!");
            scanner.reset();  scanner.nextLine();
        }

        return aux;
    }

    public WithoutMeat makeFoodWithoutMeat() {
        System.out.println("Making a Food without meat!\n");
        scanner.reset();

        WithoutMeat aux = new WithoutMeat();

        try{
            System.out.println("Name: ");
            aux.setName(scanner.nextLine());
            scanner.reset();

            System.out.println("Input price: ");
            aux.setPrice(scanner.nextFloat());
            scanner.nextLine();
            scanner.reset();

            System.out.println("Description: ");
            aux.setDescription(scanner.nextLine());
            scanner.reset();

            System.out.println("Number of people recommended per dish: ");
            aux.setNumberPeopleRecommended(scanner.nextInt());
            scanner.nextLine();
            scanner.reset();

            System.out.println("Preparation: ");
            aux.setPreparation(scanner.nextLine());
            scanner.reset();

        addFoodtoStore(aux);
        }
        catch(InputMismatchException e){
            cls();
            System.out.println("You must enter a valid option number!");
            scanner.reset();  scanner.nextLine();
        }

        return aux;
    }

    public Alcoholic makeAlcoholic() {
        System.out.println("Making an alcoholic Drink!\n");

        Alcoholic aux = new Alcoholic();

        try{
            scanner.reset();
            System.out.println("Brand: ");
            aux.setBrand(scanner.nextLine());
            scanner.reset();

            System.out.println("In stock: ");
            aux.setStock(scanner.nextInt());
            scanner.nextLine();
            scanner.reset();

            System.out.println("Price: ");
            aux.setPrice(scanner.nextFloat());
            scanner.nextLine();
            scanner.reset();

            System.out.println("Size: ");
            aux.setSize(scanner.nextFloat());
            scanner.nextLine();
            scanner.reset();

            System.out.println("Type of bottling: ");
            aux.setBottling(scanner.nextLine());
            scanner.reset();

            System.out.println("Contain fizz?:\n1.True \n2.False");
            scanner.reset();
            int optionFizz;
            do {
                optionFizz = scanner.nextInt();
                switch (optionFizz) {
                    case 1:
                        aux.setFizz(true);
                        break;
                    case 2:
                        aux.setFizz(false);
                        break;

                    default:
                        System.out.println("Invalid input. Insert a correct input.");
                        break;
                }
            } while (optionFizz < 1 || optionFizz > 2);

            scanner.reset();
            scanner.nextLine();
            System.out.println("Flavor: ");
            aux.setFlavor(scanner.nextLine());
            scanner.reset();

            System.out.println("Type of alcoholic drink:\n1.Beer\n2.Wine\n3.Champagne\n4.Liqueur\n5.Other");
            scanner.reset();
            int typeAlcoholic;
            do {
                typeAlcoholic = scanner.nextInt();

                switch (typeAlcoholic) {
                    case 1:
                        aux.setType(products.drinks.typeAlcoholic.Beer);
                        break;
                    case 2:
                        aux.setType(products.drinks.typeAlcoholic.Wine);
                        break;
                    case 3:
                        aux.setType(products.drinks.typeAlcoholic.Champagne);
                        break;
                    case 4:
                        aux.setType(products.drinks.typeAlcoholic.Liqueur);
                        break;
                    case 5:
                        aux.setType(products.drinks.typeAlcoholic.Other);
                        break;

                    default:
                        System.out.println("Invalid input. Insert a correct input.");
                        break;
                }
            } while (typeAlcoholic < 1 || typeAlcoholic > 5);

            scanner.reset();
            scanner.nextLine();

            System.out.println("Alcoholic strength (in %): ");
            aux.setAlcoholicStrength(scanner.nextFloat());
            scanner.reset();

            for (Drink eachDrink : drinks) {
                if (eachDrink.equals(aux)) {
                    System.out.println("\nThat drink is already added!");
                    aux = null;
                }
            }

            scanner.reset();
            scanner.nextLine();

            addDrinkToStore(aux);
        }
        catch(InputMismatchException e){
            cls();
            System.out.println("You must enter a valid option number!");
            scanner.reset();  scanner.nextLine();
        }
        return aux;
    }

    public NonAlcoholic makeNonAlcoholic() {
        System.out.println("Making a non alcoholic Drink!\n");
        scanner.reset();

        NonAlcoholic aux = new NonAlcoholic();

        try{
            scanner.reset();
            System.out.println("Brand: ");
            aux.setBrand(scanner.nextLine());
            scanner.reset();

            System.out.println("In stock: ");
            aux.setStock(scanner.nextInt());
            scanner.nextLine();
            scanner.reset();

            System.out.println("Price: ");
            aux.setPrice(scanner.nextFloat());
            scanner.nextLine();
            scanner.reset();

            System.out.println("Size: ");
            aux.setSize(scanner.nextFloat());
            scanner.nextLine();
            scanner.reset();

            System.out.println("Type of bottling: ");
            aux.setBottling(scanner.nextLine());
            scanner.reset();

            System.out.println("Contain fizz?:\n1.True \n2.False");
            scanner.reset();
            int optionFizz;
            do {
                optionFizz = scanner.nextInt();
                switch (optionFizz) {
                    case 1:
                        aux.setFizz(true);
                        break;
                    case 2:
                        aux.setFizz(false);
                        break;

                    default:
                        System.out.println("Invalid input. Insert a correct input.");
                        break;
                }
            } while (optionFizz < 1 || optionFizz > 2);

            scanner.reset();
            scanner.nextLine();
            System.out.println("Flavor: ");
            aux.setFlavor(scanner.nextLine());
            scanner.reset();

            System.out.println("Type of drink:\n1.Water\n2.Juice\n3.Soda\n4.Flavored Water\n5.Other");
            scanner.reset();
            int typeAlcoholic;
            do {
                typeAlcoholic = scanner.nextInt();
                switch (typeAlcoholic) {
                    case 1:
                        aux.setType(typeNonAlcoholic.Water);
                        break;
                    case 2:
                        aux.setType(typeNonAlcoholic.Juice);
                        break;
                    case 3:
                        aux.setType(typeNonAlcoholic.Soda);
                        break;
                    case 4:
                        aux.setType(typeNonAlcoholic.Flavored_Water);
                        break;
                    case 5:
                        aux.setType(products.drinks.typeNonAlcoholic.Other);
                        break;
                    default:
                        System.out.println("Invalid input. Insert a correct input.");
                        break;
                }
            } while (typeAlcoholic < 1 || typeAlcoholic > 5);


        scanner.reset(); scanner.nextLine();
        for (Drink eachDrink : drinks) {
            if (eachDrink.equals(aux)) {
                System.out.println("\nThat drink is already added!");
                aux = null;
            }
        }

        addDrinkToStore(aux);
        }
        catch(InputMismatchException e){
            cls();
            System.out.println("You must enter a valid option number!");
            scanner.reset();  scanner.nextLine();
        }

        return aux;
    }

    public Order makeOrder() {
        System.out.println("Making New Order!\n");
        Order aux = new Order();
        Client auxClient = new Client();
        Cart auxCart = new Cart();

        Scanner scanner = new Scanner(System.in);
        String op = "";

        while(!op.equals("Cancel")) {

            displayAllClients();
            System.out.println("\nInput the Client´s phone to search for it: ");
            auxClient = searchClientByPhone(scanner.next()); scanner.reset();

            //"While" statement to find the Client to add to the Order
            while(auxClient == null && !op.equals("Cancel")) {

                System.out.println("Continue? Write: 'Cancel' if no, Anything else if you continue");
                op = scanner.next(); scanner.reset();

                if(!op.equals("Cancel")){
                    displayAllClients();
                    System.out.println("\nInput the Client´s phone to search for it: ");
                    auxClient = searchClientByPhone(scanner.next()); scanner.reset();
                }
                else
                    aux = null;
            }

            //"do While" statement to fill the Cart
            if(!op.equals("Cancel")) {
                do {
                    aux.setClient(auxClient);
                    int auxID;
                    int auxAmount;

                    //Add Food
                    do {
                        displayAllFood(true);

                        try {
                            System.out.println("\nChoose the food writing the ID: ");
                            auxID = scanner.nextInt();
                            scanner.reset();

                            System.out.println("\nHow many units of this dish you want?: ");
                            auxAmount = scanner.nextInt();
                            scanner.reset();

                            if (searchFoodbyID(auxID).isActive() == true)
                                auxCart.addToCart(searchFoodbyID(auxID), auxAmount);
                            else
                                System.out.println("\nFood not available!");

                            System.out.println(auxCart);
                        }
                        catch(InputMismatchException e){
                            cls();
                            System.out.println("You must enter a valid option number!");
                            scanner.reset();  scanner.nextLine();
                        }

                        do {
                            System.out.println("\nAdd more food? Input 1:yes | 2:no");
                            op = scanner.next();
                            scanner.reset();
                        }while(!op.equals("1") && !op.equals("2"));

                        cls();
                    }while(!op.equals("2"));

                    //Add Drinks
                    do {
                        displayAllDrinks();

                        try {
                            System.out.println("\nChoose the drink writing the ID: ");
                            auxID = scanner.nextInt();
                            scanner.reset();

                            System.out.println("\nHow many units of this drink you want?: ");
                            auxAmount = scanner.nextInt();
                            scanner.reset();

                            cls();
                            auxCart.addToCart(searchDrinkbyID(auxID), auxAmount);

                            System.out.println(auxCart);
                        }
                        catch(InputMismatchException e){
                            cls();
                            System.out.println("You must enter a valid option number!");
                            scanner.reset();  scanner.nextLine();
                        }

                        do {
                            System.out.println("\nAdd more drink? Input 1:yes | 2:no");
                            op = scanner.next();
                            scanner.reset();
                        }while(!op.equals("1") && !op.equals("2"));

                        cls();

                    }while(!op.equals("2"));

                } while (aux == null);
            }

            //"While" statement to confirm Cart and Client
            while(!op.equals("Cancel")){

                //Set the auxCart to the final Cart
                aux.setCart(auxCart);

                //Set actual date to the Order
                aux.setDate(LocalDate.now());

                if(aux.getCart().calculateTotal() < 1){
                    aux = null;
                }
                op = "Cancel";
            }
        }
        int confirm = 2;
        do{
            System.out.println("\nConfirm order?: 1.yes | 2.no");
            try {
                scanner.reset();
                confirm = scanner.nextInt();
                scanner.reset();
            }
            catch(InputMismatchException e){
                cls();
                System.out.println("You must enter a valid option number!");
                scanner.reset(); scanner.nextLine();
            }
        }while(confirm < 1 && confirm > 2);

        if(confirm == 1){
            //Set +1 to the Client order´s amount
            auxClient.setOrdersAmount(auxClient.getOrdersAmount() + 1);
            if(auxClient.getOrdersAmount() == 10){
                auxClient.setPremium(true);
                System.out.println("This client is now PREMIUM!:\nNow there will be a 10% discount to the Food without Meat and the Drinks without alcohol!");
            }
            addOrderToStore(aux);
            System.out.println("\nOrder made!");
        }
        else{
            aux = null;
            System.out.println("\nOrder Cancelled!");
        }


        return aux;
    }

    //endregion

    //region "Add" Methods to add the created instances to the takeAway

    public void addPersonToStore(Person person) {
        if (person != null) {
            persons.add(person);
        }
    }

    public void addFoodtoStore(Food food) {
        if (food != null) {
            foods.add(food);
        }
    }

    public void addDrinkToStore(Drink drink) {
        if (drink != null) {
            drinks.add(drink);
        }
    }

    public void addOrderToStore(Order order){
        if (order != null) {
            orders.add(order);
        }
    }

    //endregion

    //region "Search" Methods to search for the instances using a particular attribute of each Class

    public Client searchClientByPhone(String phone){
        for (Person eachPerson : persons) {
            if (eachPerson instanceof Client) {
                if (eachPerson.getPhone().equals(phone)) {
                    Client aux = (Client) eachPerson;
                    return aux;
                }
            }
        }

        System.out.println("Client not found!");
        return null;
    }

    public Employee searchEmployeeByPhone(String phone){
        for (Person eachPerson : persons) {
            if (eachPerson instanceof Employee) {
                if (eachPerson.getPhone().equals(phone)) {
                    return (Employee) eachPerson;
                }
            }
        }

        System.out.println("Employee not found!");
        return null;
    }

    public Food searchFoodbyID(int ID){
        for (Food eachFood : foods){
            if(eachFood.getProductID() == ID){
                return eachFood;
            }
        }
        System.out.println("Food not found!");
        return null;
    }

    public Drink searchDrinkbyID(int ID){
        for (Drink eachDrink : drinks){
            if(eachDrink.getProductID() == ID){
                return eachDrink;
            }
        }
        System.out.println("Drink not found");
        return null;
    }

    public Order searchOrderbyOrderID(int orderID){
        for (Order eachOrder : orders){
            if(eachOrder.getId() == orderID){
                return eachOrder;
            }
        }
        System.out.println("Orders not found");
        return null;
    }

    //endregion

    //region "Display" Methods to show all the instances in the system

    public void displayAllClients(){
        System.out.println("Displaying Clients...");
        for (Person eachPerson : persons){
            if(eachPerson instanceof Client){
                System.out.println((Client)eachPerson);
            }
        }
    }

    public void displayAllEmployees(){
        System.out.println("Displaying Employees...");
        for(Person eachPerson : persons){
            if(eachPerson instanceof Employee){
                System.out.println((Employee)eachPerson);
            }
        }
    }

    public void displayAllFood(){
        System.out.println("Displaying Food Menu...\n");
        for(Food eachFood : foods){
                System.out.println(eachFood);
        }
    }

    public void displayAllFood(boolean available){
        System.out.println("Displaying Food Menu... If : " + available);

        for(Food eachFood : foods){
            if(eachFood.isActive() == available)
                System.out.println(eachFood);
        }
    }

    public void displayAllDrinks(){
        System.out.println("Displaying Drinks menu...");
        for(Drink eachDrink : drinks){
                System.out.println(eachDrink);
        }
    }

    //Polymorphism
    public void displayAllOrders(){
        int count = 0;
        for (Order eachOrder : orders){
            System.out.println(eachOrder);
            count++;
        }
        if(count == 0)
            System.out.println("Orders not found");
    }

    public void displayAllOrders(Client client){
        int count = 0;
        for (Order eachOrder : orders){
            if(eachOrder.getClient() == client){
                System.out.println(eachOrder);
                count++;
            }
        }
        if(count == 0)
            System.out.println("Orders not found");
    }

    public void displayAllOrders(String date){
        LocalDate fecha1 = LocalDate.parse(date, DateTimeFormatter.ofPattern("d/MM/yyyy"));

        int count = 0;
        for (Order eachOrder : orders){
            if(eachOrder.getDate().equals(fecha1)){
                System.out.println(eachOrder);
                count++;
            }
        }
        if(count == 0)
            System.out.println("There were no orders that day!");
    }

    public void displayTodayOrders(){
        int count = 0;
        System.out.println("Today orders!\n");

        for(Order eachOrder : orders){
            if(eachOrder.getDate().equals(LocalDate.now())){
                System.out.println("\n" + eachOrder);
                count += 1;
            }
        }
        if(count == 0){
            System.out.println("There were no orders today!");
        }
    }

    //endregion

    //region "Edit" Methods to edit each instance in the system
    public void editClient(Client aux) {
        int op = 0;
        System.out.println("\nWhat do you want to edit? 1. Name 2. Phone 3. Email 4. Address");
        scanner.reset();
        try{
        do {
            op = scanner.nextInt(); scanner.reset(); scanner.nextLine();
            switch (op) {
                case 1:
                    System.out.println("Input new name: ");
                    aux.setName(scanner.nextLine());
                    scanner.reset();
                    break;
                case 2:
                    System.out.println("Input new phone: ");
                    aux.setPhone(scanner.next());
                    scanner.nextLine();
                    scanner.reset();
                    break;
                case 3:
                    System.out.println("Input new email: ");
                    aux.setEmail(scanner.nextLine());
                    scanner.reset();
                    break;
                case 4:
                    System.out.println("Input new address: ");
                    aux.setAddress(scanner.nextLine());
                    scanner.reset(); scanner.nextLine();
                    break;
                default:
                    System.out.println("Insert a valid number!");
            }
        } while (op < 1 || op > 4);
        }
        catch(InputMismatchException e){
            cls();
            System.out.println("You must enter a valid option number!");
            scanner.reset(); scanner.nextLine();
        }
    }
    public void editEmployee(Employee aux) {
        int op = 0;
        System.out.println("\nWhat do you want to edit? 1.Name 2.Phone 3.Email 4.Address");
        try {
            scanner.reset();
            op = scanner.nextInt();
            scanner.reset();
        }
        catch(InputMismatchException e){
            cls();
            System.out.println("You must enter a valid option number!");
            scanner.reset(); scanner.nextLine();
        }
        switch (op) {
            case 1:
                System.out.println("Input new name: ");
                aux.setName(scanner.nextLine());
                scanner.reset();
                break;
            case 2:
                System.out.println("Input new phone: ");
                aux.setPhone(scanner.next());
                scanner.nextLine();
                scanner.reset();
                break;
            case 3:
                System.out.println("Input new email: ");
                aux.setEmail(scanner.nextLine());
                scanner.reset();
                break;
            case 4:
                System.out.println("Input new address: ");
                aux.setAddress(scanner.next());
                scanner.reset(); scanner.nextLine();
                break;
        }
    }
    public void editProductPrice(Product product){

        System.out.println("\nStock price: $" + product.getPrice() + "\nInput new price: ");
        try {
            product.setPrice(scanner.nextFloat());
            scanner.reset();
        }
        catch(InputMismatchException e){
            cls();
            System.out.println("You must enter a valid option number!");
            scanner.reset();  scanner.nextLine();
        }
    }
    //endregion

    //region Files management
    //Save data..
    public void saveProductsData(){

        //Saving drinks data to File
        try{
            File auxSerial = new File("src\\data\\drinksData.Json");
            ObjectOutputStream objOutputStream = new ObjectOutputStream(new FileOutputStream(auxSerial));

            for (Drink eachDrink : drinks)
                objOutputStream.writeObject(eachDrink);

            objOutputStream.close();

            System.out.println("\nSuccessfully saved Drinks Data to File!..");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        //Saving food data to File
        try{
            File auxSerial = new File("src\\data\\foodData.Json");
            ObjectOutputStream objOutputStream = new ObjectOutputStream(new FileOutputStream(auxSerial));

            for (Food eachFood : foods)
                objOutputStream.writeObject(eachFood);

            objOutputStream.close();

            System.out.println("Successfully saved Foods Data to File!..");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void savePersonsData(){
        //Saving person data to File
        try{
            File auxSerial = new File("src\\data\\personsData.Json");
            ObjectOutputStream objOutputStream = new ObjectOutputStream(new FileOutputStream(auxSerial));

            for (Person eachPerson : persons)
                objOutputStream.writeObject(eachPerson);

            objOutputStream.close();

            System.out.println("Successfully saved persons Data to File!..");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void saveOrdersData(){
        //Saving Order data to File
        try{
            File auxSerial = new File("src\\data\\ordersData.Json");
            ObjectOutputStream objOutputStream = new ObjectOutputStream(new FileOutputStream(auxSerial));

            for (Order eachOrder : orders)
                objOutputStream.writeObject(eachOrder);

            objOutputStream.close();

            System.out.println("Successfully saved orders Data to File!..");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //Load data..
    public void loadProductsData() {
        //Loading drinks from File
        File auxSerial = new File("src\\data\\drinksData.Json");

        if (!(auxSerial).exists()) {
            System.out.println("\nNo drinks data found!\n");
            return;
        }

        try{
            ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream(auxSerial));

            Object aux = objInputStream.readObject();

            drinks.clear();

            while (aux != null){
                if (aux instanceof Drink) {
                    Drink auxD = (Drink) aux;
                    ((Drink) auxD).newID();
                    addDrinkToStore(auxD);
                }
                aux = objInputStream.readObject();
            }

        }
        catch (IOException e){
            if(e.getMessage() != null)
                System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println("An error has occurred!");
        }
        finally {
            System.out.println("\nSuccessfully loaded Drinks Data from File!...");
        }

        //Loading food from Files
        auxSerial = new File("src\\data\\foodData.Json");

        if (!(auxSerial).exists()) {
            System.out.println("\nNo food data found!\n");
            return;
        }

        try{
            ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream(auxSerial));

            Object aux = objInputStream.readObject();

            foods.clear();

            while (aux != null){
                if (aux instanceof Food) {
                    Food auxF = (Food) aux;
                    auxF.newID();
                    addFoodtoStore(auxF);
                }
                aux = objInputStream.readObject();
            }

        }
        catch (IOException e){
            if(e.getMessage() != null)
                System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println("An error has occurred!");
        }
        finally {
            System.out.println("Successfully loaded Food Data from File!...");
        }

    }

    public void loadPersonsData(){
        //Loading persons from File
        File auxSerial = new File("src\\data\\personsData.Json");

        if (!(auxSerial).exists()) {
            System.out.println("\nNo persons data found!\n");
            return;
        }

        try{
            ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream(auxSerial));

            Object aux = objInputStream.readObject();

            persons.clear();

            while (aux != null){
                if (aux instanceof Client) {
                    Client auxC = (Client) aux;
                    auxC.newID();
                    addPersonToStore(auxC);
                }
                if (aux instanceof Employee) {
                    Employee auxE = (Employee) aux;
                    auxE.newID();
                    addPersonToStore(auxE);
                }

                aux = objInputStream.readObject();
            }

        }
        catch (IOException e){
            if(e.getMessage() != null)
                System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println("An error has occurred!");
        }
        finally {
            System.out.println("Successfully loaded persons Data from File!...");
        }
    }

    public void loadOrdersData(){
        //Loading orders from File
        File auxSerial = new File("src\\data\\ordersData.Json");

        if (!(auxSerial).exists()) {
            System.out.println("\nNo orders data found!\n");
            return;
        }

        try{
            ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream(auxSerial));

            Object aux = objInputStream.readObject();

            orders.clear();

            while (aux != null){
                Order auxO = new Order();
                auxO = (Order) aux;
                addOrderToStore(auxO);

                aux = objInputStream.readObject();
            }

            System.out.println("Successfully loaded orders Data from File!...");

        }
        catch (IOException e){
            if(e.getMessage() != null)
                System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println("An error has occurred!");
        }
    }

    //endregion

    public static void cls()
    {
        for (int i = 0; i < 50; ++i) System.out.println();
    }

}

