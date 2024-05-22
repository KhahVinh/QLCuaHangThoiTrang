
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
       public void writeFile(Product product, String fileName, ArrayList<Product> danhsachsanpham) {
        try (FileWriter fw = new FileWriter(fileName, true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter pw = new PrintWriter(bw)) {
            pw.println(product.toString());
            pw.close();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList readFile(String fileName, ArrayList<Product> danhsachsanpham) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String txt[] = line.split(";");
                Product p = new Product(txt[0], txt[1], txt[2], Integer.parseInt(txt[3]), Long.parseLong(txt[4]));
                if (!listProduct.correctProduct(txt[0], danhsachsanpham)) {
                    danhsachsanpham.add(p);
                }

            }
            br.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();

        };
        return danhsachsanpham;
    }
}
