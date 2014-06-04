package mieic.comp.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

import org.jgraph.graph.DefaultEdge;

import mieic.comp.parser.ASTGraph.GraphType;

public class Edge<T, U> extends DefaultEdge {
	private T origin;
	private U destination;
	private boolean isUsed;
	private GraphType edgeType;

	public Edge(T origin, U destination, GraphType type) {
		this.origin = origin;
		this.destination = destination;
		this.edgeType = type;
		isUsed = false;
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
	
	public boolean areNodesVisited() {
		return (((Vertex)origin).isVisited() && ((Vertex)destination).isVisited());
	}
	public double getWeight() {
		try {
			String weightStr = EdgeAttributeProvider.getInstance().getComponentAttributes(this).get("weight");
			return Double.parseDouble(weightStr);
		} catch (NullPointerException e) {
			return 1;
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
	
	public static Edge getMinEdge(HashSet<Edge> edges) {
		Edge edge = null, tmpEdge = null;
		double minWeight = Double.POSITIVE_INFINITY;
		Object[] tmp = edges.toArray();
		for(int i = 0; i < tmp.length; i++) {
			tmpEdge = (Edge)tmp[i];
			if(tmpEdge.getWeight() < minWeight && !tmpEdge.areNodesVisited() && !tmpEdge.isUsed()) {
				System.out.println("CENAS");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				minWeight = tmpEdge.getWeight();
				edge = tmpEdge;
			}
		}
		
		return edge;
	}
	
	public void setUsed(boolean b) {
		isUsed = b;
		System.out.println("oriGIN");
		((Vertex)origin).setVisited(true);
		System.out.println("DEST");
		((Vertex)destination).setVisited(true);
	}
	
	public boolean isUsed() {
		return isUsed;
	}
	
}
