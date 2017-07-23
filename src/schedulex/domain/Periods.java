
package schedulex.domain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author eniol
 */
public class Periods {
   private String PeriodDayGroup;
   private String PeridHourGroup;
   private int Start;
   private int End;

   public static final ArrayList<String> ONE_HOUR_PERIODS =new ArrayList<>(Arrays.asList("9:00-10:00", "10:00-11:00", "11:00 - 12:00", "12:00-13:00","13:00-14:00",
                                                      "14:00-15:00", "15:00-16:00","16:00-17:00"));
   public static final ArrayList<String> TWO_HOUR_PERIODS=new ArrayList<>(Arrays.asList("9:00-11:00","10:00-12:00", "11:00-13:00", "12:00-14:00",
                                            "13:00 - 15:00","14:00-16:00", "15:00-17:00"));
   public static final ArrayList<String> THREE_HOUR_PERIODS =new ArrayList<>(Arrays.asList("9:00-12:00","10:00-13:00", "11:00-14:00", "12:00-15:00", "13:00 - 16:00","14:00-17:00"));
   public static final ArrayList<String> DAYS_OF_THE_WEEK = new ArrayList<>(Arrays.asList("Mon", "Tue", "Wed", "Thur", "Fri"));

    public Periods(String PeriodDayGroup, int start_time, int end_time) {
        this.PeriodDayGroup = PeriodDayGroup;
        this.PeridHourGroup = start_time + ":00 - " + end_time + ":00" ;
        this.Start = start_time;
        this.End = end_time;
        
    }

    public int getStart() {
		return Start;
	}

	public void setStart(int start) {
		Start = start;
	}

	public int getEnd() {
		return End;
	}

	public void setEnd(int end) {
		End = end;
	}

	public Periods() {
    }
    public String getPeriodDayGroup() {
        return PeriodDayGroup;
    }

    public String getPeriodHourGroup() {
        return PeridHourGroup;
    }

 
    public void setPeriodDayGroup(String PeriodDayGroup) {
        this.PeriodDayGroup = PeriodDayGroup;
    }

    public void setPeridHourGroup(String PeridHourGroup) {
        this.PeridHourGroup = PeridHourGroup;
    }

  
    
}
