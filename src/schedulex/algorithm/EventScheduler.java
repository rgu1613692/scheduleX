package schedulex.algorithm;

import java.util.ArrayList;


import schedulex.domain.Events;
import schedulex.domain.Groups;
import schedulex.domain.Periods;
import schedulex.domain.Staff;



public class EventScheduler {
	  private ArrayList<Events>events; 
	   private boolean isFitnessChanged = true;
	   private double fitness = -1; //a schedule will have a fitness
	   private int eventNumb = 0; // defining class number counter
	   private int numbOfConflicts = 0;// a schedule will have a number of conflicts with get method defined below
	   private Data data; //using data coming from Data class
	   
	   //Used to load data for the schedule to be created.
	   public Data getData(){return data;}
	   
	   
	   //Constructor for the schedule class (This consructor loads all the entire dataset as "data")
	   public EventScheduler(ArrayList<Events> eva, Data dat){
	       this.data = dat;
	      events= eva;
     
	}
	  //Second Constructor for the schedule class. This constructor loads only data concerning the selected events
	   public EventScheduler(EventScheduler  s, Data data){
		   this.data=data;
		   events=new ArrayList<Events>();
		   for(Events e: s.events){
			    events.add(new Events(e.getModule(), e.getGroups(), e.getStaff(), e.getDuration(), e.getEventType()));
		   }
		   initialize();
	   }
	   
	   
	   //This method allocates random rooms and period/meeting time for each event that was selected by the user
	  public ArrayList<Events> initialize() {
		  			events.forEach(x-> {
		  				//This is where the room is being alocated at random
		  				x.setRooms(data.getRooms().get((int) (data.getRooms().size()*Math.random())));
		    			Periods eventPeriod = new Periods();
		    			
		    			//A day of the week is selected at random to be used to create a meating time for each event
		    			eventPeriod.setPeriodDayGroup(eventPeriod.DAYS_OF_THE_WEEK.get((int) (eventPeriod.DAYS_OF_THE_WEEK.size()*Math.random())));
		    			
		    			//Allocating periods for all events with a one hour duration
		    		if(x.getDuration()==1){
		    			int xy = (int) (eventPeriod.ONE_HOUR_PERIODS.size()*Math.random());
		    			eventPeriod.setPeridHourGroup(eventPeriod.ONE_HOUR_PERIODS.get(xy));
		    			
		    			xy = Integer.parseInt(eventPeriod.ONE_HOUR_PERIODS.get(xy).substring(0, eventPeriod.ONE_HOUR_PERIODS.get(xy).indexOf(":")));
		    			//Setting the start and end time for the event as a random period is selected
		    			eventPeriod.setStart(xy);
		    			eventPeriod.setEnd(xy+1);
		    			//System.out.println(eventPeriod.getStart() + " : "+eventPeriod.getEnd());
		    			
		    		}
		    		//Allocating periods for all events with a two hours duration
		    		if(x.getDuration()==2){
		    			int xy =(int)(eventPeriod.TWO_HOUR_PERIODS.size()*Math.random());
		    			eventPeriod.setPeridHourGroup(eventPeriod.TWO_HOUR_PERIODS.get(xy));
		    			xy = Integer.parseInt(eventPeriod.TWO_HOUR_PERIODS.get(xy).substring(0, eventPeriod.TWO_HOUR_PERIODS.get(xy).indexOf(":")));
		    			//Setting the start and end time for the event as a random period is selected
		    			eventPeriod.setStart(xy);
		    			eventPeriod.setEnd(xy+2);
		    		}
		    		//Allocating periods for all events with a three hours duration
		    		if(x.getDuration()==3){
		    			int xy = (int)(eventPeriod.THREE_HOUR_PERIODS.size()*Math.random());
		    			eventPeriod.setPeridHourGroup(eventPeriod.THREE_HOUR_PERIODS.get(xy));
		    			xy = Integer.parseInt(eventPeriod.THREE_HOUR_PERIODS.get(xy).substring(0, eventPeriod.THREE_HOUR_PERIODS.get(xy).indexOf(":")));
		    			//Setting the start and end time for the event as a random period is selected
		    			eventPeriod.setStart(xy);
		    			eventPeriod.setEnd(xy+3);
		    			
		    		}
		    		x.setPeriods(eventPeriod);
		    		
		    		
		  				
		  			});
		  
		return events;
		  
	  }
	  
	  //This method calculates the fitness of each schedule created
	  public double calculateFitness(){//using java 8 to go through all the classes
		    numbOfConflicts = 0;
		    int product;
		    
		    for(Events x:events) {
		        //using java 8 to go thru all the classes.
		    	//CONSTRAINTS 1: Checking if the total number of student due to attend an event is greater than the capacity of the room allocated for the event and increasing the number of conflicts by one if it is.
		        if (x.getRooms().getSestingCapacity()<x.getNoStudents()) numbOfConflicts++;
		       String se =  x.getPeriods().getPeriodDayGroup();
		       
		       for (int ab= 0; ab<events.size(); ab++) {
		    	   //Checking conflicts for all events happenning on the same day N:B there can only be a clash if the two events being analysed occur on the same day.
		    	   if(events.get(ab).getPeriods().getPeriodDayGroup().equals(se) && (!events.get(ab).equals(x)) ) {
		    	  
		    		   product = events.get(ab).getDuration()*x.getDuration();
		    	//CONSTRAINTS 2: Ensuring that no two events happening on the same day and having the same room are scheduled for the same or overlapping periods/meeting time
		    	   if(events.get(ab).getRooms().equals(x.getRooms())){
		    	   switch(product) {
		    	   case 1:
		    		   if(events.get(ab).getPeriods().getStart()==x.getPeriods().getStart() )
		    				   numbOfConflicts++;
		    		   break;
		    	   case 2:
		    		   if(events.get(ab).getDuration()==1) {
		    			   if((events.get(ab).getPeriods().getStart()==x.getPeriods().getStart())||(events.get(ab).getPeriods().getStart()-1)==x.getPeriods().getStart())
		    				   numbOfConflicts++;
		    			   
		    		   }
		    				   
		    		   else if (x.getDuration()==1) {
		    			   if(x.getPeriods().getStart()==events.get(ab).getPeriods().getStart()||(x.getPeriods().getStart()-1)==events.get(ab).getPeriods().getStart())
		    				   numbOfConflicts++;
		    			   
		    		   }
		    		   break;
		    	   case 3:
		    		   if(events.get(ab).getDuration()==3) {
		    			   if(events.get(ab).getPeriods().getStart()==x.getPeriods().getStart()|| ((x.getPeriods().getStart()-events.get(ab).getPeriods().getStart())<3 )&&!(x.getPeriods().getEnd() <=events.get(ab).getPeriods().getStart())) {
		    				   numbOfConflicts++;
		    			   }
		    		   }
		    		   else if (x.getDuration()==3) {
		    			   
		    			   if(x.getPeriods().getStart()==events.get(ab).getPeriods().getStart()|| ((events.get(ab).getPeriods().getStart()-x.getPeriods().getStart())<3)&& !(events.get(ab).getPeriods().getEnd() <=x.getPeriods().getStart())) {
		    				   numbOfConflicts++;
		    			   }
		    			   
		    			   
		    		   }
		    		   
		    		   
		    		   break;
		    	   case 4:
		    		   if(x.getPeriods().getStart()<events.get(ab).getPeriods().getStart() &&((x.getPeriods().getStart()+1)== events.get(ab).getPeriods().getStart()))
		    			   numbOfConflicts++;
		    		   else if(x.getPeriods().getStart()>events.get(ab).getPeriods().getStart() &&((x.getPeriods().getStart()-1)== events.get(ab).getPeriods().getStart()))
		    			   numbOfConflicts++;
		    		   else if(events.get(ab).getPeriods().getStart()==x.getPeriods().getStart())
		    			   numbOfConflicts++;
		    		   break;
		    	   case 6:
		    		   if(events.get(ab).getDuration()==3) {
		    			   if(events.get(ab).getPeriods().getStart()==x.getPeriods().getStart() || (x.getPeriods().getStart() <events.get(ab).getPeriods().getEnd() && x.getPeriods().getEnd()>events.get(ab).getPeriods().getStart())) 
		    				   numbOfConflicts++;
		    			   
		    		   }
		    		   else if (x.getDuration()==3) {
		    			   if(x.getPeriods().getStart()==events.get(ab).getPeriods().getStart() || (events.get(ab).getPeriods().getStart() <x.getPeriods().getEnd() && events.get(ab).getPeriods().getEnd()>x.getPeriods().getStart()))  
		    				   numbOfConflicts++;
		    		   }
		    		   
		    		   break;
		    	   case 9:
		    		   if(x.getPeriods().getStart()<events.get(ab).getPeriods().getStart() && !(events.get(ab).getPeriods().getStart()>=x.getPeriods().getEnd())) {
		    			   numbOfConflicts++;
		    			   
		    		   }
		    		   else if (events.get(ab).getPeriods().getStart()<x.getPeriods().getStart() && !(x.getPeriods().getStart()>=events.get(ab).getPeriods().getEnd())) {
		    			   numbOfConflicts++;
		  
		    		   }
		    		   else if (events.get(ab).getPeriods().getStart()==x.getPeriods().getStart()) {
		    			   numbOfConflicts++;
		    		   }
		    		   break;
		    	   
		    	   }
		    	   
		    	
		       
		    	   }else{
		    		   //constraints 3&4: Checking to ensure that no two staffs of student groups are scheduled to be in two events or rooms in the same  or overlapping meeting times/periods
		    		   
		    		   switch(product) {
			    	   case 1:
			    		   if(events.get(ab).getPeriods().getStart()==x.getPeriods().getStart() )
			    			   for (Staff s : x.getStaff()){
			    				   for (Staff y: events.get(ab).getStaff()){
			    					   if(s.getStaffID()== y.getStaffID())  numbOfConflicts++;
			    				   }
			    			   }
			    		   for (Groups s : x.getGroups()){
		    				   for (Groups  y: events.get(ab).getGroups()){
		    					   if(s.getGroupID().equals(y.getGroupID()) && s.getGroupSize()==y.getGroupSize())  numbOfConflicts++;
		    				   }
		    			   }
			    				  
			    		   break;
			    	   case 2:
			    		   if(events.get(ab).getDuration()==1) {
			    			   if((events.get(ab).getPeriods().getStart()==x.getPeriods().getStart())||(events.get(ab).getPeriods().getStart()-1)==x.getPeriods().getStart())
			    				   for (Staff s : x.getStaff()){
				    				   for (Staff y: events.get(ab).getStaff()){
				    					   if(s.getStaffID()== y.getStaffID())  numbOfConflicts++;
				    				   }
				    			   }
				    		   for (Groups s : x.getGroups()){
			    				   for (Groups  y: events.get(ab).getGroups()){
			    					   if(s.getGroupID().equals(y.getGroupID()) && s.getGroupSize()==y.getGroupSize())  numbOfConflicts++;
			    				   }
			    			   }
				    			
			    			   
			    		   }
			    				   
			    		   else if (x.getDuration()==1) {
			    			   if(x.getPeriods().getStart()==events.get(ab).getPeriods().getStart()||(x.getPeriods().getStart()-1)==events.get(ab).getPeriods().getStart())
			    				   for (Staff s : x.getStaff()){
				    				   for (Staff y: events.get(ab).getStaff()){
				    					   if(s.getStaffID()== y.getStaffID())  numbOfConflicts++;
				    				   }
				    			   }
				    		   for (Groups s : x.getGroups()){
			    				   for (Groups  y: events.get(ab).getGroups()){
			    					   if(s.getGroupID().equals(y.getGroupID()) && s.getGroupSize()==y.getGroupSize())  numbOfConflicts++;
			    				   }
			    			   }
				    			
			    		   }
			    		   break;
			    	   case 3:
			    		   if(events.get(ab).getDuration()==3) {
			    			   if(events.get(ab).getPeriods().getStart()==x.getPeriods().getStart()|| ((x.getPeriods().getStart()-events.get(ab).getPeriods().getStart())<3 &&!(x.getPeriods().getEnd() <=events.get(ab).getPeriods().getStart()))) {
			    				   for (Staff s : x.getStaff()){
				    				   for (Staff y: events.get(ab).getStaff()){
				    					   if(s.getStaffID()== y.getStaffID())  numbOfConflicts++;
				    				   }
				    			   }
				    		   for (Groups s : x.getGroups()){
			    				   for (Groups  y: events.get(ab).getGroups()){
			    					   if(s.getGroupID().equals(y.getGroupID()) && s.getGroupSize()==y.getGroupSize())  numbOfConflicts++;
			    				   }
			    			   }
				    			
			    			   }
			    		   }
			    		   else if (x.getDuration()==3) {
			    			   
			    			   if(x.getPeriods().getStart()==events.get(ab).getPeriods().getStart()|| ((events.get(ab).getPeriods().getStart()-x.getPeriods().getStart())<3 && !(events.get(ab).getPeriods().getEnd() <=x.getPeriods().getStart())) ){
			    				   for (Staff s : x.getStaff()){
				    				   for (Staff y: events.get(ab).getStaff()){
				    					   if(s.getStaffID()== y.getStaffID())  numbOfConflicts++;
				    				   }
				    			   }
				    		   for (Groups s : x.getGroups()){
			    				   for (Groups  y: events.get(ab).getGroups()){
			    					   if(s.getGroupID().equals(y.getGroupID()) && s.getGroupSize()==y.getGroupSize())  numbOfConflicts++;
			    				   }
			    			   }
				    			
			    			   }
			    			   
			    			   
			    		   }
			    		   
			    		   
			    		   break;
			    	   case 4:
			    		   if(x.getPeriods().getStart()<events.get(ab).getPeriods().getStart() &&((x.getPeriods().getStart()+1)== events.get(ab).getPeriods().getStart())) {
			    			   for (Staff s : x.getStaff()){
			    				   for (Staff y: events.get(ab).getStaff()){
			    					   if(s.getStaffID()== y.getStaffID())  numbOfConflicts++;
			    				   }
			    			   }
			    		   for (Groups s : x.getGroups()){
		    				   for (Groups  y: events.get(ab).getGroups()){
		    					   if(s.getGroupID().equals(y.getGroupID()) && s.getGroupSize()==y.getGroupSize())  numbOfConflicts++;
		    				   }
		    			   }
		    		   }
			    		   else if(x.getPeriods().getStart()>events.get(ab).getPeriods().getStart() &&((x.getPeriods().getStart()-1)== events.get(ab).getPeriods().getStart())) {
			    			   for (Staff s : x.getStaff()){
			    				   for (Staff y: events.get(ab).getStaff()){
			    					   if(s.getStaffID()== y.getStaffID())  numbOfConflicts++;
			    				   }
			    			   }
			    		   for (Groups s : x.getGroups()){
		    				   for (Groups  y: events.get(ab).getGroups()){
		    					   if(s.getGroupID().equals(y.getGroupID()) && s.getGroupSize()==y.getGroupSize())  numbOfConflicts++;
		    				   }
		    			   }
		    		   }
			    		   else if(events.get(ab).getPeriods().getStart()==x.getPeriods().getStart()) {
			    			   for (Staff s : x.getStaff()){
			    				   for (Staff y: events.get(ab).getStaff()){
			    					   if(s.getStaffID()== y.getStaffID())  numbOfConflicts++;
			    				   }
			    			   }
			    		   for (Groups s : x.getGroups()){
		    				   for (Groups  y: events.get(ab).getGroups()){
		    					   if(s.getGroupID().equals(y.getGroupID()) && s.getGroupSize()==y.getGroupSize())  numbOfConflicts++;
		    				   }
			    		   }
			    		   }
			    		   break;
			    	   case 6:
			    		   if(events.get(ab).getDuration()==3) {
			    			   if(events.get(ab).getPeriods().getStart()==x.getPeriods().getStart() || (x.getPeriods().getStart() <events.get(ab).getPeriods().getEnd() && x.getPeriods().getEnd()>events.get(ab).getPeriods().getStart())) 
			    				   for (Staff s : x.getStaff()){
				    				   for (Staff y: events.get(ab).getStaff()){
				    					   if(s.getStaffID()== y.getStaffID())  numbOfConflicts++;
				    				   }
				    			   }
				    		   for (Groups s : x.getGroups()){
			    				   for (Groups  y: events.get(ab).getGroups()){
			    					   if(s.getGroupID().equals(y.getGroupID()) && s.getGroupSize()==y.getGroupSize())  numbOfConflicts++;
			    				   }
			    			   }
				    			
			    			   
			    		   }
			    		   else if (x.getDuration()==3) {
			    			   if(events.get(ab).getPeriods().getStart()==x.getPeriods().getStart() || (x.getPeriods().getStart() <events.get(ab).getPeriods().getEnd() && x.getPeriods().getEnd()>events.get(ab).getPeriods().getStart())) 
			    				   for (Staff s : x.getStaff()){
				    				   for (Staff y: events.get(ab).getStaff()){
				    					   if(s.getStaffID()== y.getStaffID())  numbOfConflicts++;
				    				   }
				    			   }
				    		   for (Groups s : x.getGroups()){
			    				   for (Groups  y: events.get(ab).getGroups()){
			    					   if(s.getGroupID().equals(y.getGroupID()) && s.getGroupSize()==y.getGroupSize())  numbOfConflicts++;
			    				   }
			    			   }
				    			
			    		   }
			    		   
			    		   break;
			    	   case 9:
			    		   if(x.getPeriods().getStart()<events.get(ab).getPeriods().getStart() && !(events.get(ab).getPeriods().getStart()>=x.getPeriods().getEnd())) {
			    			   for (Staff s : x.getStaff()){
			    				   for (Staff y: events.get(ab).getStaff()){
			    					   if(s.getStaffID()== y.getStaffID())  numbOfConflicts++;
			    				   }
			    			   }
			    		   for (Groups s : x.getGroups()){
		    				   for (Groups  y: events.get(ab).getGroups()){
		    					   if(s.getGroupID().equals(y.getGroupID()) && s.getGroupSize()==y.getGroupSize())  numbOfConflicts++;
		    				   }
		    			   }
			    			
			    			   
			    		   }
			    		   else if (events.get(ab).getPeriods().getStart()<x.getPeriods().getStart() && !(x.getPeriods().getStart()>=events.get(ab).getPeriods().getEnd())) {
			    			   for (Staff s : x.getStaff()){
			    				   for (Staff y: events.get(ab).getStaff()){
			    					   if(s.getStaffID()== y.getStaffID())  numbOfConflicts++;
			    				   }
			    			   }
			    		   for (Groups s : x.getGroups()){
		    				   for (Groups  y: events.get(ab).getGroups()){
		    					   if(s.getGroupID().equals(y.getGroupID()) && s.getGroupSize()==y.getGroupSize())  numbOfConflicts++;
		    				   }
		    			   }
			    			
			  
			    		   }
			    		   else if (events.get(ab).getPeriods().getStart()==x.getPeriods().getStart()) {
			    			   for (Staff s : x.getStaff()){
			    				   for (Staff y: events.get(ab).getStaff()){
			    					   if(s.getStaffID()== y.getStaffID())  numbOfConflicts++;
			    				   }
			    			   }
			    		   for (Groups s : x.getGroups()){
		    				   for (Groups  y: events.get(ab).getGroups()){
		    					   if(s.getGroupID().equals(y.getGroupID()) && s.getGroupSize()==y.getGroupSize())  numbOfConflicts++;
		    				   }
		    			   }
			    		   }
			    		   break;
			    	   
			    	   }
		    		   
		    		   
		    		   
		    		   
		    	   }
		    	   }
		   
		        
		       }
		     
		    }
		    //Calculating the fitness of each schedule with the formula fitness = 1/(number of conflicts + 1)
		    return 1/(double)(numbOfConflicts + 1);
	  }
	  
	  
	  public int getNoOfConflicts() {return numbOfConflicts;}
	  
	  
	  
	 
	  public String printout(){
		  String print = "{";
		  for (Events evt : events){
			  print+= "[ "+evt.getModule().getModuleName()+", { ";
			  for(Groups gp: evt.getGroups()){
				  print+=gp.getGroupID()+", ";
			  }
			  print+=" } , {";
			  for(Staff st: evt.getStaff()){
				  print+=st.getStaffName()+ ", ";
			  }
			  print+=" } , "+ evt.getRooms().getRoomNumber() + ", "+ evt.getPeriods().getPeriodDayGroup() + " "+evt.getPeriods().getPeriodHourGroup()+", "+evt.getEventType()+ " ]" ;
			  
		  }
		  print+= " }";
		  
		  return print;
	  }
}