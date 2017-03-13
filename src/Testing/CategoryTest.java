package Testing;

import model.Category;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Max Kulish
 */
public class CategoryTest{

    /**
     * Test of getCategoryID method, of class Category.
     */
    @Test
    public void testGetCategoryID() {
        System.out.println("getCategoryID");
        Category instance = new Category();
        int expResult = -1;
        int result = instance.getCategoryID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCategoryID method, of class Category.
     */
    @Test
    public void testSetCategoryID() {
        System.out.println("setCategoryID");
        int categoryID = 0;
        Category instance = new Category();
        instance.setCategoryID(categoryID);
    }

    /**
     * Test of getCategoryName method, of class Category.
     */
    @Test
    public void testGetCategoryName() {
        System.out.println("getCategoryName");
        Category instance = new Category();
        String expResult = "A test category";
        String result = instance.getCategoryName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCategoryName method, of class Category.
     */
    @Test
    public void testSetCategoryName() {
        System.out.println("setCategoryName");
        String categoryName = "";
        Category instance = new Category();
        instance.setCategoryName(categoryName);
    }

    /**
     * Test of toString method, of class Category.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Category instance = new Category();
        String expResult = "A test category";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
