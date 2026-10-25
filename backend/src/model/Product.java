package model;

public class Product {

  private int id;
  private String name;
  private String category;
  private double price;
  private boolean isAvailable;

  public Product(int id, String name, String category, double price, boolean isAvailable) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.price = price;
    this.isAvailable = isAvailable;

  }

  public int getId(){

    return id;

  }
 public void setId( int id){

    this.id = id;

 }
public String getName(){

    return name;
}
public void setName(String name){

    this.name=name;

}

public String getCategory(){

    return category;

}
public void setCategory(){

    this.category=category;

}
    public double getPrice(){

      return price;

    }

    public void setPrice(double price){

      this.price=price;

    }

    public boolean isAvailable(){

      return isAvailable;

    }

    public void setisAvailable(boolean isAvailable){

      this.isAvailable=isAvailable;

          }

          @Override
        public String toString(){

            String status=isAvailable ? "Stokta":"Stok yok";

            String result= id + " - " + name + "(" + category +") : " + price + " TL | Status: " + status;

            return result;

          }



}
