import java.util.*;

public class MyMapGraph extends MapGraph{
	
	public void colorGraph(){
		
		/* ZACIATOK MIESTA PRE VAS KOD */
		
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
		
		/* KONIEC MIESTA PRE VAS KOD */
		
	}	
}