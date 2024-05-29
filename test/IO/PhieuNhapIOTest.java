/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package IO;

import Models.PhieuNhap;
import Models.Product;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author my computer
 */
public class PhieuNhapIOTest {
    
    public PhieuNhapIOTest() {
    }

    /**
     * Test of writeToFile method, of class PhieuNhapIO.
     */
    @Test
    public void testWriteToFile_PhieuNhap() throws FileNotFoundException, IOException {
        System.out.println("writeToFile");
        Product p = new Product("1", "a", "b", 0, 0);
        ArrayList<Product> lp = new ArrayList<>();
        lp.add(p);
        PhieuNhap value = new PhieuNhap("1", "NCC", lp, Long.MIN_VALUE);
        PhieuNhapIO.writeToFile(value);
        
        File file = new File("PhieuNhap.txt");
        assertTrue(file.exists());

        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            line = reader.readLine();
        }

        assertEquals(value.toString(), line);
        
    }

    /**
     * Test of writeToFile method, of class PhieuNhapIO.
     */
    @Test
    public void testWriteToFile_ArrayList() {
        System.out.println("writeToFile");
        ArrayList<PhieuNhap> list = new ArrayList<>();
        for (PhieuNhap i : list) {
            PhieuNhap ncc = new PhieuNhap(i.getMa(), i.getMaNhaCungCap(), i.getSanPhamNhap(), Long.MIN_VALUE);
            list.add(ncc);
        }
        PhieuNhapIO.writeToFile(list);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("PhieuNhap.txt"));
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

            assertEquals(list.size(), lines.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test of readFromFile method, of class PhieuNhapIO.
     */
    @Test
    public void testReadFromFile() {
        System.out.println("readFromFile");
        ArrayList<PhieuNhap> expResult = new ArrayList<>();
        for (PhieuNhap i : expResult) {
            PhieuNhap p = new PhieuNhap(i.getMa(), i.getMaNhaCungCap(), i.getSanPhamNhap(), Long.MIN_VALUE);
            expResult.add(p);
        }
        ArrayList<PhieuNhap> result = PhieuNhapIO.readFromFile();
        assertEquals(expResult, result);
    }
    
}
