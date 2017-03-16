package model;

/**
 * Category class
 * @author Jorie Fernandez
 *
 */
public class Category {
	/** category ID */
	private int categoryID;
	/** category name */
	private String categoryName;
	
	/** Method to get category ID.
	 * 
	 *  @return category ID
	 *  */
	public int getCategoryID() {
		return categoryID;
	}

	/** Method to set category ID 
	 * 
	 * @param categoryID, the category ID
	 * */
	public void setCategoryID(int categoryID) {
		if(categoryID <= 0) {
			throw new IllegalArgumentException("Category is zero or negative!");
		}
		this.categoryID = categoryID;
	}

	/** Method to get category Name. 
	 * 
	 * @return category name
	 * */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * Method to set category name
	 * @param categoryName
	 */
	public void setCategoryName(String categoryName) {
		if(categoryName == null){
			throw new NullPointerException("Null Category!");
		}
		this.categoryName = categoryName;
	}

	/** Return category name string
	 * @return category name
	 */
	@Override
	public String toString(){
		return categoryName;
	}
	
	// Constructor for testing purposes
	public Category(int i){
		this.categoryID = i;
		this.categoryName = "A test category";
	}
	
	// Constructor for testing purposes
	public Category(int categoryID, String categoryName){
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}
	/** Constructor
	 * 
	 * @param anotherCategory
	 */
	public Category(Category anotherCategory){
		this.categoryID = anotherCategory.getCategoryID();
		this.categoryName = new String(anotherCategory.getCategoryName());
	}
    /**
     * constructor
     */
	public Category() {
		categoryID = 0;
		categoryName = null;
	}
}
