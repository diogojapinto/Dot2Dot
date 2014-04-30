package mieic.comp.graph;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.ext.VertexNameProvider;

public class NodeLabelProvider implements VertexNameProvider<Vertex> {
	private Map<Vertex, String> labels;

	public NodeLabelProvider() {
		labels = new HashMap<Vertex, String>();
	}

	@Override
	public String getVertexName(Vertex node) {
		return labels.get(node);
	}

	public boolean setNodeLabel(Vertex node, String label) {
		if (labels.get(node) != null) {
			return false;
		} else {
			labels.put(node, label);
			return true;
		}
	}

}
