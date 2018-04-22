package fhsschedule;

//Jan Bobda
public class Teacher implements FHSPeople{
    //Name for the teacher
    private String name;
    private long teacherID;
    private Room [] personalSchedule = new Room[8];
    
    //Methods
    public Teacher(String name, long teacherID){
        //This is here to instantiate the name of the teacher
        this.name = name;
        this.teacherID = teacherID;
    }
    
    public String getName(){
        return name;
    }
    
    public Room [] getPersonalSchedule(){
        return personalSchedule;
    }
    
    public boolean equals(String name, long id){
        if((this.name.compareTo(name) == 0) && (this.teacherID == id)){
            return true;
        }
        return false;
    }
    
    public String toString(){
        return name;
    }
}
