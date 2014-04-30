package mieic.comp.graph;

public class ContentProvider {
	private NodeIDProvider nodeIDProvider;
	private NodeLabelProvider nodeLabelProvider;
	private EdgeLabelProvider edgeLabelProvider;
	private NodeAttributeProvider nodeAttributeProvider;
	private EdgeAttributeProvider edgeAttributeProvider;
	
	private static ContentProvider instance = null;
	
	private ContentProvider() {
	}
	
	public static ContentProvider getInstance() {
		if (instance == null) {
			instance = new ContentProvider();
		}
		return instance;
	}
	
	// TODO: add "adders"
}
