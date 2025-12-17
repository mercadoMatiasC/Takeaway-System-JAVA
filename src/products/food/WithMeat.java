package products.food;

public class WithMeat extends Food {
    private typeMeat meatType;

    public WithMeat(){
        super.newID();
    };

    public WithMeat (String name, float price, String desc, int numberPeopleRecommended, typeMeat meatType){
        super.newID();
        super.setName(name);
        super.setPrice(price);
        super.setDescription(desc);
        super.setNumberPeopleRecommended(numberPeopleRecommended);
        this.meatType = meatType;
    };

    //region GET/SET
    public typeMeat getMeatType() {
        return meatType;
    }

    public void setMeatType(typeMeat meatType) {
        this.meatType = meatType;
    }

    //endregion

    @Override
    public String toString (){
        return super.toString() + "\nMeat: " + this.meatType;
    };
}
