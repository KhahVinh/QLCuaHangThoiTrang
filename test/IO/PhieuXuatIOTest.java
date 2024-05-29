/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package IO;

import Models.PhieuXuat;
import Models.Product;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author my computer
 */
public class PhieuXuatIOTest {
    
    public PhieuXuatIOTest() {
    }

    /**
     * Test of writePhieuXuat method, of class PhieuXuatIO.
     */
    @Test
    public void testWritePhieuXuat() {
        System.out.println("writePhieuXuat");
        Product p = new Product("1", "A", "B", 2, 10);
        ArrayList<Product> lp = new ArrayList<>();
        lp.add(p);
        PhieuXuat phieuxuat = new PhieuXuat("1", "a", "b", lp, "C", 10);
        ArrayList<PhieuXuat> danhsachphieuxuat = new ArrayList<>();
        danhsachphieuxuat.add(phieuxuat);
        PhieuXuatIO instance = new PhieuXuatIO();
        instance.writePhieuXuat(phieuxuat, danhsachphieuxuat);
        ArrayList<PhieuXuat> exp = new ArrayList<>();
        exp.add(phieuxuat);
        assertEquals(exp, danhsachphieuxuat);
    }

    /**
     * Test of readFilePX method, of class PhieuXuatIO.
     */
    @Test
    public void testReadFilePX() {
        System.out.println("readFilePX");
        String fileName = "";
        PhieuXuatIO instance = new PhieuXuatIO();
        ArrayList expResult = new ArrayList();
        ArrayList result = instance.readFilePX(fileName);
        assertEquals(expResult, result);
    }
    
}
