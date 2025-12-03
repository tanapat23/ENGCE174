package lab2_10;

public class ShoppingCart {
    
    private Product[] items;
    private int itemCount;

    public ShoppingCart() {
        this.items = new Product[10];
        this.itemCount = 0;
    }

    public void addProduct(Product p) {
        if (this.itemCount < this.items.length) {
            this.items[this.itemCount] = p;
            this.itemCount++;
        } else {
            System.out.println("Error: Shopping cart is full (max 10 items).");
        }
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        
        for (int i = 0; i < this.itemCount; i++) {
            totalPrice += this.items[i].getPrice();
        }
        
        return totalPrice;
    }
}
