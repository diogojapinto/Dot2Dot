package mieic.comp.graph;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import javax.swing.text.html.HTMLDocument.Iterator;
import javax.xml.crypto.NodeSetData;

import mieic.comp.parser.ASTGraph.GraphType;
import mieic.comp.parser.Node;
import mieic.comp.parser.SimpleNode;

public class Graph {

	public enum AttrScope {
		GRAPH, NODE, EDGE, OTHER
	};

	private GraphType type;

	private HashMap<String, Vertex> nodes;
	private ArrayList<Subgraph> subgraphs;
	private ArrayList<Edge> edges;
	private String name;
	private boolean isStrict;

	private HashMap<AttrScope, HashMap<String, String>> attributes;

	public Graph(String name, GraphType type, boolean strictness) {
		nodes = new HashMap<>();
		edges = new ArrayList<>();
		subgraphs = new ArrayList<>();
		attributes = new HashMap<>();

		attributes.put(AttrScope.GRAPH, new HashMap<String, String>());
		attributes.put(AttrScope.NODE, new HashMap<String, String>());
		attributes.put(AttrScope.EDGE, new HashMap<String, String>());
		attributes.put(AttrScope.OTHER, new HashMap<String, String>());

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
		if (subgraph.getName() != null) {
			for (Subgraph graph : subgraphs) {
				if (graph.getName() != null) {
					if (graph.getName().equals(subgraph.getName())) {
						subgraphs.remove(graph);
						break;
					}
				}
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
				&& !nodes.containsKey(((Vertex) origin).getName())
				|| destination instanceof Vertex
				&& !nodes.containsKey(((Vertex) origin).getName())) {
			throw new InexistentVertexException();

		} else if (origin instanceof Subgraph) {

			for (Subgraph sg : subgraphs) {
				if (!sg.getName().equals(((Subgraph) origin).getName())) {
					throw new InexistentVertexException();
				}
			}

		} else if (destination instanceof Subgraph) {
			for (Subgraph sg : subgraphs) {
				if (sg.getName() != null) {
					if (!sg.getName()
							.equals(((Subgraph) destination).getName())) {
						throw new InexistentVertexException();
					}
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
		ArrayList<Vertex> allNodes = new ArrayList<Vertex>(nodes.values());

		for (Subgraph sg : subgraphs) {
			allNodes.addAll(sg.getNodes());
		}

		return allNodes;
	}

	public void setAttribute(AttrScope scope, String key, String value)
			throws AttributeAlreadyDefinedException {

		String prevVal = attributes.get(scope).get(key);
		if (prevVal == null) {
			attributes.get(scope).put(key, value);
		} else {
			attributes.get(scope).put(key, value);
			throw new AttributeAlreadyDefinedException(key, prevVal, value);
		}

	}

	public void computePaths(Vertex source) {
		for (Vertex v : getNodes()) {
				v.setDist(Double.POSITIVE_INFINITY);
				v.setPrevious(null);
		}
		
		source.setDist(0);
		PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty()) {
			Vertex u = vertexQueue.poll();

			// Visit each edge exiting u
			for (Edge e : u.getDestinationEdges()) {
				Vertex v = (Vertex) e.getDestination();
				double weight = 1;
				try {
					if (EdgeAttributeProvider.getInstance()
							.getComponentAttributes(e).get("weight") != null) {
						weight = Double.parseDouble(EdgeAttributeProvider
								.getInstance().getComponentAttributes(e)
								.get("weight"));
					}
				} catch (NullPointerException e1) {
					
				}
				
				double distanceThroughU = u.getDist() + weight;
				if (distanceThroughU < v.getDist()) {
					vertexQueue.remove(v);
					v.setDist(distanceThroughU);
					v.setPrevious(u);
					vertexQueue.add(v);
				}
			}
		}
	}

	public ArrayList<Vertex> getShortestPathTo(Vertex target) {
		ArrayList<Vertex> path = new ArrayList<Vertex>();
		for (Vertex vertex = target; vertex != null; vertex = vertex
				.getPrevious())
			path.add(vertex);
		Collections.reverse(path);
		return path;
	}
	
	public HashSet<Edge> prim(String startPoint) {
		HashSet<Edge> edges = new HashSet<Edge>();
		nodes.get(startPoint).setVisited(true);
		
		do {
			HashSet<Vertex> visitedNodes = getVisitedNodes();
			Object[] vNodes = visitedNodes.toArray();
			HashSet<Edge> edgeList = new HashSet<Edge>();
			for(int i = 0; i < vNodes.length; i++) {
				Object[] egs = ((Vertex)vNodes[i]).getAllEdges().toArray();
				for(int j = 0; j < egs.length; j++) {
					if(!((Edge)egs[j]).isUsed()) {
					edgeList.add((Edge)egs[j]);
					}
				}
			}
			
			try {
				Edge tmp = Edge.getMinEdge(edgeList);
				tmp.setUsed(true);
				edges.add(tmp);
			} catch(Exception e) {
				
			}
		} while(isGraphVisited());
		
		return edges;
		
	}

	private HashSet<Vertex> getVisitedNodes() {
		HashSet<Vertex> visitedNodes = new HashSet<Vertex>();
		for (Map.Entry< String,Vertex > entry : nodes.entrySet()) {
			if(entry.getValue().isVisited()) {
				visitedNodes.add(entry.getValue());
			}
		}
		return visitedNodes;
	}

    public boolean isGraphVisited() {
    	for (Map.Entry< String,Vertex > entry : nodes.entrySet()) {
    		if(!entry.getValue().isVisited()) {
    			return true;
    		}
    	}
    	
    	return false;
    }
	
	public Vertex getVertex(String name) {
		return nodes.get(name);
	}
}
