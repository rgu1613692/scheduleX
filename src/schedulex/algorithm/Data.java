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
    
    ArrayList<Events> events;
    ArrayList<Groups> groups;
    ArrayList<Modules> modules;
    ArrayList<Periods> periods;
    ArrayList<Rooms>rooms;
    ArrayList<Staff> staff;
    int Num = 0;
    
    public Data(){initialize();}

    private void initialize() {
       Rooms room1 = new Rooms("N424", 24);
        Rooms room2 = new Rooms("N523", 24);
        Rooms room3 = new Rooms("525", 30); 
        Rooms room4 = new Rooms("527", 30);
        Rooms room5 = new Rooms("N528", 60);
        Rooms room6 = new Rooms("N530", 50);
        Rooms room7 = new Rooms("N533", 116);
         rooms=  new ArrayList<>(Arrays.asList(room1, room2, room3,room4,room5,room6,room7));
         
         ArrayList<String> staffInitials = new ArrayList(Arrays.asList("AF","AP","CJ", "CM", "DL", "EE", "HA", "IA", "IH", "JG"
                                            ,"JI","JL","KH","MC","MH", "MN", "MZ", "NW","PH", "RL", "RM", "SM", "SS", "WT","YJ"));
         staffInitials.forEach(s -> {
             
                    Staff stf = new Staff(Num , s);
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
                   Groups grp = new Groups(k,v);
                   
         });//End of student Group
        Num=0;
        ArrayList<String> moduleCode = new ArrayList(Arrays.asList("CM1013","CM1014","CM1015", "CM1018", "CM1021", "CM2003", "CM2015","CM2026","CM2027",
                                        "CM2521","CM3009","CM3017","CM3019","CM3020","CM3032","CM3034","CM3039","CM3040","CM3056","CM3059","CM3068","CM3069",
                                        "CM3531","CM3600","CM4002","CM4008","CM4011","CM4017","CM4029","CM4533","CM4537","CM4539","CMM004","CMM007","CMM008",
                                        "CMM021","CMM503","CMM507","CMM528","CMM529","CMM534","CMM535","CM536","CM615"
                                        ));
        moduleCode.forEach(course -> {
             
                    Modules mod = new Modules(Num , course);
                    Num++;
                     //System.out.println(course+ "   "+Num);
                    
         });//end of forEach loop
        
        ArrayList<String> meetingTimes = new ArrayList<>();
        
        Periods.ONE_HOUR_PERIODS.forEach(prd ->{
                    Periods.DAYS_OF_THE_WEEK.forEach(day ->{
                            System.out.println( day + " "+ prd);
                    
                    });//end of days of the week loop
                   
                   
        
        
        });//end of  hour periods loop
    }//end of initialize method
    
    public static void main (String[] args){
        
       Data data1 = new Data ();
    }//end of main method
}//end of Data class
