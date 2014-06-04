package mieic.comp.frontend;

import com.jgraph.layout.JGraphFacade;
import com.jgraph.layout.graph.JGraphSimpleLayout;
import mieic.comp.graph.*;
import mieic.comp.parser.ASTGraph.GraphType;
import org.jgraph.JGraph;
import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.DOTExporter;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.ListenableDirectedGraph;
import org.jgrapht.graph.ListenableUndirectedGraph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class GraphEditor extends JFrame {

	private static final int WIDTH = 1024;
	private static final int HEIGHT = 768;

	private Graph originalGraph;
	private ListenableGraph<Vertex, Edge> editGraph;

	public GraphEditor(Graph graph) {
		super();
		if (graph.getName() == null) {
			this.setTitle("Graph Editor");
		} else {
			this.setTitle("Graph Editor - " + graph.getName());
		}

		originalGraph = graph;

		initGUI();
	}

	private void initGUI() {
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);

		switch (originalGraph.getType()) {
		case DIGRAPH:
			editGraph = new ListenableDirectedGraph<>(Edge.class);
			break;
		case GRAPH:
			editGraph = new ListenableUndirectedGraph<>(Edge.class);
			break;
		}

		JGraph jgraph = new JGraph(new JGraphModelAdapter<Vertex, Edge>(
				editGraph));

		getContentPane().add(jgraph);

		addComponents();

		jgraph.setAlignmentX(CENTER_ALIGNMENT);
		jgraph.setAlignmentY(CENTER_ALIGNMENT);

		JGraphFacade facade = new JGraphFacade(jgraph);
		new JGraphSimpleLayout(JGraphSimpleLayout.TYPE_CIRCLE, 100, 100)
				.run(facade);

		Map nestedMap = facade.createNestedMap(true, true);
		jgraph.getGraphLayoutCache().edit(nestedMap);

		setLayout(new FlowLayout(FlowLayout.LEFT));
		// add button for export
		JButton button = new JButton("Export");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				DOTExporter<Vertex, Edge> exporter = new DOTExporter<>(
						NodeIDProvider.getInstance(), NodeLabelProvider
								.getInstance(),
						EdgeLabelProvider.getInstance(), NodeAttributeProvider
								.getInstance(), EdgeAttributeProvider
								.getInstance());

				String fileName;
				if (originalGraph.getName() != null) {
					fileName = originalGraph.getName() + ".dot";
				} else {
					fileName = "exported_graph.dot";
				}

				File f = new File(fileName);
				try {
					f.createNewFile();
					System.out.println("\n\nCreated file for export!");
				} catch (IOException e) {
					e.printStackTrace();
				}

				try {
					Writer writer = new PrintWriter(f);

					exporter.export(writer, editGraph);
					System.out.println("Exported Successfully!");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					System.out.println("Error Exporting!");
				}
			}
		});
		getContentPane().add(button);

		if (originalGraph.getType() == GraphType.DIGRAPH) {
			getShortestPathUI();
		}

		if (originalGraph.getType() == GraphType.GRAPH) {
			getMinimumSpanUI();
		}
	}

	private void getMinimumSpanUI() {
		final JComboBox<String> source = new JComboBox<>();

		for (Vertex v : originalGraph.getNodes()) {
			source.addItem(v.getName());
		}

		getContentPane().add(source);

		JButton minimumSpan = new JButton("Get Minimum span tree");

		minimumSpan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showMinimumSpanTree((String) source.getSelectedItem());
			}

		});

		getContentPane().add(minimumSpan);
	}

	private void showMinimumSpanTree(String source) {
		HashSet<Edge> spanTree = originalGraph.prim(source);

        Object[] arr = spanTree.toArray();

        for(int i = 0; i < arr.length; i++) {
            System.out.println(((Edge)arr[i]).getOrigin().toString() + " - > " + ((Edge)arr[i]).getDestination().toString());
        }


		JFrame minimumSpanTree = new JFrame("Minimum Spanning Tree from "
				+ source);
		ListenableUndirectedGraph<Vertex, Edge> editPath = null;

		editPath = addComponentsSpan(spanTree);

		JGraph graphSpan = new JGraph(new JGraphModelAdapter<Vertex, Edge>(
				editPath));

		minimumSpanTree.getContentPane().add(graphSpan);

		graphSpan.setAlignmentX(CENTER_ALIGNMENT);
		graphSpan.setAlignmentY(CENTER_ALIGNMENT);

		JGraphFacade facadeSpan = new JGraphFacade(graphSpan);
		new JGraphSimpleLayout(JGraphSimpleLayout.TYPE_CIRCLE, 100, 100)
				.run(facadeSpan);

		Map nestedMapPath = facadeSpan.createNestedMap(true, true);
		graphSpan.getGraphLayoutCache().edit(nestedMapPath);

		setLayout(new FlowLayout(FlowLayout.LEFT));

		minimumSpanTree.pack();
		minimumSpanTree.setVisible(true);
	}

	private ListenableUndirectedGraph<Vertex, Edge> addComponentsSpan(
			HashSet<Edge> spanTree) {

		ListenableUndirectedGraph<Vertex, Edge> editable = new ListenableUndirectedGraph<>(
				Edge.class);

		ArrayList<Vertex> nodes = originalGraph.getNodes();

		for (Vertex v : nodes) {
			editable.addVertex(v);
		}

		for (Edge e : spanTree) {
			editable.addEdge((Vertex) e.getOrigin(),
					(Vertex) e.getDestination(), e);
		}

		return editable;
	}

	private void getShortestPathUI() {
		final JComboBox<String> source = new JComboBox<>();
		final JComboBox<String> dest = new JComboBox<>();

		for (Vertex v : originalGraph.getNodes()) {
			source.addItem(v.getName());
			dest.addItem(v.getName());
		}

		getContentPane().add(source);
		getContentPane().add(dest);

		JButton shortPath = new JButton("Get Shortest path");

		shortPath.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showShortestPath(source, dest);
			}

		});

		getContentPane().add(shortPath);
	}

	private void addComponents() {
		ArrayList<Vertex> nodes = originalGraph.getNodes();

		for (Vertex v : nodes) {
			editGraph.addVertex(v);
		}

		for (Vertex v : nodes) {
			ArrayList<Edge> edges = v.getStartEdges();
			for (Edge e : edges) {
				editGraph.addEdge((Vertex) e.getOrigin(),
						(Vertex) e.getDestination(), e);
			}
		}
	}

	private ListenableDirectedGraph<Vertex, Edge> addComponentsShort(
			ArrayList<Vertex> nodes) {

		ListenableDirectedGraph<Vertex, Edge> editable = new ListenableDirectedGraph<>(
				Edge.class);

		for (Vertex v : nodes) {
			editable.addVertex(v);
		}

		Edge edge = null;
		double minWeight = Double.POSITIVE_INFINITY;
		for (int i = 0; i < nodes.size(); i++) {
			Vertex v = nodes.get(i);
			ArrayList<Edge> edges = v.getStartEdges();
			for (Edge e : edges) {
				if (nodes.contains((Vertex) e.getDestination())
						&& ((Vertex) e.getDestination()).equals(nodes
								.get(i + 1))) {
					double weight = 1;
					try {
						if (EdgeAttributeProvider.getInstance()
								.getComponentAttributes(e).get("weight") != null) {
							weight = Double.parseDouble(EdgeAttributeProvider
									.getInstance().getComponentAttributes(e)
									.get("weight"));
						}
					} catch (NullPointerException e1) {
					}

					if (weight < minWeight) {
						minWeight = weight;
						edge = e;
					}
				}
			}
			minWeight = Double.POSITIVE_INFINITY;
			if (edge != null) {
				editable.addEdge((Vertex) edge.getOrigin(),
						(Vertex) edge.getDestination(), edge);
				edge = null;
			}
		}
		return editable;
	}

	private void showShortestPath(final JComboBox<String> source,
			final JComboBox<String> dest) {
		originalGraph.computePaths(originalGraph.getVertex((String) source
				.getSelectedItem()));
		ArrayList<Vertex> path = originalGraph.getShortestPathTo((originalGraph
				.getVertex((String) dest.getSelectedItem())));

		JFrame shortPath = new JFrame("Shortest path from "
				+ source.getSelectedItem() + " to " + dest.getSelectedItem());
		ListenableDirectedGraph<Vertex, Edge> editPath = null;

		editPath = addComponentsShort(path);

		JGraph graphPath = new JGraph(new JGraphModelAdapter<Vertex, Edge>(
				editPath));

		shortPath.getContentPane().add(graphPath);

		graphPath.setAlignmentX(CENTER_ALIGNMENT);
		graphPath.setAlignmentY(CENTER_ALIGNMENT);

		JGraphFacade facadePath = new JGraphFacade(graphPath);
		new JGraphSimpleLayout(JGraphSimpleLayout.TYPE_CIRCLE, 100, 100)
				.run(facadePath);

		Map nestedMapPath = facadePath.createNestedMap(true, true);
		graphPath.getGraphLayoutCache().edit(nestedMapPath);

		setLayout(new FlowLayout(FlowLayout.LEFT));

		shortPath.pack();
		shortPath.setVisible(true);
	}
}
