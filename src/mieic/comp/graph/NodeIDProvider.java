package mieic.comp.graph;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.ext.VertexNameProvider;

public class NodeIDProvider implements VertexNameProvider<Vertex> {
	
	private static NodeIDProvider instance = null;
	
	public static NodeIDProvider getInstance() {
		if (instance == null) {
			instance = new NodeIDProvider();
		}
		return instance;
	}
	
	private Map<Vertex, String> ids;

	private NodeIDProvider() {
		ids = new HashMap<Vertex, String>();
	}

	@Override
	public String getVertexName(Vertex node) {
		return ids.get(node);
	}

	public void setNodeId(Vertex node, String id) throws AttributeAlreadyDefinedException {
		if (ids.get(node) != null) {
			String prevVal = ids.get(node);
			ids.put(node, id);
			throw new AttributeAlreadyDefinedException("node id", prevVal, id);
		} else {
			ids.put(node, id);
		}
	}
}
