
package Models;

import java.util.Objects;

public class MatHang {
    private int ma;
    private String ten;
    private String moTa;
    private double giaBan;
    private int soLuong;
    private DanhMuc danhMuc;
    private NhaCungCap nhaCungCap;

    public MatHang(int ma, String ten, String moTa, double giaBan, int soLuong, DanhMuc danhMuc, NhaCungCap nhaCungCap) {
        this.ma = ma;
        this.ten = ten;
        this.moTa = moTa;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.danhMuc = danhMuc;
        this.nhaCungCap = nhaCungCap;
    }

    public MatHang() {
    }

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.ma;
        hash = 41 * hash + Objects.hashCode(this.ten);
        hash = 41 * hash + Objects.hashCode(this.moTa);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.giaBan) ^ (Double.doubleToLongBits(this.giaBan) >>> 32));
        hash = 41 * hash + this.soLuong;
        hash = 41 * hash + Objects.hashCode(this.danhMuc);
        hash = 41 * hash + Objects.hashCode(this.nhaCungCap);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MatHang other = (MatHang) obj;
        if (this.ma != other.ma) {
            return false;
        }
        if (Double.doubleToLongBits(this.giaBan) != Double.doubleToLongBits(other.giaBan)) {
            return false;
        }
        if (this.soLuong != other.soLuong) {
            return false;
        }
        if (!Objects.equals(this.ten, other.ten)) {
            return false;
        }
        if (!Objects.equals(this.moTa, other.moTa)) {
            return false;
        }
        if (!Objects.equals(this.danhMuc, other.danhMuc)) {
            return false;
        }
        return Objects.equals(this.nhaCungCap, other.nhaCungCap);
    }

    @Override
    public String toString() {
        return "MatHang{" + "ma=" + ma + ", ten=" + ten + ", moTa=" + moTa + ", giaBan=" + giaBan + ", soLuong=" + soLuong + ", danhMuc=" + danhMuc + ", nhaCungCap=" + nhaCungCap + '}';
    }
   
    
}
