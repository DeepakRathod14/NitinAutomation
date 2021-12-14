package nitin.automation.beans;

public class GlobalContextAttribute {

	private Object attribute;
	
	public void setAttribute(Object attribute) {
		this.attribute = attribute;
	}
	
	public Object getAttribute() { return this.attribute; }
}
