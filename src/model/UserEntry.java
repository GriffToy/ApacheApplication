package model;

public class UserEntry {
	private String entryName;
	private WeaveEvent weaveEvent;
	private String category;
	private String fibersInWeave;
	private boolean selfDyedYarn;
	private boolean handspunYarn;
	private String otherDetails;
	
	public UserEntry(WeaveEvent weaveEvent){
		this.entryName = "Some name";
		this.weaveEvent = weaveEvent;
		this.category = "Testing";
		this.fibersInWeave = "Testing 1";
		this.otherDetails = "Testing 123 Testing 123 Testing 123 Testing 123 Testing 123 Testing 123 Testing 123 Testing 123";
	}
	
	public String getEntryName() {
		return entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	public WeaveEvent getWeaveEvent() {
		return weaveEvent;
	}
	public void setWeaveEvent(WeaveEvent weaveEvent) {
		this.weaveEvent = weaveEvent;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
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
