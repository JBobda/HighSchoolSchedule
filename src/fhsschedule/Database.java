package fhsschedule;

import java.util.*;

//Jan Bobda
public class Database {
    //Variables
    private Room math = new Room("Math", 1);
    private Room english = new Room("English", 2);
    private Room science = new Room("Science", 3);
    private Room basketball = new Room("Basketball", 4);
    private Room band = new Room("Band", 5);
    private Room spanish = new Room("Spanish", 6);
    private Room german = new Room("German", 7);
    private Room computerScience = new Room("Computer Science", 8);
    private Room history = new Room("History", 9);
    private Room soccer = new Room("Soccer", 10);
    private ArrayList<Room> schedule = new ArrayList();
    
    //Methods
    protected void fillSchedule(){
        getSchedule().add(getMath());
        getSchedule().add(getEnglish());
        getSchedule().add(getScience());
        getSchedule().add(getBasketball());
        getSchedule().add(getBand());
        getSchedule().add(getSpanish());
        getSchedule().add(getGerman());
        getSchedule().add(getComputerScience());
        getSchedule().add(getHistory());
        getSchedule().add(getSoccer());
    }
    
    protected void dumpArray(ArrayList<Room> arrayList){
        for(int i = 0; i < arrayList.size(); i++){
            for(int j = 0; j < 8; j++){
                System.out.println(arrayList.get(i) + " " + "Period " + (j + 1) + ": " + arrayList.get(i).getTeachers(j + 1) + arrayList.get(i).getStudents(j + 1));
            }
        }
    }
    
    protected void enterStudent(Room classRoom, Student student, int period){
        FHSSchedule.students.add(student);
        if(classRoom.equals(getScience())){
            getScience().getStudents(period).add(student);
            student.getPersonalSchedule()[period -1] = classRoom;
        }else if(classRoom.equals(getMath())){
            getMath().getStudents(period).add(student);
            student.getPersonalSchedule()[period -1] = classRoom;
        }else if(classRoom.equals(getHistory())){
            getHistory().getStudents(period).add(student);
            student.getPersonalSchedule()[period -1] = classRoom;
        }else if(classRoom.equals(getComputerScience())){
            getComputerScience().getStudents(period).add(student);
            student.getPersonalSchedule()[period -1] = classRoom;
        }else if(classRoom.equals(getBand())){
            getBand().getStudents(period).add(student);
            student.getPersonalSchedule()[period -1] = classRoom;
        }else if(classRoom.equals(getBasketball())){
            getBasketball().getStudents(period).add(student);
            student.getPersonalSchedule()[period -1] = classRoom;
        }else if(classRoom.equals(getEnglish())){
            getEnglish().getStudents(period).add(student);
            student.getPersonalSchedule()[period -1] = classRoom;
        }else if(classRoom.equals(getSpanish())){
            getSpanish().getStudents(period).add(student);
            student.getPersonalSchedule()[period -1] = classRoom;
        }else if(classRoom.equals(getGerman())){
            getGerman().getStudents(period).add(student);
            student.getPersonalSchedule()[period -1] = classRoom;
        }else if(classRoom.equals(getSoccer())){
            getSoccer().getStudents(period).add(student);
            student.getPersonalSchedule()[period -1] = classRoom;
        }else{
            System.out.println("Error");
        }
    }
    
    protected void enterTeacher(Room classRoom, Teacher teacher, int period){
        FHSSchedule.teachers.add(teacher);
        if(classRoom.equals(getScience())){
            getScience().getTeachers(period).add(teacher);
            teacher.getPersonalSchedule()[period -1] = classRoom;
        }else if(classRoom.equals(getMath())){
            getMath().getTeachers(period).add(teacher);
            teacher.getPersonalSchedule()[period -1] = classRoom;
        }else if(classRoom.equals(getHistory())){
            getHistory().getTeachers(period).add(teacher);
            teacher.getPersonalSchedule()[period -1] = classRoom;
        }else if(classRoom.equals(getComputerScience())){
            getComputerScience().getTeachers(period).add(teacher);
            teacher.getPersonalSchedule()[period -1] = classRoom;
        }else if(classRoom.equals(getBand())){
            getBand().getTeachers(period).add(teacher);
            teacher.getPersonalSchedule()[period -1] = classRoom;
        }else if(classRoom.equals(getBasketball())){
            getBasketball().getTeachers(period).add(teacher);
            teacher.getPersonalSchedule()[period -1] = classRoom;
        }else if(classRoom.equals(getEnglish())){
            getEnglish().getTeachers(period).add(teacher);
            teacher.getPersonalSchedule()[period -1] = classRoom;
        }else if(classRoom.equals(getSpanish())){
            getSpanish().getTeachers(period).add(teacher);
            teacher.getPersonalSchedule()[period -1] = classRoom;
        }else if(classRoom.equals(getGerman())){
            getGerman().getTeachers(period).add(teacher);
            teacher.getPersonalSchedule()[period -1] = classRoom;
        }else if(classRoom.equals(getSoccer())){
            getSoccer().getTeachers(period).add(teacher);
            teacher.getPersonalSchedule()[period -1] = classRoom;
        }else{
            System.out.println("Error");
        }
        
    }
    
    protected void deleteStudent(Room classRoom, Student student, int period){
        if(classRoom.equals(getScience())){
            getScience().getStudents(period).remove(student);
            student.getPersonalSchedule()[period -1] = null;
        }else if(classRoom.equals(getMath())){
            getMath().getStudents(period).remove(student);
            student.getPersonalSchedule()[period -1] = null;
        }else if(classRoom.equals(getHistory())){
            getHistory().getStudents(period).remove(student);
            student.getPersonalSchedule()[period -1] = null;
        }else if(classRoom.equals(getComputerScience())){
            getComputerScience().getStudents(period).remove(student);
            student.getPersonalSchedule()[period -1] = null;
        }else if(classRoom.equals(getBand())){
            getBand().getStudents(period).remove(student);
            student.getPersonalSchedule()[period -1] = null;
        }else if(classRoom.equals(getBasketball())){
            getBasketball().getStudents(period).remove(student);
            student.getPersonalSchedule()[period -1] = null;
        }else if(classRoom.equals(getEnglish())){
            getEnglish().getStudents(period).remove(student);
            student.getPersonalSchedule()[period -1] = null;
        }else if(classRoom.equals(getSpanish())){
            getSpanish().getStudents(period).remove(student);
            student.getPersonalSchedule()[period -1] = null;
        }else if(classRoom.equals(getGerman())){
            getGerman().getStudents(period).remove(student);
            student.getPersonalSchedule()[period -1] = null;
        }else if(classRoom.equals(getSoccer())){
            getSoccer().getStudents(period).remove(student);
            student.getPersonalSchedule()[period -1] = null;
        }else{
            System.out.println("Error");
        }
    }
    
    protected void deleteTeacher(Room classRoom, Teacher teacher, int period){
        if(classRoom.equals(getScience())){
            getScience().getTeachers(period).remove(teacher);
            teacher.getPersonalSchedule()[period -1] = null;
        }else if(classRoom.equals(getMath())){
            getMath().getTeachers(period).remove(teacher);
            teacher.getPersonalSchedule()[period -1] = null;
        }else if(classRoom.equals(getHistory())){
            getHistory().getTeachers(period).remove(teacher);
            teacher.getPersonalSchedule()[period -1] = null;
        }else if(classRoom.equals(getComputerScience())){
            getComputerScience().getTeachers(period).remove(teacher);
            teacher.getPersonalSchedule()[period -1] = null;
        }else if(classRoom.equals(getBand())){
            getBand().getTeachers(period).remove(teacher);
            teacher.getPersonalSchedule()[period -1] = null;
        }else if(classRoom.equals(getBasketball())){
            getBasketball().getTeachers(period).remove(teacher);
            teacher.getPersonalSchedule()[period -1] = null;
        }else if(classRoom.equals(getEnglish())){
            getEnglish().getTeachers(period).remove(teacher);
            teacher.getPersonalSchedule()[period -1] = null;
        }else if(classRoom.equals(getSpanish())){
            getSpanish().getTeachers(period).remove(teacher);
            teacher.getPersonalSchedule()[period -1] = null;
        }else if(classRoom.equals(getGerman())){
            getGerman().getTeachers(period).remove(teacher);
            teacher.getPersonalSchedule()[period -1] = null;
        }else if(classRoom.equals(getSoccer())){
            getSoccer().getTeachers(period).remove(teacher);
            teacher.getPersonalSchedule()[period -1] = null;
        }else{
            System.out.println("Error");
        }
    }
    
    protected void displayStudent(Student student){
        Room [] studentScheds = student.getPersonalSchedule();
        for(int i = 0; i < studentScheds.length; i++){
            System.out.print((i+1)+") Period " + (i + 1)+ " " + studentScheds[i] + " \n");
        }
        System.out.println();
    }
    
    protected void displayTeacher( Teacher teacher){
        Room [] teacherScheds = teacher.getPersonalSchedule();
        for(int i = 0; i < teacherScheds.length; i++){
            System.out.print((i + 1)+") Period " + (i + 1)+ " " + teacherScheds[i] + " \n");
        }
        System.out.println();
    }
    
    protected ArrayList<Room> getSchedule(){
        return schedule;
    }

    /**
     * @return the math
     */
    public Room getMath() {
        return math;
    }

    /**
     * @param math the math to set
     */
    public void setMath(Room math) {
        this.math = math;
    }

    /**
     * @return the english
     */
    public Room getEnglish() {
        return english;
    }

    /**
     * @param english the english to set
     */
    public void setEnglish(Room english) {
        this.english = english;
    }

    /**
     * @return the science
     */
    public Room getScience() {
        return science;
    }

    /**
     * @param science the science to set
     */
    public void setScience(Room science) {
        this.science = science;
    }

    /**
     * @return the basketball
     */
    public Room getBasketball() {
        return basketball;
    }

    /**
     * @param basketball the basketball to set
     */
    public void setBasketball(Room basketball) {
        this.basketball = basketball;
    }

    /**
     * @return the band
     */
    public Room getBand() {
        return band;
    }

    /**
     * @param band the band to set
     */
    public void setBand(Room band) {
        this.band = band;
    }

    /**
     * @return the spanish
     */
    public Room getSpanish() {
        return spanish;
    }

    /**
     * @param spanish the spanish to set
     */
    public void setSpanish(Room spanish) {
        this.spanish = spanish;
    }

    /**
     * @return the german
     */
    public Room getGerman() {
        return german;
    }

    /**
     * @param german the german to set
     */
    public void setGerman(Room german) {
        this.german = german;
    }

    /**
     * @return the computerScience
     */
    public Room getComputerScience() {
        return computerScience;
    }

    /**
     * @param computerScience the computerScience to set
     */
    public void setComputerScience(Room computerScience) {
        this.computerScience = computerScience;
    }

    /**
     * @return the history
     */
    public Room getHistory() {
        return history;
    }

    /**
     * @param history the history to set
     */
    public void setHistory(Room history) {
        this.history = history;
    }

    /**
     * @return the soccer
     */
    public Room getSoccer() {
        return soccer;
    }

    /**
     * @param soccer the soccer to set
     */
    public void setSoccer(Room soccer) {
        this.soccer = soccer;
    }

    /**
     * @param schedule the schedule to set
     */
    public void setSchedule(ArrayList<Room> schedule) {
        this.schedule = schedule;
    }
    
    

}
