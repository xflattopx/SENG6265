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


    public String getAddress() {
        return this.address;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
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
