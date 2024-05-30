package IO;

import Models.PhieuXuat;
import Models.Product;
import Views.QLSP;
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
                String diaChi = txt[4];
                String tongTien = txt[5];
                PhieuXuat phieuxuat = new PhieuXuat(maPhieu,tenKH, sdtKH, diaChi,Long.parseLong(tongTien));
                phieuxuat.setNgayTao(txt[3]);
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
    public void deleteByIdMaPhieuNhap(String id) {
        try {
            ArrayList<PhieuXuat> list = readFilePX(FILE_PX);
            int index = 0;
            int size = list.size();
            while (index < size) {
                if (list.get(index).getMaPhieu().equalsIgnoreCase(id)) {
                    list.remove(index);
                    if (index == 0) {
                        index = 0;
                    } else {
                        index = index - 1;
                    }
                    size = list.size();
                } else {
                    index = index + 1;
                }
            }
            FileWriter fw = new FileWriter(FILE_PX);
            BufferedWriter bw = new BufferedWriter(fw);
            for (PhieuXuat i : list) {
                bw.write(i.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateInfoById(PhieuXuat data) {
        try {
            ArrayList<PhieuXuat> list = readFilePX(FILE_PX);
            for (int i = 0; i < list.size(); i++) {
                if (data.getMaPhieu().equalsIgnoreCase(list.get(i).getMaPhieu())) {
                    list.get(i).setMaPhieu(data.getMaPhieu());
                    list.get(i).setTenKH(data.getTenKH());
                    list.get(i).setSdtKH(data.getSdtKH());
                    list.get(i).setDiaChi(data.getDiaChi());
                    list.get(i).setNgayTao(data.getNgayTao());
                    list.get(i).setTien(data.getTien());
                    break;
                }
            }
            FileWriter fw = new FileWriter(FILE_PX);
            BufferedWriter bw = new BufferedWriter(fw);
            for (PhieuXuat i : list) {
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
