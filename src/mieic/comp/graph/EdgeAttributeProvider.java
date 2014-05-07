package mieic.comp.graph;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.ext.ComponentAttributeProvider;

public class EdgeAttributeProvider implements ComponentAttributeProvider<Edge> {

	private static EdgeAttributeProvider instance = null;

	public static EdgeAttributeProvider getInstance() {
		if (instance == null) {
			instance = new EdgeAttributeProvider();
		}
		return instance;
	}

	HashMap<Edge, HashMap<String, String>> edgesAttributes;

	private EdgeAttributeProvider() {
		edgesAttributes = new HashMap<>();
	}

	@Override
	public Map<String, String> getComponentAttributes(Edge edge) {
		return edgesAttributes.get(edge);
	}

	public void addAttribute(Edge edge, String key, String value)
			throws AttributeAlreadyDefinedException {
		HashMap<String, String> attributes = edgesAttributes.get(edge);
		if (attributes == null) {
			attributes = new HashMap<>();
			edgesAttributes.put(edge, attributes);
			attributes.put(key, value);
		} else {
			// check if attribute already exists
			String prevVal = attributes.get(key);
			if (prevVal == null) {
				attributes.put(key, value);
			} else {
				attributes.put(key, value);
				throw new AttributeAlreadyDefinedException(key, prevVal, value);
			}
		}
	}
}
