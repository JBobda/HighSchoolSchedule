package fhsschedule;

import java.util.*;

//Jan Bobda
public class Student implements FHSPeople{
    //Name for the student
    private String name;
    private long studentID;
    private Room [] personalSchedule = new Room[8];
    
    //Methods
    public Student(String name, long studentID){
        //This is here to instantiate the name of the student
        this.name = name;
        this.studentID = studentID;
        
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
