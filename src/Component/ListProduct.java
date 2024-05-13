package Component;

import java.io.Serializable;
import java.util.ArrayList;
import Models.Product;
import javax.swing.table.DefaultTableModel;
public class ListProduct implements Serializable {
    public void displayData(DefaultTableModel dtm,ArrayList<Product> danhsachsanpham) {
        try {
            danhsachsanpham.stream().forEach((product) -> {
                dtm.addRow(new Object[]{product.getProductName(), product.getProductCategory(), product.getProductStock(), product.getProductPrice()});
            });
        } catch (Exception e) {
            System.out.println("loi" + e.getMessage());
        }
    }

    public boolean searchProduct(DefaultTableModel dtm, String name,ArrayList<Product> danhsachsanpham) {
        try {
            for (Product product : danhsachsanpham) {
                if (product.getProductName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean correctProduct(String id,ArrayList<Product> danhsachsanpham) {
        try {
            for (Product product : danhsachsanpham) {
                if (product.getProductName().equalsIgnoreCase(id)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean addProduct(Product p,ArrayList<Product> danhsachsanpham) {
        try {
            if (danhsachsanpham.contains(p)) {
                return false;
            } else {
                danhsachsanpham.add(p);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public void delete(int index,ArrayList<Product> danhsachsanpham) {
        danhsachsanpham.remove(index);
    }
        public Product SanPham(int index,ArrayList<Product> danhsachsanpham) {
        return danhsachsanpham.get(index);
    }
}
