/* Generated By:JJTree: Do not edit this line. ASTIDStmt.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package mieic.comp.parser;

public class ASTIDStmt extends SimpleNode {

	private String id;

	public ASTIDStmt(int id) {
		super(id);
	}

	public ASTIDStmt(Dot2DotParser p, int id) {
		super(p, id);
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	@Override
	public void dump(String prefix) {
		System.out.println(toString(prefix) + ": " + id);
		if (children != null) {
			for (int i = 0; i < children.length; ++i) {
				SimpleNode n = (SimpleNode) children[i];
				if (n != null) {
					n.dump(prefix + " ");
				}
			}
		}
	}

}
/*
 * JavaCC - OriginalChecksum=63d1cd498214f6edcfe8a42a8a9b7106 (do not edit this
 * line)
 */
