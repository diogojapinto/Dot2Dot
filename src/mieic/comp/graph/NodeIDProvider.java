package mieic.comp.graph;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.ext.VertexNameProvider;

public class NodeIDProvider implements VertexNameProvider<Node> {
	private Map<Node, String> ids;

	public NodeIDProvider() {
		ids = new HashMap<Node, String>();
	}

	@Override
	public String getVertexName(Node node) {
		return ids.get(node);
	}

	public boolean setNodeLabel(Node node, String id) {
		if (ids.get(node) != null) {
			return false;
		} else {
			ids.put(node, id);
			return true;
		}
	}
}
