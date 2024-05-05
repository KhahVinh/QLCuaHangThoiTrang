
package Models;

import java.util.Objects;

public class NhaCungCap {
    private int ma;
    private String ten;

    public NhaCungCap(int ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public NhaCungCap() {
    }

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.ma;
        hash = 29 * hash + Objects.hashCode(this.ten);
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
        final NhaCungCap other = (NhaCungCap) obj;
        if (this.ma != other.ma) {
            return false;
        }
        return Objects.equals(this.ten, other.ten);
    }

    @Override
    public String toString() {
        return "NhaCungCap{" + "ma=" + ma + ", ten=" + ten + '}';
    }
    
    
}
