public class Dot2DotAttr {
	private String name;
	/**
	 * E - edges N - nodes G - graph S - subgraph C - cluster
	 */
	private Boolean[] usedBy = null;
	private String type;
	private String dflt;
	private String minimum;

	public Dot2DotAttr(Boolean[] u, String t, String d, String m) {
		usedBy = u;
		type = t;
		dflt = d;
		minimum = m;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean[] getUsedBy() {
		return usedBy;
	}

	public void setUsedBy(Boolean[] u) {
		usedBy = u;
	}

	public String getType() {
		return type;
	}

	public void setType(String t) {
		type = t;
	}

	public String getDefault() {
		return dflt;
	}

	public void setDefault(String d) {
		dflt = d;
	}

	public String getMinimum() {
		return minimum;
	}

	public void setMinimum(String m) {
		minimum = m;
	}

}