package schedulex.algorithm;

import java.util.ArrayList;


import schedulex.domain.Events;
import schedulex.domain.Groups;



public class EventScheduler {
	  private ArrayList<Events>events; 
	   private boolean isFitnessChanged = true;
	   private double fitness = -1; //a schedule will have a fitness
	   private int eventNumb = 0; // defining class number counter
	   private int numbOfConflicts = 0;// a schedule will have a number of conflicts with get method defined below
	   private Data data; //using data coming from Data class
	   public Data getData(){return data;}
	   
	   public EventScheduler(Data data){
	       this.data = data;
	    //   events = new ArrayList<Events>(data.getNumberOfModules()); //to know the number of events to schedule based on the number of modules offered by each department;  
	}
	   public EventScheduler initialize(){
		   new ArrayList<Groups>(data.getGroups()).forEach(grp -> {//using data to pick up all the department
		       grp.getModules().forEach(course -> { //using data to pick up all the courses
		          
		    	   
		    	   
		    	   
		    	   
		    	   
		    	   
		    	   
		       });//end of arraylist of modules iteration block
		   });  //end of new arraylist of groups iteration block
		  return this;
		}//End of initialize method   
	   
	   
}//End of the EventScheduler Class
