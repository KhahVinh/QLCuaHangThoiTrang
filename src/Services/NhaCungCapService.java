
package Services;

import Models.NhaCungCap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class NhaCungCapService {
    private static final String FILE_NAME = "NhaCungCap.txt";
    private ArrayList<NhaCungCap> list;
    
    public NhaCungCapService() {
        this.list = new ArrayList<NhaCungCap>();
        try {
            FileReader fr = new FileReader(FILE_NAME);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while(true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(";");
                String ma = txt[0];
                String ten = txt[1];
                String sdt = txt[2];
                String diaChi = txt[3];
                this.list.add(new NhaCungCap(ma, ten, diaChi, diaChi));
            }
        } catch (Exception e) {
        }
        if (list == null) {
            this.list = new ArrayList<NhaCungCap>();
        }
    }
    
    public ArrayList<NhaCungCap> getListNhaCungCap() {
        return list;
    }
}
