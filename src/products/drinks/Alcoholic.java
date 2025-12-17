package products.drinks;


public class Alcoholic extends Drink {

    private typeAlcoholic type;
    private float alcoholicStrength;

    public Alcoholic(){
        super.newID();
    };

    public Alcoholic(String brand, int stock, float price, float size, String bottling, boolean fizz, String flavor, typeAlcoholic type, float strength){
        super.newID();
        super.setBrand(brand);
        super.setStock(stock);
        super.setPrice(price);
        super.setSize(size);
        super.setBottling(bottling);
        super.setFizz(fizz);
        super.setFlavor(flavor);

        this.type = type;
        this.alcoholicStrength = strength;
    };

    //region GET/SET
    public typeAlcoholic getType() {
        return type;
    }

    public void setType(typeAlcoholic type) {
        this.type = type;
    }

    public float getAlcoholicStrength() {
        return alcoholicStrength;
    }

    public void setAlcoholicStrength(float alcoholicStrength) {
        this.alcoholicStrength = alcoholicStrength;
    }

    //endregion

    @Override
    public String toString(){
        return super.toString() +
                "\nType: " + this.getType() +
                "\nStrength: " + this.getAlcoholicStrength() + "%";
    };


}
