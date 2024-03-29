/* Generated By:JJTree: Do not edit this line. ASTNodeStmt.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package mieic.comp.parser;

public class ASTNodeStmt extends SimpleNode {
	
	private String nodeId;
	
	public ASTNodeStmt(int id) {
		super(id);
	}

	public ASTNodeStmt(Dot2DotParser p, int id) {
		super(p, id);
	}
	
	public void setNodeId(String id) {
		nodeId = id;
	}
	
	public String getNodeId() {
		return nodeId;
	}
	
	@Override
	public void dump(String prefix) {
		System.out.println(toString(prefix) + ": " + nodeId);
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
 * JavaCC - OriginalChecksum=8fae7d14e713e12615343a75082a9bcc (do not edit this
 * line)
 */
