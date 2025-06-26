
public class DiscussionGroups {
	
	private String topic;
	private int memberQuantity;
	
	public DiscussionGroups(String topic, int memberQuantity) {
		this.topic = topic;
		this.memberQuantity = memberQuantity;
	}

	public String getTopic() {
		return topic;
	}

	public int getMemberQuantity() {
		return memberQuantity;
	}
	public void discussionGroupDisplay() {
		System.out.println("Topic: " + topic);
		System.out.println("Member Quantity: " + memberQuantity);
	}
	

}
