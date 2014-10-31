import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class GraphColoringIterator implements Iterator{

	int counter;
	Queue<GraphColoringState> orderedNeighStates;
	
	public GraphColoringIterator(GraphColoringState coloring){
		HashSet<Pair<String, String>> used = new HashSet<Pair<String, String>>(); // colorings already added to queue
		
		orderedNeighStates = new LinkedList<GraphColoringState>(); // list of returned states ordered by constraint demanding
		
		
		// nacpeme si do fronty susedne stavy zoradene podla toho, kolko constraints nam zrusia
		while (true){
			// initialize variables to find least constraint demanding state
			String leastConstraintColor = null;
			String leastConstraintState = null;
			int minConstraintCount = 1000;
		
			// skusame vsetky dvojice stat, farba
			for (MapNode state : coloring.graph.states){
				for (String color : Constants.colors){
					if (coloring.canColor(state.GetName(), color) &&
							coloring.getImpact(state.GetName(), color) < minConstraintCount && 
							!used.contains(new Pair<String, String>(state.GetName(), color))){
						minConstraintCount = coloring.getImpact(state.GetName(), color);
						leastConstraintColor = color;
						leastConstraintState = state.GetName();
					}
				}
			}
		
			if (minConstraintCount == 1000) break; // no least constraint state found
		
			used.add(new Pair<String, String>(leastConstraintState, leastConstraintColor));
		
			// create a copy of the current state and modify it
			GraphColoringState pom = new GraphColoringState(coloring.graph, coloring.coloring);
			pom.color(leastConstraintState, leastConstraintColor);
			
			orderedNeighStates.add(pom);
		}
	}
	
	@Override
	public boolean hasNext() {
		return !orderedNeighStates.isEmpty();
	}

	@Override
	public GraphColoringState next() {
		return orderedNeighStates.remove(); // returns next state in the ordered list
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
	}

}
