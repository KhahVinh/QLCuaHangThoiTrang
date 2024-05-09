package Component;

import java.io.Serializable;
import java.util.ArrayList;
import Models.Product;
import javax.swing.table.DefaultTableModel;

public class ListProduct implements Serializable {

    ArrayList<Product> pd = new ArrayList<>();

    public void displayData(DefaultTableModel dtm) {
        try {
            pd.stream().forEach((product) -> {
                dtm.addRow(new Object[]{product.getProductName(), product.getProductSold(), product.getProductCategory(), product.getProductStock(), product.getProductPrice()});
            });
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public boolean searchProduct(DefaultTableModel dtm, String name) {
        try {
            for (Product product : pd) {
                if(product.getProductName().equalsIgnoreCase(name)){
                   return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
                return false;
    }
    public boolean correctProduct(String id) {
        try {
            for (Product product : pd) {
                if(product.getProductName().equalsIgnoreCase(id)){
                   return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
                return false;
    }
    public boolean addProduct(Product p){
        try {
            if(pd.contains(p)){
                return false;
            } else {
                pd.add(p);
            }
            return true; 
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public void delete(int index) {
        pd.remove(index);
    }
}
