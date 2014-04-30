package mieic.comp.graph;

import java.util.ArrayList;

public class Vertex {
	ArrayList<Edge> edges;
	String name;

	public Vertex(String name) {
		edges = new ArrayList<Edge>();
		this.name = name;
	}
}
