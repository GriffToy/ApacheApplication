package model;

public class UserEntry {
	public WeaveEvent weaveEvent;
	public Category category;
	private String fibersInWeave;
	private boolean selfDyedYarn;
	private boolean handspunYarn;
	private String otherDetails;


	public UserEntry(WeaveEvent wv) {
		weaveEvent = wv;
	}

	public UserEntry() {
		weaveEvent = null;
		category = new Category();
		fibersInWeave = null;
		selfDyedYarn = false;
		handspunYarn = false;
		otherDetails = null;
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
}
