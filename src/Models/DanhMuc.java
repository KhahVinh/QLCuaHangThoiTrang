
package Models;

import java.util.Objects;

public class DanhMuc {
    private int id;
    private String ten;

    public DanhMuc(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public DanhMuc() {
    }

    public int getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.ten);
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
        final DanhMuc other = (DanhMuc) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.ten, other.ten);
    }

    @Override
    public String toString() {
        return "DanhMuc{" + "id=" + id + ", ten=" + ten + '}';
    }
    
    
}
