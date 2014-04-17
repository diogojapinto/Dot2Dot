package graph;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.ext.EdgeNameProvider;

public class EdgeLabelProvider implements EdgeNameProvider<Edge> {
	private Map<Edge, String> labels;

	public EdgeLabelProvider() {
		labels = new HashMap<Edge, String>();
	}

	public boolean setEdgeLabel(Edge edge, String id) {
		if (labels.get(edge) != null) {
			return false;
		} else {
			labels.put(edge, id);
			return true;
		}
	}
	
	@Override
	public String getEdgeName(Edge edge) {
		return labels.get(edge);
	}

}
