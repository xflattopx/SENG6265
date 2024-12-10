package project.property;

public class Property {
    private String category;
    private String type;
    private String address;
    private String status;
    private int price;

    // Constructor
    public Property(String category, String type, String address, String status, int price) {
        this.category = category;
        this.type = type;
        this.address = address;
        this.status = status;
        this.price = price;
    }

    //Getters
    public String getCategory() {
        return this.category;
    }

    public String getType() {
        return this.type;
    }

    public String getAddress() {
        return this.address;
    }

    public String getStatus() {
        return this.status;
    }

    public int getPrice() {
        return this.price;
    }

    // Setters
    public void setCategory(String category) {
        this.category = category;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ("Category: " + this.category
                + "\nType: " + this.type
                + "\nAddress: " + this.address
                + "\nStatus: " + this.status
                + "\nPrice: " + this.price
        );
    }
}
