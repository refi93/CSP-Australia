import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class GraphColoringState {
	
	MapGraph graph;
	public HashMap<String, String> coloring;
	
	
	public GraphColoringState(MapGraph graph, HashMap<String, String> coloring){
		this.graph = graph;
		
		if (coloring == null){
			this.coloring = new HashMap<String, String>();
		}
		else{ // deep copy of coloring
			this.coloring = new HashMap<String, String>();
			for (String state : coloring.keySet()){
				this.coloring.put(state, coloring.get(state));
			}
		}
		
	}
	
	
	// returns possibilities for a state in the coloring
	public HashSet<String> getPossibilitiesFor(String state){
		HashSet<String> ret = new HashSet<String>();
		
		//System.out.println(coloring.size());
		if (coloring.get(state) != null) return ret;
		
		for(int i = 0;i < Constants.colors.size(); i++){
			ret.add(Constants.colors.get(i));
		}
		
		for (int i = 0;i < graph.states.length; i++){
			if (graph.isBorder(state, graph.states[i].GetName())){
				ret.remove(coloring.get(graph.states[i].GetName()));
			}
		}
		return ret;
	}
	
	public boolean canColor(String state, String color){
		if (coloring.get(state) != null){ // state has already a color
			return false;
		}
		
		return getPossibilitiesFor(state).contains(color);
	}
	
	// returns, how many possibilities we cancel coloring a state
	public int getImpact(String state, String color){
		int ret = 0;
		
		if (coloring.get(state) != null) return 10000000;
		
		for(MapNode node : graph.states){
			// if neighbour contains the color between possibilities, then increase impact
			if (graph.isBorder(state, node.GetName()) && getPossibilitiesFor(node.GetName()).contains(color)){
				ret++;
			}
		}
		return ret;
	}
	
	public void color(String state, String color){
		coloring.put(state, color);
	}
	
	public boolean finished(){
		return (coloring.size() == graph.states.length);
	}
	
	public boolean equals(Object o){
		if (o == null) return false;
	    if (!(o instanceof GraphColoringState)) return false;
	    GraphColoringState s = (GraphColoringState) o;
	    
	    // compare colorings
	    if (s.coloring.size() != this.coloring.size())
	    	return false;
  	   	for (String key: s.coloring.keySet()){
  	   		if (!s.coloring.get(key).equals(this.coloring.get(key)))
  	         return false;
  	   	}
  	   	return true;
	}
	
	public int hashCode(){
		return 0;
	}
}