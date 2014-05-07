package mieic.comp.graph;

import java.util.ArrayList;

public class Subgraph extends Graph {
	private Graph parent;

	public Subgraph(String id, Graph parent) {
		super(id, parent.getType(), parent.isStrict());
		this.parent = parent;
	}
}
