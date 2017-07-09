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
public class Modules {
    private int moduleID;
    private String moduleName;
    private ArrayList<Groups> groups;
    private ArrayList<Staff> staff;

    public Modules(int modID, String modName) {
        this.moduleID = modID;
        this.moduleName = modName;
       
    }

    public Modules() {
    }

    public int getModuleID() {
        return moduleID;
    }

    public String getModuleName() {
        return moduleName;
    }

    public ArrayList<Groups> getGroups() {
        return groups;
    }

    public ArrayList<Staff> getStaff() {
        return staff;
    }
    
    
    
    
}
