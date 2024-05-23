package Models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ProductTest {
    
    public ProductTest() {
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
     * Test of getProductID method, of class Product.
     */
    @Test
    public void testGetProductID() {
        System.out.println("getProductID");
        Product instance = new Product();
        String expResult = "";
        instance.setProductID("");
        String result = instance.getProductID();
        assertEquals(expResult, result);

    }

    /**
     * Test of setProductID method, of class Product.
     */
    @Test
    public void testSetProductID() {
        System.out.println("setProductID");
        String productID = "123";
        Product instance = new Product();
        instance.setProductID(productID);
        String result = productID;
        String expect = "123";
        assertEquals(expect, result);

    }

    /**
     * Test of getProductName method, of class Product.
     */
    @Test
    public void testGetProductName() {
        System.out.println("getProductName");
        Product instance = new Product();
        instance.setProductName("");
        String expResult = "";
        String result = instance.getProductName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProductName method, of class Product.
     */
    @Test
    public void testSetProductName() {
        System.out.println("setProductName");
        String productName = "";
        Product instance = new Product();
        instance.setProductName(productName);
        
    }

    /**
     * Test of getProductCategory method, of class Product.
     */
    @Test
    public void testGetProductCategory() {
        System.out.println("getProductCategory");
        Product instance = new Product();
        instance.setProductCategory("");
        String expResult = "";
        String result = instance.getProductCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProductCategory method, of class Product.
     */
    @Test
    public void testSetProductCategory() {
        System.out.println("setProductCategory");
        String productCategory = "";
        Product instance = new Product();
        instance.setProductCategory(productCategory);
    }

    /**
     * Test of getProductQuantity method, of class Product.
     */
    @Test
    public void testGetProductQuantity() {
        System.out.println("getProductQuantity");
        Product instance = new Product();
        int expResult = 0;
        int result = instance.getProductQuantity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProductQuantity method, of class Product.
     */
    @Test
    public void testSetProductQuantity() {
        System.out.println("setProductQuantity");
        int productQuantity = 0;
        Product instance = new Product();
        instance.setProductQuantity(productQuantity);
    }

    /**
     * Test of getProductPrice method, of class Product.
     */
    @Test
    public void testGetProductPrice() {
        System.out.println("getProductPrice");
        Product instance = new Product();
        long expResult = 0L;
        long result = instance.getProductPrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProductPrice method, of class Product.
     */
    @Test
    public void testSetProductPrice() {
        System.out.println("setProductPrice");
        long productPrice = 0L;
        Product instance = new Product();
        instance.setProductPrice(productPrice);
    }

    /**
     * Test of toString method, of class Product.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Product instance = new Product();
        instance.setProductID("123");
        instance.setProductName("BTK");
        instance.setProductCategory("Quan ao");
        instance.setProductQuantity(10);
        instance.setProductPrice(1000000);
        String expResult = instance.getProductID() +";" +instance.getProductName() +";" + instance.getProductCategory() +";" + instance.getProductQuantity() +";" + instance.getProductPrice();
        String result = instance.toString();
        assertEquals(expResult, result);

    }
    
}
