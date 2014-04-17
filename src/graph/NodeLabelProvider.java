package graph;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.ext.VertexNameProvider;

public class NodeLabelProvider implements VertexNameProvider<Node> {
	private Map<Node, String> labels;

	public NodeLabelProvider() {
		labels = new HashMap<Node, String>();
	}

	@Override
	public String getVertexName(Node node) {
		return labels.get(node);
	}

	public boolean setNodeLabel(Node node, String label) {
		if (labels.get(node) != null) {
			return false;
		} else {
			labels.put(node, label);
			return true;
		}
	}

}
