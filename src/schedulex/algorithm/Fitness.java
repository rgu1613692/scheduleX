package schedulex.algorithm;

import java.util.ArrayList;

import schedulex.domain.Events;
import schedulex.domain.Groups;
import schedulex.domain.Staff;

public class Fitness {
	public ArrayList<Events> eventsFitness;
	public ArrayList<Integer> noOfIndividualConflicts = new ArrayList<Integer>();
	int noOfConflicts=0;
	
	public Fitness(ArrayList<Events> events){
		this.eventsFitness = events;
		
	}
	public Fitness(){};
	
	
	public ArrayList<Integer> getperiodConflicts(ArrayList<Events> eve){

		 eve.forEach((Events x) -> {
			 int num = 0; 
			 for(Groups grp : x.getGroups())
					num += grp.getGroupSize();
					
			 if (x.getRooms().getSestingCapacity()<num){ noOfConflicts++;  
			 
			 System.out.println("I have a conflict here "+ num);
				 
			 };
			 
		        eve.stream().filter(y -> eve.indexOf(y) >= eve.indexOf(x)).forEach(y -> {
		            if (x.getPeriods().equals(y.getPeriods())){
		                if (x.getRooms() == y.getRooms())noOfConflicts++;
		                //get a way of checking to make sure that the lecturers don't clash;
		               for(Staff stf : x.getStaff()){
		            	   for(Staff st : y.getStaff()){
		            		   if (stf.equals(st)) noOfConflicts++;
		            	   }
		               }
		            }
		            
		        });
		        noOfIndividualConflicts.add(1/noOfConflicts);
		        noOfConflicts = 0;
		    });
		 
		 
		
		return noOfIndividualConflicts;
	}
	
	
	
	

}
