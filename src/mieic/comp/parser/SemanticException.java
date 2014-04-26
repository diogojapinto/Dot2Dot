package mieic.comp.parser;

public class SemanticException extends Exception {
	
	private String messg;
	
	public SemanticException(String messg) {
		
	}
	
	public String toString() {
		return messg;
	}
}
