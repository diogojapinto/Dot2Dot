package mieic.comp.graph;

import org.jgraph.graph.DefaultEdge;

import mieic.comp.parser.ASTGraph.GraphType;

public class Edge<T, U> extends DefaultEdge {
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

	public void addAttribute(String key, String value) throws AttributeAlreadyDefinedException {
		if (key.equals("label")) {
			EdgeLabelProvider.getInstance().setEdgeLabel(this, value);
		} else {
			EdgeAttributeProvider.getInstance().addAttribute(this, key, value);
		}
	}

	public T getOrigin() {
		return origin;
	}

	public U getDestination() {
		return destination;
	}

	@Override
	public String toString() {
		return EdgeLabelProvider.getInstance().getEdgeName(this);
	}
}
