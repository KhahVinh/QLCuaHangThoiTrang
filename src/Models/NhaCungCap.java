
package Models;

import java.util.Objects;

public class NhaCungCap {
    private int ma;
    private String ten;
    private String soDienThoai;
    private String diaChi;

    public NhaCungCap() {
    }

    public NhaCungCap(int ma, String ten, String soDienThoai, String diaChi) {
        this.ma = ma;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
