package IO;

import Models.PhieuXuat;
import Models.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhieuXuatIO {

    String FILE_PX = "QuanLyPhieuXuat.txt";

    public void writePhieuXuat(PhieuXuat phieuxuat, ArrayList<PhieuXuat> danhsachphieuxuat) {
        try {
            FileWriter fw = new FileWriter(FILE_PX, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(phieuxuat.toString());
            pw.close();
            bw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(PhieuXuatIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList readFilePX(String fileName) {
        ArrayList<PhieuXuat> danhsachphieuxuat = new ArrayList<>();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String txt[] = line.split("-");
                String maPhieu = txt[0];
                String tenKH = txt[1];
                String sdtKH = txt[2];
                String diaChi = txt[5];
                String listProduct[] = txt[3].split("&");
                ArrayList<Product> products = new ArrayList<>();
                for (int i = 0; i < listProduct.length; i++) {
                    String valueProduct[] = listProduct[i].split(";");
                    Product product = new Product(valueProduct[0], valueProduct[1], valueProduct[2], Integer.parseInt(valueProduct[3]), Long.parseLong(valueProduct[4]));
                    products.add(product);
                }
                String tongTien = txt[6];
                PhieuXuat phieuxuat = new PhieuXuat(maPhieu,tenKH, sdtKH, products, diaChi,Long.parseLong(tongTien));
                phieuxuat.setNgayTao(txt[4]);
                if (!danhsachphieuxuat.contains(phieuxuat)) {
                    danhsachphieuxuat.add(phieuxuat);
                }
            }

            br.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PhieuXuatIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PhieuXuatIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (danhsachphieuxuat == null) {
            danhsachphieuxuat = new ArrayList<PhieuXuat>();
        }
        return danhsachphieuxuat;
    }
}
