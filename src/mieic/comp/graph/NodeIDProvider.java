package mieic.comp.graph;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.ext.VertexNameProvider;

public class NodeIDProvider implements VertexNameProvider<Vertex> {
	private Map<Vertex, String> ids;

	public NodeIDProvider() {
		ids = new HashMap<Vertex, String>();
	}

	@Override
	public String getVertexName(Vertex node) {
		return ids.get(node);
	}

	public boolean setNodeLabel(Vertex node, String id) {
		if (ids.get(node) != null) {
			return false;
		} else {
			ids.put(node, id);
			return true;
		}
	}
}
