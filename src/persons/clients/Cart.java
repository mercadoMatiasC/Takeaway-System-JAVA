package persons.clients;

import products.Product;
import products.drinks.Alcoholic;
import products.drinks.Drink;
import products.drinks.NonAlcoholic;
import products.food.Food;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable{
    private static final long serialVersionUID = 8799656478674716638L;

    private List<Drink> drinkCart = new ArrayList<>();
    private List<Integer> drinkAmount = new ArrayList<>();
    private List<Food> foodCart = new ArrayList<>();
    private List<Integer> foodAmount = new ArrayList<>();

    public Cart() {
    }

    //region GET/SET

    public List<Drink> getDrinkCart() {
        return drinkCart;
    }

    public void setDrinkCart(List<Drink> drinkCart) {
        this.drinkCart = drinkCart;
    }

    public List<Integer> getDrinkAmount() {
        return drinkAmount;
    }

    public void setDrinkAmount(List<Integer> drinkAmount) {
        this.drinkAmount = drinkAmount;
    }

    public List<Food> getFoodCart() {
        return foodCart;
    }

    public void setFoodCart(List<Food> foodCart) {
        this.foodCart = foodCart;
    }

    public List<Integer> getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(List<Integer> foodAmount) {
        this.foodAmount = foodAmount;
    }

    //endregion

    //--- GENERICIDAD ---
    public <T extends Product> void addToCart(T o, int amount) {
        if(o != null){
            if (o instanceof Drink) {
                Drink aux = (Drink) o;
                if (aux.getStock() >= amount) {
                    aux.setStock(aux.getStock() - amount);
                    drinkCart.add(aux);
                    drinkAmount.add(amount);
                }
                else{
                    System.out.println("Not enough stock of: " + aux.getStock() + " left!");
                }
            }
            else{
                Food aux = (Food) o;
                foodCart.add(aux);
                foodAmount.add(amount);
            }
        }
        else
            System.out.println("The product doesn't exist!");
    }

    public float calculateTotal(){
        float total = 0;

        for (Integer i=0; i < drinkCart.size(); i++) {
            total += drinkCart.get(i).getPrice() * drinkAmount.get(i);
        }

        for (Integer i=0; i < foodCart.size(); i++) {
            total += foodCart.get(i).getPrice() * foodAmount.get(i);
        }
        return total;
    }

    public void displayCart(){
        System.out.println("---------------------------------------------------------------");
        for (Integer i=0; i < drinkCart.size(); i++) {
            System.out.println(drinkAmount.get(i) + ": " + drinkCart.get(i).getBrand() +
                    " " + drinkCart.get(i).getSize() + "L " + drinkCart.get(i).getPrice() + " -$");
        }
        for (Integer i=0; i < foodCart.size(); i++) {
            System.out.println(foodAmount.get(i) + ": " + foodCart.get(i).getName() +
                    ": " + foodCart.get(i).getDescription() + " " + foodCart.get(i).getPrice() + " -$");
        }
        System.out.println("\t\t\t\t\t\t<--  CART  -->");
    }

    @Override
    public String toString() {
        displayCart();
        return  "\n-------------------" +
                "\nTOTAL: " + calculateTotal() + "$";
    }
}
