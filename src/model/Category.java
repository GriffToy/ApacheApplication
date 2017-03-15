package model;

public class Category {
	private int categoryID;
	private String categoryName;
	private int categoryEvent;
	
	public Category(int categoryID, String categoryName, int event){
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.categoryEvent = event;
	}
	
	
	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString(){
		return categoryName;
	}
	
	// Constructor for testing purposes
	public Category(){
		this.categoryID = -1;
		this.categoryName = "A test category";
	}
	
	// Constructor for testing purposes
	public Category(int categoryID, String categoryName){
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}
	
	public Category(Category anotherCategory){
		this.categoryID = anotherCategory.getCategoryID();
		this.categoryName = new String(anotherCategory.getCategoryName());
	}
}
