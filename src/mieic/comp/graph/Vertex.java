package mieic.comp.graph;

import java.util.ArrayList;
import java.util.Comparator;

public class Vertex implements Comparable<Vertex>{
	private ArrayList<Edge> edges;
	private String name;
	private double dist;
	private Vertex previous;
	private boolean visited;
	
	public Vertex(String name) throws AttributeAlreadyDefinedException {
		edges = new ArrayList<Edge>();
		NodeIDProvider.getInstance().setNodeId(this, name);
		this.name = name;
		dist =Double.POSITIVE_INFINITY;
		previous = null;
		visited = false;
	}

	public String getName() {
		return name;
	}

	public void addEdge(Edge e) {
		edges.add(e); // graph already verifies if the edge corresponds to this
						// vertex
	}

	public ArrayList<Edge> getDestinationEdges() {
		ArrayList<Edge> res = new ArrayList<>();
		for (Edge e : edges) {
			if (e.getDestination() != this) {
				res.add(e);
			}
		}
		return res;
	}

	public ArrayList<Edge> getStartEdges() {
		ArrayList<Edge> retEdges = new ArrayList<>();
		for (Edge e : edges) {
			if (e.getOrigin() == this) {
				retEdges.add(e);
			}
		}
		return retEdges;
	}

	public ArrayList<Edge> getEndEdges() {
		ArrayList<Edge> retEdges = new ArrayList<>();
		for (Edge e : edges) {
			if (e.getDestination() == this) {
				retEdges.add(e);
			}
		}
		return retEdges;
	}

	public ArrayList<Edge> getAllEdges() {
		return edges;
	}

	@Override
	public String toString() {
		return NodeIDProvider.getInstance().getVertexName(this);
	}

	public void addAttr(String key, String value)
			throws AttributeAlreadyDefinedException {
		if (key.equals("label")) {
			NodeLabelProvider.getInstance().setNodeLabel(this, value);
		} else {
			NodeAttributeProvider.getInstance().addAttribute(this, key, value);
		}
	}

	public double getDist() {
		return dist;
	}

	public void setDist(double dist) {
		this.dist = dist;
	}

	public Vertex getPrevious() {
		return previous;
	}

	public void setPrevious(Vertex previous) {
		this.previous = previous;
	}

	
	public boolean equals(Vertex v) {
		return name.equals(v.getName());
	}
	
	public ArrayList<Vertex> getNeighbours() {
		ArrayList<Vertex> neighbours = new ArrayList<>();
		for (int i = 0; i < edges.size(); i++) {
			Vertex v = (Vertex) edges.get(i).getDestination();
			if (!v.equals(this)) {
				neighbours.add(v);
			} else{
				neighbours.add((Vertex) edges.get(i).getOrigin());
			}
		}
		return neighbours;
	}

	@Override
	public int compareTo(Vertex other) {
		return Double.compare(dist, other.getDist());
	}
	
	public void setVisited(boolean b){
		visited = b;
	}
	
	public boolean isVisited() {
		return visited;
	}

}
