public class Textbook {
    private String SKU, title, price, quantity;

    // Constructor
    public Textbook(String SKU, String title, String price, String quantity) {
        this.SKU = SKU;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }
    // Setters and Getters
    public void setSKU(String SKU) {
        this.SKU = SKU;
    }
    public String getSKU() {
        return SKU;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getPrice() {
        return price;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public String getQuantity() {
        return quantity;
    }
    public String getDetails() {
        return "SKU: " + SKU + " Title: " + title + " Price: $" + price + " Quantity: " + quantity;
    }
}