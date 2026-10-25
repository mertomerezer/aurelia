package model;

public class OrderItem {
    private int productId;
    private String productName;
    private int quantity;
    private double unitPrice;

    public OrderItem(int productId, String productName, int quantity, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "productId=" + productId + ", productName='" + productName + '\'' + ", quantity=" + quantity + ", unitPrice=" + unitPrice + '}';
    }
}
