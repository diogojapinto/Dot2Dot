package mieic.comp.graph;

import java.util.ArrayList;

public class Vertex {
	private ArrayList<Edge> edges;
	private String name;

	public Vertex(String name) throws AttributeAlreadyDefinedException {
		edges = new ArrayList<Edge>();
		NodeIDProvider.getInstance().setNodeId(this, name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addEdge(Edge e) {
		edges.add(e); // graph already verifies if the edge corresponds to this
						// vertex
	}

	public boolean hasDestination(Vertex v) {

		for (Edge e : edges) {
			if (e.getOrigin() == this && e.getDestination() == v
					|| e.getOrigin() == v) {
				return true;
			}
		}
		
		return false;
	}
}
