/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulex.domain;

import java.util.ArrayList;

/**
 *
 * @author eniol
 */
public class Groups {
    private String groupID;
    private int groupSize;
    private ArrayList<Modules> modules;

    public Groups(String groupID, int groupSize) {
        this.groupID = groupID;
        this.groupSize = groupSize;
        
    }

    public Groups() {
    }

    public String getGroupID() {
        return groupID;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public ArrayList<Modules> getModules() {
        return modules;
    }
    
    
    
    
}
