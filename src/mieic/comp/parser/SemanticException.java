package mieic.comp.parser;

public class SemanticException extends Exception {
	
	private String messg;
	
	public SemanticException(String messg) {
		this.messg = messg;
	}
	
	public String toString() {
		return "Semantic exception: " + messg;
	}
}
