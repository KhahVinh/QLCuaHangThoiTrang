
package IO;

import Models.PhieuNhap;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class PhieuNhapIO {
    private static final String FILE_NAME_PHIEUNHAP = "PhieuNhap.txt";
    
    public static void writeToFile(PhieuNhap value) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME_PHIEUNHAP, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(value.toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

}
