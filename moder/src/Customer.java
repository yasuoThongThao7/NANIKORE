import java.util.ArrayList;

public class Customer {
    private String id;
    private String name;
    private String address;
    private String birth;
    private ArrayList<OrderDetail> orderDetails = new ArrayList<>();

    public Customer() {

    }

    public Customer(String customer_id, String customer_name, String customer_address, String birth) {
        this.id = customer_id;
        this.name = customer_name;
        this.address = customer_address;
        this.birth = birth;
    }

    public String getCustomer_id() {return id;}

    public void setCustomer_id(String customer_id) {this.id = customer_id;}

    public String getCustomer_name() {return name;}

    public void setCustomer_name(String customer_name) {this.name = customer_name;}

    public String getCustomer_address() {return address;}

    public void setCustomer_address(String customer_address) {this.address = customer_address;}

    public String getBirth() {return birth;}

    public void setBirth(String birth) {this.birth = birth;}

    public OrderDetail getProduct(int i) {return orderDetails.get(i);}

    public void removeListProduct(Products product) {this.orderDetails.remove(product);}

}
