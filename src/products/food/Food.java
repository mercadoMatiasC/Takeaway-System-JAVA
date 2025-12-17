package products.food;

import products.Product;

public abstract class Food extends Product {

    private boolean active = true;
    private String name;
    private String description;
    private int numberPeopleRecommended;

    //region GET/SET
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberPeopleRecommended() {
        return numberPeopleRecommended;
    }

    public void setNumberPeopleRecommended(int numberPeopleRecommended) {
        this.numberPeopleRecommended = numberPeopleRecommended;
    }

    //endregion

    @Override
    public String toString (){
        return "\nID: #" + super.getProductID() +
                "\nAvailable: " + this.isActive() +
                "\nName: " + this.name +
                "\nPrice: $" + super.getPrice() +
                "\nDescription: " + this.description +
                "\nThis dish is recommended for: " + this.numberPeopleRecommended + " people";
    };
}
