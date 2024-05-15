
package Component;

import Models.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadWriteProduct {

    public ReadWriteProduct() {
    }
    Product pd;


    public void writeFile(Product product, String fileName) {
        try (FileWriter fw = new FileWriter(fileName, true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter pw = new PrintWriter(bw)) {

//            for (Product product : danhsachsanpham) {
            pw.println(product.getProductID());
            pw.println(product.getProductName());
            pw.println(product.getProductCategory());
            pw.println(product.getProductStock());
            pw.println(product.getProductPrice());

//            }
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
                danhsachsanpham.add(p);

            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();

        };
        return danhsachsanpham;
    }
}
