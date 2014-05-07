package mieic.comp.graph;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.ext.EdgeNameProvider;

public class EdgeLabelProvider implements EdgeNameProvider<Edge> {
	
	private static EdgeLabelProvider instance = null;

	public static EdgeLabelProvider getInstance() {
		if (instance == null) {
			instance = new EdgeLabelProvider();
		}
		return instance;
	}
	
	private Map<Edge, String> labels;

	private EdgeLabelProvider() {
		labels = new HashMap<Edge, String>();
	}

	public void setEdgeLabel(Edge edge, String id) throws AttributeAlreadyDefinedException {
		if (labels.get(edge) != null) {
			String prevVal = labels.get(edge);
			labels.put(edge, id);
			throw new AttributeAlreadyDefinedException("label", prevVal, id);
		} else {
			labels.put(edge, id);
		}
	}
	
	@Override
	public String getEdgeName(Edge edge) {
		return labels.get(edge);
	}

}
