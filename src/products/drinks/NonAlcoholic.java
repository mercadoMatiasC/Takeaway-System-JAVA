package products.drinks;


import products.premiumDiscount;

public class NonAlcoholic extends Drink implements premiumDiscount {

    private typeNonAlcoholic type;

    public NonAlcoholic (){
        super.newID();
    };

    public NonAlcoholic (String brand, int stock, float price, float size, String bottling, boolean fizz, String flavor, typeNonAlcoholic type){
        super.newID();
        super.setBrand(brand);
        super.setStock(stock);
        super.setPrice(price);
        super.setSize(size);
        super.setBottling(bottling);
        super.setFizz(fizz);
        super.setFlavor(flavor);

        this.type = type;
    };

    //region GET/SET

    public typeNonAlcoholic getType() {
        return type;
    }

    public void setType(typeNonAlcoholic type) {
        this.type = type;
    }

    //endregion

    @Override
    public String toString(){
        return super.toString() + "\nType: " + this.getType();
    };

    @Override
    public float priceWithDiscount() {
        return super.getPrice() - ((super.getPrice() * percent) / 100);
    }
}
