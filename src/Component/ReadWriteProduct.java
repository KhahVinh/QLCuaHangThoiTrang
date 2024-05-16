package Component;

import Models.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ReadWriteProduct {
    ListProduct listProduct = new ListProduct();
    public ReadWriteProduct() {
    }
    Product pd;

    public void writeFile(Product product, String fileName) {
        try (FileWriter fw = new FileWriter(fileName, true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter pw = new PrintWriter(bw)) {
            pw.println(product.getProductID());
            pw.println(product.getProductName());
            pw.println(product.getProductCategory());
            pw.println(product.getProductStock());
            pw.println(product.getProductPrice());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList readFile(String fileName, ArrayList<Product> danhsachsanpham) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                Product p = new Product();
                p.setProductID(line);
                p.setProductName(br.readLine());
                p.setProductCategory(br.readLine());
                p.setProductStock(br.readLine());
                p.setProductPrice(Float.parseFloat(br.readLine()));
                if(!listProduct.correctProduct(line, danhsachsanpham)){
                    danhsachsanpham.add(p);
                } 

            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();

        };
        return danhsachsanpham;
    }
}
