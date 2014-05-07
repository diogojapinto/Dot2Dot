package mieic.comp.graph;

public class AttributeAlreadyDefinedException extends Exception {
	public String key;
	public String prevVal;
	public String newVal;

	public AttributeAlreadyDefinedException(String key, String prevVal, String newVal) {
		this.key = key;
		this.prevVal = prevVal;
		this.newVal = newVal;
	}

	public void printMessage () {
		System.err.println("The value of " + key + " has been overwriten from " + prevVal + " to " + newVal);
	}
}