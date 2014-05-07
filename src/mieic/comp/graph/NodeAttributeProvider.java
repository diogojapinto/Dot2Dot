package mieic.comp.graph;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.ext.ComponentAttributeProvider;

public class NodeAttributeProvider implements ComponentAttributeProvider<Vertex> {
	
	private static NodeAttributeProvider instance = null;

	public static NodeAttributeProvider getInstance() {
		if (instance == null) {
			instance = new NodeAttributeProvider();
		}
		return instance;
	}
	
	private HashMap<Vertex, HashMap<String, String>> nodesAttributes;
	
	private NodeAttributeProvider() {
		nodesAttributes = new HashMap<>();
	}

	@Override
	public Map<String, String> getComponentAttributes(Vertex v) {
		return nodesAttributes.get(v);
	}
	
	public void addAttribute(Vertex vertex, String key, String value)
			throws AttributeAlreadyDefinedException {
		HashMap<String, String> attributes = nodesAttributes.get(vertex);
		if (attributes == null) {
			attributes = new HashMap<>();
			nodesAttributes.put(vertex, attributes);
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
