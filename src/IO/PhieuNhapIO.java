
package IO;

import Models.PhieuNhap;
import Models.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class PhieuNhapIO {
    private static final String FILE_NAME_PHIEUNHAP = "PhieuNhap.txt";
    
    public static void writeToFile(PhieuNhap value) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME_PHIEUNHAP, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(value.toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void writeToFile(ArrayList<PhieuNhap> list) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME_PHIEUNHAP);
            BufferedWriter bw = new BufferedWriter(fw);
            for (PhieuNhap i : list) {
                bw.write(i.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<PhieuNhap> readFromFile() {
        ArrayList<PhieuNhap> list = new ArrayList<PhieuNhap>();
        try {
            FileReader fr = new FileReader(FILE_NAME_PHIEUNHAP);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while(true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split("-");
                String listProducts[] = txt[2].split("&");
                ArrayList<Product> products = new ArrayList<Product>();
                for (int i = 0; i < listProducts.length; i++) {
                    String value[] = listProducts[i].split(";");
                    products.add(new Product(value[0], value[1], value[2], Integer.parseInt(value[3]), Long.parseLong(value[4])));
                }
                PhieuNhap value = new PhieuNhap(txt[0], txt[1], products, Long.parseLong(txt[5]));
                value.setNgayTao(txt[3]);
                value.setNgayCapNhat(txt[4]);
                list.add(value);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list == null) {
            list = new ArrayList<PhieuNhap>();
        }
        return list;
    }

}
