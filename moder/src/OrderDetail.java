public class OrderDetail {
    private String ID;
    private String customerID;
    private String productID;
    private int quantity;
    private Double price;

    public OrderDetail(String ID, String customerID, String productID, String supplierID, int quantity, Double price) {
        this.ID = ID;
        this.customerID = customerID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductID() {return productID;}

    public void setProductID(String productID) {this.productID = productID;}

    public String getID() {return ID;}

    public void setID(String ID) {this.ID = ID;}

    public String getCustomerID() {return customerID;}

    public Integer getQuantity() {return quantity;}

    public void setQuantity(Integer quantity) {this.quantity = quantity;}

    public Double getPrice() {return price;}

    public void setPrice(Double price) {this.price = price;}

    public void setCustomerID(String customerID) {this.customerID = customerID;}
}
