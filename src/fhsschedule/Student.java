package fhsschedule;

import java.util.*;

//Jan Bobda
public class Student implements FHSPeople{
    //Name for the student
    private String name;
    private long studentID;
    private Room [] personalSchedule = new Room[8];
    
    //Methods
    public Student(String info){
        //This is here to instantiate the info of the student
        String[] storage = new String[10];
        int count = 0;
        int index = 0;
        for (int i = 0; i < info.length(); i++) {
            if(info.charAt(i) == ' '){
                storage[index] = info.substring(count, i);
                count = i+1;
                index++;
            }
        }
        
        name = storage[0];
        studentID = Long.parseLong(storage[1]);
        
        //Loop that goes through storage array
        for (int i = 2; i < 10; i++) {
            //Loop that goes through each of the room possibilities
            for (int j = 0; j < FHSSchedule.getSchedule().getSchedule().size(); j++) {
                if(FHSSchedule.getSchedule().getSchedule().get(j).equals(storage[i])){
                    personalSchedule[i-2] = FHSSchedule.getSchedule().getSchedule().get(j);
                    break;
                }
            }
        }
        
    }
    
    public String getName(){
        return name;
    }
    
    public Room [] getPersonalSchedule(){
        return personalSchedule;
    }
    
    public boolean equals(String student, long id){
        if((this.name.compareTo(name) == 0) && (this.studentID == id)){
            return true;
        }
        return false;
    }
    
    public String toString(){
        return name;
    }
    
    
}
