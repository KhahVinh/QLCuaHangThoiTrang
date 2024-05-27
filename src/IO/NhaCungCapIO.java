
package IO;

import Models.NhaCungCap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class NhaCungCapIO {
    private static final String FILE_NAME_NHACUNGCAP = "NhaCungCap.txt";

    public static ArrayList<NhaCungCap> readFromFile() {
        ArrayList<NhaCungCap> list = new ArrayList<NhaCungCap>();
        try {
            FileReader fr = new FileReader(FILE_NAME_NHACUNGCAP);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while(true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(";");
                list.add(new NhaCungCap(txt[0], txt[1], txt[2], txt[3]));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list == null) {
            list = new ArrayList<NhaCungCap>();
        }
        return list;
    }
    
    public static void writeToFile(ArrayList<NhaCungCap> list) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME_NHACUNGCAP);
            BufferedWriter bw = new BufferedWriter(fw);
            for (NhaCungCap i : list) {
                bw.write(i.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void writeToFile(ArrayList<NhaCungCap> list, boolean nextLine) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME_NHACUNGCAP, nextLine);
            BufferedWriter bw = new BufferedWriter(fw);
            for (NhaCungCap i : list) {
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
