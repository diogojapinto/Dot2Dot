/* Generated By:JJTree: Do not edit this line. ASTAssignStmt.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package mieic.comp.parser;

import mieic.comp.graph.AttributeAlreadyDefinedException;
import mieic.comp.graph.Graph;
import mieic.comp.graph.Graph.AttrScope;

public class ASTAssignStmt extends SimpleNode {
	public ASTAssignStmt(int id) {
		super(id);
	}

	public ASTAssignStmt(Dot2DotParser p, int id) {
		super(p, id);
	}

	public void parse(Graph graph, String key) throws SemanticException {
		if (children.length != 1 || !(children[0] instanceof ASTIDStmt)) {
			throw new SemanticException(
					"Invalid statement: Invalid assignment operation");
		}

		try {
			graph.setAttribute(AttrScope.OTHER, key,
					((ASTIDStmt) children[0]).getId());
		} catch (AttributeAlreadyDefinedException e) {
			e.printMessage();
		}
	}

}
/*
 * JavaCC - OriginalChecksum=011af0b095106eda959e3563417dbf4e (do not edit this
 * line)
 */
