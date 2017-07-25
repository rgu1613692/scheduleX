package schedulex.algorithm;

import java.util.ArrayList;
import java.util.stream.IntStream;



public class Population {
	private ArrayList<EventScheduler> schedules; //arraylist of schedules
	public Population (int size, EventScheduler Schedule,Data data){
	    schedules = new ArrayList<>(size);
		IntStream.range(0,11).forEach(x -> 
 		{
 			EventScheduler s= new EventScheduler(Schedule, data);
 			//s.initialize();
 			schedules.add(s);
 		}
 				
 				);
	  }
	public ArrayList<EventScheduler> getSchedules(){ return this.schedules;} //get method that will return the schedules
	public Population sortByFitness(){
	    schedules.sort((schedule1, schedule2) -> {
	        int returnValue = 0;
	        if (schedule1.calculateFitness()> schedule2.calculateFitness()) returnValue = -1;
	        else if (schedule1.calculateFitness() < schedule2.calculateFitness()) returnValue = 1;
	        return returnValue;
	       });
	       return this;
	}
	
	
	
	
	
	
}
