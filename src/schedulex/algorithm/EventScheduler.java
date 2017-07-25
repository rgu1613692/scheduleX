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
	   public Data getData(){return data;}
	   
	   public EventScheduler(ArrayList<Events> eva, Data dat){
	       this.data = dat;
	      events= eva;
     
	}
	   public EventScheduler(EventScheduler  s, Data data){
		   this.data=data;
		   events=new ArrayList<Events>();
		   for(Events e: s.events){
			    events.add(new Events(e.getModule(), e.getGroups(), e.getStaff(), e.getDuration(), e.getEventType()));
		   }
		   initialize();
	   }
	  public ArrayList<Events> initialize() {
		  			events.forEach(x-> {
		  				
		  				x.setRooms(data.getRooms().get((int) (data.getRooms().size()*Math.random())));
		    			Periods eventPeriod = new Periods();
		    			eventPeriod.setPeriodDayGroup(eventPeriod.DAYS_OF_THE_WEEK.get((int) (eventPeriod.DAYS_OF_THE_WEEK.size()*Math.random())));
		    			
		    		if(x.getDuration()==1){
		    			int xy = (int) (eventPeriod.ONE_HOUR_PERIODS.size()*Math.random());
		    			eventPeriod.setPeridHourGroup(eventPeriod.ONE_HOUR_PERIODS.get(xy));
		    			
		    			xy = Integer.parseInt(eventPeriod.ONE_HOUR_PERIODS.get(xy).substring(0, eventPeriod.ONE_HOUR_PERIODS.get(xy).indexOf(":")));
		    			eventPeriod.setStart(xy);
		    			eventPeriod.setEnd(xy+1);
		    			//System.out.println(eventPeriod.getStart() + " : "+eventPeriod.getEnd());
		    			
		    		}
		    		if(x.getDuration()==2){
		    			int xy =(int)(eventPeriod.TWO_HOUR_PERIODS.size()*Math.random());
		    			eventPeriod.setPeridHourGroup(eventPeriod.TWO_HOUR_PERIODS.get(xy));
		    			xy = Integer.parseInt(eventPeriod.TWO_HOUR_PERIODS.get(xy).substring(0, eventPeriod.TWO_HOUR_PERIODS.get(xy).indexOf(":")));
		    			eventPeriod.setStart(xy);
		    			eventPeriod.setEnd(xy+2);
		    		}
		    		if(x.getDuration()==3){
		    			int xy = (int)(eventPeriod.THREE_HOUR_PERIODS.size()*Math.random());
		    			eventPeriod.setPeridHourGroup(eventPeriod.THREE_HOUR_PERIODS.get(xy));
		    			xy = Integer.parseInt(eventPeriod.THREE_HOUR_PERIODS.get(xy).substring(0, eventPeriod.THREE_HOUR_PERIODS.get(xy).indexOf(":")));
		    			eventPeriod.setStart(xy);
		    			eventPeriod.setEnd(xy+3);
		    			
		    		}
		    		x.setPeriods(eventPeriod);
		    		
		    		
		  				
		  			});
		  
		return events;
		  
	  }
	  
	  
	  public double calculateFitness(){//using java 8 to go through all the classes
		    numbOfConflicts = 0;
		    int product;
		    
		    for(Events x:events) {
		        //using java 8 to go thru all the classes.
		        if (x.getRooms().getSestingCapacity()<x.getNoStudents()) numbOfConflicts++;
		       String se =  x.getPeriods().getPeriodDayGroup();
		       for (int ab= 0; ab<events.size(); ab++) {
		    	   if(events.get(ab).getPeriods().getPeriodDayGroup().equals(se) && (!events.get(ab).equals(x)) ) {
		    	   product = events.get(ab).getDuration()*x.getDuration();
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
		    			   if(events.get(ab).getPeriods().getStart()==x.getPeriods().getStart()|| (x.getPeriods().getStart()-events.get(ab).getPeriods().getStart())<3) {
		    				   numbOfConflicts++;
		    			   }
		    		   }
		    		   else if (x.getDuration()==3) {
		    			   
		    			   if(x.getPeriods().getStart()==events.get(ab).getPeriods().getStart()|| (events.get(ab).getPeriods().getStart()-x.getPeriods().getStart())<3) {
		    				   numbOfConflicts++;
		    			   }
		    			   
		    			   
		    		   }
		    		   
		    		   
		    		   break;
		    	   case 4:
		    		   if(x.getPeriods().getStart()<events.get(ab).getPeriods().getStart() &&((x.getPeriods().getStart()+1)== events.get(ab).getPeriods().getStart()))
		    			   numbOfConflicts++;
		    		   if(x.getPeriods().getStart()>events.get(ab).getPeriods().getStart() &&((x.getPeriods().getStart()-1)== events.get(ab).getPeriods().getStart()))
		    			   numbOfConflicts++;
		    		   break;
		    	   case 6:
		    		   if(events.get(ab).getDuration()==3) {
		    			   if(!(x.getPeriods().getStart() >=events.get(ab).getPeriods().getEnd()) && !(x.getPeriods().getEnd()<=events.get(ab).getPeriods().getStart())) 
		    				   numbOfConflicts++;
		    			   
		    		   }
		    		   else if (x.getDuration()==3) {
		    			   if(!(events.get(ab).getPeriods().getStart() >=x.getPeriods().getEnd()) && !(events.get(ab).getPeriods().getEnd()<=x.getPeriods().getStart())) 
		    				   numbOfConflicts++;
		    		   }
		    		   
		    		   break;
		    	   case 9:
		    		   if(x.getPeriods().getStart()<events.get(ab).getPeriods().getStart() && !(events.get(ab).getPeriods().getStart()>=x.getPeriods().getEnd())) {
		    			   numbOfConflicts++;
		    			   
		    		   }
		    		   else if (events.get(ab).getPeriods().getStart()<x.getPeriods().getStart() && !(events.get(ab).getPeriods().getStart()>=x.getPeriods().getEnd())) {
		    			   numbOfConflicts++;
		  
		    		   }
		    		   break;
		    	   
		    	   }
		    	   
		    	
		       
		    	   }else{
		    		   
		    		   
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
			    			   if(events.get(ab).getPeriods().getStart()==x.getPeriods().getStart()|| (x.getPeriods().getStart()-events.get(ab).getPeriods().getStart())<3) {
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
			    			   
			    			   if(x.getPeriods().getStart()==events.get(ab).getPeriods().getStart()|| (events.get(ab).getPeriods().getStart()-x.getPeriods().getStart())<3) {
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
			    		   if(x.getPeriods().getStart()<events.get(ab).getPeriods().getStart() &&((x.getPeriods().getStart()+1)== events.get(ab).getPeriods().getStart()))
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
			    			
			    		   if(x.getPeriods().getStart()>events.get(ab).getPeriods().getStart() &&((x.getPeriods().getStart()-1)== events.get(ab).getPeriods().getStart()))
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
			    	   case 6:
			    		   if(events.get(ab).getDuration()==3) {
			    			   if(!(x.getPeriods().getStart() >=events.get(ab).getPeriods().getEnd()) && !(x.getPeriods().getEnd()<=events.get(ab).getPeriods().getStart())) 
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
			    			   if(!(events.get(ab).getPeriods().getStart() >=x.getPeriods().getEnd()) && !(events.get(ab).getPeriods().getEnd()<=x.getPeriods().getStart())) 
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
			    		   else if (events.get(ab).getPeriods().getStart()<x.getPeriods().getStart() && !(events.get(ab).getPeriods().getStart()>=x.getPeriods().getEnd())) {
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
		    return 1/(double)(numbOfConflicts + 1);
	  }
	  
	  
	  
	  
	  
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