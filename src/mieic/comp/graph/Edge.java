package mieic.comp.graph;

import mieic.comp.parser.ASTGraph.GraphType;

public class Edge<T, U> {
	private T origin;
	private U destination;
	
	private GraphType edgeType;
	
	public Edge(T origin, U destination, GraphType type) {
		this.origin = origin;
		this.destination = destination;
		this.edgeType = type;
	}
	
	public void setLabel(String label) throws AttributeAlreadyDefinedException {
		EdgeLabelProvider.getInstance().setEdgeLabel(this, label);
	}
	
	public void addAttribute(String key, String value) {
		
	}

	public T getOrigin() {
		return origin;
	}

	public U getDestination() {
		return destination;
	}
}
