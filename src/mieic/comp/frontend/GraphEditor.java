package mieic.comp.frontend;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import org.jgraph.JGraph;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.DOTExporter;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.ListenableDirectedGraph;
import org.jgrapht.graph.ListenableUndirectedGraph;

import com.jgraph.layout.JGraphFacade;
import com.jgraph.layout.graph.JGraphSimpleLayout;

import mieic.comp.graph.Edge;
import mieic.comp.graph.EdgeAttributeProvider;
import mieic.comp.graph.EdgeLabelProvider;
import mieic.comp.graph.Graph;
import mieic.comp.graph.NodeAttributeProvider;
import mieic.comp.graph.NodeIDProvider;
import mieic.comp.graph.NodeLabelProvider;
import mieic.comp.graph.Vertex;

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
				originalGraph.computePaths(originalGraph
						.getVertex((String) source.getSelectedItem()));
				ArrayList<Vertex> path = originalGraph
						.getShortestPathTo((originalGraph
								.getVertex((String) dest.getSelectedItem())));

				System.out.println(path.toString());
				JFrame shortPath = new JFrame("Shortest path from "
						+ source.getSelectedItem() + " to "
						+ dest.getSelectedItem());
				ListenableDirectedGraph<Vertex, Edge> editPath = new ListenableDirectedGraph<>(
						Edge.class);

				editPath = addComponents(path);

				JGraph graphPath = new JGraph(
						new JGraphModelAdapter<Vertex, Edge>(editPath));

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

	private ListenableDirectedGraph<Vertex, Edge> addComponents(
			ArrayList<Vertex> nodes) {

		ListenableDirectedGraph<Vertex, Edge> editable = new ListenableDirectedGraph<>(
				Edge.class);

		for (Vertex v : nodes) {
			editable.addVertex(v);
		}

		for (Vertex v : nodes) {
			ArrayList<Edge> edges = v.getStartEdges();
			for (Edge e : edges) {
				if (nodes.contains((Vertex)e.getDestination())) {
					editable.addEdge((Vertex) e.getOrigin(),
							(Vertex) e.getDestination(), e);
				}
			}
		}
		return editable;
	}
}
