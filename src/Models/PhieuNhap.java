
package Models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PhieuNhap {
   private String ma; 
   private String maNhaCungCap;
   private ArrayList<Product> sanPhamNhap;
   private String ngayTao;
   private String ngayCapNhat;
   private Long tien;

    public PhieuNhap(String ma, String maNhaCungCap, ArrayList<Product> sanPhamNhap, Long tien) {
        this.ma = ma;
        this.maNhaCungCap = maNhaCungCap;
        this.sanPhamNhap = sanPhamNhap;
        this.tien = tien;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        this.ngayTao = formatter.format(new Date());
        this.ngayCapNhat = formatter.format(new Date());
    }

    public PhieuNhap() {
    }

    public String getMa() {
        return ma;
    }

    public void setNgayCapNhat(String ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public String getNgayCapNhat() {
        return ngayCapNhat;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public ArrayList<Product> getSanPhamNhap() {
        return sanPhamNhap;
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

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setTien(Long tien) {
        this.tien = tien;
    }
    
    private String listProduct() {
        String result = "";
        int size = this.sanPhamNhap.size();
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                result = result + this.sanPhamNhap.get(i).toString() + "&";
            } else {
                result = result + this.sanPhamNhap.get(i).toString();
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return ma + "-" + maNhaCungCap + "-" + this.listProduct() + "-" + ngayTao + "-" + ngayCapNhat + "-" + tien;
    }
    
   
   
}
