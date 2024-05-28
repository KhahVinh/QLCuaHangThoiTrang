package Models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PhieuXuat implements Serializable{
    private String maPhieu;
    private String tenKH;
    private String sdtKH;
    private ArrayList<Product> danhsachsanphamxuat;
    private String ngayTao;
    private String diaChi;
    private long tien;

    public PhieuXuat() {
    }

    public PhieuXuat(String maPhieu, String tenKH, String sdtKH, ArrayList<Product> danhsachsanphamxuat,String diaChi, long tien) {
        this.maPhieu = maPhieu;
        this.tenKH = tenKH;
        this.sdtKH = sdtKH;
        this.danhsachsanphamxuat = danhsachsanphamxuat;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        this.ngayTao = formatter.format(new Date());
        this.diaChi = diaChi;
        this.tien = tien;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }
    
    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdtKH() {
        return sdtKH;
    }

    public void setSdtKH(String sdtKH) {
        this.sdtKH = sdtKH;
    }

    public ArrayList<Product> getDanhsachsanphamxuat() {
        return danhsachsanphamxuat;
    }

    public void setDanhsachsanphamxuat(ArrayList<Product> danhsachsanphamxuat) {
        this.danhsachsanphamxuat = danhsachsanphamxuat;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    
    
    public long getTien() {
        return tien;
    }

    public void setTien(long tien) {
        this.tien = tien;
    }
    private String listProduct() {
        String result = "";
        int size = this.danhsachsanphamxuat.size();
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                result = result + this.danhsachsanphamxuat.get(i).toString() + "&";
            } else {
                result = result + this.danhsachsanphamxuat.get(i).toString();
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return maPhieu+"-"+tenKH + "-" + sdtKH + "-" + this.listProduct() + "-" + ngayTao +"-"+diaChi+ "-" + tien;
    }
    
}
