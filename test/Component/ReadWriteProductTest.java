package Component;

import Models.Product;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReadWriteProductTest {
    
    public ReadWriteProductTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of writeFile method, of class ReadWriteProduct.
     */
    @Test
    public void testWriteFile() {
        System.out.println("writeFile");
        String id = "ABTEST";
        String name = "Phu kien test";
        String category = "Phụ kiện";
        int quantity = 10;
        long price = 1000000;
        Product product = new Product(id, name, category, quantity, price) ;
        String fileName = "QuanLySanPham.txt";
        ArrayList<Product> danhsachsanpham = new ArrayList<>();
        danhsachsanpham.add(product);
        ReadWriteProduct instance = new ReadWriteProduct();
        instance.writeFile(product, fileName, danhsachsanpham);
    }

    /**
     * Test of readFile method, of class ReadWriteProduct.
     */
    @Test
    public void testReadFile() {
        System.out.println("readFile");
        String fileName = "";
        ArrayList<Product> danhsachsanpham = null;
        ReadWriteProduct instance = new ReadWriteProduct();
        ArrayList expResult = null;
        ArrayList result = instance.readFile(fileName, danhsachsanpham);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
