/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author my computer
 */
public class ProductTest {
    
    public ProductTest() {
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
        Product instance = new Product();
        String exResult = "";
        instance.setProductID("");
        String productID = instance.getProductID();
        assertEquals(exResult, productID);
    }

    /**
     * Test of getProductName method, of class Product.
     */
    @Test
    public void testGetProductName() {
        System.out.println("getProductName");
        Product instance = new Product();
        String expResult = "";
        instance.setProductName("");
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
        String result = instance.getProductName();
        String exResult = "";
        assertEquals(exResult, result);
    }

    /**
     * Test of getProductCategory method, of class Product.
     */
    @Test
    public void testGetProductCategory() {
        System.out.println("getProductCategory");
        Product instance = new Product();
        String expResult = "";
        instance.setProductCategory("");
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
        String result = instance.getProductCategory();
        String expResult = "";
        assertEquals(expResult, result);
    }

    /**
     * Test of getProductQuantity method, of class Product.
     */
    @Test
    public void testGetProductQuantity() {
        System.out.println("getProductQuantity");
        Product instance = new Product();
        int expResult = 0;
        instance.setProductQuantity(0);
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
        int result = instance.getProductQuantity();
        int expResult = 0;
        assertEquals(expResult, result);
    }

    /**
     * Test of getProductPrice method, of class Product.
     */
    @Test
    public void testGetProductPrice() {
        System.out.println("getProductPrice");
        Product instance = new Product();
        long expResult = 0L;
        instance.setProductPrice(0L);
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
        long result = instance.getProductPrice();
        long expResult = 0L;
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Product.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Product instance = new Product();
        String expResult = ";;;0;0";
        instance.setProductID("");
        instance.setProductName("");
        instance.setProductCategory("");
        instance.setProductQuantity(0);
        instance.setProductPrice(0);
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
