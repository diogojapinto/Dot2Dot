package mieic.comp.graph;

import java.util.ArrayList;
import java.util.HashMap;

import mieic.comp.parser.ASTGraph.GraphType;

public class Graph {

	private GraphType type;

	private HashMap<String, Vertex> nodes;
	private ArrayList<Subgraph> subgraphs;
	private ArrayList<Edge> edges;
	private String name;
	private boolean isStrict;

	public Graph(String name, GraphType type, boolean strictness) {
		nodes = new HashMap<>();
		edges = new ArrayList<>();
		subgraphs = new ArrayList<>();

		this.name = name;
		this.type = type;
		isStrict = strictness;
	}

	/**
	 * 
	 * @param v
	 * @return true if the node was added (didn't exist)
	 */
	public Vertex addVertex(Vertex v) {
		Vertex node = nodes.get(v.getName());
		if (node != null) {
			return node;
		} else {
			nodes.put(v.getName(), v);
			return v;
		}
	}

	/**
	 * Removes a previous stored subgraph with the given id if exists
	 * 
	 * @param subgraph
	 * @return
	 */
	public Subgraph addSubgraph(Subgraph subgraph) {

		for (Subgraph graph : subgraphs) {
			if (graph.getName().equals(subgraph.getName())) {
				subgraphs.remove(graph);
				break;
			}
		}

		subgraphs.add(subgraph);
		return subgraph;
	}

	public <T, U> void addEdge(Edge<T, U> edge)
			throws InexistentVertexException, StrictIncoherenceException {

		T origin = edge.getOrigin();
		U destination = edge.getDestination();

		// verify if both vertexes exist
		if (origin instanceof Vertex
				&& nodes.containsKey(((Vertex) origin).getName())
				|| destination instanceof Vertex
				&& nodes.containsKey(((Vertex) origin).getName())) {

			throw new InexistentVertexException();

		} else if (origin instanceof Subgraph) {

			for (Subgraph sg : subgraphs) {
				if (sg.getName().equals(((Subgraph) origin).getName())) {
					throw new InexistentVertexException();
				}
			}

		} else if (destination instanceof Subgraph) {
			for (Subgraph sg : subgraphs) {
				if (sg.getName().equals(((Subgraph) origin).getName())) {
					throw new InexistentVertexException();
				}
			}
		}

		ArrayList<Edge> allEdges = getEdges();

		if (isStrict) {
			for (Edge e : allEdges) {
				if (e.getOrigin() == origin
						&& e.getDestination() == destination
						|| e.getOrigin() == destination
						&& e.getDestination() == origin) {
					throw new StrictIncoherenceException();
				}
			}
		}

		edges.add(edge);

		switch (type) {
		case GRAPH:
			if (origin instanceof Vertex && destination instanceof Vertex) {
				((Vertex) edge.getOrigin()).addEdge(edge);
			} else if (origin instanceof Vertex
					&& destination instanceof Subgraph) {
				for (Vertex v : ((Subgraph) destination).getNodes()) {
					Edge e = new Edge<Vertex, Vertex>((Vertex) origin, v, type);
					((Vertex) origin).addEdge(e);
				}
			} else if (origin instanceof Subgraph
					&& destination instanceof Vertex) {
				for (Vertex v : ((Subgraph) origin).getNodes()) {
					Edge e = new Edge<Vertex, Vertex>(v, (Vertex) destination,
							type);
					v.addEdge(e);
				}
			} else if (origin instanceof Subgraph
					&& destination instanceof Subgraph) {
				for (Vertex v1 : ((Subgraph) origin).getNodes()) {
					for (Vertex v2 : ((Subgraph) destination).getNodes()) {
						Edge e = new Edge<Vertex, Vertex>(v1, v2, type);
						v1.addEdge(e);
					}
				}
			}
			break;
		case DIGRAPH:
			if (origin instanceof Vertex && destination instanceof Vertex) {
				((Vertex) origin).addEdge(edge);
				((Vertex) destination).addEdge(edge);
			} else if (origin instanceof Vertex
					&& destination instanceof Subgraph) {
				for (Vertex v : ((Subgraph) destination).getNodes()) {
					Edge e = new Edge<Vertex, Vertex>((Vertex) origin, v, type);
					((Vertex) origin).addEdge(e);
					v.addEdge(e);
				}
			} else if (origin instanceof Subgraph
					&& destination instanceof Vertex) {
				for (Vertex v : ((Subgraph) origin).getNodes()) {
					Edge e = new Edge<Vertex, Vertex>(v, (Vertex) destination,
							type);
					v.addEdge(e);
					((Vertex) destination).addEdge(e);
				}
			} else if (origin instanceof Subgraph
					&& destination instanceof Subgraph) {
				for (Vertex v1 : ((Subgraph) origin).getNodes()) {
					for (Vertex v2 : ((Subgraph) destination).getNodes()) {
						Edge e = new Edge<Vertex, Vertex>(v1, v2, type);
						v1.addEdge(e);
						v2.addEdge(e);
					}
				}
			}
			break;
		}
	}

	public ArrayList<Edge> getEdges() {

		ArrayList<Edge> allEdges = (ArrayList<Edge>) edges.clone();

		for (Subgraph sg : subgraphs) {
			allEdges.addAll(sg.getEdges());
		}

		return allEdges;
	}

	public GraphType getType() {
		return type;
	}

	public boolean isStrict() {
		return isStrict;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Vertex> getNodes() {
		ArrayList<Vertex> allNodes = (ArrayList<Vertex>) nodes.clone();

		for (Subgraph sg : subgraphs) {
			allNodes.addAll(sg.getNodes());
		}

		return allNodes;
	}

}
