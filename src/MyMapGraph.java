import java.util.*;

public class MyMapGraph extends MapGraph{
	
	
	private GraphColoringState DFS(GraphColoringState first){
		Deque<GraphColoringState> open = new ArrayDeque<GraphColoringState>(); // a stack of open states
		open.add(first); // states to visit
		
		Set<GraphColoringState> close = new HashSet<GraphColoringState>(); // set of visited states
		
		while (!open.isEmpty()){
			GraphColoringState curState = (GraphColoringState) open.remove();
			
			if (curState.finished()) {
				return curState;
			}
			
			if (!close.contains(curState)){
				close.add(curState);
				GraphColoringIterator it = new GraphColoringIterator(curState);
				while(it.hasNext()){
					GraphColoringState pom = (GraphColoringState)it.next();
					if ((pom != null) && (!close.contains(pom))){
						open.add(pom);
					}
				}
			}
		}
		return null;
	}
	
	public void colorGraph(){
		Constants.init();
		
		GraphColoringState initState = new GraphColoringState(this, null);
		
		GraphColoringState result = DFS(initState);
		
		System.out.println(result);
		
		for(String state : result.coloring.keySet()){
			color(state, result.coloring.get(state));
		}
		
		/* ZACIATOK MIESTA PRE VAS KOD */
		/*
		// toto je len nezmyselna ukazka - postupne sa nafarbia vsetky staty nahodou farbou
		Double r;
		Random generator = new Random();
		
		String color;
		r = generator.nextDouble();
		if (r < 0.33) {color = "red";} else if (r < 0.66) {color = "green";} else {color = "blue";};
		color("Western Australia",color);
		r = generator.nextDouble();
		if (r < 0.33) {color = "red";} else if (r < 0.66) {color = "green";} else {color = "blue";};
		color("Northern Territory",color);
		r = generator.nextDouble();
		if (r < 0.33) {color = "red";} else if (r < 0.66) {color = "green";} else {color = "blue";};
		color("South Australia",color);
		r = generator.nextDouble();
		if (r < 0.33) {color = "red";} else if (r < 0.66) {color = "green";} else {color = "blue";};
		color("Queensland",color);
		r = generator.nextDouble();
		if (r < 0.33) {color = "red";} else if (r < 0.66) {color = "green";} else {color = "blue";};
		color("New South Wales",color);
		r = generator.nextDouble();
		if (r < 0.33) {color = "red";} else if (r < 0.66) {color = "green";} else {color = "blue";};
		color("Victoria",color);
		r = generator.nextDouble();
		if (r < 0.33) {color = "red";} else if (r < 0.66) {color = "green";} else {color = "blue";};
		color("Tasmania",color);
		*/
		/* KONIEC MIESTA PRE VAS KOD */
		
	}	
}