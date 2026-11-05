package model;

public class Product {


    private int id;
    private String name;
    private ProductCategory category;
    private double price;
    private boolean isAvailable;



    public Product(int id, String name, ProductCategory category, double price, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.isAvailable = isAvailable;
    }




    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public ProductCategory getCategory() {
        return category;
    }


    public void setCategory(ProductCategory category) {
        this.category = category;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public boolean isAvailable() {
        return isAvailable;
    }


    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }


    @Override
    public String toString() {
        String status;

        if (isAvailable) {
            status = "Stokta";
        } else {
            status = "Stok yok";
        }

        return id + " - " + name + " (" + category.name() + ") : "
                + price + " TL | Durum: " + status;
    }
}