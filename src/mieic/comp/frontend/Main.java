package mieic.comp.frontend;

import java.util.Scanner;

import javax.swing.JFrame;

import mieic.comp.graph.Graph;
import mieic.comp.parser.Dot2DotParser;

public class Main {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Please input the source file path: ");
		
		String filePath = s.nextLine();
		
		Graph graph = Dot2DotParser.parse(filePath);
		
		GraphEditor gui = new GraphEditor(graph);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.pack();
		gui.setVisible(true);
	}
}
