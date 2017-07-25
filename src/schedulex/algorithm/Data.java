/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulex.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import schedulex.domain.Events;
import schedulex.domain.Groups;
import schedulex.domain.Modules;
import schedulex.domain.Periods;
import schedulex.domain.Rooms;
import schedulex.domain.Staff;

/**
 *
 * @author eniol
 */
public class Data {
    
 
    ArrayList<Groups> groups = new ArrayList<>();
    ArrayList<Periods> oneHourPeriods = new ArrayList<>();
    ArrayList<Periods> twoHourPeriods = new ArrayList<>();
    ArrayList<Periods> threeHourPeriods = new ArrayList<>();
    private int numberOfModules = 0;
    

	public ArrayList<Groups> getGroups() {
		return groups;
	}

	public void setGroups(ArrayList<Groups> groups) {
		this.groups = groups;
	}

	public ArrayList<Periods> getOneHourPeriods() {
		return oneHourPeriods;
	}

	public void setOneHourPeriods(ArrayList<Periods> oneHourPeriods) {
		this.oneHourPeriods = oneHourPeriods;
	}

	public ArrayList<Periods> getTwoHourPeriods() {
		return twoHourPeriods;
	}

	public void setTwoHourPeriods(ArrayList<Periods> twoHourPeriods) {
		this.twoHourPeriods = twoHourPeriods;
	}

	public ArrayList<Periods> getThreeHourPeriods() {
		return threeHourPeriods;
	}

	public void setThreeHourPeriods(ArrayList<Periods> threeHourPeriods) {
		this.threeHourPeriods = threeHourPeriods;
	}

	public ArrayList<Rooms> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Rooms> rooms) {
		this.rooms = rooms;
	}

	public ArrayList<Modules> getModules() {
		return modules;
	}

	public void setModules(ArrayList<Modules> modules) {
		this.modules = modules;
	}

	public ArrayList<Staff> getStaff() {
		return staff;
	}

	public void setStaff(ArrayList<Staff> staff) {
		this.staff = staff;
	}

	public int getNum() {
		return Num;
	}

	public void setNum(int num) {
		Num = num;
	}

	ArrayList<Rooms>rooms;
    ArrayList<Modules> modules= new ArrayList<>();
    ArrayList<Staff> staff = new ArrayList<>();
    int Num = 1;
    
    public Data(){initialize();}
    
    public Data (ArrayList<Modules> Pmods, ArrayList<Groups> Pgrps, ArrayList<Staff> Pstf){
    	Rooms room1 = new Rooms("N424", 24);
        Rooms room2 = new Rooms("N523", 24);
        Rooms room3 = new Rooms("N525", 30); 
        Rooms room4 = new Rooms("N527", 30);
        Rooms room5 = new Rooms("N528", 60);
        Rooms room6 = new Rooms("N530", 50);
        Rooms room7 = new Rooms("N533", 116);
         rooms=  new ArrayList<>(Arrays.asList(room1, room2, room3,room4,room5,room6,room7));
         
         
         for (int i =9; i<17; i++){
             for (String a : Periods.DAYS_OF_THE_WEEK){
             	oneHourPeriods.add(new Periods(a, i, i+1));
             	if (i<16)
             		twoHourPeriods.add(new Periods(a, i, i+2));
             	if(i<15)
             		threeHourPeriods.add(new Periods(a, i, i+3));
             }
         }
         
         modules = Pmods;
         staff = Pstf;
         groups = Pgrps;
         groups.forEach(g -> {
            System.out.println(g.getGroupID() + "   " + g.getGroupSize());
         });
         staff.forEach(s-> {
                System.out.println(s.getStaffID() +"  "+s.getStaffName());
         });
         modules.forEach(m-> {
                System.out.println(m.getModuleID()+ "  "+ m.getModuleName() );
         });
         System.out.println("The Size of the student group list is : "+groups.size());
         System.out.println("The Size of the Module list is : "+modules.size());
         System.out.println("The Size of the Staff list is : "+staff.size());
         
    };

    private Data initialize() {
       Rooms room1 = new Rooms("N424", 24);
        Rooms room2 = new Rooms("N523", 24);
        Rooms room3 = new Rooms("525", 30); 
        Rooms room4 = new Rooms("527", 30);
        Rooms room5 = new Rooms("N528", 60);
        Rooms room6 = new Rooms("N530", 50);
        Rooms room7 = new Rooms("N533", 116);
         rooms=  new ArrayList<>(Arrays.asList(room1, room2, room3,room4,room5,room6,room7));
         
         ArrayList<String> staffInitials = new ArrayList<String>(Arrays.asList("AF","AP","CJ", "CM", "DL", "EE", "HA", "IA", "IH", "JG"
                                            ,"JI","JL","KH","MC","MH", "MN", "MZ", "NW","PH", "RL", "RM", "SM", "SS", "WT","YJ"));
         staffInitials.forEach(s -> {
             
        	 staff.add(new Staff(Num , s));
                    //System.out.println("Staff initial: "+s + " Staff number is: " +Num);
                  
                   Num++;
                    
                    
         });//end of forEach loop
         
         HashMap <String, Integer> maplist = new HashMap<String, Integer>(){
                                               {
                                                 put("BIT2", 6); put("BIT3",6);put("BIT4",7);put("BIT4D",2);put("CASD3",30);put("CASD4",13);
                                                 put("CGA1",25);put("CGA2",30);put("CGA3",13);put("CGA4",12);put("CMOG",20);put("CNMD3",38);
                                                 put("CNMD4",20);put("CS1",60);put("CS2",54);put("CS4",56);put("CS5",45);put("CSPG",5);
                                                 put("CSTNM",20);put("DM1",25);put("DM2",26);put("DM3",21);put("DM3D",20);put("DM4",24);
                                                 put("DS",25);put("INS",15);
                                               }};
         maplist.forEach((k,v) ->{
                   
                   groups.add(new Groups(k,v));
                   //System.out.println("Student Group: "+k +" Size: "+ v);
                   
         });//End of student Group
        Num=0;
        ArrayList<String> moduleCode = new ArrayList<String>(Arrays.asList("CM1013","CM1014","CM1015", "CM1018", "CM1021", "CM2003", "CM2015","CM2026","CM2027",
                                        "CM2521","CM3009","CM3017","CM3019","CM3020","CM3032","CM3034","CM3039","CM3040","CM3056","CM3059","CM3068","CM3069",
                                        "CM3531","CM3600","CM4002","CM4008","CM4011","CM4017","CM4029","CM4533","CM4537","CM4539","CMM004","CMM007","CMM008",
                                        "CMM021","CMM503","CMM507","CMM528","CMM529","CMM534","CMM535","CMM536","CMM615"
                                        ));
        moduleCode.forEach(course -> {
             
                   
                    modules.add(new Modules(Num , course));
                    Num++;
                    // System.out.println(course+ "   "+Num);
                    
         });//end of forEach loop
        
       
       
     
        for (int i =9; i<17; i++){
                    for (String s : Periods.DAYS_OF_THE_WEEK){
                    	oneHourPeriods.add(new Periods(s, i, i+1));
                    	if (i<16)
                    		twoHourPeriods.add(new Periods(s, i, i+2));
                    	if(i<15)
                    		threeHourPeriods.add(new Periods(s, i, i+3));
                    }
                 
        }
     
      /*oneHourPeriods.forEach(prd -> {
        	System.out.println(prd.getPeriodHourGroup());
        }); 
        System.out.println("---------------------------------------------------------------------");
        
        
       twoHourPeriods.forEach(prd -> {
        	System.out.println(prd.getPeriodHourGroup());
        }); 
        System.out.println("---------------------------------------------------------------------");
        
        
       threeHourPeriods.forEach(prd -> {
        	System.out.println(prd.getPeriodHourGroup());
        }); 
       System.out.println("---------------------------------------------------------------------");*/
       
    
        return this;
        
    }//end of initialize method
    
    public int getNumberOfModules() {
		return this.numberOfModules;
	}

	
	public static void main (String[] args){
        
       Data data1 = new Data ();
    }//end of main method
}//end of Data class
