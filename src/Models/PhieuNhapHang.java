
package Models;

import java.util.ArrayList;
import java.util.Date;

public class PhieuNhapHang {
   private String ma; 
   private String maNhaCungCap;
   private ArrayList<Product> sanPhamNhap;
   private Date ngayTao = new Date();
   private Long tien;

    public PhieuNhapHang(String ma, String maNhaCungCap, ArrayList<Product> sanPhamNhap, Long tien) {
        this.ma = ma;
        this.maNhaCungCap = maNhaCungCap;
        this.sanPhamNhap = sanPhamNhap;
        this.tien = tien;
    }

    public PhieuNhapHang() {
    }

    public String getMa() {
        return ma;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public ArrayList<Product> getSanPhamNhap() {
        return sanPhamNhap;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public Long getTien() {
        return tien;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public void setSanPhamNhap(ArrayList<Product> sanPhamNhap) {
        this.sanPhamNhap = sanPhamNhap;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setTien(Long tien) {
        this.tien = tien;
    }
    
    private String listProduct() {
        String result = "";
        for (Product i : this.sanPhamNhap) {
            result = result + "&" + i.toString();
        }
        return result;
    }

    @Override
    public String toString() {
        return ma + "-" + maNhaCungCap + "-" + this.listProduct() + "-" + ngayTao + "-" + tien;
    }
    
   
   
}
