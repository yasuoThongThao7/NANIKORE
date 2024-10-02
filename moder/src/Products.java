import java.io.*;
import java.util.ArrayList;


public class Products implements Serializable {
    private String product_id;
    private String product_name;
    private String supplier_id;
    private int price_in; // Giá bán trên 1 đơn vị tính
    private Double price_out; // Giá xuất ra trên 1 đơn vị  tính
    private String unit_name; // ID đơn vị tính
    private static int cnt;


    public Products( String product_name,int price_in, String supplier_id, String unit_name) {
        this.price_in = price_in;
        this.product_id = MakeID.makeID(product_name,ListSupplier.getSuppliersName(supplier_id),cnt++);
        this.product_name = product_name;
        this.supplier_id = supplier_id ;
        this.unit_name = unit_name;
    }


    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {this.product_id = product_id;}

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_ID(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public int getPrice_in() {
        return price_in;
    }

    public void setPrice_in(int price_in) {
        this.price_in = price_in;
    }

    public Double getPrice_out() {
        return price_out;
    }

    public void setPrice_out(Double price_out) {
        this.price_out = price_out;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

}


class ListEnterWareHouse{
    public static ArrayList<Products> LIST_ENTER_WAREHOUSE;

    public ListEnterWareHouse(Products products) {
        LIST_ENTER_WAREHOUSE.add(products);
    }

    public  ArrayList<Products> getListEnterWareHouse() {
        return LIST_ENTER_WAREHOUSE;
    }

}

class ListWareHouse{
    public static ArrayList<Products> LIST_WAREHOUSE;

    public ListWareHouse(Products products) {
        LIST_WAREHOUSE.add(products);
    }
    public  ArrayList<Products> getListWareHouse() {
        return LIST_WAREHOUSE;
    }

}

class ListWareHouseExport{
    public static ArrayList<Products> LIST_WAREHOUSE_EXPORT = new ArrayList<>();

    static {
        try {
            FileInputStream fileStream = new FileInputStream("ListWareHouseExport.txt");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            while (true){
                try {
                    Object o = os.readObject();
                    Products products = (Products) o;
                    LIST_WAREHOUSE_EXPORT.add(products);
                    os.close();
                }catch(EOFException e){
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void add(Products products) {
        LIST_WAREHOUSE_EXPORT.add(products);
        try {
            FileOutputStream fileStream = new FileOutputStream("ListWareHouseExport.txt");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(products);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Unit{
    public static String[] unit_name = {"Tấn","Kg","gam","m","cm","Thùng","Chiếc"};
}