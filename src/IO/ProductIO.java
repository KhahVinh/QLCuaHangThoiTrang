
package IO;

import Models.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ProductIO {
    private static final String FILE_NAME_PRODUCT = "QuanLySanPham.txt";
    
    public static ArrayList<Product> readFromFile() {
        ArrayList<Product> list = new ArrayList<Product>();
        try {
            FileReader fr = new FileReader(FILE_NAME_PRODUCT);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while(true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(";");
                list.add(new Product(txt[0], txt[1], txt[2], Integer.parseInt(txt[3]), Long.parseLong(txt[4])));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list == null) {
            list = new ArrayList<Product>();
        }
        return list;
    }    
    
    public static void writeToFile(ArrayList<Product> list) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME_PRODUCT);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Product i : list) {
                bw.write(i.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
