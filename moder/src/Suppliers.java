import java.util.ArrayList;

public class Suppliers {
    private String supplier_id ; /**Khóa chính, mã nhà cung cấp.*/
    private String name; /** Tên nhà cung cấp.*/
    private String address; /** Địa chỉ.*/
    private String phone; /**Số điện thoại.*/
    private String email;
    private ArrayList<Products> products_supplied;  /** Danh sách sản phẩm cung cấp */

    public Suppliers(String supplier_id, String name, String address, String phone, String email) {
        this.supplier_id = supplier_id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getSupplier_id() {return supplier_id;}

    public void setSupplier_id(String supplier_id) {this.supplier_id = supplier_id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public void inputProduct(Products newProduct){this.products_supplied.add(newProduct);}

    public Products getProducts_supplied(int i) {return products_supplied.get(i);}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Supplier ID: ").append(supplier_id).append("\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("Address: ").append(address).append("\n");
        sb.append("Phone: ").append(phone).append("\n");
        sb.append("Email: ").append(email).append("\n");
        return sb.toString();
    }
}
class ListSupplier {
    public static ArrayList<Suppliers> LIST_SUPPLIERS;
    private ArrayList<Suppliers> listSameName;

    public ListSupplier(Suppliers supplier) {
        LIST_SUPPLIERS.add(supplier);
    }


    public void addListSameName(String name) {
        for (Suppliers supplier : LIST_SUPPLIERS) {
            if (supplier.getName().contains(name)) {
                listSameName.add(supplier);
            }
        }
    }

    public static ArrayList<Suppliers> getListSuppliers() {
        return LIST_SUPPLIERS;
    }


    public static String getSuppliersName(String ID){
        for(Suppliers supplier : LIST_SUPPLIERS) {
            if(supplier.getSupplier_id().equals(ID)) {
                return supplier.getName();
            }
        }
        return null;
    }
}
