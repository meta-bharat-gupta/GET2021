package jdbc_assignment;

public class Category {

	private int categoryId;
	private String categoryName;
	private int childCategoryCount;
	
	/**
	 * Constructor for category class
	 * @param cid
	 * 			integer of category Id
	 * @param cname
	 * 			String of category name
	 * @param children
	 * 			int of number of child categories
	 */
	public Category(int cid, String cname, int children){
		this.categoryId = cid;
		this.categoryName = cname;
		this.childCategoryCount = children;
	}
	
	/**
	 * toString function to return the details of category object
	 */
	public String toString(){
		return "Category Id: "+this.categoryId +" , Category Name: "+this.categoryName
				+" , Child Category Count: "+this.childCategoryCount;
	}

	// Getters and Setters for class attributes
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getChildCategoryCount() {
		return childCategoryCount;
	}

	public void setChildCategoryCount(int childCategoryCount) {
		this.childCategoryCount = childCategoryCount;
	}
	
}
