package products.drinks;

import products.Product;

import java.util.Objects;

public abstract class Drink extends Product {
    private String brand;
    private int stock;
    private float size;
    private String bottling;
    private boolean fizz;
    private String flavor;

    //region GET/SET

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getBottling() {
        return bottling;
    }

    public void setBottling(String bottling) {
        this.bottling = bottling;
    }

    public boolean isFizz() {
        return fizz;
    }

    public void setFizz(boolean fizz) {
        this.fizz = fizz;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return Float.compare(drink.size, size) == 0 && Objects.equals(brand, drink.brand) && Objects.equals(bottling, drink.bottling) && Objects.equals(flavor, drink.flavor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, size, bottling, flavor);
    }

    @Override
    public String toString() {
        return  "\nID: #" + super.getProductID() +
                "\nBrand: " + brand  + " " + flavor +
                "\nIn stock: " + stock + ", price: $" + super.getPrice() +
                "\nBottling: " + bottling + " " + size + "L" +
                "\nContain fizz: " + fizz;
    }
}