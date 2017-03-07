package model;

public class UserEntry {
	private Category category;
	private String fibersInWeave;
	private boolean selfDyedYarn;
	private boolean handspunYarn;
	private String otherDetails;
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getFibersInWeave() {
		return fibersInWeave;
	}
	public void setFibersInWeave(String fibersInWeave) {
		this.fibersInWeave = fibersInWeave;
	}
	public boolean isSelfDyedYarn() {
		return selfDyedYarn;
	}
	public void setSelfDyedYarn(boolean selfDyedYarn) {
		this.selfDyedYarn = selfDyedYarn;
	}
	public boolean isHandspunYarn() {
		return handspunYarn;
	}
	public void setHandspunYarn(boolean handspunYarn) {
		this.handspunYarn = handspunYarn;
	}
	public String getOtherDetails() {
		return otherDetails;
	}
	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}
}
