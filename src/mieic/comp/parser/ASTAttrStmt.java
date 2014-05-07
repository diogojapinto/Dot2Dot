/* Generated By:JJTree: Do not edit this line. ASTAttrStmt.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package mieic.comp.parser;

import mieic.comp.graph.AttributeAlreadyDefinedException;
import mieic.comp.graph.Graph;
import mieic.comp.graph.Graph.AttrScope;

public class ASTAttrStmt extends SimpleNode {

	public enum attrsScope {
		GRAPH, NODE, EDGE
	};

	private attrsScope scope;

	public ASTAttrStmt(int id) {
		super(id);
	}

	public ASTAttrStmt(Dot2DotParser p, int id) {
		super(p, id);
	}

	public void setScope(attrsScope scope) {
		this.scope = scope;
	}

	@Override
	public void dump(String prefix) {
		System.out.println(toString(prefix) + ": " + scope);
		if (children != null) {
			for (int i = 0; i < children.length; ++i) {
				SimpleNode n = (SimpleNode) children[i];
				if (n != null) {
					n.dump(prefix + " ");
				}
			}
		}
	}

	public void parse(Graph graph) {
		
		AttrScope scope = null;
		
		switch (this.scope) {
		case GRAPH:
			scope = AttrScope.GRAPH;
			break;
		case NODE:
			scope = AttrScope.NODE;
			break;
		case EDGE:
			scope = AttrScope.EDGE;
			break;
		default:
			scope = AttrScope.OTHER;
			break;
		}
		
		for (ASTAttribute attr : (ASTAttribute[]) children) {
			String[] params = attr.getAttrParams();
			try {
				graph.setAttribute(scope, params[0], params[1]);
			} catch (AttributeAlreadyDefinedException e) {
				e.printMessage();
			}
		}
	}

}
/*
 * JavaCC - OriginalChecksum=7330b35c3be4b120ece2283996b69ff8 (do not edit this
 * line)
 */
