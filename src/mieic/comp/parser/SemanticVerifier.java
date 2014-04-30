package mieic.comp.parser;

public class SemanticVerifier {
	
	private static SemanticVerifier verifier = null;
	
	public SemanticVerifier() {
		
	}
	
	public static SemanticVerifier getInstance() {
		if (verifier == null) {
			verifier = new SemanticVerifier();
		}
		
		return verifier;
	}
	
	public void parseNode(SimpleNode node) {
		try {
			node.parseChildren();
		} catch (SemanticException e) {
			System.exit(1);
		}
	}
}
