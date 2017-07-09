/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulex.domain;

/**
 *
 * @author eniol
 */
public class Rooms {
    private String roomNumber;
    private int seatingCapacity;

    public Rooms(String roomNo, int capacity) {
        this.roomNumber = roomNo;
        this.seatingCapacity = capacity;
    }
    
    public Rooms(){
        
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getSestingCapacity() {
        return seatingCapacity;
    }
    
}
