package mieic.comp.graph;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.ext.VertexNameProvider;

public class NodeLabelProvider implements VertexNameProvider<Vertex> {
	
	private static NodeLabelProvider instance = null;

	public static NodeLabelProvider getInstance() {
		if (instance == null) {
			instance = new NodeLabelProvider();
		}
		return instance;
	}
	
	private Map<Vertex, String> labels;

	private NodeLabelProvider() {
		labels = new HashMap<Vertex, String>();
	}

	@Override
	public String getVertexName(Vertex node) {
		return labels.get(node);
	}

	public void setNodeLabel(Vertex node, String label) throws AttributeAlreadyDefinedException {
		if (labels.get(node) != null) {
			String prevVal = labels.get(node);
			labels.put(node, label);
			throw new AttributeAlreadyDefinedException("label", prevVal, label);
		} else {
			labels.put(node, label);
		}
	}

}
