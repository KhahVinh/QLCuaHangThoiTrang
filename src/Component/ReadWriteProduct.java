package Component;
import Models.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadWriteProduct {
    public ReadWriteProduct() {
    }
//    public void writeFile(String fileName, Object obj){
//        try {
//            FileOutputStream fos = new FileOutputStream(fileName,true);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.close();
//            fos.close();
//            
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ReadWriteProduct.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ReadWriteProduct.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    public void readFile(String fileName){
//        Object result = null;
//        try {
//           FileInputStream fis = new FileInputStream(fileName);
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            while (fis.available() > 0) {
//                result = ois.readObject();
//                System.out.println(result);
//            }
//            ois.close();
//            fis.close();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ReadWriteProduct.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ReadWriteProduct.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ReadWriteProduct.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    static public void writeFile(ArrayList<Product> listProduct, String fileName) {
        try (FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {

            for (Product product : listProduct) {
                pw.println(product.getProductID());
                pw.println(product.getProductName());
                pw.println(product.getProductCategory());
                pw.println(product.getProductStock());
                pw.println(product.getProductPrice());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

static public ArrayList<Product> readFile(String fileName, ArrayList<Product> danhsachsanpham) {
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
    }
    return danhsachsanpham;
}

}


