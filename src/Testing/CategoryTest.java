package Testing;

import model.Category;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Category Test
 * @author Max Kulish
 * @author Jorie Fernandez - Added methods to handle negative category ID and name
 */
public class CategoryTest{

    /**
     * Test of getCategoryID method, of class Category.
     */
    @Test
    public void testGetCategoryID() {
        System.out.println("getCategoryID");
        Category instance = new Category();
        int expResult = 0;
        int result = instance.getCategoryID();
        assertEquals(expResult, result);
    }
    
    /**
     * Method to test if the category ID is negative.
     * @author Jorie Fernandez
     */
    @Test (expected = IllegalArgumentException.class)
    public void testSetNegativeCategoryID() {
    	Category instance = new Category();
    	instance.setCategoryID(-1);
    	
    }

    /**
     * Test of setCategoryID method, of class Category.
     * Modified by Jorie Fernandez by setting category instance and  checking the result.
     */
    @Test
    public void testSetCategoryID() {
        System.out.println("setCategoryID");
        int categoryID = 2;
        Category instance = new Category();
        instance.setCategoryID(categoryID);
        assertEquals(2, instance.getCategoryID());
    }

    /**
     * Test of getCategoryName method, of class Category.
     */
    @Test
    public void testGetCategoryName() {
        System.out.println("getCategoryName");
        Category instance = new Category();
        String expResult = "A test category";
        instance.setCategoryName(expResult);
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
     * Method to 
     */
    @Test (expected = NullPointerException.class)
    public void testSetNullCategoryName(){
    	Category instance = new Category();
    	instance.setCategoryName(null);
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
        assertEquals(null, result);
    }
    
}
