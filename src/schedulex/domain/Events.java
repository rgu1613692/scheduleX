/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulex.domain;

import java.util.ArrayList;

/*
 *
 * @author eniol
 */
public class Events {
    private Modules module;
    private ArrayList<Groups> groups;
    private Rooms rooms;
    private ArrayList<Staff> staff;
    private int Duration;
    private String EventType;
    private Periods periods;

    public Events(Modules module, ArrayList<Groups> groups, ArrayList<Staff> staff, int Duration, String EventType) {
        this.module = module;
        this.groups = groups;
        this.staff = staff;
        this.Duration = Duration;
        this.EventType = EventType;
    }

    public Events() {
    }

    public Periods getPeriods() {
		return periods;
	}

	public void setPeriods(Periods periods) {
		this.periods = periods;
	}

	public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public Modules getModule() {
        return module;
    }

    public ArrayList<Groups> getGroups() {
        return groups;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public ArrayList<Staff> getStaff() {
        return staff;
    }

    public int getDuration() {
        return Duration;
    }

    public String getEventType() {
        return EventType;
    }
    
    
    
    
  
}