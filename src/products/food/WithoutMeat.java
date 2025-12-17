package products.food;
import products.premiumDiscount;

public class WithoutMeat extends Food implements premiumDiscount {

    private String preparation;

    public WithoutMeat() {
        super.newID();
    }

    public WithoutMeat(String name, float price, String description, int numberPeopleRecommended, String preparation) {
        super.newID();
        this.preparation = preparation;
        super.setName(name);
        super.setPrice(price);
        super.setDescription(description);
        super.setNumberPeopleRecommended(numberPeopleRecommended);
    }

    //region GET/SET
    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }
    //endregion

    @Override
    public float priceWithDiscount() {
        return super.getPrice() - ((super.getPrice() * percent) / 100);
    }

    @Override
    public String toString() {
        return super.toString() + "\nPreparation: " + preparation;
    };
}


