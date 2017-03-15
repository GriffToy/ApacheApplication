package model;

public class UserEntry {
	private WeaveEvent weaveEvent;
	private Category category;
	private String fibersInWeave;
	private boolean selfDyedYarn;
	private boolean handspunYarn;
	private String otherDetails;
	private User regUser;
	
	public UserEntry(WeaveEvent weaveEvent, User user){
		this.weaveEvent = weaveEvent;
		this.category = new Category();
		this.setRegUser(user);
		handspunYarn = false;
		selfDyedYarn = false;
		this.fibersInWeave = "Testing 1";
		this.otherDetails = "Testing 123 Testing 123 Testing 123 Testing 123 Testing 123 Testing 123 Testing 123 Testing 123";
	}
	
	
	
	@Override
	public String toString(){
		if(weaveEvent != null && category != null){
			return weaveEvent.toString() + ": " + category.toString();
		}
		else if(weaveEvent != null){
			return weaveEvent.toString();
		}
		else
			return "None";
	}

	public WeaveEvent getWeaveEvent() {
		return weaveEvent;
	}
	public void setWeaveEvent(WeaveEvent weaveEvent) {
		this.weaveEvent = weaveEvent;
	}
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



	public User getRegUser() {
		return regUser;
	}



	public void setRegUser(User regUser) {
		this.regUser = regUser;
	}
}
