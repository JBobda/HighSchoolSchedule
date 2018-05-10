package fhsschedule;

import java.util.*;

//Jan Bobda
public class Room {
    //Variables that each room will have, a pair of students and teachers for each period
    private String roomName;
    private int roomNumber;
    //First Period
    private ArrayList<Teacher> teacherList1 = new ArrayList();
    private ArrayList<Student> studentList1 = new ArrayList();
    //Second Period
    private ArrayList<Teacher> teacherList2 = new ArrayList();
    private ArrayList<Student> studentList2 = new ArrayList();
    //Third Period
    private ArrayList<Teacher> teacherList3 = new ArrayList();
    private ArrayList<Student> studentList3 = new ArrayList();
    //Fourth Period
    private ArrayList<Teacher> teacherList4 = new ArrayList();
    private ArrayList<Student> studentList4 = new ArrayList();
    //Fifth Period
    private ArrayList<Teacher> teacherList5 = new ArrayList();
    private ArrayList<Student> studentList5 = new ArrayList();
    //Sixth Period
    private ArrayList<Teacher> teacherList6 = new ArrayList();
    private ArrayList<Student> studentList6 = new ArrayList();
    //Seventh Period
    private ArrayList<Teacher> teacherList7 = new ArrayList();
    private ArrayList<Student> studentList7 = new ArrayList();
    //Eight Period
    private ArrayList<Teacher> teacherList8 = new ArrayList();
    private ArrayList<Student> studentList8 = new ArrayList();
    
    //Constructor
    public Room(String name, int room){
        roomName = name;
        roomNumber = room;
    }
    
    //Methods
    public ArrayList<Student> getStudents(int period){
        switch(period){
            case 1: return studentList1;
            case 2: return studentList2;
            case 3: return studentList3;
            case 4: return studentList4;
            case 5: return studentList5;
            case 6: return studentList6;
            case 7: return studentList7;
            case 8: return studentList8;
        }
        
        return studentList1;
    }
    
    public ArrayList<Teacher> getTeachers(int period){
        switch(period){
            case 1: return teacherList1;
            case 2: return teacherList2;
            case 3: return teacherList3;
            case 4: return teacherList4;
            case 5: return teacherList5;
            case 6: return teacherList6;
            case 7: return teacherList7;
            case 8: return teacherList8;
        }
        
        return teacherList1;
    }
    
    public String getRoomName(){
        return roomName;
    }
    
    public int getRoomNumber(){
        return roomNumber;
    }
    
    public boolean equals(String roomName){
        if(this.roomName.equals(roomName)){
            return true;
        }
        return false;
    }
    
    public String toString(){
        return roomName;
    }
}
